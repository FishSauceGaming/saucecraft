package sauce.saucecraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class LightningStaffEntity extends ThrowableEntity{



	public LightningStaffEntity(EntityType<? extends ProjectileItemEntity> type, double x, double y, double z,
			World worldIn) {
		super(type, x, y, z, worldIn);
	}
	public LightningStaffEntity(World worldIn, double x, double y, double z) 
	{
		super(SauceEntities.LIGHTNING_STAFF_ENTITY, x, y, z, worldIn);
	}
	public LightningStaffEntity(World worldIn, PlayerEntity throwerIn)
	{
		super(SauceEntities.LIGHTNING_STAFF_ENTITY, throwerIn, worldIn);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		BlockPos pos = this.getPosition();
		this.remove();
		Entity entity1 = this.getThrower();
		LightningBoltEntity lbe = new LightningBoltEntity(world, (double)pos.getX()+ 0.5D, (double)pos.getY(), (double)pos.getZ()+ 0.5D, false);
		lbe.setCaster((ServerPlayerEntity)entity1);
		lbe.setPosition((double)pos.getX()+ 0.5D, (double)pos.getY(), (double)pos.getZ()+ 0.5D);	
		this.world.addEntity(lbe);
		ServerWorld world = (ServerWorld)this.world;
		world.addLightningBolt(lbe);	
	}
	
	protected float getGravityVelocity() {
		return 0.0f;
	}


	@Override
	protected void registerData() {
		// TODO Auto-generated method stub
		
	}
	
	public LightningStaffEntity(FMLPlayMessages.SpawnEntity packet, World worldIn)
	{
		super(SauceEntities.LIGHTNING_STAFF_ENTITY, worldIn);
	}
	@Override
	public IPacket<?> createSpawnPacket(){
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	public void tick() {
	      LivingEntity livingentity = this.getThrower();
	      if (livingentity != null && livingentity instanceof PlayerEntity && !livingentity.isAlive()) {
	         this.remove();
	      } else {
	         super.tick();
	      }
	   }


	
}
