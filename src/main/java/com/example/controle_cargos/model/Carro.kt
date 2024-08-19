package com.example.controle_cargos.model

open class Carro (
    private var marca: String,
    private var modelo: String,
    private var ano: Int,
    private var quilometragem: Int) {

    fun getMarca(): String {
        return marca
    }
    fun setMarca( marca: String){
        this.marca = marca
    }
    fun getModelo(): String{
        return modelo
    }
    fun setModelo(modelo: String){
        this.modelo = modelo
    }
    fun getAno(): Int {
        return ano
    }
    fun setAno(ano: Int){
        this.ano = ano
    }
    fun getQuilometragem(): Int{
        return quilometragem
    }
    fun setQuilometragem(quilometragem: Int){
        this.quilometragem = quilometragem
    }

    init {
        println("Carro ${marca} ${modelo} criado...")
    }
}