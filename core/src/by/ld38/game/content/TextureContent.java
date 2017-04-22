package by.ld38.game.content;

import com.badlogic.gdx.graphics.Texture;

/**
 * Content of textures
 *
 * @author SharK729
 * @since 1.0
 */
public enum TextureContent {
    TEST("test/test.png")


    ;
    private Texture texture;

    TextureContent(String filePath) {
        this.texture = new Texture(filePath);
    }

    public Texture getTexture() {
        return texture;
    }
}