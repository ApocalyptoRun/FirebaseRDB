package com.ibrahima.firebaserdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText name, firstname;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.nom);
        firstname = (EditText) findViewById(R.id.prenom);
        btnSave = (Button) findViewById(R.id.btnSave);

       // myRef = FirebaseDatabase.getInstance().getReference(Personne.class.getSimpleName());


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Personne personne = new Personne();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();

                personne.setNom(name.getText().toString());
                personne.setPrenom(firstname.getText().toString());

                myRef.push().setValue(personne).addOnSuccessListener(suc->
                {
                    Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
                });

            }
        });


    }
}