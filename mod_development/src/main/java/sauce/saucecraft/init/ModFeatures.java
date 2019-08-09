package sauce.saucecraft.init;

import java.util.Locale;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import sauce.saucecraft.Reference;
import sauce.saucecraft.world.gen.features.CongealingSauceFeature;
import sauce.saucecraft.world.gen.features.SauceTreeFeature;
import sauce.saucecraft.world.gen.structures.test.WaterSheepPieces;
import sauce.saucecraft.world.gen.structures.test.WaterSheepStructure;



public class ModFeatures 
{
	public static final Feature<NoFeatureConfig> CONGEAL = new CongealingSauceFeature(NoFeatureConfig::deserialize);
	public static final Feature<NoFeatureConfig> SAUCETREE = new SauceTreeFeature(NoFeatureConfig::deserialize, false);
	
    public static final Structure<NoFeatureConfig> WATERSHEEP = new WaterSheepStructure(NoFeatureConfig::deserialize);

    public static final IStructurePieceType WATERSHEEP_STRUCTURE = IStructurePieceType.register(WaterSheepPieces.Piece::new, "WSHP");
	

    public static void registerFeatures(IForgeRegistry<Feature<?>> event) 
	{
		generic(event).add(new ResourceLocation(Reference.MODID, "congeal"), CONGEAL);
		generic(event).add(new ResourceLocation(Reference.MODID, "saucetree"), SAUCETREE);
		generic(event).add(new ResourceLocation(Reference.MODID, "watersheep"), WATERSHEEP);
		
        Registry.register(Registry.STRUCTURE_FEATURE,"WaterSheep".toLowerCase(Locale.ROOT), WATERSHEEP);
        Registry.register(Registry.STRUCTURE_PIECE,"WSHP".toLowerCase(Locale.ROOT), WATERSHEEP_STRUCTURE);
        Feature.STRUCTURES.put("WaterSheep".toLowerCase(Locale.ROOT), WATERSHEEP);
	}
	
	
	public static <T extends IForgeRegistryEntry<T>> Generic<T> generic(IForgeRegistry<T> registry) 
	{
		return new Generic<>(registry);
	}
	
	public static class Generic<T extends IForgeRegistryEntry<T>> 
	{
		private final IForgeRegistry<T> registry;

		private Generic(IForgeRegistry<T> registry) 
		{
			this.registry = registry;
		}

		public Generic<T> add(ResourceLocation name, T entry) 
		{
			entry.setRegistryName(name);
			this.registry.register(entry);
			return this;
        }
    }
}