package com.movie.movie2;

import android.os.Bundle;
import android.support.annotation.NonNull;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
/*
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

*/
import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    //private FusedLocationProviderClient mFusedLocationClient;

   //  private FusedLocationProviderClient mFusedLocationClient;
    private static final int RC_LOCATION = 1;
    protected Location mLastLocation;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);

        //mFusedLocationClient= LocationServices.getFusedLocationProviderClient(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
/*
    @AfterPermissionGranted(RC_LOCATION)
    public void getLastLocation() {
        String[] perms = {android.Manifest.permission.ACCESS_FINE_LOCATION};
        if(EasyPermissions.hasPermissions(this, perms)) {
            mFusedLocationClient.getLastLocation().addOnCompleteListener(this, new OnCompleteListener<Location>() {
                public void onComplete(@NonNull Task<Location> task) {
                    if(task.isSuccessful() && task.getResult() != null) {
                        mLastLocation = task.getResult();
                    }
                }
            });
        }
    }
*/

    /*
  if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
        mMap.setMyLocationEnabled(true);
    } else {
        // Show rationale and request permission.
    }

    protected synchronized void bildGoogleApiClient(){
        if(mGoogleApiClient == null){
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this,this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            } else {
                // Permission was denied. Display an error message.
            }
        }
        */
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in duksung and move the camera
       /*
        LatLng duksung = new LatLng(37.651799, 127.015743 );
        LatLng cgv = new LatLng(37.651798, 127.015742 );

        mMap.addMarker(new MarkerOptions().position(duksung).title("Marker in duksung"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(duksung,20));
*/
        LatLng duksung = new LatLng(37.651799, 127.015743 );
        LatLng suyu = new LatLng(37.651161, 127.015974   );
        LatLng cgv = new LatLng(37.642319, 127.029821 );
        LatLng megabox = new LatLng(37.654600, 127.038738 );
        LatLng lotte = new LatLng(37.635787, 127.023789  );
        LatLng cgv2 = new LatLng(37.612055, 127.030738 );
        LatLng lotte2 = new LatLng(37.654801, 127.061067  );


        MarkerOptions markerOptions = new MarkerOptions();
        MarkerOptions markerOptions1 = new MarkerOptions();
        MarkerOptions markerOptions2 = new MarkerOptions();
        MarkerOptions markerOptions3 = new MarkerOptions();
        MarkerOptions markerOptions4 = new MarkerOptions();
        MarkerOptions markerOptions5 = new MarkerOptions();
        MarkerOptions markerOptions6 = new MarkerOptions();

        markerOptions.position(duksung)
                .title("내 위치" )
                .snippet("덕성여자대학교");

        markerOptions1.position(suyu)
                .title("너 위치" )
                .snippet("수유역");

        markerOptions2.position(cgv)
                .title("수유 cgv" )
                .snippet("어벤져스 5:15")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .alpha(0.8f);

        markerOptions3.position(megabox)
                .title("창동 메가박스" )
                .snippet("그날, 바다 5:30")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .alpha(0.8f);

        markerOptions4.position(lotte)
                .title("수유 롯데시네마" )
                .snippet("챔피언 5:20")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .alpha(0.8f);

        markerOptions5.position(cgv2)
                .title("미아 cgv" )
                .snippet("그날, 바다 5:30")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .alpha(0.8f);

        markerOptions6.position(lotte2)
                .title("노원 롯데시네마" )
                .snippet("어벤져스 5:50")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .alpha(0.8f);

        mMap.addMarker(markerOptions);
        mMap.addMarker(markerOptions1);
        mMap.addMarker(markerOptions2);
        mMap.addMarker(markerOptions3);
        mMap.addMarker(markerOptions4);
        mMap.addMarker(markerOptions5);
        mMap.addMarker(markerOptions6);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(duksung,15));


        // Add a marker in duksung and move the camera
        // final LatLng duksung = new LatLng(37.651799, 127.015743);
/*
        Button button = (Button)findViewById(R.id.button3D);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(duksung)      // Sets the center of the map to Mountain View
                        .zoom(17)                   // Sets the zoom
                        .bearing(90)                // Sets the orientation of the camera to east
                        .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                        .build();                   // Creates a CameraPosition from the builder
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });
*/



    }
}
