package sauce.saucecraft.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
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
import sauce.saucecraft.world.dimensions.sauce.SauceTeleporterManager;


public class ItemDimChanger extends Item{

	public ItemDimChanger(Properties properties) {
		super(properties);
	}
		
	@Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		Entity entity = playerIn;
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		SauceTeleporterManager.teleport(entity);
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}
	
	@OnlyIn(Dist.CLIENT)
	public static void playSound(World worldIn, PlayerEntity playerIn){
		
		int x = playerIn.getPosition().getX();
		int y = playerIn.getPosition().getY();
		int z = playerIn.getPosition().getZ();
		
		worldIn.playSound(null, x, y, z, SoundEvents.BLOCK_BELL_USE, SoundCategory.PLAYERS, 0.5f, 1.0f);		
	}
}
