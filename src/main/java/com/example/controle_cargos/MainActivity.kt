package com.example.controle_cargos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.controle_cargos.databinding.ActivityMainBinding
import com.example.controle_cargos.model.Carro
import com.example.controle_cargos.model.Taxi

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var veiculo: Carro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCriar.setOnClickListener {
            try{

            val marca = binding.editMarca.text.toString()
            val modelo = binding.editModelo.text.toString()
            val ano = binding.editAno.text.toString().toInt()

                val radioId = binding.groupTipoVeiculo.checkedRadioButtonId
                val radioButton = findViewById<RadioButton>(radioId)
                val tipoVeiculo = radioButton.text.toString()

            veiculo = if (tipoVeiculo == "Taxi"){
                Taxi (marca, modelo,ano, quilometragem = 0)
            } else {
                Carro (marca, modelo,ano, quilometragem = 0 )
            }

            mostrarDetalhes()

            } catch (e: NumberFormatException){
                binding.textDetalhes.text = e.message
            } catch (e : IllegalArgumentException) {
                binding.textDetalhes.text = e.message
            }
        }

        binding.buttonQuilometragem.setOnClickListener{
            try{
            val novaQuilometragem = binding.editQuilometragem.text.toString().toInt()
            veiculo.setQuilometragem(novaQuilometragem)
            mostrarDetalhes()
                if (veiculo is  Taxi && veiculo.getQuilometragem()  >= 200.000 ) {
                    Toast.makeText(this,  "velocidade atingiu os 200.000 km/h", Toast.LENGTH_LONG).show()
                }
            }catch (e: NumberFormatException){
                binding.textDetalhes.text = e.message
            }
        }

    }

    private fun mostrarDetalhes() {

        val detalhes = """
            Tipo: ${if (veiculo is Taxi) "Taxi" else "Carro"}
            Marca: ${veiculo.getMarca()}
            Modelo: ${veiculo.getModelo()}
            Ano: ${veiculo.getAno()}
            Quilometragem: ${veiculo.getQuilometragem()}
        """.trimIndent()

        binding.textDetalhes.text = detalhes
    }
}