package com.renatoandrade.desafiohorizon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SurfistaActivity extends AppCompatActivity {

    private Button botaoAdicionarId;
    private Button botaoBuscarId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfista);

        botaoAdicionarId = findViewById(R.id.botaoBateriaAdicionarId);
        botaoBuscarId = findViewById(R.id.botaoSurfistaBuscarId);

        botaoAdicionarId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SurfistaActivity.this, SurfistaAdicionarActivity.class);
                startActivity(intent);
            }
        });

        botaoBuscarId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SurfistaActivity.this, SurfistaBuscarActivity.class);
                startActivity(intent);
            }
        });
    }
}
