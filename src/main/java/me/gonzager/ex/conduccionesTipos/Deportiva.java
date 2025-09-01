package me.gonzager.ex.conduccionesTipos;

public class Deportiva implements TipoConduccion {

    @Override
    public Double consumo() {
        return 5.0;
    }

    @Override
    public Double velocidadMaxima() {
        return 200.0;
    }

    @Override
    public TipoConduccion siguiente() {
        return new Deportiva();
    }

    @Override
    public TipoConduccion anterior() {
        return new Estandar();
    }

}
