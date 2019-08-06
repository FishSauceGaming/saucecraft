package sauce.saucecraft.init;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import sauce.saucecraft.Reference;
import sauce.saucecraft.armor.ModArmorMaterial;
import sauce.saucecraft.armor.PotionArmorItem;
import sauce.saucecraft.blocks.BlockSauce;
import sauce.saucecraft.entities.SauceEntities;
import sauce.saucecraft.items.ItemDimChanger;
import sauce.saucecraft.items.ItemEndStaff;
import sauce.saucecraft.items.ItemFireStaff;
import sauce.saucecraft.items.ItemLightningStaff;
import sauce.saucecraft.items.ItemEndBag;
import sauce.saucecraft.items.ItemSauceDust;
import sauce.saucecraft.items.ItemTotemOfRecall;
import sauce.saucecraft.items.ItemTungstenIngot;
import sauce.saucecraft.tools.ModAxeItem;
import sauce.saucecraft.tools.ModHoeItem;
import sauce.saucecraft.tools.ModItemTier;
import sauce.saucecraft.tools.ModPickaxeItem;
import sauce.saucecraft.tools.ModShovelItem;
import sauce.saucecraft.tools.ModSwordItem;



@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MODID)
public class ModItems {

    public static final Item totem_of_recall = null;
    public static final Item sauce_dust = null;
    public static final Item piston_kit = null;
    public static final Item tungsten_ingot = null;
    public static final Item speed_boots = null;
    public static final Item water_helmet = null;
    public static final Item jump_pants = null;
    public static final SignItem SAUCEWOOD_SIGN = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(

        		//Items
                new ItemTotemOfRecall(new ItemTotemOfRecall.Properties().maxStackSize(1).group(ModCreativeTab.sauce)).setRegistryName(Reference.MODID, "totem_of_recall"),
                new ItemEndStaff(new ItemEndStaff.Properties().maxStackSize(1).group(ModCreativeTab.sauce).maxDamage(256)).setRegistryName(Reference.MODID, "end_staff"),
                new ItemFireStaff(new ItemFireStaff.Properties().maxStackSize(1).group(ModCreativeTab.sauce).maxDamage(256)).setRegistryName(Reference.MODID, "fire_staff"),
                new ItemLightningStaff(new ItemLightningStaff.Properties().maxStackSize(1).group(ModCreativeTab.sauce).maxDamage(256)).setRegistryName(Reference.MODID, "lightning_staff"),
                new ItemEndBag(new ItemEndBag.Properties().maxStackSize(1).group(ModCreativeTab.sauce)).setRegistryName(Reference.MODID, "end_bag"),
                new ItemSauceDust(new ItemSauceDust.Properties().maxStackSize(64).group(ModCreativeTab.sauce)).setRegistryName(Reference.MODID, "sauce_dust"),
                new ItemTungstenIngot(new ItemTungstenIngot.Properties().maxStackSize(64).group(ModCreativeTab.sauce)).setRegistryName(Reference.MODID, "tungsten_ingot"),
                new ItemDimChanger(new ItemDimChanger.Properties().maxStackSize(1).group(ModCreativeTab.sauce)).setRegistryName(Reference.MODID, "dim_changer"),
                new Item(new Item.Properties().maxStackSize(64).group(ModCreativeTab.sauce)).setRegistryName(Reference.MODID, "piston_kit"),   
                new Item(new Item.Properties().maxStackSize(64).group(ModCreativeTab.sauce)).setRegistryName(Reference.MODID, "sauce_brick"),
                new ArmorItem(ModArmorMaterial.tungsten, EquipmentSlotType.HEAD, (new Item.Properties()).group(ModCreativeTab.sauce)).setRegistryName(Reference.MODID, "tungsten_helmet"),
                new ArmorItem(ModArmorMaterial.tungsten, EquipmentSlotType.CHEST, (new Item.Properties()).group(ModCreativeTab.sauce)).setRegistryName(Reference.MODID, "tungsten_chestplate"),
                new ArmorItem(ModArmorMaterial.tungsten, EquipmentSlotType.LEGS, (new Item.Properties()).group(ModCreativeTab.sauce)).setRegistryName(Reference.MODID, "tungsten_leggings"),
                new ArmorItem(ModArmorMaterial.tungsten, EquipmentSlotType.FEET, (new Item.Properties()).group(ModCreativeTab.sauce)).setRegistryName(Reference.MODID, "tungsten_boots"),
                new PotionArmorItem(ModArmorMaterial.speed, EquipmentSlotType.FEET, (new Item.Properties()).group(ModCreativeTab.sauce).maxDamage(1000)).setRegistryName(Reference.MODID, "speed_boots"),
                new PotionArmorItem(ModArmorMaterial.speed, EquipmentSlotType.HEAD, (new Item.Properties()).group(ModCreativeTab.sauce).maxDamage(1000)).setRegistryName(Reference.MODID, "water_helmet"),
                new PotionArmorItem(ModArmorMaterial.speed, EquipmentSlotType.LEGS, (new Item.Properties()).group(ModCreativeTab.sauce).maxDamage(1200)).setRegistryName(Reference.MODID, "jump_pants"),
                new ModPickaxeItem(ModItemTier.tungsten, -2.8F, (new Item.Properties().group(ModCreativeTab.sauce))).setRegistryName(Reference.MODID, "tungsten_pickaxe"),
                new ModSwordItem(ModItemTier.tungsten, 3, -2.4F, (new Item.Properties().group(ModCreativeTab.sauce))).setRegistryName(Reference.MODID, "tungsten_sword"),
                new ModAxeItem(ModItemTier.tungsten, 6.0F, -3.1F, (new Item.Properties().group(ModCreativeTab.sauce))).setRegistryName(Reference.MODID, "tungsten_axe"),
                new ModShovelItem(ModItemTier.tungsten, 1.5F, -3.0F, (new Item.Properties().group(ModCreativeTab.sauce))).setRegistryName(Reference.MODID, "tungsten_shovel"),
                new ModHoeItem(ModItemTier.tungsten, -3.0F, (new Item.Properties().group(ModCreativeTab.sauce))).setRegistryName(Reference.MODID, "tungsten_hoe"),
                
                //Blocks
                //new SignItem((new Item.Properties().maxStackSize(16).group(ModCreativeTab.sauce)), ModBlocks.SAUCEWOOD_SIGN, ModBlocks.SAUCEWOOD_WALL_SIGN).setRegistryName(Reference.MODID, "saucewood_sign"),
                
                createItemBlockForBlock(BlockSauce.sauce_block, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.bluestone_wire, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.greenstone_wire, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.yellowstone_wire, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.orangestone_wire, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.cyanstone_wire, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.brownstone_wire, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.purplestone_wire, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.pinkstone_wire, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.whitestone_wire, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.blackstone_wire, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.COLOREDSTONE_REPEATER, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.COLOREDSTONE_COMPARATOR, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                
                createItemBlockForBlock(ModBlocks.TUNGSTEN_ORE, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.SAUCE_BRICK, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                
                createItemBlockForBlock(ModBlocks.SAUCE_LOG, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.SAUCE_PLANKS, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.STRIPPED_SAUCE_LOG, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.SAUCEWOOD_STAIRS, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.SAUCEWOOD_SLAB, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.SAUCEWOOD_FENCE, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.SAUCEWOOD_FENCE_GATE, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.SAUCEWOOD_BUTTON, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.SAUCEWOOD_PRESSURE_PLATE, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.SAUCEWOOD_DOOR, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.SAUCEWOOD_TRAPDOOR, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.SAUCE_WOOD, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64)),
                createItemBlockForBlock(ModBlocks.STRIPPED_SAUCE_WOOD, new Item.Properties().group(ModCreativeTab.sauce).maxStackSize(64))
        );
        System.out.println("Saucecraft items loaded");
        
        SauceEntities.registerEntitySpawnEggs(event);
    }
    
	private static BlockItem createItemBlockForBlock(Block block, Item.Properties properties) {
	    return (BlockItem) new BlockItem(block, properties).setRegistryName(block.getRegistryName());
	}
}