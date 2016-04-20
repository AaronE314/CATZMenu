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
