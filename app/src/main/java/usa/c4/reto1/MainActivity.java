package usa.c4.reto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * @Author Andrés Durán
 * Clase extends AppCompatActivity
 */

public class MainActivity extends AppCompatActivity {

    Button boton1;
    TextView text1;

    /**
     * Pantalla de inicio en la app: Die Jacken
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button) findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("Bienvenido Estimado Cliente");
                Toast.makeText(getApplicationContext(), "Oprimió botón", Toast.LENGTH_LONG ).show();
            }
        });
        text1 = (TextView) findViewById(R.id.texto1);
    }

    /**
     * Menú de opciones en la app
     */
    //------------------------------ Menu de Opciones ------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return true;
    }

    /**
     * Mensaje en la pantalla de inicio al cambiar en las opciones del menú.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.productos){
            Toast.makeText(getApplicationContext(), "Oprimió Productos", Toast.LENGTH_LONG ).show();
            Intent productosPantalla = new Intent(this, productos.class);
            startActivity(productosPantalla);
        }
        if (id == R.id.servicios){
            Toast.makeText(getApplicationContext(), "Oprimió Servicios", Toast.LENGTH_LONG ).show();
            Intent serviciosPantalla = new Intent(this, servicios.class);
            startActivity(serviciosPantalla);
        }
        if (id == R.id.sucursales){
            Toast.makeText(getApplicationContext(), "Oprimió Sucursales", Toast.LENGTH_LONG ).show();
            Intent sucursalesPantalla = new Intent(this, sucursales.class);
            startActivity(sucursalesPantalla);
        }
        return super.onOptionsItemSelected(item);
    }
}