package usa.c4.reto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class sucursales extends AppCompatActivity {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagSucu1, imagSucu2, imagSucu3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucursales);

        // ----------------------------------------------------------------------------
        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.dj_sucursal1, getTheme());
        imagSucu1 = (ImageView) findViewById(R.id.imagSucu1);
        imagSucu1.setImageDrawable(drawable1);

        // ----------------------------------------------------------------------------
        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.dj_sucursal2, getTheme());
        imagSucu2 = (ImageView) findViewById(R.id.imagSucu2);
        imagSucu2.setImageDrawable(drawable2);

        // ----------------------------------------------------------------------------
        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.dj_sucursal3, getTheme());
        imagSucu3 = (ImageView) findViewById(R.id.imagSucu3);
        imagSucu3.setImageDrawable(drawable3);
    }
}