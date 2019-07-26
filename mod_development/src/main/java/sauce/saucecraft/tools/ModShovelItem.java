package sauce.saucecraft.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.common.ToolType;
import sauce.saucecraft.init.ModCreativeTab;

public class ModShovelItem extends ShovelItem {

    public ModShovelItem(IItemTier material, float attackdmgin, float speed, Item.Properties properties) {
        super(material, attackdmgin, speed, new Properties().group(ModCreativeTab.sauce).addToolType(ToolType.AXE, material.getHarvestLevel()));
    }

}