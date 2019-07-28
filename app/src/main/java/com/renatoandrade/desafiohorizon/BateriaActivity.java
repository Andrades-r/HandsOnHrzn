package com.renatoandrade.desafiohorizon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BateriaActivity extends AppCompatActivity {

    private Button botaoAdicionar;
    private Button botaoBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bateria);

        botaoAdicionar = findViewById(R.id.botaoBateriaAdicionarId);
        botaoBuscar = findViewById(R.id.botaoBateriaBuscaId);

        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BateriaActivity.this, BateriaAdicionarActivity.class);
                startActivity(intent);
            }
        });

        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BateriaActivity.this, BateriaBuscarActivity.class);
                startActivity(intent);
            }
        });


    }


}
