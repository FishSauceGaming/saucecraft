package sauce.saucecraft.entities;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;
import sauce.saucecraft.Reference;
import sauce.saucecraft.entities.CavemanEntity;
import sauce.saucecraft.init.ModBiomes;
import sauce.saucecraft.entities.LightningStaffEntity;

public class SauceEntities {
	
	public static EntityType<?> CAVEMAN_ENTITY = EntityType.Builder.create(CavemanEntity::new, EntityClassification.MISC).build(Reference.MODID +":caveman_entity").setRegistryName(Reference.MODID, "caveman_entity");
	public static EntityType<?> SAUCESLIME_ENTITY = EntityType.Builder.create(SauceSlimeEntity::new, EntityClassification.MONSTER).build(Reference.MODID +":sauceslime_entity").setRegistryName(Reference.MODID, "sauceslime_entity");
	public static EntityType<?> MUSCOVY_ENTITY = EntityType.Builder.create(MuscovyEntity::new, EntityClassification.AMBIENT).build(Reference.MODID + ":muscovy_entity").setRegistryName(Reference.MODID, "muscovy_entity");
	public static EntityType<LightningStaffEntity> LIGHTNING_STAFF_ENTITY = EntityType.Builder.<LightningStaffEntity>create(EntityClassification.MISC).setCustomClientFactory(LightningStaffEntity::new).size(0.01f, 0.01f).build(Reference.MODID + "lightning_staff_entity");
	public static Item CAVEMAN_ENTITY_EGG;
	public static Item SAUCESLIME_ENTITY_EGG;
	public static Item MUSCOVY_ENTITY_EGG;
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				CAVEMAN_ENTITY_EGG = registerEntitySpawnEgg(CAVEMAN_ENTITY, 0x735c03, 0xe0dbc5, "caveman_entity_egg"),
				SAUCESLIME_ENTITY_EGG = registerEntitySpawnEgg(SAUCESLIME_ENTITY, 0xb8aa74, 0xc2bc8d, "sauceslime_entity_egg"),
				MUSCOVY_ENTITY_EGG = registerEntitySpawnEgg(MUSCOVY_ENTITY, 0x78755c, 0xffffff, "muscovy_entity_egg")
				);
	}
	
	public static void registerEntityWorldSpawns() {
		registerEntityWorldSpawn(CAVEMAN_ENTITY, 5, 1, 5, ModBiomes.BLOODLANDS, Biomes.DESERT);
		registerEntityWorldSpawn(SAUCESLIME_ENTITY, 5, 1, 2, ModBiomes.BLOODLANDS);
		registerEntityWorldSpawn(MUSCOVY_ENTITY, 5, 1, 6, Biomes.BIRCH_FOREST, Biomes.BEACH, Biomes.FOREST, Biomes.PLAINS);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) {
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ItemGroup.MISC));
		item.setRegistryName(Reference.MODID, name);
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, int weight, int minSpawns, int maxSpawns, Biome...biomes) {
		for(Biome biome : biomes) {
			if (biome!=null) {
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, weight, minSpawns, maxSpawns));
			}
		}
	}

}




