package sauce.saucecraft.init;

import java.util.Locale;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import sauce.saucecraft.world.gen.structures.igloo.IglooStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import sauce.saucecraft.Reference;
import sauce.saucecraft.world.gen.features.CongealingSauceFeature;
import sauce.saucecraft.world.gen.features.SauceTreeFeature;


@ObjectHolder(Reference.MODID)
public class ModFeatures 
{
	public static final Feature<NoFeatureConfig> CONGEAL = new CongealingSauceFeature(NoFeatureConfig::deserialize);
	public static final Feature<NoFeatureConfig> SAUCETREE = new SauceTreeFeature(NoFeatureConfig::deserialize, false);
	public static final Structure<NoFeatureConfig> IGLOO =  new IglooStructure(NoFeatureConfig::deserialize);
	
	@SubscribeEvent
    public static void registerFeatures(IForgeRegistry<Feature<?>> event) 
	{
		generic(event).add(new ResourceLocation(Reference.MODID, "congeal"), CONGEAL);
		generic(event).add(new ResourceLocation(Reference.MODID, "saucetree"), SAUCETREE);	
		generic(event).add(new ResourceLocation(Reference.MODID, "igloo1"), IGLOO);
		Feature.STRUCTURES.put("Igloo1".toLowerCase(Locale.ROOT), IGLOO);

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