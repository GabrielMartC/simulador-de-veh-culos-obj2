package me.gonzager.ex.vehiculos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    void vehículoRetrocediendoYAvanzandoTiposDeConduccionDeberíaRetornarCorrectamenteLaVelocidad() {
        Vehiculo vehiculo = new Vehiculo(3.0);
        vehiculo.retrocTipoConducc();

        vehiculo.avanzarTipoConducc();
        vehiculo.avanzarTipoConducc();
        vehiculo.avanzarTipoConducc();

        vehiculo.retrocTipoConducc();

        assertEquals(150.0, vehiculo.getVelocidadMaxima());
    }

    @Test
    void vehículoEnConduccionEstandarDeberíaAvanzarCorrectamenteYReducirElCombustible() {
        Vehiculo vehiculo = new Vehiculo(25.0);

        vehiculo.avanzarTipoConducc();

        vehiculo.desplazar(200.0);

        assertEquals(200.0, vehiculo.getKmRecorridos());
        assertEquals(5.0, vehiculo.getCantCombustible());

    }

    @Test
    void vehiculoEnConduccionDeportivaDeberíaLanzarUnaExcepcionSiNoHaySuficienteCombustible() {
        Vehiculo vehiculo = new Vehiculo(13.0);

        vehiculo.avanzarTipoConducc();
        vehiculo.avanzarTipoConducc();

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            vehiculo.desplazar(75.0); 
        });

        assertEquals("Combustible insuficiente, solo pude recorrer 65.0 del total de 75.0 kilometros.", exception.getMessage());
        assertEquals(65.0,vehiculo.getKmRecorridos());
        assertEquals(0.0,vehiculo.getCantCombustible());
    }

    @Test
    void valorDeCombustibleMenorACeroAlCrearVehiculoLanzaExcepcion() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Vehiculo vehiculo = new Vehiculo(-10.0); 
        });

        assertEquals("La cantidad de combustible no puede ser negativa.", exception.getMessage());

    }

    @Test
    void velocidadMaximaDiferenteSegunTipoDeConduccion() {
        Vehiculo vehiculo = new Vehiculo(10.0); 

        Double velMaxEcolog = vehiculo.getVelocidadMaxima();

        vehiculo.avanzarTipoConducc();

        Double velMaxEstand = vehiculo.getVelocidadMaxima();

        vehiculo.avanzarTipoConducc();

        Double velMaxDeport = vehiculo.getVelocidadMaxima();

        assertTrue(velMaxEcolog < velMaxEstand);
        assertFalse(velMaxEstand > velMaxDeport);
        assertNotEquals(velMaxEstand, velMaxDeport);

    }
}
