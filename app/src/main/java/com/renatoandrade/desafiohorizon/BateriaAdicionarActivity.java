package com.renatoandrade.desafiohorizon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BateriaAdicionarActivity extends AppCompatActivity {

    private EditText editSurfista1;
    private EditText editSurfista2;
    private Button botaoAdicionarBateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bateria_adicionar);

        editSurfista1 = (EditText) findViewById(R.id.editAdicionarSurfista1Id);
        editSurfista2 = (EditText) findViewById(R.id.editAdicionarSurfista2Id);
        botaoAdicionarBateria = (Button) findViewById(R.id.botaoAdicionarBateria);

        botaoAdicionarBateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String surfist1 = editSurfista1.getText().toString();
                String surfista2 = editSurfista2.getText().toString();

                //Adicionar no banco
            }
        });

    }
}
