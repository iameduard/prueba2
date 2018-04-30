package com.edujimenez.miapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityConfirmar extends AppCompatActivity {

    TextView tvNombre ;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    TextView tvFecha;
    private String nombre      ;
    private String telefono    ;
    private String email       ;
    private String descripcion ;
    private int dia            ;
    private int mes            ;
    private int anno           ;
    private String fecha       ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        Intent intent=getIntent();
        Bundle extras   = intent.getExtras();
        //Leer los parametros...
        nombre       = extras.getString(getResources().getString(R.string.nombre));
        telefono     = extras.getString(getResources().getString(R.string.telefono));
        email        = extras.getString(getResources().getString(R.string.email));
        descripcion  = extras.getString(getResources().getString(R.string.descripcion));
        dia          = extras.getInt("dia");
        mes          = extras.getInt("mes");
        anno         = extras.getInt("anno");

        //String fecha        = extras.getString(getResources().getString(R.string.fecha));
        fecha=Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(anno);

        //Toast.makeText(ActivityConfirmar.this,fecha,Toast.LENGTH_SHORT).show();

        //De aqui para abajo esta Okey
        tvNombre        =(TextView) findViewById(R.id.tvNombre);
        tvTelefono      =(TextView) findViewById(R.id.tvTelefono);
        tvEmail         =(TextView) findViewById(R.id.tvEmail);
        tvDescripcion   =(TextView) findViewById(R.id.tvDescripcion);
        tvFecha         =(TextView) findViewById(R.id.tvFecha);

        tvNombre.setText(nombre);
        tvTelefono.setText(getResources().getString(R.string.telefono)+":"+telefono);
        tvEmail.setText(getResources().getString(R.string.email)+":"+email);
        tvDescripcion.setText(getResources().getString(R.string.descripcion)+":"+descripcion);
        tvFecha.setText(getResources().getString(R.string.fecha)+":"+fecha);


        agregarBotonEditar();
    }

    public void agregarBotonEditar(){
        Button btn_editar=(Button) findViewById(R.id.btn_editar);
        btn_editar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityConfirmar.this,MainActivity.class);
                intent.putExtra(getResources().getString(R.string.nombre),nombre);
                intent.putExtra(getResources().getString(R.string.telefono),telefono);
                intent.putExtra(getResources().getString(R.string.email),email);
                intent.putExtra(getResources().getString(R.string.descripcion),descripcion);
                intent.putExtra("dia",dia);
                intent.putExtra("mes",mes);
                intent.putExtra("anno",anno);
                //
                startActivity(intent);
                finish();
            }
        });
    }

}
