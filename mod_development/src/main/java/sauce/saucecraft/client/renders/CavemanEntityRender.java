package sauce.saucecraft.client.renders;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import sauce.saucecraft.Reference;
import sauce.saucecraft.client.models.CavemanEntityModel;
import sauce.saucecraft.entities.CavemanEntity;

@OnlyIn(Dist.CLIENT)
public class CavemanEntityRender extends MobRenderer<CavemanEntity, CavemanEntityModel>{

	public CavemanEntityRender(EntityRendererManager manager) {
		super(manager, new CavemanEntityModel(1.0f, false), 0f);
	}

	@Override
	protected ResourceLocation getEntityTexture(CavemanEntity entity) {
		return new ResourceLocation(Reference.MODID, "textures/entity/caveman_entity.png");
	}
	
	public static class RenderFactory implements IRenderFactory<CavemanEntity>{
		@Override
		public EntityRenderer<? super CavemanEntity> createRenderFor(EntityRendererManager manager){
			return new CavemanEntityRender(manager);
		}
	}

}
