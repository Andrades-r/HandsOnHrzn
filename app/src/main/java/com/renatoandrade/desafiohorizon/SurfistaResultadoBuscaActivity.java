package com.renatoandrade.desafiohorizon;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import BancoHelper.CriarBanco;
import controllers.SurfistaController;

public class SurfistaResultadoBuscaActivity extends AppCompatActivity {

    private int tipoBusca;
    private ListView lista;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_busca_surfista);


        Intent intent = getIntent();
        Bundle extras;
        SurfistaController control = new SurfistaController(getBaseContext());

        if(intent.hasExtra("Nome") && intent.hasExtra("Pais")) {
            //BUSCAR POR NOME + PAIS
            extras = intent.getExtras();
            String pais = extras.getString("Pais");
            String nome = extras.getString("Nome");
            cursor = control.bucarPorNomePais(nome,pais);

        }else if(intent.hasExtra("Pais")) {
            //BUSCA POR PAIS

            extras = intent.getExtras();
            String pais = extras.getString("Pais");
            cursor = control.bucarPorPais(pais);

        }else if(intent.hasExtra("Nome")) {
            //BUSCAR POR NOME
            extras = intent.getExtras();
            String nome = extras.getString("Nome");
            cursor = control.bucarPorNome(nome);

        }else {
            if (intent.hasExtra("Alteracao")) {
                Toast.makeText(getApplicationContext(), "Surfista Alterado", Toast.LENGTH_LONG).show();
            } else if (intent.hasExtra("Excluir")) {
                Toast.makeText(getApplicationContext(), "Surfista Excluído", Toast.LENGTH_LONG).show();
            }
            cursor = control.buscarTodos();

        }

        //Adaptar cursos para a View

        String[] campos = new String[] {CriarBanco.COL_SURFISTA_ID,CriarBanco.COL_SURFISTA_NOME, CriarBanco.COL_SURFISTA_PAIS};
        int[] idViews = new int[] {R.id.idSurfista,R.id.nomeSurfista, R.id.paisSurfista};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.surfista_layout,cursor,campos,idViews, 0);
        lista = (ListView)findViewById(R.id.listaSurfistaId);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cod;
                cursor.moveToPosition(position);
                cod = cursor.getString(cursor.getColumnIndexOrThrow(CriarBanco.COL_SURFISTA_ID));
                Intent intent = new Intent(SurfistaResultadoBuscaActivity.this, SurfistaAlteracaoActivity.class);
                intent.putExtra("cod", cod);
                startActivity(intent);
                finish();

            }
        });

    }
}
