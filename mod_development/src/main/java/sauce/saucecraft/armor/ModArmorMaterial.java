package sauce.saucecraft.armor;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import sauce.saucecraft.Reference;
import sauce.saucecraft.init.ModItems;

public class ModArmorMaterial {
	public static final IArmorMaterial tungsten = new MArmorMaterial(Reference.MODID + ":tungsten", 55, new int[] {4, 8, 10, 4}, 26, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, () -> Ingredient.fromItems(ModItems.tungsten_ingot));
	public static final IArmorMaterial emerald = new MArmorMaterial(Reference.MODID + ":emerald", 31, new int[] {2, 5, 7, 2}, 26, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, () -> Ingredient.fromItems(Items.EMERALD));
	public static final IArmorMaterial speed = new MArmorMaterial(Reference.MODID + ":speed", 50, new int[] {2, 4, 5, 3}, 26, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 3.0F, () -> Ingredient.fromItems(Items.SHULKER_SHELL));

    private static class MArmorMaterial implements IArmorMaterial{

        private static final int[] Max_Damage_Array = new int[] {13,15,16,11};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;

        public MArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> supplier) {
            this.name = name;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.toughness = toughness;
            this.repairMaterial = new LazyLoadBase<Ingredient>(supplier);
        }

        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyLoadBase<Ingredient> repairMaterial;


        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return Max_Damage_Array[slotIn.getIndex()] * maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }
    }


}
	

