package usa.c4.reto4.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import usa.c4.reto4.Modelo.Adaptador;
import usa.c4.reto4.Modelo.BaseDatos.MotorBaseDatosSQLite;
import usa.c4.reto4.Modelo.Entidad;
import usa.c4.reto4.R;

public class Fragment_Favoritos extends Fragment {

    int [] imagen = {R.drawable.dj_bomberjack1, R.drawable.dj_bomberjack2, R.drawable.dj_bomberjack3};
    String TAG = "Fragment_Favoritos";

    View v;
    ListView listaFavoritos;
    Adaptador adaptador;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;

    //Empty Public Constructor
    public Fragment_Favoritos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__favoritos, container, false);
        // ----------------------------------------------------------------------------
        listaFavoritos = (ListView) v.findViewById(R.id.lista_favoritos);
        adaptador = new Adaptador(getTablaFavoritos(), getContext());

        listaFavoritos.setAdapter(adaptador);
        // ----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaFavoritos(){
        ArrayList<Entidad> listaFavoritos = new ArrayList<>();

        conectar = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        // conectar.onUpgrade(db_leer, 1, 2);
        Cursor cursor = db_leer.rawQuery("SELECT * FROM favoritos", null);
        Log.v(TAG, "Leyendo Base de Datos");

        //Trae elementos de BD a la visualización
        while(cursor.moveToNext()){
            Log.v(TAG, "dentro de while");
            listaFavoritos.add(new Entidad(imagen[cursor.getInt(0)], cursor.getString(1), cursor.getString(2)));
            Log.v(TAG, "despues del while");
        }
        return listaFavoritos;
    }
}