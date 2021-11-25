package usa.c4.reto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class servicios extends AppCompatActivity {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagServ1, imagServ2, imagServ3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.dj_servicio_1, getTheme());
        imagServ1 = (ImageView) findViewById(R.id.imagServ1);
        imagServ1.setImageDrawable(drawable1);

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.dj_servicio_2, getTheme());
        imagServ2 = (ImageView) findViewById(R.id.imagServ2);
        imagServ2.setImageDrawable(drawable2);

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.dj_servicio_3, getTheme());
        imagServ3 = (ImageView) findViewById(R.id.imagServ3);
        imagServ3.setImageDrawable(drawable3);
    }
}