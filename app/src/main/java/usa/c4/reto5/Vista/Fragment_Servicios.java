package usa.c4.reto5.Vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import usa.c4.reto5.Modelo.Adaptador;
import usa.c4.reto5.Modelo.Entidad;
import usa.c4.reto5.R;

public class Fragment_Servicios extends Fragment {

    int [] imagen = {R.drawable.dj_servicio_1, R.drawable.dj_servicio_2, R.drawable.dj_servicio_3};
    String TAG = "Fragment_Servicios";

    View v;
    ListView listaServicios;
    Adaptador adaptador;
    TextView mostrarjsons;

    // CONEXION A LA BASE DE DATOS: Instancia APEX de SQL en Oracle Cloud

    //Empty Public Constructor
    public Fragment_Servicios() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__servicios, container, false);
        // ----------------------------------------------------------------------------
        listaServicios = (ListView) v.findViewById(R.id.lista_servicios);
        adaptador = new Adaptador(getTablaServicios(), getContext());

        listaServicios.setAdapter(adaptador);

        mostrarjsons = (TextView) v.findViewById(R.id.mostrarjsons);
        // ----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaServicios(){
        ArrayList<Entidad> listaServicios = new ArrayList<>();

        /* ================================================================================================== */
        String url = "https://ge7ad7e12a53a66-proyectociclo4.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/servicios/servicios";

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //***********************************************************
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String titulo = jsonObject.getString("titulo");
                        String descripcion = jsonObject.getString("descripcion");

                        listaServicios.add(new Entidad(imagen[i], titulo, descripcion));
                        mostrarjsons.append(titulo + '\n');

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //***********************************************************
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
        /* ================================================================================================== */

        return listaServicios;
    }
}