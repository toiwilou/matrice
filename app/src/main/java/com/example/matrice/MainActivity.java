package com.example.matrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bouton;
    TextView text;
    EditText editText;
    String chaine, Mamatrice;
    double maMatrice[][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton = findViewById(R.id.bouton);
        text = findViewById(R.id.mytext);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText = findViewById(R.id.input);
                chaine = editText.getText().toString();

                Matrice matrice = new Matrice();
                maMatrice = matrice.recupMat(chaine);

                Mamatrice = matrice.afficher_matrice(maMatrice);

                text.setText(" itworks !\n\n" + Mamatrice);
            }
        });
    }
}