package com.renatoandrade.desafiohorizon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import controllers.SurfistaController;

public class SurfistaAdicionarActivity extends AppCompatActivity {

    private EditText nomeSurfista;
    private EditText paisSurfista;
    private Button botaoAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_surfista);

        nomeSurfista = (EditText) findViewById(R.id.editSurfistaNomeId);
        paisSurfista = (EditText) findViewById(R.id.editSurfistaPaisId);
        botaoAdicionar = (Button) findViewById(R.id.botaoInserirSurfistaId);

        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SurfistaController controller = new SurfistaController(getBaseContext());
                String nome = nomeSurfista.getText().toString();
                String pais = paisSurfista.getText().toString();
                String res = controller.inserirSurfista(nome,pais);
                //ADICIONAR NO BANCO
                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
            }
        });



    }
}
