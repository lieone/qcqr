package by.ld38.game.content.screen.menu;

import by.ld38.game.content.screen.WorldScreen;
import by.ld38.game.content.screen.common.TextItem;
import by.ld38.game.content.screen.common.system.RenderTextSystem;
import by.ld38.game.core.item.ItemHolder;
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
        TextItem item = ItemHolder.create(world, TextItem.class);
        item.text.value = "Demo";

    }
}
