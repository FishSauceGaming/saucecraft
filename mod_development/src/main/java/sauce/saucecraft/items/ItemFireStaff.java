package sauce.saucecraft.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemFireStaff extends Item{

	public ItemFireStaff(Properties properties) {
		super(properties);
	}
		
	@Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if(!worldIn.isRemote) {
			itemstack.damageItem(1, playerIn, (p_220045_0_) -> {
		         p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		     });
			Vec3d look = playerIn.getLookVec();
			FireballEntity fireball2 = new FireballEntity(worldIn, playerIn, 1, 1, 1);
			fireball2.setPosition(
			playerIn.posX + look.x * 1.5f,
			(playerIn.posY + 1f) + look.y * 1.5f,
			playerIn.posZ + look.z * 1.5f);
			fireball2.accelerationX = look.x * 0.1;
			fireball2.accelerationY = look.y * 0.1;
			fireball2.accelerationZ = look.z * 0.1;
			worldIn.addEntity(fireball2);

	        playSound(worldIn, playerIn);		
		}
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}
	
	@OnlyIn(Dist.CLIENT)
	public static void playSound(World worldIn, PlayerEntity playerIn){
		
		int x = playerIn.getPosition().getX();
		int y = playerIn.getPosition().getY();
		int z = playerIn.getPosition().getZ();
		
		worldIn.playSound(null, x, y, z, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS, 0.5f, 1.0f);		
	}
}
