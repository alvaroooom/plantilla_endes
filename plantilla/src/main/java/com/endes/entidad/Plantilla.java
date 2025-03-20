package com.endes.entidad;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona una lista de empleados dentro de la empresa.
 */
public class Plantilla {
    private List<Empleado> empleados;

    /**
     * Constructor de la clase Plantilla.
     * Inicializa la lista de empleados.
     */
    public Plantilla() {
        empleados = new ArrayList<>();
    }

    /**
     * Agrega un nuevo empleado a la plantilla.
     *
     * @param empleado El empleado a contratar.
     * @throws IllegalArgumentException Si el empleado es nulo.
     */
    public void contratarEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("No se puede contratar un empleado nulo");
        }
        
        for (Empleado e : empleados) {
            if (e.getDni().equals(empleado.getDni())) {
                throw new IllegalArgumentException("El empleado con DNI " + empleado.getDni() + " ya está contratado");
            }
        }
        
        empleados.add(empleado);
    }

    /**
     * Busca empleados por nombre o apellido.
     *
     * @param filtroNombre Nombre o apellido a buscar.
     * @return Lista de empleados que coincidan con el filtro.
     * @throws RuntimeException Si no se encuentra ningún empleado.
     */
    public List<Empleado> getEmpleadosPorNombre(String filtroNombre) {
        return empleados.stream()
                .filter(e -> e.getNombre().contains(filtroNombre) || e.getApellidos().contains(filtroNombre))
                .toList();
    }
}

