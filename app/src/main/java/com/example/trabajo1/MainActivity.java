package com.example.trabajo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView os;
    ImageView logo;

    CheckBox check;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        os = findViewById(R.id.listView);
        logo = findViewById(R.id.imageView3);
        String[] datos = {"Android","iOS"};
        check = findViewById(R.id.radioButton5);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String elementoSeleccionado = (String) parent.getItemAtPosition(position);

                if(elementoSeleccionado.equals("Android")){
                    logo.setImageResource(R.drawable.android);

                }else{
                    logo.setImageResource(R.drawable.ios);
                }
            }
        });



        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check.getText().equals("Otra")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    // Configurar el título del cuadro de diálogo
                    builder.setTitle("Ingrese otra preferencia");

                    // Crear un EditText para ingresar el texto
                    final EditText input = new EditText(MainActivity.this);
                    builder.setView(input);

                    // Configurar el botón positivo
                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String inputText = input.getText().toString();
                            check.setText(inputText);
                        }
                    });

                    // Configurar el botón negativo
                    builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    // Mostrar el cuadro de diálogo de alerta
                    builder.show();
                }
            }
        });

    }
}