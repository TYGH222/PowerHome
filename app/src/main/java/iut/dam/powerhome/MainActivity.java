package iut.dam.powerhome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView  emailText, passwordText;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        emailText = findViewById(R.id.textmail);
        passwordText = findViewById(R.id.textpassword);


        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");



        emailText.setText("Your Email: " + email);
        passwordText.setText("Your Password: " + password);

    }
}
