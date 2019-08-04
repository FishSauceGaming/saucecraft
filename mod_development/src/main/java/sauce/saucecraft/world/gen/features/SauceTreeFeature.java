package sauce.saucecraft.world.gen.features;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import sauce.saucecraft.init.ModBlocks;

public class SauceTreeFeature  extends AbstractTreeFeature<NoFeatureConfig> {
	   private static final BlockState TRUNK = ModBlocks.SAUCE_LOG.getDefaultState();
	   private static final BlockState LEAF = Blocks.OAK_LEAVES.getDefaultState();

	   public SauceTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51443_1_, boolean p_i51443_2_) {
	      super(p_i51443_1_, p_i51443_2_);
	   }

	   public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox p_208519_5_) {
	      int i = rand.nextInt(3) + rand.nextInt(3) + 5;
	      boolean flag = true;
	      if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getMaxHeight()) {
	         for(int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
	            int k = 1;
	            if (j == position.getY()) {
	               k = 0;
	            }

	            if (j >= position.getY() + 1 + i - 2) {
	               k = 2;
	            }

	            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

	            for(int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
	               for(int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
	                  if (j >= 0 && j < worldIn.getMaxHeight()) {
	                     if (!func_214587_a(worldIn, blockpos$mutableblockpos.setPos(l, j, i1))) {
	                        flag = false;
	                     }
	                  } else {
	                     flag = false;
	                  }
	               }
	            }
	         }

	         if (!flag) {
	            return false;
	         } else if (isSoil(worldIn, position.down(), getSapling()) && position.getY() < worldIn.getMaxHeight() - i - 1) {
	            this.setDirtAt(worldIn, position.down(), position);
	            int k2 = i - rand.nextInt(7) - 1;
	            int i3 = position.getX();
	            int j3 = position.getZ();
	            int y1 = position.getY();
	            int j1 = 0;
	            int height = 0;
	            
	            BlockPos blockpos = new BlockPos(i3, y1, j3);
	            if(k2<4) {
	            	k2 = 5;
	            }
		        for(j1 = 0; j1<=k2; j1++) {
		        	blockpos = new BlockPos(i3, y1+j1, j3);
		            height = blockpos.getY();
		            placeLog(changedBlocks, worldIn, blockpos, p_208519_5_);
		        }
		        int treex = blockpos.getX();
		        int treez = blockpos.getZ();
		        height = blockpos.getY();
		        blockpos = new BlockPos(treex, height + 1, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex+1, height + 1, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex-1, height + 1, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height + 1, treez+1);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height + 1, treez-1);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height + 2, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex+1, height, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex-1, height, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height, treez+1);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height, treez-1);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex+2, height, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex-2, height, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height, treez+2);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height, treez-2);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex+2, height-1, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex-2, height-1, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height-1, treez+2);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height-1, treez-2);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex+1, height-1, treez);
		        placeLog(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex-1, height-1, treez);
		        placeLog(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height-1, treez+1);
		        placeLog(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height-1, treez-1);
		        placeLog(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex+1, height-1, treez+1);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex-1, height-1, treez-1);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex-1, height-1, treez+1);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex+1, height-1, treez-1);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex+2, height-2, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex-2, height-2, treez);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height-2, treez+2);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
		        blockpos = new BlockPos(treex, height-2, treez-2);
		        placeLeafAt(changedBlocks, worldIn, blockpos, p_208519_5_);
	            
	            

	            return true;
	         } else {
	            return false;
	         }
	      } else {
	         return false;
	      }
	   }

	   private void placeLog(Set<BlockPos> p_208532_1_, IWorldWriter p_208532_2_, BlockPos p_208532_3_, MutableBoundingBox p_208532_4_) {
	      this.setLogState(p_208532_1_, p_208532_2_, p_208532_3_, TRUNK, p_208532_4_);
	   }

	   private void placeLeafAt(Set<BlockPos> worldIn, IWorldGenerationReader pos, BlockPos p_175924_3_, MutableBoundingBox p_175924_4_) {
	      if (isAirOrLeaves(pos, p_175924_3_)) {
	         this.setLogState(worldIn, pos, p_175924_3_, LEAF, p_175924_4_);
	      }

	   }
	}