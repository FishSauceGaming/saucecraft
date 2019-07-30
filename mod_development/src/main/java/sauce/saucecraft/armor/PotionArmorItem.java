package sauce.saucecraft.armor;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import sauce.saucecraft.init.ModItems;

public class PotionArmorItem extends ArmorItem{

	public PotionArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player){
		super.onArmorTick(stack, world, player);
		if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ModItems.speed_boots) {
			player.addPotionEffect(new EffectInstance(Effects.SPEED, 1, 0));
		}
		if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ModItems.water_helmet) {
			player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 1, 0));
			player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 1, 0));
		}
		if(player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ModItems.jump_pants) {
			player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 1, 0));
			player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 1, 0));
		}
	}
}
