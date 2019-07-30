package sauce.saucecraft.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class ModSwordItem extends SwordItem {
	

	public ModSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
	      super(tier, attackDamageIn, -2.4F, builder);
	   }
}