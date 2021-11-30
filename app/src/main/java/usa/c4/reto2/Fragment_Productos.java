package usa.c4.reto2;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment_Productos extends Fragment {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagProd1, imagProd2, imagProd3;

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__productos, container, false);
        // ----------------------------------------------------------------------------
        // --------------------------------Carga de Imágenes--------------------------------------------
        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.dj_bomberjack1, v.getContext().getTheme());
        imagProd1 = (ImageView) v.findViewById(R.id.imagProd1);
        imagProd1.setImageDrawable(drawable1);

        // ----------------------------------------------------------------------------
        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.dj_bomberjack2, v.getContext().getTheme());
        imagProd2 = (ImageView) v.findViewById(R.id.imagProd2);
        imagProd2.setImageDrawable(drawable2);

        // ----------------------------------------------------------------------------
        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.dj_bomberjack3, v.getContext().getTheme());
        imagProd3 = (ImageView) v.findViewById(R.id.imagProd3);
        imagProd3.setImageDrawable(drawable3);

        // ----------------------------------------------------------------------------
        return v;
    }
}