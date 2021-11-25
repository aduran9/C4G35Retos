package usa.c4.reto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class productos extends AppCompatActivity {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagProd1, imagProd2, imagProd3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.dj_bomberjack1, getTheme());
        imagProd1 = (ImageView) findViewById(R.id.imagProd1);
        imagProd1.setImageDrawable(drawable1);

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.dj_bomberjack2, getTheme());
        imagProd2 = (ImageView) findViewById(R.id.imagProd2);
        imagProd2.setImageDrawable(drawable2);

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.dj_bomberjack3, getTheme());
        imagProd3 = (ImageView) findViewById(R.id.imagProd3);
        imagProd3.setImageDrawable(drawable3);
    }
}