package sauce.saucecraft.init;

import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import sauce.saucecraft.Reference;
import sauce.saucecraft.SauceCraft;
import sauce.saucecraft.world.dimensions.sauce.SauceDimensionType;

@ObjectHolder(Reference.MODID)
public class ModDimensions 
{
	public static final SauceDimensionType LAYER_ONE = new SauceDimensionType(new ResourceLocation(Reference.MODID, "sauce_dimension"));
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerModDimensions(final RegistryEvent.Register<ModDimension> event) 
		{
			event.getRegistry().registerAll
			(
				LAYER_ONE
			);
			
			SauceCraft.LOGGER.info("Registered Dimensions");
		}
	}
	
	public static void registerDimensions()
	{
		DimensionManager.registerDimension(new ResourceLocation(Reference.MODID, "sauce_dimension"), LAYER_ONE, new PacketBuffer(Unpooled.buffer(16)), true);
	}
}