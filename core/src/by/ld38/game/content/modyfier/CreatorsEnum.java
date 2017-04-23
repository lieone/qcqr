package by.ld38.game.content.modyfier;

import by.ld38.game.content.asset.AnimationContent;
import by.ld38.game.content.screen.common.component.base.Position;
import by.ld38.game.content.screen.common.component.render.Animation;
import by.ld38.game.content.screen.common.component.render.RenderOrder;
import by.ld38.game.content.screen.common.component.render.Scale;
import by.ld38.game.content.screen.process.component.Player;
import by.ld38.game.content.screen.process.component.RadPosition;
import by.ld38.game.content.screen.process.component.Velocity;
import by.ld38.game.utils.help.CreateEntityHelper;
import com.artemis.World;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public enum CreatorsEnum {
    HERO_CAR(new CarCreator()),

    ;
    private CreateEntityHelper helper;

    CreatorsEnum(CreateEntityHelper helper) {
        this.helper = helper;
    }

    public int create(World wOrld) {
        return helper.createEntity(wOrld);
    }
}

class CarCreator extends CreateEntityHelper {
    public CarCreator() {
        super(Velocity.class, RenderOrder.class, RadPosition.class, Animation.class, Position.class, Scale.class, Player.class);
    }

    @Override
    protected void initializeEntity(World world, int id) {
        world.getMapper(Animation.class).get(id).model = AnimationContent.CAR_HERO.getModel();
    }
}
