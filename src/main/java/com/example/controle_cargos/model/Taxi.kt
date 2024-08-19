package com.example.controle_cargos.model

class Taxi (
    marca: String,
    modelo: String,
    ano: Int,
    quilometragem: Int
) : Carro (marca,modelo,ano,quilometragem) {

    init {

        val anoAtual = 2024
        if (anoAtual - ano > 10) {
            throw IllegalArgumentException("O Veículo não pode ter mais de 10 anos...")
        }

        println("Carro ${marca} ${modelo} criado...")
    }

}