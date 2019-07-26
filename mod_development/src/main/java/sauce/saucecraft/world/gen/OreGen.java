package sauce.saucecraft.world.gen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import sauce.saucecraft.init.ModBlocks;

public class OreGen{
	
	public static void setupOreGeneration() {
		for(Biome biome : ForgeRegistries.BIOMES) {
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.TUNGSTEN_ORE.getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(2, 1, 1, 10)));// Count, MinHeight, MaxHeightBase, MaxHeight
		}
	}
}