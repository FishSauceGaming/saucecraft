package sauce.saucecraft.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import sauce.saucecraft.entities.LightningStaffEntity;

public class ItemLightningStaff extends Item{

	public ItemLightningStaff(Properties properties) {
		super(properties);
	}
		
	@Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		playSound(worldIn, playerIn);
		if(!worldIn.isRemote) {
			itemstack.damageItem(1, playerIn, (p_220045_0_) -> {
		         p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		     });
		
			LightningStaffEntity lse = new LightningStaffEntity(worldIn, playerIn);
			lse.setPosition(lse.posX, lse.posY, lse.posZ);
			lse.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F,	5.5F, 0.01F);
			if(lse.posY > 256 || lse.posY < 0) {
				lse.remove();
			}
			worldIn.addEntity(lse);
		}
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}
	
	public static void playSound(World worldIn, PlayerEntity playerIn){
		
		int x = playerIn.getPosition().getX();
		int y = playerIn.getPosition().getY();
		int z = playerIn.getPosition().getZ();
		
		worldIn.playSound(null, x, y, z, SoundEvents.ITEM_TRIDENT_THUNDER, SoundCategory.PLAYERS, 0.5f, 1.0f);		
	}
}
