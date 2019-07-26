package sauce.saucecraft.handlers;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import sauce.saucecraft.blocks.BlackstoneWireBlock;
import sauce.saucecraft.blocks.BluestoneWireBlock;
import sauce.saucecraft.blocks.BrownstoneWireBlock;
import sauce.saucecraft.blocks.CyanstoneWireBlock;
import sauce.saucecraft.blocks.GreenstoneWireBlock;
import sauce.saucecraft.blocks.OrangestoneWireBlock;
import sauce.saucecraft.blocks.PinkstoneWireBlock;
import sauce.saucecraft.blocks.PurplestoneWireBlock;
import sauce.saucecraft.blocks.WhitestoneWireBlock;
import sauce.saucecraft.blocks.YellowstoneWireBlock;
import sauce.saucecraft.init.ModBlocks;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ModColorHandler {
	
	@SubscribeEvent
	public static void registerBlockColors(ColorHandlerEvent.Block event) {
		BlockColors colors = event.getBlockColors();
	    final IBlockColor compressedColor = (state, blockAccess, pos, tintIndex) -> getColor(state);
	    colors.register(compressedColor, ModBlocks.bluestone_wire);
	    colors.register(compressedColor, ModBlocks.greenstone_wire);
	    colors.register(compressedColor, ModBlocks.yellowstone_wire);
	    colors.register(compressedColor, ModBlocks.orangestone_wire);
	    colors.register(compressedColor, ModBlocks.cyanstone_wire);
	    colors.register(compressedColor, ModBlocks.brownstone_wire);
	    colors.register(compressedColor, ModBlocks.purplestone_wire);
	    colors.register(compressedColor, ModBlocks.pinkstone_wire);
	    colors.register(compressedColor, ModBlocks.whitestone_wire);
	    colors.register(compressedColor, ModBlocks.blackstone_wire);
	}
	
	private static int getColor(BlockState state){
		if(state.getBlock() == ModBlocks.bluestone_wire) {
			return BluestoneWireBlock.colorMultiplier(state.get(BluestoneWireBlock.POWER));
		}
		else if (state.getBlock() == ModBlocks.greenstone_wire) {
			return GreenstoneWireBlock.colorMultiplier(state.get(GreenstoneWireBlock.POWER));
		}
		else if (state.getBlock() == ModBlocks.yellowstone_wire) {
			return YellowstoneWireBlock.colorMultiplier(state.get(YellowstoneWireBlock.POWER));
		}
		else if (state.getBlock() == ModBlocks.orangestone_wire) {
			return OrangestoneWireBlock.colorMultiplier(state.get(OrangestoneWireBlock.POWER));
		}
		else if (state.getBlock() == ModBlocks.cyanstone_wire) {
			return CyanstoneWireBlock.colorMultiplier(state.get(CyanstoneWireBlock.POWER));
		}
		else if (state.getBlock() == ModBlocks.brownstone_wire) {
			return BrownstoneWireBlock.colorMultiplier(state.get(BrownstoneWireBlock.POWER));
		}
		else if (state.getBlock() == ModBlocks.purplestone_wire) {
			return PurplestoneWireBlock.colorMultiplier(state.get(PurplestoneWireBlock.POWER));
		}
		else if (state.getBlock() == ModBlocks.pinkstone_wire) {
			return PinkstoneWireBlock.colorMultiplier(state.get(PinkstoneWireBlock.POWER));
		}
		else if (state.getBlock() == ModBlocks.whitestone_wire) {
			return WhitestoneWireBlock.colorMultiplier(state.get(WhitestoneWireBlock.POWER));
		}
		else if (state.getBlock() == ModBlocks.blackstone_wire) {
			return BlackstoneWireBlock.colorMultiplier(state.get(BlackstoneWireBlock.POWER));
		}
		else {
			return 0;
		}
		

	  }

}
