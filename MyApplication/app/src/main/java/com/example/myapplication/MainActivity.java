package com.example.myapplication;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextSurname, editTextEmail, editTextPhone, editTextPassword, editPasswordConfirm;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.Surname);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editPasswordConfirm = findViewById(R.id.editTextPasswordConfirm);
        buttonSubmit= findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String confirmPassword = editPasswordConfirm.getText().toString().trim();



                if (TextUtils.isEmpty(name)) {
                    editTextName.setError("Podaj imię");
                    return;
                }

                if (TextUtils.isEmpty(surname)) {
                    editTextSurname.setError("Podaj nazwisko");
                    return;
                }

                if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    editTextEmail.setError("Podaj poprawny adres e-mail");
                    return;
                }

                if (TextUtils.isEmpty(phone) || phone.length() < 9) {
                    editTextPhone.setError("Podaj poprawny numer telefonu");
                    return;
                }

                if (TextUtils.isEmpty(password) || password.length() < 6) {
                    editTextPassword.setError("Hasło musi zawierać co najmniej 6 znaków");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    editPasswordConfirm.setError("Hasła się nie zgadzają");
                    return;
                }

                Toast.makeText(MainActivity.this, "Formularz został poprawnie wypełniony!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
