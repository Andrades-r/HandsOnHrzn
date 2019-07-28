package com.renatoandrade.desafiohorizon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BateriaBuscarActivity extends AppCompatActivity {

    private EditText editIdBateria;
    private Button botaoBuscarBateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bateria_buscar);

        editIdBateria = (EditText) findViewById(R.id.editBuscarIdBateriaId);
        botaoBuscarBateria = (Button) findViewById(R.id.botaoBuscarIdBateriaId);

        botaoBuscarBateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String bateriaId = editIdBateria.getText().toString();
                //BUSCAR NO BANCO E PASSAR O RESULTADO DA BUSCA PARA PROXIMA TELA


            }
        });


    }
}
