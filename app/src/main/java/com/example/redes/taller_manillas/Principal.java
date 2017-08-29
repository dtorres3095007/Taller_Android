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

    int  opcion_tipo_manilla = tipo_manillas.getSelectedItemPosition();
    int  opcion_material_manilla = materiales_manillas.getSelectedItemPosition();
    int  opcion_pago_manilla = pago_manillas.getSelectedItemPosition();
    int  opcion_dije_manilla = dije_manillas.getSelectedItemPosition();
    int Num =Integer.parseInt(num_man.getText().toString());
    String tipo_selecci = tipo_ma[opcion_tipo_manilla];
    String material_selecci = mate_ma[opcion_material_manilla];
    String pago_selecci = pago_ma[opcion_pago_manilla];
    String dije_selecci = dije_ma[opcion_dije_manilla];
if(material_selecci.equalsIgnoreCase("cuero") && dije_selecci.equalsIgnoreCase("martillo") && (tipo_selecci.equalsIgnoreCase("oro") || tipo_selecci.equalsIgnoreCase("oro rosado"))){
    valor=100;
}else if(material_selecci.equalsIgnoreCase("cuero") && dije_selecci.equalsIgnoreCase("martillo") && tipo_selecci.equalsIgnoreCase("plata") ){
    valor=80;
}else if(material_selecci.equalsIgnoreCase("cuero") && dije_selecci.equalsIgnoreCase("martillo") && tipo_selecci.equalsIgnoreCase("niquel")){
    valor=70;
}else if(material_selecci.equalsIgnoreCase("cuero") && dije_selecci.equalsIgnoreCase("ancla") && (tipo_selecci.equalsIgnoreCase("oro") || tipo_selecci.equalsIgnoreCase("oro rosado"))){
    valor=120;
}else if(material_selecci.equalsIgnoreCase("cuero") && dije_selecci.equalsIgnoreCase("ancla") && tipo_selecci.equalsIgnoreCase("plata")){
    valor=100;
}else if(material_selecci.equalsIgnoreCase("cuero") && dije_selecci.equalsIgnoreCase("ancla") && tipo_selecci.equalsIgnoreCase("niquel") ){
    valor=90;
}else if(material_selecci.equalsIgnoreCase("cuerda") && dije_selecci.equalsIgnoreCase("martillo") && (tipo_selecci.equalsIgnoreCase("oro") || tipo_selecci.equalsIgnoreCase("oro rosado"))){
    valor=90;
}else if(material_selecci.equalsIgnoreCase("cuerda") && dije_selecci.equalsIgnoreCase("martillo") && tipo_selecci.equalsIgnoreCase("plata") ){
    valor=70;
}else if(material_selecci.equalsIgnoreCase("cuerda") && dije_selecci.equalsIgnoreCase("martillo") && tipo_selecci.equalsIgnoreCase("niquel")){
    valor=50;
}else if(material_selecci.equalsIgnoreCase("cuerda") && dije_selecci.equalsIgnoreCase("ancla") && (tipo_selecci.equalsIgnoreCase("oro") || tipo_selecci.equalsIgnoreCase("oro rosado"))){
    valor=110;
}else if(material_selecci.equalsIgnoreCase("cuerda") && dije_selecci.equalsIgnoreCase("ancla") && tipo_selecci.equalsIgnoreCase("plata")){
    valor=90;
}else if(material_selecci.equalsIgnoreCase("cuerda") && dije_selecci.equalsIgnoreCase("ancla") && tipo_selecci.equalsIgnoreCase("niquel") ){
    valor=80;
}else{
    resultado_pago.setText("Manilla No Disponible");
    return;
}
        double total = valor*Num;
        if (pago_selecci.equalsIgnoreCase("dolar")){
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
}
