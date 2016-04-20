package menu.catz.aaron.catzmenu;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

public class Player {
    Context context;
    LatLng pos;
    int maxHealth, Health, Damage, Defence, Money, EXP, Level, EXPLevel;
    GPSTracker gps;
    Player (Context _CONTEXT) {
        context = _CONTEXT;
        gps = new GPSTracker(context, this);
        //TODO create a call to get online data
        //TODO could have possibility for local save
    }
    private void lvlUp() {
        maxHealth*=1.15;
        Health = maxHealth;
        EXPLevel*=1.25;
        EXP=0;
        Damage*=1.1;
        Defence*=1.05;
        Level++;
    }

    public void updateLocation(){
        pos = new LatLng(gps.location.getLatitude(), gps.location.getLongitude());
    }
}
