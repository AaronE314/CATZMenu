package menu.catz.aaron.catzmenu;

import com.google.android.gms.maps.model.LatLng;

public class Zombie {
    LatLng pos;
    int Health, Damage, Defence, Atck, Def;
    double Lat, Long, spdLat, spdLong, spdMax= 1;
    Zombie(String type) {
        //TODO create a call to pull data from json
        //TODO can be online can be a local file
    }
    private double getSpdLat (LatLng you){
        spdLat = spdMax * Math.cos(Math.tan(((Lat - you.latitude)/(Long - you.longitude))));
        if (Lat > you.latitude) {
            spdLat*=(-1);
        }
        return spdLat;
    }
    private double getSpdLong (LatLng you){
        spdLat = spdMax * Math.sin(Math.tan(((Lat - you.latitude)/(Long - you.longitude))));
        if (Long > you.longitude) {
            spdLong*=(-1);
        }
        return spdLong;
    }
    private double attack (int Defence) {
        Atck = (Damage / Defence) * 10;
        return Atck;
    }
    private double defend (int Damage) {
        Def = (Damage / Defence) * 10;
        return Def;
    }
}
