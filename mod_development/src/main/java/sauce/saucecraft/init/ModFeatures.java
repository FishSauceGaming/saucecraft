package sauce.saucecraft.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import sauce.saucecraft.Reference;
import sauce.saucecraft.world.gen.features.CongealingSauceFeature;


@ObjectHolder(Reference.MODID)
public class ModFeatures 
{
	public static final Feature<NoFeatureConfig> CONGEAL = new CongealingSauceFeature(NoFeatureConfig::deserialize);
	
	@SubscribeEvent
    public static void registerFeatures(IForgeRegistry<Feature<?>> event) 
	{
		generic(event).add("congeal", CONGEAL);
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

		public Generic<T> add(String name, T entry) 
		{
			ResourceLocation registryName = GameData.checkPrefix(name, false);
			entry.setRegistryName(registryName);
			this.registry.register(entry);
			return this;
        }
    }
}