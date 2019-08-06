package sauce.saucecraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import sauce.saucecraft.Reference;
import sauce.saucecraft.blocks.BlackstoneWireBlock;
import sauce.saucecraft.blocks.BluestoneWireBlock;
import sauce.saucecraft.blocks.BrownstoneWireBlock;
import sauce.saucecraft.blocks.ColoredstoneComparatorBlock;
import sauce.saucecraft.blocks.ColoredstoneRepeaterBlock;
import sauce.saucecraft.blocks.CyanstoneWireBlock;
import sauce.saucecraft.blocks.GreenstoneWireBlock;
import sauce.saucecraft.blocks.OrangestoneWireBlock;
import sauce.saucecraft.blocks.PinkstoneWireBlock;
import sauce.saucecraft.blocks.PurplestoneWireBlock;
import sauce.saucecraft.blocks.WhitestoneWireBlock;
import sauce.saucecraft.blocks.YellowstoneWireBlock;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MODID)
public class ModBlocks {
	
	public static Block bluestone_wire = null;
	public static Block greenstone_wire = null;
	public static Block yellowstone_wire = null;
	public static Block orangestone_wire = null;
	public static Block cyanstone_wire = null;
	public static Block brownstone_wire = null;
	public static Block purplestone_wire = null;
	public static Block pinkstone_wire = null;
	public static Block whitestone_wire = null;
	public static Block blackstone_wire = null;
	public static Block COLOREDSTONE_REPEATER = null;
	public static Block COLOREDSTONE_COMPARATOR = null;
	
	public static Block TUNGSTEN_ORE = null;
	public static Block SAUCE_BRICK = null;
	
