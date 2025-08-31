package me.gonzager.ex.conduccionesTipos;

public interface TipoConduccion {
    public Double consumo();
    public Double velocidadMaxima();
    public TipoConduccion siguiente();
    public TipoConduccion anterior();
}
