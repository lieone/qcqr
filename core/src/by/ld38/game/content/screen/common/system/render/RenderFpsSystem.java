package by.ld38.game.content.screen.common.system.render;

import by.ld38.game.QcqrGame;
import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Show FPS;
 *
 * @author SharK729
 * @since 1.0
 */
public class RenderFpsSystem extends BaseSystem {
    private BitmapFont font = new BitmapFont();

    @Override
    protected void processSystem() {
        font.draw(QcqrGame.getInstance().batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 0f, 20f);
    }
}
