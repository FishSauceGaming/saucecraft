package sauce.saucecraft.world.dimensions.sauce;

import java.util.function.BiFunction;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;
import sauce.saucecraft.Reference;

public class SauceDimensionType extends ModDimension
{
	public SauceDimensionType(final ResourceLocation registryName) 
	{
		this.setRegistryName(registryName);
	}

	public static DimensionType getDimensionType() 
	{
		return DimensionType.byName(new ResourceLocation(Reference.MODID, "sauce_dimension"));
	}
	
	@Override
	public BiFunction<World, DimensionType, ? extends Dimension> getFactory() 
	{
		return SauceDimension::new;
	}
}