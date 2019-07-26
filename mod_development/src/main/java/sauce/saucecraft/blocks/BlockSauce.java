package sauce.saucecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BreakableBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
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
	
	@Override
	public ResourceLocation getLootTable() {
		return super.getLootTable();
	}
	
}