package sauce.saucecraft.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BreakableBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import sauce.saucecraft.Reference;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MODID)
public class BlockSauce extends BreakableBlock{
	public BlockSauce(Properties properties) {
		super(properties);
	}
	public static Block sauce_block = null;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				sauce_block = new BlockSauce(Block.Properties.create(Material.GLASS).hardnessAndResistance(1.0f, 3.0f).sound(SoundType.SLIME)).setRegistryName(Reference.MODID, "sauce_block")
				);	
	}
	
	@Override
	public BlockRenderLayer getRenderLayer() {
	      return BlockRenderLayer.TRANSLUCENT;
	}
	
	public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, player, pos, state, te, stack);
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
			if (worldIn.dimension.doesWaterVaporize()) {
				worldIn.removeBlock(pos, false);
				return;
			}
			Material material = worldIn.getBlockState(pos.down()).getMaterial();
			if (material.blocksMovement() || material.isLiquid()) {
				worldIn.setBlockState(pos, Blocks.WATER.getDefaultState());
			}
		}
	}
	
	@Override
	public ResourceLocation getLootTable() {
		return super.getLootTable();
	}
	
}