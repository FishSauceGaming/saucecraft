package sauce.saucecraft.client.renders;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import sauce.saucecraft.Reference;
import sauce.saucecraft.client.models.SauceSlimeEntityModel;
import sauce.saucecraft.entities.SauceSlimeEntity;

@OnlyIn(Dist.CLIENT)
public class SauceSlimeEntityRender extends MobRenderer<SauceSlimeEntity, SauceSlimeEntityModel<SauceSlimeEntity>>{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SauceSlimeEntityRender(EntityRendererManager manager) {
		super(manager, new SauceSlimeEntityModel(16), 0.25f);
		this.addLayer(new SauceSlimeGelLayer<>(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(SauceSlimeEntity entity) {
		return new ResourceLocation(Reference.MODID, "textures/entity/sauceslime_entity.png");
	}
	
	public static class RenderFactory implements IRenderFactory<SauceSlimeEntity>{
		@Override
		public EntityRenderer<? super SauceSlimeEntity> createRenderFor(EntityRendererManager manager){
			return new SauceSlimeEntityRender(manager);
		}
	}
	
	public void doRender(SauceSlimeEntity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.shadowSize = 0.25F * (float)entity.getSlimeSize();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(SauceSlimeEntity entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scalef(0.999F, 0.999F, 0.999F);
        float f1 = (float)entitylivingbaseIn.getSlimeSize();
        float f2 = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

}
