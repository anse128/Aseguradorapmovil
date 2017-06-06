package com.example.sebastian.aseguradora;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link IngresarFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link IngresarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IngresarFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText etCodigo,etCedula,etNombre,etTelefono,etEmail,
                etCovertura1;
    Button btnIngresar;

    String codigo, cedula, nombre, telefono, email;

    public IngresarFragment() {
        // Required empty public constructor
    }


    public static IngresarFragment newInstance(String param1, String param2) {
        IngresarFragment fragment = new IngresarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.fragment_ingresar,container,false);

        etCodigo = (EditText) view.findViewById(R.id.etcodigo);
        etCedula = (EditText) view.findViewById(R.id.etcedula);
        etNombre = (EditText) view.findViewById(R.id.etnombre);
        etTelefono = (EditText) view.findViewById(R.id.ettelefono);
        etEmail = (EditText) view.findViewById(R.id.etemail);

        etCovertura1 = (EditText) view.findViewById(R.id.etcovertura1);


        btnIngresar = (Button) view.findViewById(R.id.btningresar);

        final PolizasBD ayudabd = new PolizasBD(getContext());

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = ayudabd.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(PolizasBD.DatosTabla.COLUMNA_CODIGOS,etCodigo.getText().toString());
                valores.put(PolizasBD.DatosTabla.COLUMNA_CEDULAS,etCedula.getText().toString());
                valores.put(PolizasBD.DatosTabla.COLUMNA_NOMBRES,etNombre.getText().toString());
                valores.put(PolizasBD.DatosTabla.COLUMNA_TELEFONOS,etTelefono.getText().toString());
                valores.put(PolizasBD.DatosTabla.COLUMNA_EMAILS,etEmail.getText().toString());
                valores.put(PolizasBD.DatosTabla.COLUMNA_COBERTURAS,etCovertura1.getText().toString());


                //valores.put(PolizasBD.DatosTabla.COLUMNA_NOMBRES,etCovertura1.getText().toString());


                Long IdGuardado = db.insert(PolizasBD.DatosTabla.NOMBRE_TABLA, PolizasBD.DatosTabla.COLUMNA_CODIGOS,valores);
                Toast.makeText(getContext(), "Se ingreso la poliza con codigo: : " + IdGuardado, Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
