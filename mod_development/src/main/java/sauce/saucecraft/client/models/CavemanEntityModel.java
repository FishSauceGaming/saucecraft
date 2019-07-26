package sauce.saucecraft.client.models;

import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import sauce.saucecraft.entities.CavemanEntity;

@OnlyIn(Dist.CLIENT)
public class CavemanEntityModel extends PlayerModel<CavemanEntity>{

	public CavemanEntityModel(float modelSize, boolean smallArmsIn) {
		super(modelSize, smallArmsIn);
	}

}
