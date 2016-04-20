package menu.catz.aaron.catzmenu;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
//Maps template
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public GoogleMap mMap;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //startActivity(new Intent(getApplicationContext(),DrawerActivity.class));
    }
    private void attempt() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(/*gps.location.getLatitude(), gps.location.getLongitude()*/10,10)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(/*gps.location.getLatitude(), gps.location.getLongitude()*/10,10)));
    }
    public void update() {
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(new LatLng(/*gps.location.getLatitude(), gps.location.getLongitude()*/10,10)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(/*gps.location.getLatitude(), gps.location.getLongitude()*/10,10)));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //attempt();
    }
}
