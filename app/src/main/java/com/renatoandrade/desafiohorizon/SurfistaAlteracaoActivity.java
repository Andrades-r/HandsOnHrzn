package com.renatoandrade.desafiohorizon;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import BancoHelper.CriarBanco;
import controllers.SurfistaController;

public class SurfistaAlteracaoActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editPais;
    private Button botaoAlterar;
    private Button botaoExcluir;
    private SurfistaController controller;
    private String cod;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfista_alteracao);

        editNome = (EditText) findViewById(R.id.editAlterarNomeSurfistaId);
        editPais = (EditText) findViewById(R.id.editAlterarPaisSusfistaId);
        botaoAlterar = (Button) findViewById(R.id.botaoAlterarSurfistaId);
        botaoExcluir = (Button) findViewById(R.id.botaoExlcuirSurfistaId);

        cod = this.getIntent().getStringExtra("cod");
        controller = new SurfistaController(getBaseContext());
        Cursor cursor = controller.buscarPorId(Integer.parseInt(cod));

        editNome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.COL_SURFISTA_NOME)));
        editPais.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.COL_SURFISTA_PAIS)));

        //ALTERAR SURFISTA
        botaoAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.alterarSurfista(Integer.parseInt(cod),
                        editNome.getText().toString(),
                        editPais.getText().toString());
                Intent intent = new Intent(SurfistaAlteracaoActivity.this, SurfistaResultadoBuscaActivity.class);
                intent.putExtra("Alteracao", "Alteracao");
                startActivity(intent);
                finish();
            }
        });

        //EXCLUIR O SURFISTA
        botaoExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.deletarSurfista(Integer.parseInt(cod));
                Intent intent = new Intent(SurfistaAlteracaoActivity.this, SurfistaResultadoBuscaActivity.class);
                intent.putExtra("Excluir","Excluir");
                startActivity(intent);
                finish();
            }
        });


    }
}
