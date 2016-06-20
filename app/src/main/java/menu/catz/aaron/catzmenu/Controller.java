package menu.catz.aaron.catzmenu;

import android.content.Context;
import java.util.ArrayList;

public class Controller {

    Context context;
    Player player;
    ArrayList<Zombie> zombies;
    Boolean isMapActivity = false, isOptionsActivity = false, isShopActivity = false, isUpgradeActivity = false;

    Controller(Context _CONTEXT, Class _CLASS) {
        onNewActivity(_CONTEXT, _CLASS);
        player = new Player(context);
        zombies = new ArrayList<>();
    }

    public void onNewActivity(Context _CONTEXT, Class _CLASS) {
        context = _CONTEXT;
        updateContext();
        updateActivity(_CLASS);
    }

    private void updateContext () {
        player.gps.stopUsingGPS();
        player.context = context;
        player.gps.context = context;
        player.gps.getLocation();
    }
    private void updateActivity(Class _CLASS) {
        if (_CLASS.equals(MapsActivity.class)) {
            isMapActivity = true;
            isOptionsActivity = isShopActivity = isUpgradeActivity = false;
        } else if (_CLASS.equals(ShopActivity.class)) {
            isShopActivity = true;
            isOptionsActivity = isMapActivity = isUpgradeActivity = false;
        } else if (_CLASS.equals(UpgradeActivity.class)) {
            isMapActivity = true;
            isOptionsActivity = isShopActivity = isMapActivity = false;
        } else if (_CLASS.equals(OptionsActivity.class)) {
            isOptionsActivity = true;
            isMapActivity = isShopActivity = isUpgradeActivity = false;
        }
    }
}
/*package com.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class test extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	Texture img;
    Sprite sprite;
    Boolean movingright = false;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        sprite = new Sprite(img);
        sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2,Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);

        Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {

       if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            sprite.translateX(-1f);if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            sprite.translateX(1f);
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            sprite.translateY(1f);
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            sprite.translateY(-1f);

//        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
//            sprite.setPosition(Gdx.input.getX(),Gdx.graphics.getHeight() - Gdx.input.getY());

//        if(movingright)
//            sprite.translateX(1f);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(sprite, sprite.getX(), sprite.getY());
		batch.end();
	}

    @Override
    public boolean keyDown(int keycode) {
//        if(keycode == Input.Keys.LEFT)
//            sprite.translateX(-1f);

        if(keycode == Input.Keys.RIGHT)
            movingright = true;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        if(keycode == Input.Keys.RIGHT)
            movingright = false;

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        //sprite.setPosition(screenX, Gdx.graphics.getHeight() - screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        if(amount > 0)
            sprite.translateY(1f);
        if(amount < 0)
            sprite.translateY(-1f);
        return false;
    }
}
*/
