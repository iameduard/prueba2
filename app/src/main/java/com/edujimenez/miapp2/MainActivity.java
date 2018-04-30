package com.edujimenez.miapp2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tietNombre;
    private TextInputEditText tietTelefono;
    private TextInputEditText tietEmail;
    private TextInputEditText tietDescripcion;
    private String            fecha;
    private DatePicker        dpfecha;
    int dia;
    int mes;
    int anno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //

        Intent intent=getIntent();
        Bundle extras   = intent.getExtras();
        if (extras != null){
            String nombre       = extras.getString(getResources().getString(R.string.nombre));
            String telefono     = extras.getString(getResources().getString(R.string.telefono));
            String email        = extras.getString(getResources().getString(R.string.email));
            String descripcion  = extras.getString(getResources().getString(R.string.descripcion));
            dia                 = extras.getInt("dia");
            mes                 = extras.getInt("mes")-1;
            anno                = extras.getInt("anno");
            //
            tietNombre          =(TextInputEditText)findViewById(R.id.campoNombre);
            tietTelefono        =(TextInputEditText)findViewById(R.id.campoTelf);
            tietEmail           =(TextInputEditText)findViewById(R.id.campoEmail);
            tietDescripcion     =(TextInputEditText)findViewById(R.id.campoDescripcion);
            dpfecha             =(DatePicker)findViewById(R.id.dp_fecha);

            //Asignar valores..
            tietNombre.setText(nombre);
            tietTelefono.setText(telefono);
            tietEmail.setText(email);
            tietDescripcion.setText(descripcion);
            dpfecha.updateDate(anno,mes,dia);
        }

        agregarBotonSiguiente();

    }

    public void agregarBotonSiguiente(){
        Button btn_siguiente=(Button) findViewById(R.id.btn_siguiente);
        btn_siguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                tietNombre     =(TextInputEditText) findViewById(R.id.campoNombre);
                tietTelefono   =(TextInputEditText) findViewById(R.id.campoTelf);
                tietEmail      =(TextInputEditText) findViewById(R.id.campoEmail);
                tietDescripcion=(TextInputEditText) findViewById(R.id.campoDescripcion);
                //DatePicker..
                dpfecha         =(DatePicker)findViewById(R.id.dp_fecha);
                dia             = dpfecha.getDayOfMonth();
                mes             = dpfecha.getMonth()+1;
                anno            = dpfecha.getYear();
                fecha           = Integer.toString(dia)+'-'+Integer.toString(mes)+'-'+Integer.toString(anno);

                /*
                Toast.makeText(MainActivity.this,fecha,Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,telefono.getText(),Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,email.getText(),Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,descripcion.getText(),Toast.LENGTH_SHORT).show();
                */

                //Contacto contacto=new Contacto(nombre, telefono, email, descripcion);
                Intent intent=new Intent(MainActivity.this,ActivityConfirmar.class);
                intent.putExtra(getResources().getString(R.string.nombre),tietNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.telefono),tietTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.email),tietEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.descripcion),tietDescripcion.getText().toString());
                //intent.putExtra(getResources().getString(R.string.fecha),fecha);
                intent.putExtra("dia",dia);
                intent.putExtra("mes",mes);
                intent.putExtra("anno",anno);
                //intent.putExtra(getResources().getString(R.string.descripcion),descripcion.getText());

                startActivity(intent);
                finish();
            }
        });
    }
}
