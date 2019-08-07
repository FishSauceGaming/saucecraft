package sauce.saucecraft.tools;

import java.util.function.Supplier;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import sauce.saucecraft.Reference;
import sauce.saucecraft.init.ModItems;

public class ModItemTier implements IItemTier {


   public static final IItemTier tungsten = new ModItemTier(Reference.MODID + ":tungsten", 4, 1800, 10.5F, 4.0F, 10,  () -> Ingredient.fromItems(ModItems.tungsten_ingot));
   public static final IItemTier emerald = new ModItemTier(Reference.MODID + ":emerald", 3, 1064, 6.5F, 2.5F, 10,  () -> Ingredient.fromItems(Items.EMERALD));
   

   private final int harvestLevel;
   public final String name;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final LazyLoadBase<Ingredient> repairMaterial;

   private ModItemTier(String name, int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
	  this.name = name;
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
      this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
   }

   public int getMaxUses() {
      return this.maxUses;
   }

   public float getEfficiency() {
      return this.efficiency;
   }

   public float getAttackDamage() {
      return this.attackDamage;
   }

   public int getHarvestLevel() {
      return this.harvestLevel;
   }

   public int getEnchantability() {
      return this.enchantability;
   }
   
   @OnlyIn(Dist.CLIENT)
   public String getName() {
       return name;
   }

   public Ingredient getRepairMaterial() {
      return this.repairMaterial.getValue();
   }
}