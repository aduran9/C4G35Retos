package usa.c4.reto3.Vista;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import usa.c4.reto3.Modelo.Adaptador;
import usa.c4.reto3.Modelo.BaseDatos.MotorBaseDatosSQLite;
import usa.c4.reto3.Modelo.Entidad;
import usa.c4.reto3.R;

public class Fragment_Servicios extends Fragment {

    int [] imagen = {R.drawable.dj_servicio_1, R.drawable.dj_servicio_2, R.drawable.dj_servicio_3};
    String TAG = "Fragment_Servicios";

    View v;
    ListView listaServicios;
    Adaptador adaptador;
    Cursor cursor;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;

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
        // ----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaServicios(){
        ArrayList<Entidad> listaServicios = new ArrayList<>();

        conectar = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        conectar.onUpgrade(db_leer, 1, 2);
        cursor = db_leer.rawQuery("SELECT * FROM servicios", null);
        Log.v(TAG, "Leyendo Base de Datos");

        //Trae elementos de BD a la visualización
        while(cursor.moveToNext()){
            Log.v(TAG, "dentro del while");
            // listaServicios.add(new Entidad(R.drawable.dj_servicio_1, cursor.getString(0), cursor.getString(1)));
            listaServicios.add(new Entidad(imagen[cursor.getInt(0)], cursor.getString(1), cursor.getString(2)));
            Log.v(TAG, "despues del while");
        }
        return listaServicios;
    }

    private ArrayList<Entidad> GetArrayItems(){
        ArrayList<Entidad> listaItems = new ArrayList<Entidad>();
        listaItems.add(new Entidad(R.drawable.dj_servicio_1, "Confección Taylor:", "Toma de medidas en el lugar que lo indique, avanzadi sistema de talle."));
        listaItems.add(new Entidad(R.drawable.dj_servicio_2, "Arreglo Deckland:", "Ajuste, entalla, de acuerdo a sus indicaciones, reparación de vestidos."));
        listaItems.add(new Entidad(R.drawable.dj_servicio_3, "Recolección London:", "Disposición final y Manejo del ciclo completo de la ropa de vestir."));
        return listaItems;
    }
}