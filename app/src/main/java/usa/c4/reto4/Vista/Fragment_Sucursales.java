package usa.c4.reto4.Vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.osmdroid.config.Configuration;
import org.osmdroid.library.BuildConfig;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

import usa.c4.reto4.R;

public class Fragment_Sucursales extends Fragment {

    private MapView myOpenMapView;
    private MapController myMapController;

    View v;
    GeoPoint galerias, fontanar, tibabuye, centrare;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__sucursales, container, false);
        // ----------------------------------------------------------------------------
        myOpenMapView = (MapView) v.findViewById(R.id.openmapview);

        /* ---- necesitamos establecer el valor del agente de usuario en la configuración ------- */
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        /*   punto de geolocalizacion de ejemplo */
        galerias = new GeoPoint(4.642161, -74.075007);
        fontanar = new GeoPoint(4.885085, -74.034841);
        tibabuye = new GeoPoint(4.756444, -74.114453);
        centrare = new GeoPoint(4.77025186075926, -74.06770746829463);

        myOpenMapView.setBuiltInZoomControls(true);

        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(centrare);
        myMapController.setZoom(13);

        myOpenMapView.setMultiTouchControls(true);

        /* -------------------------------------------------------------------------------------------------- */
        final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()), myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationoverlay); //No añadir si no quieres una marca
        myLocationoverlay.enableMyLocation();

        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                myMapController.animateTo(myLocationoverlay.getMyLocation());
            }
        });
        /* -------------------------------------------------------------------------------------------------- */

        /* MARCAS EN EL MAPA */
        ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
        puntos.add(new OverlayItem("Sede Galerias", "BOGT: AV CL 53 25-35", galerias));
        puntos.add(new OverlayItem("Sede Fontanar", "CHIA: CC Fontanar L123", fontanar));
        puntos.add(new OverlayItem("Sede Tibabuyes", "SUBA: DG 149 142-52", tibabuye));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);
        // ----------------------------------------------------------------------------
        return v;
    }

    /** Se complicó la traída de GoogleMaps al fragment sucursales
    public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

        private GoogleMap mMap;
        private ActivityMapsBinding binding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            binding = ActivityMapsBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            mMap = googleMap;

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(4.743615, -74.06633), 11));

            // Add a marker in Galerias and move the camera
            LatLng galerias = new LatLng(4.642161, -74.075007);
            mMap.addMarker(new MarkerOptions()
                    .position(galerias)
                    .title("Sede Galerias")
                    .snippet("BOGT: AV CL 53 25-35"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(galerias));

            // Add a marker in Fontanar and move the camera
            LatLng fontanar = new LatLng(4.885085, -74.034841);
            mMap.addMarker(new MarkerOptions()
                    .position(fontanar)
                    .title("Sede Fontanar")
                    .snippet("CHIA: CC Fontanar L123"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(fontanar));

            // Add a marker in Tibabuye and move the camera
            LatLng tibabuye = new LatLng(4.756444, -74.114453);
            mMap.addMarker(new MarkerOptions()
                    .position(tibabuye)
                    .title("Sede Tibabuyes")
                    .snippet("SUBA: DG 149 142-52"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(tibabuye));
    }
    */
}