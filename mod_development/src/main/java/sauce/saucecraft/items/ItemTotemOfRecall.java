package sauce.saucecraft.items;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ItemTotemOfRecall extends Item{
	
	public ItemTotemOfRecall(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		if (!worldIn.isRemote) {
			DimensionType dimType = playerIn.getSpawnDimension();
			
			if (dimType != playerIn.dimension) {
				playerIn.changeDimension(dimType);
			}
			
			BlockPos spawnPos = playerIn.getBedLocation(dimType);	
			
			if (spawnPos == null) {
				spawnPos = worldIn.getSpawnPoint();
			}
			Block blockType = playerIn.world.getBlockState(spawnPos).getBlock();
			
			if (blockType == Blocks.BLACK_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.BLUE_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.BROWN_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.CYAN_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.GRAY_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.GREEN_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.LIGHT_BLUE_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.LIGHT_GRAY_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.LIME_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.MAGENTA_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.ORANGE_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.PINK_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.PURPLE_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.RED_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.WHITE_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else if (blockType == Blocks.YELLOW_BED){
				spawnPos = playerIn.getBedLocation(dimType);
			}
			else {
				spawnPos = worldIn.getSpawnPoint();
			}
			
			getValidSpawn(blockType, worldIn, playerIn, spawnPos);
		}
		
		playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION,100,2));
		playerIn.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,100,2));
		playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION,100,2));
		playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE,100,2));
		playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH,100,2));
		playRecallSound(worldIn, playerIn);
		
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		if(!playerIn.abilities.isCreativeMode) {
			playerIn.inventory.deleteStack(itemstack);
		}
		
	    return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	   }

	public static void playRecallSound(World worldIn, PlayerEntity playerIn){
		
		int x = playerIn.getPosition().getX();
		int y = playerIn.getPosition().getY();
		int z = playerIn.getPosition().getZ();
		
		worldIn.playSound(null, x, y, z, SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.PLAYERS, 0.5f, 1.0f);
		
	}
	
	public static void getValidSpawn(Block blockType, World worldIn, PlayerEntity playerIn, BlockPos spawnPos){
		int ctr = 0;

		Block blockType1;
		
		do{	
			BlockPos pos = new BlockPos(spawnPos.getX(), (spawnPos.getY() + ctr), spawnPos.getZ());
			BlockPos pos1 = new BlockPos(spawnPos.getX(), (spawnPos.getY() + ctr + 1), spawnPos.getZ());
			blockType = worldIn.getBlockState(pos).getBlock();
			blockType1 = worldIn.getBlockState(pos1).getBlock();
			System.out.println(blockType1);
			System.out.println(blockType);
			ctr++;
		}while(blockType != Blocks.AIR && blockType1 != Blocks.AIR);
		
		playerIn.setPositionAndUpdate(spawnPos.getX(), (spawnPos.getY()+ctr), spawnPos.getZ());
	}

}
