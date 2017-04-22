package by.ld38.game.screen.menu;

import by.ld38.game.screen.WorldScreen;
import by.ld38.game.screen.common.builder.TextCreator;
import by.ld38.game.screen.common.components.Text;
import by.ld38.game.screen.common.system.RenderTextSystem;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;

/**
 * TODO  plz, describe me
 *
 * @author SharK729
 * @since 1.0
 */
public class MenuWorldScreen extends WorldScreen {
    @Override
    public World generateWorld() {
        WorldConfiguration configuration = new WorldConfigurationBuilder()
                .with(new RenderTextSystem())
                .build();
        World world = new World(configuration);
        demo();
        return world;
    }

    private void demo() {
        int id = TextCreator.createText(world);
        Text text = world.getMapper(Text.class).get(id);
        text.value = "Demo";

    }
}