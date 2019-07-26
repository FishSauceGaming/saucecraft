package sauce.saucecraft.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import sauce.saucecraft.init.ModCreativeTab;

public class ModAxeItem extends AxeItem {

    public ModAxeItem(IItemTier material, float p_i48530_2_, float speed, Item.Properties properties) {
        super(material, p_i48530_2_, speed, new Properties().group(ModCreativeTab.sauce).addToolType(ToolType.AXE, material.getHarvestLevel()));
    }

}