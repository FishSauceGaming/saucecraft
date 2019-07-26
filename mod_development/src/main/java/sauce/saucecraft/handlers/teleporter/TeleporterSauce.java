package sauce.saucecraft.handlers.teleporter;

import javax.annotation.Nonnull;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Teleporter;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;

public class TeleporterSauce extends Teleporter {

    public TeleporterSauce(ServerWorld world, double x, double y, double z) {
        super(world);
        this.worldServer = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private final ServerWorld worldServer;
    private double x;
    private double y;
    private double z;

    public void placeInPortal(@Nonnull Entity entity, float rotationYaw) {
        this.worldServer.getBlockState(new BlockPos((int) this.x, (int) this.y, (int) this.z));

        entity.setPosition(this.x, this.y, this.z);
        entity.setMotion(Vec3d.ZERO);
    }


    public static void teleportToDimension(PlayerEntity player, DimensionType dimension, double x, double y, double z) {
        Dimension oldDimension = player.getEntityWorld().getDimension();
        MinecraftServer server = player.getEntityWorld().getServer();
        ServerWorld worldServer = server.getWorld(dimension);
        player.addExperienceLevel(0);

        if (worldServer == null || worldServer.getServer() == null){ 
            throw new IllegalArgumentException("Dimension: "+dimension+" doesn't exist!");
        }

        player.setPortal(player.getPosition());
        player.changeDimension(DimensionType.OVERWORLD);
        player.setPositionAndUpdate(x, y, z);
        if (oldDimension.getType() == DimensionType.THE_END) {
            player.setPositionAndUpdate(x, y, z);
        }
    }
    public static void onceInDimension(PlayerEntity playerIn, double x, double y, double z) {
    	playerIn.setPositionAndUpdate(x, y, z);
    }

}