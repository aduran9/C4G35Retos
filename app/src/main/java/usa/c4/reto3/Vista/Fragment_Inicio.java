package usa.c4.reto3.Vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import usa.c4.reto3.R;

public class Fragment_Inicio extends Fragment {

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__inicio, container, false);
        // ----------------------------------------------------------------------------


        // ----------------------------------------------------------------------------
        return v;
    }
}