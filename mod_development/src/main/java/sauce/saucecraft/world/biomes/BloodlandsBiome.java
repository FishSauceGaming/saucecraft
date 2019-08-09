package sauce.saucecraft.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import sauce.saucecraft.entities.SauceEntities;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;


public class BloodlandsBiome extends Biome{
	
	protected static final SurfaceBuilderConfig	BLOODLANDS_SURFACE = new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(), Blocks.BROWN_CONCRETE.getDefaultState(), Blocks.RED_SAND.getDefaultState());
	
	 @SuppressWarnings("static-access")
	public BloodlandsBiome(){
		 
		  super((new Biome.Builder()).surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.DEFAULT, BLOODLANDS_SURFACE)).precipitation(Biome.RainType.NONE).category(Biome.Category.DESERT).depth(0.3F).scale(.2F).temperature(10F).downfall(0F).waterColor(6164736).waterFogColor(4002048).parent((String)null));
		  
		  this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
	      this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
	      this.addStructure(Feature.DESERT_PYRAMID, IFeatureConfig.NO_FEATURE_CONFIG);
	      this.addStructure(Feature.VILLAGE, new VillageConfig("village/savanna/town_centers", 6));
	      
	      DefaultBiomeFeatures.addCarvers(this);
	      DefaultBiomeFeatures.addStructures(this);
	      DefaultBiomeFeatures.addLakes(this);
	      DefaultBiomeFeatures.addMonsterRooms(this);
	      DefaultBiomeFeatures.addSedimentDisks(this);
	      DefaultBiomeFeatures.addStoneVariants(this);
	      DefaultBiomeFeatures.addOres(this);
	      DefaultBiomeFeatures.addDesertLakes(this);
	      

	      this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(SauceEntities.CAVEMAN_ENTITY, 5, 1, 5));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(SauceEntities.SAUCESLIME_ENTITY, 5, 1, 2));
	      new BiomeManager().addBiome(BiomeType.DESERT, new BiomeEntry(this, 3));
	      new BiomeManager().addSpawnBiome(this);
	      
	    }

}
