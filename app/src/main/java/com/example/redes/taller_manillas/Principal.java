package com.example.redes.taller_manillas;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    private TextView resultado_pago;
    private EditText num_man;
    private Resources resources;
    private Spinner materiales_manillas;
    private Spinner tipo_manillas;
    private Spinner dije_manillas;
    private Spinner pago_manillas;
    private String mate_ma[];
    private String tipo_ma[];
    private String dije_ma[];
    private String pago_ma[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        resources=this.getResources();
        materiales_manillas=(Spinner) findViewById(R.id.cbxmaterial);
        tipo_manillas=(Spinner) findViewById(R.id.cbxtipo);
        dije_manillas=(Spinner) findViewById(R.id.cbxdije);
        pago_manillas=(Spinner) findViewById(R.id.cbxpago);

        mate_ma=resources.getStringArray(R.array.material_array);
        tipo_ma=resources.getStringArray(R.array.tipo_array);
        dije_ma=resources.getStringArray(R.array.dije_array);
        pago_ma=resources.getStringArray(R.array.pago_array);

        ArrayAdapter<String> adapter_material = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mate_ma);
        materiales_manillas.setAdapter(adapter_material);

        ArrayAdapter<String> adapter_tipo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipo_ma);
        tipo_manillas.setAdapter(adapter_tipo);

        ArrayAdapter<String> adapter_dije = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dije_ma);
        dije_manillas.setAdapter(adapter_dije);

        ArrayAdapter<String> adapter_pago = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,pago_ma);
        pago_manillas.setAdapter(adapter_pago);

        resultado_pago=(TextView)findViewById(R.id.txtpago_resultado);
        num_man=(EditText)findViewById(R.id.txtnumero);
    }

    public void calcular(View v){

if (Validar()){
    double valor =0;

    int tipo_selecci = tipo_manillas.getSelectedItemPosition();
    int material_selecci = materiales_manillas.getSelectedItemPosition();
    int pago_selecci = pago_manillas.getSelectedItemPosition();
    int dije_selecci = dije_manillas.getSelectedItemPosition();
    int Num = Integer.parseInt(num_man.getText().toString());

    if (material_selecci == 0 && dije_selecci == 0 && (tipo_selecci == 0 || tipo_selecci == 2)) {
        valor = 100;
    } else if (material_selecci == 0 && dije_selecci == 0 && tipo_selecci == 4) {
        valor = 80;
    } else if (material_selecci == 0 && dije_selecci == 0 && tipo_selecci == 3) {
        valor = 70;
    } else if (material_selecci == 0 && dije_selecci == 1 && (tipo_selecci == 0 || tipo_selecci == 2)) {
        valor = 120;
    } else if (material_selecci == 0 && dije_selecci == 1 && tipo_selecci == 4) {
        valor = 100;
    } else if (material_selecci == 0 && dije_selecci == 1 && tipo_selecci == 3) {
        valor = 90;
    } else if (material_selecci == 1 && dije_selecci == 0 && (tipo_selecci == 0 || tipo_selecci == 2)) {
        valor = 90;
    } else if (material_selecci == 1 && dije_selecci == 0 && tipo_selecci == 4) {
        valor = 70;
    } else if (material_selecci == 1 && dije_selecci == 0 && tipo_selecci == 3) {
        valor = 50;
    } else if (material_selecci == 1 && dije_selecci == 1 && (tipo_selecci == 0 || tipo_selecci == 2)) {
        valor = 110;
    } else if (material_selecci == 1 && dije_selecci == 1 && tipo_selecci == 4) {
        valor = 90;
    } else if (material_selecci == 1 && dije_selecci == 1 && tipo_selecci == 3) {
        valor = 80;
    } else {
        resultado_pago.setText(resources.getString(R.string.error_diponible) + " ");
        return;
    }
        double total = valor*Num;
        if (pago_selecci==0){
            resultado_pago.setText("$"+total);
        }else{
            total =total*3200;
            resultado_pago.setText("$"+total);
        }



}
    }


    public boolean Validar(){
        if (num_man.getText().toString().isEmpty()){
            num_man.setError(resources.getString(R.string.mensaje_error_num));
            return false;
        }
        return true;

    }

    public void Borrar(View v){
       num_man.setText("");
        resultado_pago.setText("");

    }
}
