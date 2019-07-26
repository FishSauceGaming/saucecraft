package sauce.saucecraft.items;

import net.minecraft.entity.item.EnderPearlEntity;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemEndStaff extends Item{

	public ItemEndStaff(Properties properties) {
		super(properties);
	}
		
	@Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if(!worldIn.isRemote) {
			itemstack.damageItem(1, playerIn, (p_220045_0_) -> {
		         p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		     });
			
			EnderPearlEntity enderpearlentity = new EnderPearlEntity(worldIn, playerIn);
	        enderpearlentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
	        worldIn.addEntity(enderpearlentity);
	        playSound(worldIn, playerIn);		
		}
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}
	
	@OnlyIn(Dist.CLIENT)
	public static void playSound(World worldIn, PlayerEntity playerIn){
		
		int x = playerIn.getPosition().getX();
		int y = playerIn.getPosition().getY();
		int z = playerIn.getPosition().getZ();
		
		worldIn.playSound(null, x, y, z, SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.PLAYERS, 0.5f, 1.0f);		
	}
}
