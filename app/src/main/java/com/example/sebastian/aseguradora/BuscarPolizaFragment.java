package com.example.sebastian.aseguradora;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BuscarPolizaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BuscarPolizaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuscarPolizaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText etCodigo;
    TextView tvCedula, tvNombre, tvTelefono, tvEmail, tvCobert1;
    Button btnBuscar;
    String codigo;

    public BuscarPolizaFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BuscarPolizaFragment newInstance(String param1, String param2) {
        BuscarPolizaFragment fragment = new BuscarPolizaFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_buscar_poliza, container, false);

        etCodigo = (EditText) view.findViewById(R.id.etcodigo);
        tvCedula = (TextView) view.findViewById(R.id.tvcedula);
        tvNombre = (TextView) view.findViewById(R.id.tvnombre);
        tvTelefono = (TextView) view.findViewById(R.id.tvtelefono);
        tvEmail = (TextView) view.findViewById(R.id.tvemail);

        tvCobert1 = (TextView) view.findViewById(R.id.tvcobert1);

        btnBuscar = (Button) view.findViewById(R.id.btnbuscar_poliza);

        final PolizasBD polizasBD = new PolizasBD(getContext());
       // final CoberturaBD coberturaBD = new CoberturaBD(getContext());

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = polizasBD.getReadableDatabase();
                String[] argsel = {etCodigo.getText().toString()};
                String[] projection = {PolizasBD.DatosTabla.COLUMNA_CEDULAS, PolizasBD.DatosTabla.COLUMNA_NOMBRES,
                        PolizasBD.DatosTabla.COLUMNA_TELEFONOS, PolizasBD.DatosTabla.COLUMNA_EMAILS, PolizasBD.DatosTabla.COLUMNA_COBERTURAS};
                Cursor c = db.query(PolizasBD.DatosTabla.NOMBRE_TABLA, projection, PolizasBD.DatosTabla.COLUMNA_CODIGOS + "=?", argsel, null, null, null);
                c.moveToFirst();
                tvCedula.setText(c.getString(0));
                tvNombre.setText(c.getString(1));
                tvTelefono.setText(c.getString(2));
                tvEmail.setText(c.getString(3));
                tvCobert1.setText(c.getString(4));

                codigo = c.getString(4);
                //Log.v(codigo,"hola");
                //SQLiteDatabase cober = coberturaBD.getReadableDatabase();
                //String[] argse2 = {c.getString(4)};
                //String[] projection2 = {CoberturaBD.DatosTabla.COLUMNA_NOMBRES, CoberturaBD.DatosTabla.COLUMNA_PRIMAS};
                //Cursor a = db.query(CoberturaBD.DatosTabla.NOMBRE_TABLA, projection, CoberturaBD.DatosTabla.COLUMNA_NOMBRES + "=?", argsel, null, null, null);

                //tvCobert1.setText(a.getString(0));

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
