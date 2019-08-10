package sauce.saucecraft.world.dimensions.sauce;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import sauce.saucecraft.handlers.teleporter.TeleporterSauce;
import sauce.saucecraft.items.ItemDimChanger;

public class SauceTeleporterManager
{
	
	public static void teleport(PlayerEntity playerIn, World worldIn, BlockPos pos)
	{			
        if(!playerIn.world.isRemote)
        {
        	if (worldIn.getDimension().getType().getId() == DimensionType.OVERWORLD.getId()) {
                World otherWorld = worldIn.getServer().getWorld(SauceDimensionType.getDimensionType());
                otherWorld.getBlockState(pos);
                BlockPos otherWorldPos = otherWorld.getHeight(Heightmap.Type.WORLD_SURFACE, pos);
                boolean foundBlock = false;
                BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos(0, 0, 0);

                for (int y = 0; y < 256; y++) {
                    for (int x = pos.getX() - 64; x < pos.getX() + 64; x++) {
                        for (int z = pos.getZ() - 64; z < pos.getZ() + 64; z++) {
                            mutableBlockPos.setPos(x,y,z);
                            if (otherWorld.getBlockState(mutableBlockPos).getBlock() == Blocks.GRASS) {
                                otherWorldPos = new BlockPos(x, y + 1, z);
                                foundBlock = true;
                                break;
                            }
                        }
                    }
                }
                if (foundBlock){
                	ItemDimChanger.TrueOrFalse(true);
                    TeleporterSauce.changeDim(((ServerPlayerEntity) playerIn), otherWorldPos, SauceDimensionType.getDimensionType());
                }
                if (!foundBlock){
                	ItemDimChanger.TrueOrFalse(false);
                    playerIn.sendMessage(new StringTextComponent("Couldn't find a block!"));
                }
            }

            //FROM MINING DIM TO OVERWORLD
            if (worldIn.getDimension().getType() == SauceDimensionType.getDimensionType()) {
                World overWorld = worldIn.getServer().getWorld(DimensionType.OVERWORLD);
                overWorld.getBlockState(pos);
                BlockPos overWorldPos = overWorld.getHeight(Heightmap.Type.WORLD_SURFACE, pos);
                boolean foundBlock = false;
                BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos(0, 0, 0);

                for (int y = 0; y < 256; y++) {
                    for (int x = pos.getX() - 64; x < pos.getX() + 64; x++) {
                        for (int z = pos.getZ() - 64; z < pos.getZ() + 64; z++) {
                            mutableBlockPos.setPos(x, y, z);
                            if (overWorld.getBlockState(mutableBlockPos).getBlock() == Blocks.GRASS) {
                                overWorldPos = new BlockPos(x, y + 1, z);
                                foundBlock = true;
                                break;
                            }
                            else if (overWorld.getBlockState(mutableBlockPos).getBlock() == Blocks.STONE) {
                            	overWorldPos = new BlockPos(x, y + 1, z);
                                foundBlock = true;
                                break;
                            }
                            else if (overWorld.getBlockState(mutableBlockPos).getBlock() == Blocks.SAND) {
                            	overWorldPos = new BlockPos(x, y + 1, z);
                                foundBlock = true;
                                break;
                            }
                            else if (overWorld.getBlockState(mutableBlockPos).getBlock() == Blocks.MYCELIUM) {
                            	overWorldPos = new BlockPos(x, y + 1, z);
                                foundBlock = true;
                                break;
                            }
                            else if (overWorld.getBlockState(mutableBlockPos).getBlock() == Blocks.DIRT) {
                            	overWorldPos = new BlockPos(x, y + 1, z);
                                foundBlock = true;
                                break;
                            }
                        }
                    }
                }
                if (foundBlock){
                	ItemDimChanger.TrueOrFalse(true);
                    TeleporterSauce.changeDim(((ServerPlayerEntity) playerIn), overWorldPos, DimensionType.OVERWORLD);
                }
                if (!foundBlock){
                	ItemDimChanger.TrueOrFalse(false);
                    TeleporterSauce.changeDim(((ServerPlayerEntity) playerIn), overWorldPos, DimensionType.OVERWORLD);
                }
            }
        }

    }
        
}