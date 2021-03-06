package com.example.matrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bouton;
    TextView text1;
    TextView text2;
    EditText editText1;
    EditText editText2;
    String chaine1, chaine2, Mamatrice1, Mamatrice2;
    double maMatrice1 [][];
    double maMatrice2 [][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton = findViewById(R.id.bouton);
        text1 = findViewById(R.id.mytext1);
        text2 = findViewById(R.id.mytext2);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText1 = findViewById(R.id.input1);
                editText2 = findViewById(R.id.input2);
                chaine1 = editText1.getText().toString();
                chaine2 = editText2.getText().toString();

                Matrice matrice = new Matrice();
                OperationsMatriceCarree opMatCar = new OperationsMatriceCarree();

                if (matrice.validation(chaine1)) {
                    text1.setText("it works !\n\n" + opMatCar.determinant(matrice.recupMat(chaine1)));
                } else {
                    text1.setText("Erreur !\n\n");
                }
            }
        });
    }
}