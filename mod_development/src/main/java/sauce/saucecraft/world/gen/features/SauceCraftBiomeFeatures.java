package sauce.saucecraft.world.gen.features;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import sauce.saucecraft.init.ModFeatures;

public class SauceCraftBiomeFeatures {
	public static void addCongealTopLayer(Biome biomeIn) {
	      biomeIn.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Biome.createDecoratedFeature(ModFeatures.CONGEAL, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
	   }
}
