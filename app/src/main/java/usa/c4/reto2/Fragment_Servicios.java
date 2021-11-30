package usa.c4.reto2;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment_Servicios extends Fragment {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagServ1, imagServ2, imagServ3;

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__servicios, container, false);
        // ----------------------------------------------------------------------------
        // --------------------------------Carga de Imágenes--------------------------------------------
        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.dj_servicio_1, v.getContext().getTheme());
        imagServ1 = (ImageView) v.findViewById(R.id.imagServ1);
        imagServ1.setImageDrawable(drawable1);

        // ----------------------------------------------------------------------------
        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.dj_servicio_2, v.getContext().getTheme());
        imagServ2 = (ImageView) v.findViewById(R.id.imagServ2);
        imagServ2.setImageDrawable(drawable2);

        // ----------------------------------------------------------------------------
        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.dj_servicio_3, v.getContext().getTheme());
        imagServ3 = (ImageView) v.findViewById(R.id.imagServ3);
        imagServ3.setImageDrawable(drawable3);

        // ----------------------------------------------------------------------------
        return v;
    }
}