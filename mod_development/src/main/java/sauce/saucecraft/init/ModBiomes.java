package sauce.saucecraft.init;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import sauce.saucecraft.Reference;
import sauce.saucecraft.world.biomes.BloodlandsBiome;
import sauce.saucecraft.world.biomes.ForestMountainsBiome;
import sauce.saucecraft.world.biomes.LushPlainsBiome;
import sauce.saucecraft.world.biomes.MinersParadiseBiome;
import sauce.saucecraft.world.biomes.NetherLeakBiome;


@ObjectHolder(Reference.MODID)
public class ModBiomes 
{
	public static final Biome FOREST_MOUNTAINS = null;
	public static final Biome BLOODLANDS = null;
	public static final Biome MINERS_PARADISE = null;
	public static final Biome NETHERLEAK = null;
	public static final Biome LUSH_PLAINS = null;
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerBiomes(final RegistryEvent.Register<Biome> e)
		{
			e.getRegistry().registerAll
			(
				setup(new ForestMountainsBiome(), "forest_mountains"),
				setup(new BloodlandsBiome(), "bloodlands"),
				setup(new MinersParadiseBiome(), "miners_paradise"),
				setup(new NetherLeakBiome(), "netherleak"),
				setup(new LushPlainsBiome(), "lush_plains")
			);
			
			System.out.println("Saucecraft biomes registered");
		}
		
	}
	
	
	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) 
	{
		return setup(entry, new ResourceLocation(Reference.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) 
	{
		entry.setRegistryName(registryName);
		return entry;
	}
}