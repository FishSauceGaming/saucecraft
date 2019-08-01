package sauce.saucecraft.world.dimensions.sauce;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap.Type;

public class SauceTeleporterManager
{
	
	public static void teleport(Entity entity)
	{		
		

		
        if(!entity.world.isRemote)
        {
            DimensionType type = SauceDimensionType.getDimensionType();
            if(entity.getRidingEntity() == null && !entity.isBeingRidden())
            {
                if(entity.dimension != type)
                {
                	entity.changeDimension(type);
                }
                else if(entity.dimension == type)
                {
                    entity.changeDimension(DimensionType.OVERWORLD);
                }
            }
        }
    }
	
	public boolean makePortal(Entity entityIn) {
		return false;
	}
}