package com.example.trabalhofaculfaz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaCadastro : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var notaProdutorEditText: EditText
    private lateinit var dataNascimentoEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var cadastrarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_cadastro)

        // Inicializando os campos de texto e o botão
        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        notaProdutorEditText = findViewById(R.id.notaProdutorEditText)
        dataNascimentoEditText = findViewById(R.id.dataNascimentoEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        cadastrarButton = findViewById(R.id.cadastrarButton)

        // Evento de clique do botão
        cadastrarButton.setOnClickListener {
            val nome = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val notaProdutor = notaProdutorEditText.text.toString().trim()
            val dataNascimento = dataNascimentoEditText.text.toString().trim()
            val senha = passwordEditText.text.toString().trim()

            // Verificando se todos os campos estão preenchidos
            if (nome.isEmpty() || email.isEmpty() || notaProdutor.isEmpty() || dataNascimento.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Todos os campos devem ser preenchidos", Toast.LENGTH_SHORT).show()
            } else {
                // Lógica de cadastro (salvar no banco de dados, etc.)

                // Exibindo um toast de sucesso
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()

                // Navegar para a MainActivity após o cadastro
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                // Fechar a TelaCadastro após a navegação (opcional)
                finish()
            }
        }
    }
}
