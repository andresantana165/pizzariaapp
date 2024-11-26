package com.example.pizzariaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int numeroPedido = 1830;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Componentes
        EditText editNome = findViewById(R.id.editNome);
        EditText editDescricao = findViewById(R.id.editDescricao);
        RadioGroup radioGroupTamanho = findViewById(R.id.radioGroupTamanho);
        Switch switchEntrega = findViewById(R.id.switchEntrega);
        Switch switchQueijoExtra = findViewById(R.id.switchQueijoExtra);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);
        Button btnCancelar = findViewById(R.id.btnCancelar);

        // Ação para Confirmar Pedido
        btnConfirmar.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);

            String nomeCliente = editNome.getText().toString();
            String descricaoPedido = editDescricao.getText().toString();
            String tamanho = ((RadioButton) findViewById(radioGroupTamanho.getCheckedRadioButtonId())).getText().toString();
            boolean entrega = switchEntrega.isChecked();
            boolean queijoExtra = switchQueijoExtra.isChecked();

            new AlertDialog.Builder(this)
                    .setTitle("Confirmação de Pedido")
                    .setMessage("Pedido #" + (++numeroPedido) + "\n" +
                            "Nome: " + nomeCliente + "\n" +
                            "Descrição: " + descricaoPedido + "\n" +
                            "Tamanho: " + tamanho + "\n" +
                            "Entrega: " + (entrega ? "Sim" : "Não") + "\n" +
                            "Queijo Extra: " + (queijoExtra ? "Sim" : "Não"))
                    .setPositiveButton("OK", (dialog, which) -> {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(this, "Pedido Confirmado!", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });

        // Ação para Cancelar Pedido
        btnCancelar.setOnClickListener(v -> {
            Toast.makeText(this, "Pedido Cancelado", Toast.LENGTH_SHORT).show();
        });
    }
}