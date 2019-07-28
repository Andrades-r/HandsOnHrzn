package com.renatoandrade.desafiohorizon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SurfistaBuscarActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editPais;
    private Button botaoBuscaUnica;
    private Button botaoBuscaTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_surfista);

        editNome = (EditText) findViewById(R.id.editNomeBuscaId);
        editPais = (EditText) findViewById(R.id.editPaisBuscaId);
        botaoBuscaUnica = (Button) findViewById(R.id.botaoBuscaUnicaId);
        botaoBuscaTodos = (Button) findViewById(R.id.botaoBuscaTodosId);

        botaoBuscaUnica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome;
                String pais;
                String res;
                nome = editNome.getText().toString();
                pais = editPais.getText().toString();
                //Fazer Busca No Bancode Dados
                Intent intent =  new Intent(SurfistaBuscarActivity.this, SurfistaResultadoBuscaActivity.class);
                if(!nome.equals("")){
                    intent.putExtra("Nome",nome);
                }
                if(!(pais.equals(""))){
                    intent.putExtra("Pais", pais);
                }
                if((pais.equals(""))&&(nome.equals(""))){
                    Toast.makeText(getApplicationContext(), "Campos estao em branco", Toast.LENGTH_LONG).show();
                }else {
                    startActivity(intent);
                }
            }
        });

        botaoBuscaTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(SurfistaBuscarActivity.this, SurfistaResultadoBuscaActivity.class);
                startActivity(intent);

            }
        });



    }
}
