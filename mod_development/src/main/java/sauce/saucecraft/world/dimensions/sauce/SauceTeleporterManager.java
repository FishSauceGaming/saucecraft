package sauce.saucecraft.world.dimensions.sauce;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;

public class SauceTeleporterManager 
{
	public static void teleport(Entity entity)
	{
        if(!entity.world.isRemote)
        {
            DimensionType type = SauceDimensionType.getDimensionType();
            if(entity.getRidingEntity() == null && !entity.isBeingRidden())
            {
            	entity.setPortal(new BlockPos(entity.posX, entity.posY, entity.posZ));
            	
                if (entity.timeUntilPortal > 0) 
                {
                    entity.timeUntilPortal = 10;
                }
                else if(entity.dimension != type)
                {
                    entity.timeUntilPortal = 10;
                    entity.changeDimension(type);
                }
                else if(entity.dimension == type)
                {
                    entity.timeUntilPortal = 10;
                    entity.changeDimension(DimensionType.OVERWORLD);
                }
            }
        }
    }
}