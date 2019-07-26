package sauce.saucecraft.init;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import sauce.saucecraft.entities.SauceEntities;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities{
	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(
				SauceEntities.CAVEMAN_ENTITY,
				SauceEntities.SAUCESLIME_ENTITY,
				SauceEntities.MUSCOVY_ENTITY
				);
		SauceEntities.registerEntityWorldSpawns();
		
	}
	
	
}