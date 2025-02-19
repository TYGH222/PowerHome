package iut.dam.powerhome;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private Button buttonretour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registre);

        String[] countryCodes = {"+33", "+1", "+44", "+49", "+91"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, countryCodes);
        Spinner spinner = findViewById(R.id.spinnerNumTel);
        spinner.setAdapter(adapter);

        EditText editText = findViewById(R.id.editTextNumber);
        editText.setBackground(null);



//        buttonretour = findViewById(R.id.buttonRetour);
//        if (buttonretour != null) {
//            buttonretour.setOnClickListener(v -> {
//                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            });
//        }
    }
}
