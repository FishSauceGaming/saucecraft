package sauce.saucecraft.entities;

import javax.annotation.Nonnull;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class MuscovyEntity extends CreatureEntity implements IFlyingAnimal{
	
	@SuppressWarnings("unchecked")
	public MuscovyEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
		super((EntityType<? extends CreatureEntity>) SauceEntities.MUSCOVY_ENTITY, worldIn);
		this.moveController = new FlyingMovementController(this);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomFlyingGoal(this, 1.5D));
		this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 0.25f));
	}
	@Override
	public void fall(float distance, float damageMultiplier) {
	   }
	
	 @Override
	 protected PathNavigator createNavigator(World worldIn) {
	      FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, worldIn);
	      flyingpathnavigator.setCanOpenDoors(false);
	      flyingpathnavigator.setCanSwim(true);
	      flyingpathnavigator.setCanEnterDoors(true);
	      return flyingpathnavigator;
	   }
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0d);
		this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue((double)0.4F);
	    this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.2F);
	}
	
	

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return false;
	}
	
	public boolean isFlying() {
	      return !this.onGround;
	   }
	
	@Override
	public boolean canSpawn(IWorld world, @Nonnull SpawnReason spawnReason) {
		int x = MathHelper.floor(this.posX);
		int y = MathHelper.floor(this.getBoundingBox().minY);
		int z = MathHelper.floor(this.posZ);
		BlockPos pos = new BlockPos(x, y, z);
		return (world.getLightSubtracted(pos, 0) > 8);
    }
}
