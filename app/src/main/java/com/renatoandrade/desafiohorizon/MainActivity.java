package com.renatoandrade.desafiohorizon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button surfistaBotao;
    private Button bateriaBotao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfistaBotao = (Button) findViewById(R.id.botaoSurfistaId);
        bateriaBotao = (Button) findViewById(R.id.botaoBateriaId);

        surfistaBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2Surfista = new Intent(MainActivity.this, SurfistaActivity.class);
                startActivity(intent2Surfista);
            }
        });

        bateriaBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2Bateria = new Intent(MainActivity.this, BateriaActivity.class);
                startActivity(intent2Bateria);
            }
        });


    }
}
