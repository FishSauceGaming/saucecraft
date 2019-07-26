package sauce.saucecraft.client.models;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;


/**
 * muscovy - fishsauce
 * Created using Tabula 7.0.1
 */
public class MuscovyModel<T extends Entity> extends EntityModel<T> {
	 public RendererModel leftfoot;
	    public RendererModel rightfoot;
	    public RendererModel leftfoottoe1;
	    public RendererModel leftfoottoe2;
	    public RendererModel rightfoottoe1;
	    public RendererModel rightfoottoe2;
	    public RendererModel rightleg;
	    public RendererModel leftleg;
	    public RendererModel bodybottom;
	    public RendererModel bodybottom2;
	    public RendererModel bodymid1;
	    public RendererModel bodymid2;
	    public RendererModel bodymid15;
	    public RendererModel chest;
	    public RendererModel chest2;
	    public RendererModel bodytop;
	    public RendererModel rightwing;
	    public RendererModel leftwing;
	    public RendererModel head1;
	    public RendererModel beak;
	    public RendererModel neck1;
	    public RendererModel neck2;

	    public MuscovyModel(float modelSize) {
	        this.textureWidth = 64;
	        this.textureHeight = 32;
	        this.leftfoottoe2 = new RendererModel(this, 5, 7);
	        this.leftfoottoe2.setRotationPoint(2.0F, 23.0F, -2.0F);
	        this.leftfoottoe2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
	        this.leftleg = new RendererModel(this, 20, 17);
	        this.leftleg.setRotationPoint(1.0F, 21.0F, 0.0F);
	        this.leftleg.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
	        this.chest2 = new RendererModel(this, 46, 20);
	        this.chest2.setRotationPoint(-1.0F, 18.25F, -3.0F);
	        this.chest2.addBox(0.0F, 0.0F, 0.0F, 2, -2, 1, 0.0F);
	        this.bodytop = new RendererModel(this, 0, 14);
	        this.bodytop.setRotationPoint(-1.0F, 17.0F, -2.0F);
	        this.bodytop.addBox(0.0F, 0.0F, 0.0F, 2, 1, 12, 0.0F);
	        this.leftfoot = new RendererModel(this, 9, 31);
	        this.leftfoot.setRotationPoint(1.0F, 23.0F, 0.0F);
	        this.leftfoot.addBox(0.0F, 0.0F, 0.0F, 1, 1, -3, 0.0F);
	        this.bodymid1 = new RendererModel(this, 21, 21);
	        this.bodymid1.setRotationPoint(-2.0F, 19.0F, -3.0F);
	        this.bodymid1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 9, 0.0F);
	        this.rightwing = new RendererModel(this, 47, 19);
	        this.rightwing.setRotationPoint(-0.5F, 17.25F, 0.0F);
	        this.rightwing.addBox(0.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
	        this.setRotateAngle(rightwing, 0.0F, 0.0F, 2.4535838624536286F);
	        this.bodymid15 = new RendererModel(this, 32, 8);
	        this.bodymid15.setRotationPoint(-1.5F, 19.0F, 0.0F);
	        this.bodymid15.addBox(0.0F, 0.0F, 0.0F, 3, 1, 6, 0.0F);
	        this.head1 = new RendererModel(this, 50, 3);
	        this.head1.setRotationPoint(-1.0F, 15.25F, -2.75F);
	        this.head1.addBox(0.0F, 0.0F, 0.0F, 2, -2, 1, 0.0F);
	        this.rightfoottoe1 = new RendererModel(this, 7, 15);
	        this.rightfoottoe1.setRotationPoint(-3.0F, 23.0F, -2.0F);
	        this.rightfoottoe1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
	        this.chest = new RendererModel(this, 40, 20);
	        this.chest.setRotationPoint(-1.0F, 19.0F, -3.5F);
	        this.chest.addBox(0.0F, 0.0F, 0.0F, 2, -2, 1, 0.0F);
	        this.bodymid2 = new RendererModel(this, 16, 5);
	        this.bodymid2.setRotationPoint(-1.5F, 18.0F, -3.0F);
	        this.bodymid2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 10, 0.0F);
	        this.leftwing = new RendererModel(this, 5, 0);
	        this.leftwing.setRotationPoint(2.0F, 18.5F, 0.0F);
	        this.leftwing.addBox(0.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
	        this.setRotateAngle(leftwing, 0.0F, 0.0F, -2.4535838624536286F);
	        this.rightfoot = new RendererModel(this, 14, 31);
	        this.rightfoot.setRotationPoint(-2.0F, 23.0F, 0.0F);
	        this.rightfoot.addBox(0.0F, 0.0F, 0.0F, 1, 1, -3, 0.0F);
	        this.beak = new RendererModel(this, 5, 18);
	        this.beak.setRotationPoint(-0.5F, 14.25F, -2.0F);
	        this.beak.addBox(0.0F, 0.0F, 0.0F, 1, 1, -2, 0.0F);
	        this.bodybottom2 = new RendererModel(this, 33, 0);
	        this.bodybottom2.setRotationPoint(-2.0F, 20.0F, -2.0F);
	        this.bodybottom2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 7, 0.0F);
	        this.neck2 = new RendererModel(this, 5, 22);
	        this.neck2.setRotationPoint(-0.75F, 17.25F, -2.5F);
	        this.neck2.addBox(0.0F, 0.0F, 0.0F, 1, -2, 1, 0.0F);
	        this.leftfoottoe1 = new RendererModel(this, 0, 7);
	        this.leftfoottoe1.setRotationPoint(0.0F, 23.0F, -2.0F);
	        this.leftfoottoe1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
	        this.rightfoottoe2 = new RendererModel(this, 1, 19);
	        this.rightfoottoe2.setRotationPoint(-1.0F, 23.0F, -2.0F);
	        this.rightfoottoe2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
	        this.neck1 = new RendererModel(this, 5, 20);
	        this.neck1.setRotationPoint(-0.25F, 17.25F, -2.5F);
	        this.neck1.addBox(0.0F, 0.0F, 0.0F, 1, -2, 1, 0.0F);
	        this.bodybottom = new RendererModel(this, 20, 0);
	        this.bodybottom.mirror = true;
	        this.bodybottom.setRotationPoint(-3.0F, 20.0F, 0.0F);
	        this.bodybottom.addBox(0.0F, 0.0F, 0.0F, 6, 1, 4, 0.0F);
	        this.rightleg = new RendererModel(this, 19, 7);
	        this.rightleg.setRotationPoint(-2.0F, 21.0F, 0.0F);
	        this.rightleg.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
	    }

	    @Override
	    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
	        this.leftfoottoe2.render(f5);
	        this.leftleg.render(f5);
	        this.chest2.render(f5);
	        this.bodytop.render(f5);
	        this.leftfoot.render(f5);
	        this.bodymid1.render(f5);
	        this.rightwing.render(f5);
	        this.bodymid15.render(f5);
	        this.head1.render(f5);
	        this.rightfoottoe1.render(f5);
	        this.chest.render(f5);
	        this.bodymid2.render(f5);
	        this.leftwing.render(f5);
	        this.rightfoot.render(f5);
	        this.beak.render(f5);
	        this.bodybottom2.render(f5);
	        this.neck2.render(f5);
	        this.leftfoottoe1.render(f5);
	        this.rightfoottoe2.render(f5);
	        this.neck1.render(f5);
	        this.bodybottom.render(f5);
	        this.rightleg.render(f5);
	    }

	    /**
	     * This is a helper function from Tabula to set the rotation of model parts
	     */
	    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
	        RendererModel.rotateAngleX = x;
	        RendererModel.rotateAngleY = y;
	        RendererModel.rotateAngleZ = z;
	    }
	    @Override
	    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
	    	
	    	this.head1.rotateAngleY = netHeadYaw * 0.017453292F;
	    	this.beak.rotateAngleY = netHeadYaw * 0.017453292F;
	    	this.neck1.rotateAngleY = netHeadYaw * 0.017453292F;
	    	this.head1.rotateAngleX = headPitch * 0.017453292F;
	    	this.beak.rotateAngleX = headPitch * 0.017453292F;
	    	this.neck2.rotateAngleX = headPitch * 0.017453292F;
	    	
	    	if(entityIn.isInWater()) {
	    		this.leftwing.isHidden = true;
	    		this.rightwing.isHidden = true;
    		}
	    	else if(!entityIn.onGround){
	    		this.leftwing.isHidden = false;
	    		this.rightwing.isHidden = false;
	    		this.leftwing.rotateAngleX = MathHelper.cos((limbSwing * 1F) * 1.4f * limbSwingAmount) * -1.2f;
	    		this.leftwing.rotateAngleY = MathHelper.cos((limbSwing * 1F) * 1.4f * limbSwingAmount) * -1.2f;
	    		this.rightwing.rotateAngleX = MathHelper.cos((limbSwing * 1F) * 1.4f * limbSwingAmount) * -1;
	    		this.rightwing.rotateAngleY = MathHelper.cos((limbSwing * 1F) * 1.4f * limbSwingAmount) * -1;
	    	}
	    	else {
	    		this.leftwing.isHidden = true;
	    		this.rightwing.isHidden = true;
	    	}

	    	
	    }
	    
}
	    

	    


