package com.dopingdetector.fragment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.dopingdetector.R;

public class Tab3Form extends Fragment{

    private EditText e1, e2, e3;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3form, container, false);
        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.hide();
        return rootView;
    }


    public void EnviarCorreo() {

        e1 = (EditText) getActivity().findViewById(R.id.editTextName);
        e2 = (EditText) getActivity().findViewById(R.id.editTextCode);
        e3 = (EditText) getActivity().findViewById(R.id.editTextDes);



        if(e1.equals("") || e1.length() == 0 || e1 == null||
           e2.equals("") || e2.length() == 0 || e2 == null||
           e3.equals("") || e3.length() == 0 || e3 == null){
            Toast.makeText(getActivity(),"Hay campos vacíos",
                    Toast.LENGTH_SHORT).show();
        }

        else
        {
            String Mensaje = "Nombre del fármaco: " + e1.getText() + "\n"
                    + "Código del fármaco: " + e2.getText() + "\n"
                    + "Descripción del fármaco: " + e3.getText() + "\n";

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("plain/text");
            i.putExtra(Intent.EXTRA_EMAIL,new String[]{"dopingdetector@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT,"Datos de nuevo farmaco");
            i.putExtra(Intent.EXTRA_TEXT,Mensaje);
            startActivity(i);

            e1.setText("");
            e2.setText("");
            e3.setText("");
        }



    }

}
