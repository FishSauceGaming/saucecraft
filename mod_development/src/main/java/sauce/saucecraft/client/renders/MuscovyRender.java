package sauce.saucecraft.client.renders;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import sauce.saucecraft.Reference;
import sauce.saucecraft.client.models.MuscovyModel;
import sauce.saucecraft.entities.MuscovyEntity;

@OnlyIn(Dist.CLIENT)
public class MuscovyRender extends MobRenderer<MuscovyEntity, MuscovyModel<MuscovyEntity>>{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MuscovyRender(EntityRendererManager manager) {
		super(manager, new MuscovyModel(1f), 0f);
	}

	@Override
	protected ResourceLocation getEntityTexture(MuscovyEntity entity) {
		return new ResourceLocation(Reference.MODID, "textures/entity/muscovy_entity.png");
	}
	
	public static class RenderFactory implements IRenderFactory<MuscovyEntity>{
		@Override
		public EntityRenderer<? super MuscovyEntity> createRenderFor(EntityRendererManager manager){
			return new MuscovyRender(manager);
		}
	}

}
