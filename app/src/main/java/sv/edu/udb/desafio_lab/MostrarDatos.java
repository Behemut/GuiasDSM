package sv.edu.udb.desafio_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {
    TextView txtNombre, txtAños, txtNuevoSueldo, txtIncremento, txtSalario;
    Button btnRegresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        // Obtener las variables enviadas desde la otra activity y definirlas en esta activity
        Bundle bundle = getIntent().getExtras();

        String nombre = bundle.getString("name");
        Double salario = Double.parseDouble(bundle.getString("salary"));
        Integer años = Integer.parseInt(bundle.getString("years"));
        Double incremento, porcentaje=0.0, nuevoSalario ;
        txtNombre = findViewById(R.id.txtRNombre);
        txtSalario = findViewById(R.id.txtRSalario);
        txtIncremento = findViewById(R.id.txtRAumento);
        txtAños = findViewById(R.id.txtRAños);
        txtNuevoSueldo = findViewById(R.id.txtNuevoSal);
        btnRegresar = findViewById(R.id.btnRegresar);

        txtNombre.setText(nombre);
        txtAños.setText(años+" años");
        txtSalario.setText("$ "+salario);

        if(salario < 500 && años >= 10) {
           porcentaje = 0.2;
        }
        else if(salario < 500 && años < 10){
            porcentaje = 0.05;
        }

        incremento = salario * porcentaje;
        nuevoSalario = salario + incremento;

        txtIncremento.setText("$ " + incremento + " (" + (porcentaje * 100) + "%)");
        txtNuevoSueldo.setText("$ "+ nuevoSalario);



        btnRegresar.setOnClickListener((v) -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}