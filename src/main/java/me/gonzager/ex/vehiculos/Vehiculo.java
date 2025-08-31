package me.gonzager.ex.vehiculos;

import me.gonzager.ex.conduccionesTipos.Ecologico;
import me.gonzager.ex.conduccionesTipos.TipoConduccion;

public class Vehiculo {
    private Double cantCombustible;
    private Double kmRecorridos = 0.0;
    private Double consumo;
    private Double velocidMaxima;
    private TipoConduccion tipoConduccion = new Ecologico();

    public Vehiculo(Double conbustible){
        this.cantCombustible = conbustible;
    }

    public void desplazar(Double km){

    }

    public void avanzarTipoConducc(){

    }

    public void retrocTipoConducc(){

    }
}
