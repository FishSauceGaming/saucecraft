package sauce.saucecraft.world.dimensions.sauce;

import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;
import sauce.saucecraft.world.types.SauceWorldType;

public class SauceBiomeProviderSettings implements IBiomeProviderSettings
{
	private WorldInfo worldInfo;
    private SauceGenSettings genSettings;

    public SauceBiomeProviderSettings setWorldInfo(WorldInfo worldInfo) 
    {
    	worldInfo.setGenerator(new SauceWorldType());
        this.worldInfo = worldInfo;
        return this;
    }

    public SauceBiomeProviderSettings setGeneratorSettings(SauceGenSettings genSettings) 
    {
        this.genSettings = genSettings;
        return this;
    }

    public WorldInfo getWorldInfo()
    {
    	worldInfo.setGenerator(new SauceWorldType());
        return worldInfo;
    }

    public SauceGenSettings getGeneratorSettings() 
    {
        return genSettings;
    }
}