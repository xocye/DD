package com.example.xocye.dopingdetector.fragment;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xocye.dopingdetector.MainActivity;
import com.example.xocye.dopingdetector.R;
import com.example.xocye.dopingdetector.dataaccess.DataAccess;

public class Tab1Shear extends Fragment{//class
    private DataAccess da = null;
    private SQLiteDatabase db= null;
    private EditText et1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1shear, container, false);
        return rootView;

    }


    public void Busqueda() {

        da = new DataAccess((MainActivity) this.getActivity());
        db = da.getWritableDatabase();

        et1 = (EditText) getActivity().findViewById(R.id.editTextCodeB);
        String[] consulta = new String[]{et1.getText().toString()};
        if (et1.equals("") || et1.length() == 0 || et1 == null) {
            Toast.makeText(getActivity(), "El campo está vacío",
                    Toast.LENGTH_SHORT).show();
        } else {
            Cursor c = db.rawQuery("SELECT * FROM  Farmaco WHERE Code=?", consulta);
            if (c.moveToFirst()) {
                do {
                    String Code = c.getString(0);
                    String Name = c.getString(1);
                    String Description = c.getString(2);
                    Toast.makeText(getActivity(), "Nombre del fármaco: " + Name + "\n"
                                    + "Código del fármaco: " + Code + "\n"
                                    + "Descripción del fármaco: " + Description + "\n",
                            Toast.LENGTH_LONG).show();
                }
                while (c.moveToNext());

            } else {
                Toast.makeText(getActivity(), "No existe el farmaco",
                        Toast.LENGTH_SHORT).show();
            }

            et1.setText("");
        }
    }

}//class
