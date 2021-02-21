package sv.edu.udb.desafio_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //Declaracion de objetos

    EditText txtName, txtSalary, txtYears;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    txtName = findViewById(R.id.txtNombre);
    txtSalary = findViewById(R.id.txtSueldo);
    txtYears = findViewById(R.id.txtAños);
    btnSend = findViewById(R.id.btnEnviar);

    btnSend.setOnClickListener((v)->{
        String name = txtName.getText().toString();
        String salary = txtSalary.getText().toString();
        String years = txtYears.getText().toString();

        //Validaciones de la aplicacion
        if(!name.equals("") && !salary.equals("") && !years.equals("")) {

            if(!isNumeric(salary)) {
                Toast toastMessage = Toast.makeText(this,"El salario debe ser un valor numérico",Toast.LENGTH_LONG);
                toastMessage.show();
            }
            else if(Double.parseDouble(salary) < 100.0) {
                Toast toastMessage = Toast.makeText(this,"El salario debe ser mayor o igual a $100",Toast.LENGTH_LONG);
                toastMessage.show();
            }
            else if(!isNumeric(years)) {
                Toast toastMessage = Toast.makeText(this,"Formato de años, incorrecto",Toast.LENGTH_LONG);
                toastMessage.show();
            }
            else if(Double.parseDouble(years) < 0.0) {
                Toast toastMessage = Toast.makeText(this,"Los años no pueden ser menores a 0",Toast.LENGTH_LONG);
                toastMessage.show();
            }
            else {
                Intent intent = new Intent(this, MostrarDatos.class);
                intent.putExtra("name", name);
                intent.putExtra("salary", salary);
                intent.putExtra("years", years);
                startActivity(intent);
            }
        }
        else {
            Toast toastMessage = Toast.makeText(this,"Rellenar los campos vacíos",Toast.LENGTH_LONG);
            toastMessage.show();
        }
    });
    }

    public static boolean isNumeric(String string) {
        boolean result;

        try {
            Double.parseDouble(string);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }

        return result;
    }
}

