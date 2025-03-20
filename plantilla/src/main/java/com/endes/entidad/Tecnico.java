package com.endes.entidad;
/**
 * Clase que representa a un empleado de tipo Técnico.
 * El sueldo base se incrementa según la categoría del técnico.
 */
public class Tecnico extends Empleado {
    private int categoria;

    /**
     * Constructor para la clase Técnico.
     *
     * @param dni        Número de identificación del técnico.
     * @param nombre     Nombre del técnico.
     * @param apellidos  Apellidos del técnico.
     * @param sueldoBase Sueldo base del técnico.
     * @param categoria  Nivel de categoría (debe ser mayor o igual a 1).
     * @throws IllegalArgumentException Si la categoría es menor que 1.
     * @author alvmunferdaw1
     */
    public Tecnico(String dni, String nombre, String apellidos, Double sueldoBase, int categoria) {
        super(dni, nombre, apellidos, sueldoBase);
        if (categoria < 1) {
            throw new IllegalArgumentException("La categoría debe ser mayor o igual a 1");
        }
        this.categoria = categoria;
    }

    /**
     * Obtiene la categoría del técnico.
     *
     * @return Categoría del técnico.
     * @author alvmunferdaw1
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * Establece una nueva categoría para el técnico.
     *
     * @param categoria Nueva categoría (debe ser mayor o igual a 1).
     * @throws IllegalArgumentException Si la categoría es menor que 1.
     * @author alvmunferdaw1
     */
    public void setCategoria(int categoria) {
        if (categoria < 1) {
            throw new IllegalArgumentException("La categoría debe ser mayor o igual a 1");
        }
        this.categoria = categoria;
    }

    /**
     * Calcula el extra del sueldo basado en la categoría del técnico.
     *
     * @return Incremento del sueldo basado en la categoría (100€ por nivel).
     * @author alvmunferdaw1
     */
    @Override
    protected Double calcularExtra() {
        return categoria * 100.0;
    }
}