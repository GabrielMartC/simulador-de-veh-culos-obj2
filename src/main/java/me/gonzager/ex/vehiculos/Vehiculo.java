package me.gonzager.ex.vehiculos;

import me.gonzager.ex.conduccionesTipos.Ecologico;
import me.gonzager.ex.conduccionesTipos.TipoConduccion;

public class Vehiculo {
    private Double cantCombustible;
    private Double kmRecorridos = 0.0;
    private Double consumo;
    private Double velocidadMaxima;
    private TipoConduccion tipoConduccion = new Ecologico();

    public Vehiculo(Double combustible){
        if(combustible < 0){
            throw new RuntimeException("La cantidad de combustible no puede ser negativa.");
        }
        this.cantCombustible = combustible;
        this.consumo = tipoConduccion.consumo();
        this.velocidadMaxima = tipoConduccion.velocidadMaxima();
    }

    public void desplazar(Double km){
        if(!this.puedeDesplazarse_KM(km)){
            Double distanciaRecorrid = this.cantCombustible * tipoConduccion.consumo();
            this.cantCombustible = Double.max(cantCombustible - this.combNecesarioParaRecorrer_KM(km), 0);
            this.kmRecorridos = distanciaRecorrid;
            
            throw new RuntimeException("Combustible insuficiente, solo pude recorrer " + distanciaRecorrid.toString() + " del total de "+ km.toString() + " kilometros.");
        }

        this.cantCombustible = cantCombustible - this.combNecesarioParaRecorrer_KM(km);
        this.kmRecorridos += km;

    }

    public void avanzarTipoConducc(){
        this.tipoConduccion = tipoConduccion.siguiente();

        this.consumo = tipoConduccion.consumo();
        this.velocidadMaxima = tipoConduccion.velocidadMaxima();
    }

    public void retrocTipoConducc(){
        this.tipoConduccion = tipoConduccion.anterior();

        this.consumo = tipoConduccion.consumo();
        this.velocidadMaxima = tipoConduccion.velocidadMaxima();

        
    }

    private Boolean puedeDesplazarse_KM(Double km){

        return this.combNecesarioParaRecorrer_KM(km) <= this.cantCombustible;
    }


    private Double combNecesarioParaRecorrer_KM(Double km){
        return km / this.consumo;
    }

    public Double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public Double getCantCombustible() {
        return cantCombustible;
    }

    public Double getKmRecorridos() {
        return kmRecorridos;
    }

    
}
