package com.example.sebastian.aseguradora;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CoberturaFragment.OnFragmentInteractionListener, IngresarFragment.OnFragmentInteractionListener, BuscarPolizaFragment.OnFragmentInteractionListener, IngresarCoberturaFragment.OnFragmentInteractionListener {

    Bundle bundle;
    Button btnBuscarPoliza, btnIngresarPoliza, btnListarCobertura, btnIngrasarCobertura ;

    TextView tvCodigo ,tvNombre, tvPrima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = new Bundle();
        bundle.putInt("KEY", 40);

        btnBuscarPoliza = (Button) findViewById(R.id.btnbuscarpoliza);
        btnIngresarPoliza = (Button) findViewById(R.id.btningresarpoliza);
        btnListarCobertura = (Button) findViewById(R.id.btnlistarcobertura);
        btnIngrasarCobertura = (Button) findViewById(R.id.btningresarcobertura);


        final BuscarPolizaFragment buscarPolizaFragment = new BuscarPolizaFragment();
        final IngresarFragment ingresarFragment = new IngresarFragment();

        //final CoberturaBD coberturaBD = new CoberturaBD(getApplicationContext());

        //SQLiteDatabase cobertura = coberturaBD.getWritableDatabase();
        //ContentValues valores = new ContentValues();


        btnBuscarPoliza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, buscarPolizaFragment)
                        .commit();
            }
        });

        btnIngresarPoliza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, ingresarFragment)
                        .commit();
            }
        });

        btnListarCobertura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CoberturaFragment coberturaFragment = new CoberturaFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, coberturaFragment)
                        .commit();

            }
        });

        btnIngrasarCobertura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngresarCoberturaFragment ingresarCoberturaFragment = new IngresarCoberturaFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, ingresarCoberturaFragment)
                        .commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
