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

public class Fragment_Productos extends Fragment {

    int [] imagen = {R.drawable.dj_bomberjack1, R.drawable.dj_bomberjack2, R.drawable.dj_bomberjack3};
    String TAG = "Fragment_Productos";

    View v;
    ListView listaProductos;
    Adaptador adaptador;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;

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
        // ----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaProductos(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();

        conectar = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        // conectar.onUpgrade(db_leer, 1, 2);
        Cursor cursor = db_leer.rawQuery("SELECT * FROM productos", null);
        Log.v(TAG, "Leyendo Base de Datos");

        //Trae elementos de BD a la visualización
        while(cursor.moveToNext()){
            Log.v(TAG, "dentro del while");
            listaProductos.add(new Entidad(imagen[cursor.getInt(0)], cursor.getString(1), cursor.getString(2)));
            Log.v(TAG, "despues del while");
        }
        return listaProductos;
    }

    private ArrayList<Entidad> GetListItems(){
        ArrayList<Entidad> listaItems = new ArrayList<>();
        listaItems.add(new Entidad(R.drawable.dj_bomberjack1, "Becerro Cuero", "BomberJack Leder Motorrader"));
        listaItems.add(new Entidad(R.drawable.dj_bomberjack2, "Plumas Invierno", "Cosy Feathers Neck Protector"));
        listaItems.add(new Entidad(R.drawable.dj_bomberjack3, "Silicon Plata", "Women Silicon Winter Brand"));
        return listaItems;
    }

}