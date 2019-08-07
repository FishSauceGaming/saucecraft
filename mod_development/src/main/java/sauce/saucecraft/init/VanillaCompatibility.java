package sauce.saucecraft.init;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.util.IItemProvider;

public class VanillaCompatibility {
	
	public static void init()
    {
        registerFlammableBlocks(ModBlocks.SAUCE_LOG, 5, 20);
        registerFlammableBlocks(ModBlocks.SAUCE_PLANKS, 5, 20);
        registerFlammableBlocks(ModBlocks.STRIPPED_SAUCE_LOG, 5, 20);
        registerFlammableBlocks(ModBlocks.SAUCEWOOD_SLAB, 5, 20);
        registerFlammableBlocks(ModBlocks.SAUCEWOOD_STAIRS, 5, 20);
        registerFlammableBlocks(ModBlocks.SAUCEWOOD_FENCE, 5, 20);
        registerFlammableBlocks(ModBlocks.SAUCEWOOD_FENCE_GATE, 5, 20);
        registerFlammableBlocks(ModBlocks.SAUCEWOOD_DOOR, 5, 20);
        registerFlammableBlocks(ModBlocks.SAUCEWOOD_TRAPDOOR, 5, 20);
        registerFlammableBlocks(ModBlocks.SAUCE_WOOD, 5, 20);
        registerFlammableBlocks(ModBlocks.STRIPPED_SAUCE_WOOD, 5, 20);
        registerFlammableBlocks(ModBlocks.SAUCE_LEAVES, 30, 60);
        registerStrippableBlocks(ModBlocks.SAUCE_LOG, ModBlocks.STRIPPED_SAUCE_LOG);
        registerStrippableBlocks(ModBlocks.SAUCE_WOOD, ModBlocks.STRIPPED_SAUCE_WOOD);
    }

    public static void registerStrippableBlocks(Block log, Block stripped_log) {
       AxeItem.BLOCK_STRIPPING_MAP = Maps.newHashMap(AxeItem.BLOCK_STRIPPING_MAP);
       AxeItem.BLOCK_STRIPPING_MAP.put(log, stripped_log);
    }

    public static void registerCompostableBlocks(float chance, IItemProvider itemIn) {
        ComposterBlock.CHANCES.put(itemIn.asItem(), chance);
    }

    public static void registerFlammableBlocks(Block blockIn, int encouragement, int flammability)
    {
        FireBlock fireblock = (FireBlock)Blocks.FIRE;
        fireblock.setFireInfo(blockIn, encouragement, flammability);
    }
}

