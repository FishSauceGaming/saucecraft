package sauce.saucecraft.world.gen.features;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.LightType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import sauce.saucecraft.blocks.BlockSauce;

public class CongealingSauceFeature extends Feature<NoFeatureConfig> {
	
	
	   public CongealingSauceFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51435_1_) {
		      super(p_i51435_1_);
		   }

	   public boolean doesSauceCongeal(IWorldReader worldIn, BlockPos water, boolean mustBeAtEdge) {
		   if (water.getY() >= 0 && water.getY() < worldIn.getDimension().getHeight() && worldIn.getLightFor(LightType.BLOCK, water) < 10) {
			   BlockState blockstate = worldIn.getBlockState(water);
			   IFluidState ifluidstate = worldIn.getFluidState(water);
			   if (ifluidstate.getFluid() == Fluids.WATER && blockstate.getBlock() instanceof FlowingFluidBlock) {
				   if (!mustBeAtEdge) {
					   return true;
				   }

				   boolean flag = worldIn.hasWater(water.west()) && worldIn.hasWater(water.east()) && worldIn.hasWater(water.north()) && worldIn.hasWater(water.south());
				   if (!flag) {
					   return true;
				   }
			   }
		   }
	
		   return false;
	}
	   @Override
		   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		      BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
		      BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

		      for(int i = 0; i < 16; ++i) {
		         for(int j = 0; j < 16; ++j) {
		            int k = pos.getX() + i;
		            int l = pos.getZ() + j;
		            int i1 = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, k, l);
		            blockpos$mutableblockpos.setPos(k, i1, l);
		            blockpos$mutableblockpos1.setPos(blockpos$mutableblockpos).move(Direction.DOWN, 1);
		            if (doesSauceCongeal(worldIn, blockpos$mutableblockpos1, false)) {
		               worldIn.setBlockState(blockpos$mutableblockpos1, BlockSauce.sauce_block.getDefaultState(), 2);
		            }
		         }
		      }

		      return true;
		   }
		}