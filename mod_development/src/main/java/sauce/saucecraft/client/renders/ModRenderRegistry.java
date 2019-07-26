package sauce.saucecraft.client.renders;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import sauce.saucecraft.entities.CavemanEntity;
import sauce.saucecraft.entities.LightningStaffEntity;
import sauce.saucecraft.entities.MuscovyEntity;
import sauce.saucecraft.entities.SauceSlimeEntity;


@OnlyIn(Dist.CLIENT)
public class ModRenderRegistry {

	public static void registryEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(CavemanEntity.class, new CavemanEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(SauceSlimeEntity.class, new SauceSlimeEntityRender.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(MuscovyEntity.class, new MuscovyRender.RenderFactory());
	};
}

