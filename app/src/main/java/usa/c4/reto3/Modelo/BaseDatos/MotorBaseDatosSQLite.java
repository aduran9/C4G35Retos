package usa.c4.reto3.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // --------------------------------TABLA FAVORITOS--------------------------------------------
        //***** Creación de BD
        db.execSQL("CREATE TABLE favoritos (id INT, titulo TEXT, descripcion TEXT)"); //id INT
        //***** Registros
        //db.execSQL("INSERT INTO favoritos VALUES (0, 'Bomber Steel','Classic Temper')");
        //db.execSQL("INSERT INTO favoritos VALUES (1, 'Amerik Goldi','Long Sleves Du')");
        //db.execSQL("INSERT INTO favoritos VALUES (2, 'Liason Coope','Hallial StormT')");

        // --------------------------------TABLA PRODUCTOS--------------------------------------------
        //***** Creación de BD
        db.execSQL("CREATE TABLE productos (imagen INT, titulo TEXT, descripcion TEXT)");
        //***** Registros
        db.execSQL("INSERT INTO productos VALUES (0, 'Becerro Cuero','BomberJack Leder Motorrader')");
        db.execSQL("INSERT INTO productos VALUES (1, 'Plumas Invierno','Cosy Feathers Neck Protector')");
        db.execSQL("INSERT INTO productos VALUES (2, 'Silicon Plata','Women Silicon Winter Brand')");

        // --------------------------------TABLA SERVICIOS--------------------------------------------
        //***** Creación de BD
        db.execSQL("CREATE TABLE servicios (imagen INT, titulo TEXT, descripcion TEXT)"); //imagen y 0,1,2
        //***** Registros
        db.execSQL("INSERT INTO servicios VALUES (0, 'Confección Taylor:','Toma de medidas en el lugar que lo indique, avanzadi sistema de talle.')");
        db.execSQL("INSERT INTO servicios VALUES (1, 'Arreglo Deckland:','Ajuste, entalla, de acuerdo a sus indicaciones, reparación de vestidos.')");
        db.execSQL("INSERT INTO servicios VALUES (2, 'Recolección London:','Disposición final y Manejo del ciclo completo de la ropa de vestir.')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE favoritos");
        db.execSQL("DROP TABLE productos");
        db.execSQL("DROP TABLE servicios");
        onCreate(db);
    }
}
