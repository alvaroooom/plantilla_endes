package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComercialTest {
	private Comercial comercial;

	@BeforeEach
	@DisplayName("Inicializamos el comercial")
    void setUp() {
        comercial = new Comercial("12345678A", "Juan", "Pérez", 2000.0, 5000.0);
    }

    @Test
    @DisplayName("Test del método getVentas")
    void testGetVentas() {
        assertEquals(5000.0, comercial.getVentas(), "El total de ventas debería ser 5000.0");
    }

    @Test
    @DisplayName("Test del método setVentas")
    void testSetVentas() {
        comercial.setVentas(6000.0);
        assertEquals(6000.0, comercial.getVentas(), "El total de ventas debería ser 6000.0 después de la actualización");
    }

    @Test
    @DisplayName("Test del método setVentas son negativas")
    void testSetVentasNegativo() {
        assertThrows(IllegalArgumentException.class, () -> comercial.setVentas(-1000.0), "Debería lanzar excepción si las ventas son negativas");
    }

    @Test
    @DisplayName("Test del método calcularExtra")
    void testCalcularExtra() {
        assertEquals(500.0, comercial.calcularExtra(), "El extra debería ser el 10% de las ventas (500.0)");
    }

    @Test
    @DisplayName("Test del método getSueldo")
    void testGetSueldo() {
        assertEquals(2500.0, comercial.getSueldo(), "El sueldo total debería ser 2000.0 + 500.0 = 2500.0");
    }

    @Test
    @DisplayName("Test del método getSueldo con diferentes ventas")
    void testGetSueldoConDiferentesVentas() {
        comercial.setVentas(10000.0);
        assertEquals(3000.0, comercial.getSueldo(), "El sueldo total debería ser 2000.0 + 1000.0 = 3000.0");
		
	}

}