	public static Block SAUCE_LOG = null;
	public static Block SAUCE_PLANKS = null;
	public static Block STRIPPED_SAUCE_LOG = null;
	public static Block SAUCEWOOD_STAIRS = null;
	public static Block SAUCEWOOD_SLAB = null;
	public static Block SAUCEWOOD_FENCE = null;
	public static Block SAUCEWOOD_FENCE_GATE = null;
	public static Block SAUCEWOOD_BUTTON = null;
	public static Block SAUCEWOOD_PRESSURE_PLATE = null;
	public static Block SAUCEWOOD_DOOR = null;
	public static Block SAUCEWOOD_TRAPDOOR = null;
	public static Block SAUCEWOOD_SIGN = null;
	public static Block SAUCEWOOD_WALL_SIGN = null;
	public static Block SAUCE_WOOD = null;
	public static Block STRIPPED_SAUCE_WOOD = null;
	
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				
				//COLOREDSTONE
				bluestone_wire = new BluestoneWireBlock(Block.Properties.create(Material.ROCK, DyeColor.BLUE).hardnessAndResistance(0f, 0f).sound(SoundType.STONE).doesNotBlockMovement(), 19, 59, 219, 6, 13, 40).setRegistryName(Reference.MODID, "bluestone"),
				greenstone_wire = new GreenstoneWireBlock(Block.Properties.create(Material.ROCK, DyeColor.GREEN).hardnessAndResistance(0f, 0f).sound(SoundType.STONE).doesNotBlockMovement(), 23, 233, 0, 6, 58, 0).setRegistryName(Reference.MODID, "greenstone"),
				yellowstone_wire = new YellowstoneWireBlock(Block.Properties.create(Material.ROCK, DyeColor.YELLOW).hardnessAndResistance(0f, 0f).sound(SoundType.STONE).doesNotBlockMovement(), 255, 239, 0, 102, 102, 0).setRegistryName(Reference.MODID, "yellowstone"),
				orangestone_wire = new OrangestoneWireBlock(Block.Properties.create(Material.ROCK, DyeColor.ORANGE).hardnessAndResistance(0f, 0f).sound(SoundType.STONE).doesNotBlockMovement(), 216, 108, 0, 129, 65, 0).setRegistryName(Reference.MODID, "orangestone"),
				cyanstone_wire = new CyanstoneWireBlock(Block.Properties.create(Material.ROCK, DyeColor.CYAN).hardnessAndResistance(0f, 0f).sound(SoundType.STONE).doesNotBlockMovement(), 102, 255, 255, 0, 102, 102).setRegistryName(Reference.MODID, "cyanstone"),
				brownstone_wire = new BrownstoneWireBlock(Block.Properties.create(Material.ROCK, DyeColor.BROWN).hardnessAndResistance(0f, 0f).sound(SoundType.STONE).doesNotBlockMovement(), 137, 82, 0, 68, 41, 0).setRegistryName(Reference.MODID, "brownstone"),
				purplestone_wire = new PurplestoneWireBlock(Block.Properties.create(Material.ROCK, DyeColor.PURPLE).hardnessAndResistance(0f, 0f).sound(SoundType.STONE).doesNotBlockMovement(), 153, 51, 255, 51, 0, 102).setRegistryName(Reference.MODID, "purplestone"),
				pinkstone_wire = new PinkstoneWireBlock(Block.Properties.create(Material.ROCK, DyeColor.PINK).hardnessAndResistance(0f, 0f).sound(SoundType.STONE).doesNotBlockMovement(), 255, 102, 178, 102, 0, 51).setRegistryName(Reference.MODID, "pinkstone"),
				whitestone_wire = new WhitestoneWireBlock(Block.Properties.create(Material.ROCK, DyeColor.WHITE).hardnessAndResistance(0f, 0f).sound(SoundType.STONE).doesNotBlockMovement(), 255, 255, 255, 130, 130, 130).setRegistryName(Reference.MODID, "whitestone"),
				blackstone_wire = new BlackstoneWireBlock(Block.Properties.create(Material.ROCK, DyeColor.BLACK).hardnessAndResistance(0f, 0f).sound(SoundType.STONE).doesNotBlockMovement(), 75, 67, 77, 0, 0, 0).setRegistryName(Reference.MODID, "blackstone"),
				COLOREDSTONE_REPEATER = new ColoredstoneRepeaterBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0f, 0f).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "coloredstone_repeater"),
				COLOREDSTONE_COMPARATOR = new ColoredstoneComparatorBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0f, 0f).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "coloredstone_comparator"),
				
				//GENERAL BLOCKS
				TUNGSTEN_ORE = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(22.5F, 120.0F).sound(SoundType.STONE).harvestLevel(3).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.MODID, "tungsten_ore"),
				SAUCE_BRICK = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.MODID, "sauce_bricks"),
				
				//SAUCE WOOD
				SAUCE_LOG = new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "sauce_log"),
				SAUCE_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "sauce_planks"),
				STRIPPED_SAUCE_LOG = new LogBlock(MaterialColor.OBSIDIAN, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "stripped_sauce_log"),
				SAUCEWOOD_STAIRS = new StairsBlock(SAUCE_PLANKS.getDefaultState(), Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "saucewood_stairs"),
				SAUCEWOOD_SLAB =  new SlabBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "saucewood_slab"),
				SAUCEWOOD_FENCE = new FenceBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "saucewood_fence"),
				SAUCEWOOD_FENCE_GATE = new FenceGateBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "saucewood_fence_gate"),
				SAUCEWOOD_BUTTON = new WoodButtonBlock(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "saucewood_button"),
				SAUCEWOOD_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "saucewood_pressure_plate"),
				SAUCEWOOD_DOOR = new DoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "saucewood_door"),
				SAUCEWOOD_TRAPDOOR = new TrapDoorBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "saucewood_trapdoor"),
				SAUCEWOOD_SIGN = new StandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "saucewood_sign"),
				SAUCEWOOD_WALL_SIGN = new WallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(SAUCEWOOD_SIGN)).setRegistryName(Reference.MODID, "saucewood_wall_sign"),
				SAUCE_WOOD = new RotatedPillarBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "sauce_wood"),
				STRIPPED_SAUCE_WOOD = new RotatedPillarBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName(Reference.MODID, "stripped_sauce_wood")
				);	
	}
}