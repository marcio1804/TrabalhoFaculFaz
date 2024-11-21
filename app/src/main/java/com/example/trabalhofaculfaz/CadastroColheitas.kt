package com.example.trabalhofaculfaz

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CadastroColheitas : AppCompatActivity() {

    private lateinit var imagePlantacao: ImageView
    private lateinit var etTipoColheita: EditText
    private lateinit var etDataPlantio: EditText
    private lateinit var etTipoInsumos: EditText
    private lateinit var etDataProximoInsumo: EditText
    private lateinit var etQuantidadeAreaColhida: EditText
    private lateinit var btnAddPlantInfo: Button
    private lateinit var listViewPlantInfo: ListView
    private lateinit var plantInfoList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_planta)

        // Inicializando os componentes da interface
        imagePlantacao = findViewById(R.id.imagePlantacao)
        etTipoColheita = findViewById(R.id.etTipoColheita)
        etDataPlantio = findViewById(R.id.etDataPlantio)
        etTipoInsumos = findViewById(R.id.etTipoInsumos)
        etDataProximoInsumo = findViewById(R.id.etDataProximoInsumo)
        etQuantidadeAreaColhida = findViewById(R.id.etQuantidadeAreaColhida)
        btnAddPlantInfo = findViewById(R.id.btnAddPlantInfo)
        listViewPlantInfo = findViewById(R.id.listViewPlantInfo)

        // Recuperando o tipo de colheita passado pela Intent
        val selectedColheita = intent.getStringExtra("selectedColheita")
        etTipoColheita.setText(selectedColheita)

        // Inicializando a lista de informações
        plantInfoList = ArrayList()

        // Configurando o adapter da ListView
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, plantInfoList)
        listViewPlantInfo.adapter = adapter

        // Configurando o botão para adicionar informações
        btnAddPlantInfo.setOnClickListener {
            val tipoColheita = etTipoColheita.text.toString()
            val dataPlantio = etDataPlantio.text.toString()
            val tipoInsumos = etTipoInsumos.text.toString()
            val dataProximoInsumo = etDataProximoInsumo.text.toString()
            val quantidadeAreaColhida = etQuantidadeAreaColhida.text.toString()

            // Validando se os campos não estão vazios
            if (tipoColheita.isNotEmpty() && dataPlantio.isNotEmpty() && tipoInsumos.isNotEmpty() &&
                dataProximoInsumo.isNotEmpty() && quantidadeAreaColhida.isNotEmpty()) {

                // Criando a string com as informações inseridas
                val plantInfo = "Tipo de Colheita: $tipoColheita\n" +
                        "Data de Plantio: $dataPlantio\n" +
                        "Tipo de Insumos: $tipoInsumos\n" +
                        "Data do Próximo Insumo: $dataProximoInsumo\n" +
                        "Quantidade de Área Colhida: $quantidadeAreaColhida"

                // Adicionando a informação à lista
                plantInfoList.add(plantInfo)

                // Notificando o adapter para atualizar a ListView
                adapter.notifyDataSetChanged()

                // Limpando os campos de entrada
                etTipoColheita.text.clear()
                etDataPlantio.text.clear()
                etTipoInsumos.text.clear()
                etDataProximoInsumo.text.clear()
                etQuantidadeAreaColhida.text.clear()

                // Exibindo mensagem de sucesso
                Toast.makeText(this, "Informações cadastradas com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                // Caso algum campo esteja vazio, mostrar um alerta
                Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
