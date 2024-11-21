package com.example.trabalhofaculfaz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtNome: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtSenha: EditText
    private lateinit var btnCadastro: Button
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNome = findViewById(R.id.nameEditText)
        edtEmail = findViewById(R.id.emailEditText)
        edtSenha = findViewById(R.id.passwordEditText)
        btnCadastro = findViewById(R.id.cadastrarButton)
        btnLogin = findViewById(R.id.acessarButton)

        // Ação para o botão de cadastro
        btnCadastro.setOnClickListener {
            // Verificando se os campos estão preenchidos antes de abrir a TelaCadastro
            val nome = edtNome.text.toString()
            val email = edtEmail.text.toString()
            val senha = edtSenha.text.toString()

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                // Navegar para a TelaCadastro
                val intent = Intent(this, TelaCadastro::class.java)
                startActivity(intent)
            }
        }

        // Ação para o botão de login
        btnLogin.setOnClickListener {
            val nome = edtNome.text.toString()
            val senha = edtSenha.text.toString()

            if (nome.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                // Navegar para a EscolhaActivity após login bem-sucedido
                val intent = Intent(this, EscolhaActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Acesso realizado com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
