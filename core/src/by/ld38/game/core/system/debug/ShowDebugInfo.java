package by.ld38.game.core.system.debug;

import by.ld38.game.core.component.base.Debug;
import by.ld38.game.core.component.base.Text;
import by.ld38.game.core.component.player.Player;
import by.ld38.game.core.component.rad.RadDirection;
import by.ld38.game.core.component.rad.RadPosition;
import com.artemis.Aspect;
import com.artemis.BaseSystem;
import com.artemis.EntitySubscription;
import static by.ld38.game.util.DegreeUtil.*;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class ShowDebugInfo extends BaseSystem {
    @Override
    protected void processSystem() {
        EntitySubscription subscription = world.getAspectSubscriptionManager()
                .get(Aspect.all(RadDirection.class, Player.class, RadPosition.class));
        int id = subscription.getEntities().get(0);

        subscription = world.getAspectSubscriptionManager()
                .get(Aspect.all(Text.class, Debug.class));
        int textId = subscription.getEntities().get(0);


        RadDirection rd = world.getMapper(RadDirection.class).get(id);
        RadPosition rp = world.getMapper(RadPosition.class).get(id);


        Text text = world.getMapper(Text.class).get(textId);
        text.value = "Debug: " +
            "Rad.alpha: " + rad2dec( rp.alpha ) + "\n" +
            "Rad.beta: " + rad2dec( rp.beta ) + "\n" +
            "Direction: " + rad2dec( rd.angle )+ "\n" +
            "Speed: " + rd.speed;
    }
}
