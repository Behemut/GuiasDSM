package sv.edu.udb.empleados;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class ImprimirEmpleados extends AppCompatActivity {
            TextView Nombre1, Sueldo1, isss1,afp1,renta1,bono1;
            Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimir_empleados);
        //Asignando Variables a sus respuesta de impresion
        Nombre1 = findViewById(R.id.txtNombre1);
        Sueldo1 = findViewById(R.id.txtSueldo1);
        isss1 = findViewById(R.id.txtISSS1);
        afp1 = findViewById(R.id.txtAFP1);
        renta1 = findViewById(R.id.txtRenta1);
        Bundle bundle = getIntent().getExtras();
        Empleado worker1 = getIntent().getExtras().getParcelable("empleo1");
        btnRegresar = findViewById(R.id.btnRegresar);

        //Imprimiendo los valores en sus respectivos items en base a los objetos recolectados

             Nombre1.setText( " "+ worker1.Nombre.toString() + " " + worker1.Apellido);
             isss1.setText("$" + String.format ("%.2f",worker1.ISSS));
             afp1.setText("$" + String.format ("%.2f",worker1.AFP));
             renta1.setText("$" + String.format ("%.2f",worker1.RENTA));
             Sueldo1.setText("$"+ String.format ("%.2f",worker1.seldom_liquid()));


        btnRegresar.setOnClickListener((v)->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}