package usa.c4.reto3.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import usa.c4.reto3.R;

public class Fragment_Sucursales extends Fragment {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagSucu1, imagSucu2, imagSucu3;

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__sucursales, container, false);
        // ----------------------------------------------------------------------------
        // --------------------------------Carga de Imágenes--------------------------------------------
        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.dj_sucursal1, v.getContext().getTheme());
        imagSucu1 = (ImageView) v.findViewById(R.id.imagSucu1);
        imagSucu1.setImageDrawable(drawable1);

        // ----------------------------------------------------------------------------
        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.dj_sucursal2, v.getContext().getTheme());
        imagSucu2 = (ImageView) v.findViewById(R.id.imagSucu2);
        imagSucu2.setImageDrawable(drawable2);

        // ----------------------------------------------------------------------------
        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.dj_sucursal3, v.getContext().getTheme());
        imagSucu3 = (ImageView) v.findViewById(R.id.imagSucu3);
        imagSucu3.setImageDrawable(drawable3);

        // ----------------------------------------------------------------------------
        return v;
    }
}