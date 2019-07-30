package sauce.saucecraft.entities;

import javax.annotation.Nonnull;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class CavemanEntity extends CreatureEntity{
	
	@SuppressWarnings("unchecked")
	public CavemanEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
		super((EntityType<? extends CreatureEntity>) SauceEntities.CAVEMAN_ENTITY, worldIn);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 0.5d));
		this.goalSelector.addGoal(0, new LookRandomlyGoal(this));
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5d);
	}
	
	

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return false;
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
