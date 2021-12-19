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

public class Fragment_Productos extends Fragment {

    int [] imagen = {R.drawable.dj_bomberjack1, R.drawable.dj_bomberjack2, R.drawable.dj_bomberjack3};
    String TAG = "Fragment_Productos";

    View v;
    ListView listaProductos;
    Adaptador adaptador;
    TextView mostrarjsonp;

    // CONEXION A LA BASE DE DATOS: Instancia APEX de SQL en Oracle Cloud

    //Empty Public Constructor
    public Fragment_Productos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__productos, container, false);
        // ----------------------------------------------------------------------------
        listaProductos = (ListView) v.findViewById(R.id.lista_productos);
        adaptador = new Adaptador(getTablaProductos(), getContext());

        listaProductos.setAdapter(adaptador);

        mostrarjsonp = (TextView) v.findViewById(R.id.mostrarjsonp);
        // ----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaProductos(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();

        /* ================================================================================================== */
        String url = "https://ge7ad7e12a53a66-proyectociclo4.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/productos/productos";

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

                        listaProductos.add(new Entidad(imagen[i], titulo, descripcion));
                        mostrarjsonp.append(titulo + '\n');

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

        return listaProductos;
    }
}