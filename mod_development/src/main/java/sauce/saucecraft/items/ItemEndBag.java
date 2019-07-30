package sauce.saucecraft.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.EnderChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemEndBag extends Item{

	
	public ItemEndBag(Properties properties) {
		super(properties);
	}
	
	public int numPlayersUsing;
	
	public static final TranslationTextComponent field_220115_d = new TranslationTextComponent("container.enderchest");
		
	@Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {	
		this.numPlayersUsing++;
		EnderChestInventory enderchestinventory = playerIn.getInventoryEnderChest();
		BlockPos pos = playerIn.getPosition();
		TileEntity tileentity = worldIn.getTileEntity(pos);
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if(!worldIn.isRemote) {
			playSound(worldIn, playerIn, SoundEvents.BLOCK_ENDER_CHEST_OPEN);
			EnderChestTileEntity enderchesttileentity = (EnderChestTileEntity)tileentity;
		    enderchestinventory.setChestTileEntity(enderchesttileentity);
		    playerIn.openContainer(new SimpleNamedContainerProvider((p_220114_1_, p_220114_2_, p_220114_3_) -> {
		    	return ChestContainer.createGeneric9X3(p_220114_1_, p_220114_2_, enderchestinventory);
		    }, field_220115_d));
		    playerIn.addStat(Stats.OPEN_ENDERCHEST);
		    worldIn.removeTileEntity(pos);
		}
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}
	
	
	
	@OnlyIn(Dist.CLIENT)
	public static void playSound(World worldIn, PlayerEntity playerIn, SoundEvent soundevent){
		
		int x = playerIn.getPosition().getX();
		int y = playerIn.getPosition().getY();
		int z = playerIn.getPosition().getZ();
		
		worldIn.playSound(null, x, y, z, soundevent, SoundCategory.PLAYERS, 0.5f, 1.0f);		
	}



	
	
}
