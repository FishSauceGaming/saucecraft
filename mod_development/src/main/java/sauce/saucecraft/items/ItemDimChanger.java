package sauce.saucecraft.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import sauce.saucecraft.world.dimensions.sauce.SauceTeleporterManager;


public class ItemDimChanger extends Item{

	public ItemDimChanger(Properties properties) {
		super(properties);
	}
	
	
	@Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if(!worldIn.isRemote) {
			itemstack.damageItem(1, playerIn, (p_220045_0_) -> {
		         p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		     });
		}
		SauceTeleporterManager.teleport(playerIn, worldIn, playerIn.getPosition());
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}
}
