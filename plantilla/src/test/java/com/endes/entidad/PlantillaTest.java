package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase Plantilla.
 */
class PlantillaTest {
    private Plantilla plantilla;

    @BeforeEach
    @DisplayName("Inicialización de la plantilla de empleados")
    void setUp() {
        plantilla = new Plantilla();
    }

    /**
     * Prueba que verifica que no se puedan contratar empleados con el mismo DNI.
     */
    @Test
    @DisplayName("No permite contratar empleados con el mismo DNI")
    void testContratarEmpleado_Duplicado() {
        Empleado tecnico1 = new Tecnico("11111111H", "Alejandro", "Fernández", 1000.0, 1);
        Empleado tecnico2 = new Tecnico("11111111H", "Carlos", "Pérez", 1200.0, 2); // Mismo DNI que el primero

        // Se permite el primer contrato
        assertDoesNotThrow(() -> plantilla.contratarEmpleado(tecnico1));

        // Intentar contratar otro empleado con el mismo DNI debería lanzar una excepción
        Exception ex = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(tecnico2));

        // Verificar el mensaje de la excepción
        assertEquals("El empleado con DNI 11111111H ya está contratado", ex.getMessage());
    }
    @Test
    @DisplayName("Permite contratar empleados válidos")
    void testContratarEmpleadoEsValido() {
        Empleado empleado = new Tecnico("22222222J", "Laura", "Gómez", 1500.0, 3);
        assertDoesNotThrow(() -> plantilla.contratarEmpleado(empleado));
    }

    @Test
    @DisplayName("No permite contratar empleados nulos")
    void testContratarEmpleadoEsNulo() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(null));
        assertEquals("No se puede contratar un empleado nulo", ex.getMessage());
    }

    @Test
    @DisplayName("Busca empleados por nombre o apellido")
    void testGetEmpleadosPorNombre() {
        Empleado empleado1 = new Tecnico("33333333K", "María", "López", 1800.0, 4);
        Empleado empleado15 = new Tecnico("55555555M", "Mariano", "Ruiz", 1600.0, 6);
        
        plantilla.contratarEmpleado(empleado1);
        plantilla.contratarEmpleado(empleado15);
        
        List<Empleado> resultado = plantilla.getEmpleadosPorNombre("María");
        assertEquals(1, resultado.size());
        assertEquals("María", resultado.get(0).getNombre());
        
        resultado = plantilla.getEmpleadosPorNombre("Mar");
        assertEquals(2, resultado.size());
    }

    @Test
    @DisplayName("Devuelve la lista si no hay coincidencias en la búsqueda")
    void testGetEmpleadosPorNombreNoCoincidencias() {
        List<Empleado> resultado = plantilla.getEmpleadosPorNombre("Juan");
        assertTrue(resultado.isEmpty());
    }
}
