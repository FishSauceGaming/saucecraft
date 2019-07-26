package sauce.saucecraft.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;
import sauce.saucecraft.init.ModCreativeTab;

public class ModPickaxeItem extends PickaxeItem {

    public ModPickaxeItem(IItemTier material, float speed, Item.Properties properties) {
        super(material, 1, speed, new Properties().group(ModCreativeTab.sauce).addToolType(ToolType.PICKAXE, material.getHarvestLevel()));
    }

}