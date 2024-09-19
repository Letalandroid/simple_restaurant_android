package com.example.chamba19_9;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import controllers.ProductoPlato;
import models.Product;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spnPlatos;
    EditText txtCant;
    TextView txtResult;
    Button btnCalc;

    Product objProd;
    ProductoPlato objProdPlato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objProd = new Product();
        objProdPlato = new ProductoPlato();
        spnPlatos = findViewById(R.id.spnPlatos);
        txtCant = findViewById(R.id.txtCant);
        txtResult = findViewById(R.id.txtResult);
        btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(this);
    }

    private void calcular() {
        int plato = spnPlatos.getSelectedItemPosition();
        int num_platos = Integer.parseInt(txtCant.getText().toString());

        objProd.setPlato(plato);
        objProd.setNum_plato(num_platos);

        String mensaje = objProdPlato.calcOperation(objProd);
        txtResult.setText(mensaje);
    }

    @Override
    public void onClick(View v) {
        if (v == btnCalc) {
            try {
                calcular();
            } catch (Exception e) {
                Log.i("Restaurant", "" + e);
            }
        }
    }
}