package sauce.saucecraft.world.dimensions.sauce;

import java.util.ArrayList;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import sauce.saucecraft.init.ModBiomes;

public class SauceBiomeLayer implements IC0Transformer 
{
	public static ImmutableList<BiomeManager.BiomeEntry> getBiomesToGeneration()
	{
        ArrayList<BiomeManager.BiomeEntry> list = new ArrayList<>();
        list.add(new BiomeManager.BiomeEntry(ModBiomes.SAUCE_BIOME, 100));
        return ImmutableList.copyOf(list);
    }
	
	@SuppressWarnings("unchecked")
	private java.util.List<BiomeEntry>[] biomes = new java.util.ArrayList[BiomeType.values().length];
	private final SauceGenSettings settings;
	
	public SauceBiomeLayer(WorldType p_i48641_1_, SauceGenSettings p_i48641_2_) 
	{
		for (BiomeType type : BiomeType.values()) 
		{
			ImmutableList<BiomeManager.BiomeEntry> biomesToAdd = getBiomesToGeneration();
			int idx = type.ordinal();
	
			if (biomes[idx] == null) 
				biomes[idx] = new java.util.ArrayList<BiomeEntry>();
			
			if (biomesToAdd != null) 
				biomes[idx].addAll(biomesToAdd);
		}
	
		if (p_i48641_1_ == WorldType.DEFAULT_1_1) 
		{
			this.settings = null;
		} 
		else 
		{
			this.settings = p_i48641_2_;
		}
	}
	
	@SuppressWarnings("deprecation")
	public int apply(INoiseRandom context, int value) 
	{
		if (this.settings != null && this.settings.func_202199_l() >= 0) 
		{
            return this.settings.func_202199_l();
        } 
		else 
        {
            return Registry.BIOME.getId(getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType.DESERT, context).biome);
        }
	}
	
	protected BiomeEntry getWeightedBiomeEntry(BiomeType type, INoiseRandom context) 
	{
		java.util.List<BiomeEntry> biomeList = biomes[type.ordinal()];
		int totalWeight = net.minecraft.util.WeightedRandom.getTotalWeight(biomeList);
		int weight = BiomeManager.isTypeListModded(type)?context.random(totalWeight):context.random(totalWeight / 10) * 10;
		return (BiomeEntry)net.minecraft.util.WeightedRandom.getRandomItem(biomeList, weight);
	}
}