package com.endes.entidad;

/**
 * Representa a un empleado de tipo Comercial.
 * <p>
 * Este tipo de empleado recibe un sueldo base, con un incremento
 * basado en el total de ventas realizadas. El incremento es del 10% del total de ventas.
 * </p>
 * 
 * @author [Tu Nombre, usa tus iniciales]
 * @version 1.0
 * @since 2024-03-19
 */
public class Comercial extends Empleado {
    /** Monto total de ventas realizadas por el comercial. */
    private double ventas;

    /**
     * Constructor para la clase Comercial.
     *
     * @param dni        Número de identificación del comercial (DNI o equivalente).
     * @param nombre     Nombre del comercial.
     * @param apellidos  Apellidos del comercial.
     * @param sueldoBase Sueldo base del comercial.
     * @param ventas     Monto total de ventas realizadas (debe ser mayor o igual a 0).
     * @throws IllegalArgumentException Si las ventas son negativas.
     */
    public Comercial(String dni, String nombre, String apellidos, Double sueldoBase, double ventas) {
        super(dni, nombre, apellidos, sueldoBase);
        if (ventas < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser negativas");
        }
        this.ventas = ventas;
    }

    /**
     * Obtiene el total de ventas realizadas por el comercial.
     *
     * @return El total de ventas acumuladas.
     */
    public double getVentas() {
        return ventas;
    }

    /**
     * Establece un nuevo monto de ventas.
     * <p>
     * Este valor se usa para calcular el sueldo del comercial. El incremento
     * sobre el sueldo base es del 10% del monto de ventas.
     * </p>
     *
     * @param ventas Nuevo monto de ventas (debe ser mayor o igual a 0).
     * @throws IllegalArgumentException Si las ventas son negativas.
     */
    public void setVentas(double ventas) {
        if (ventas < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser negativas");
        }
        this.ventas = ventas;
    }

    /**
     * Calcula el extra del sueldo basado en las ventas realizadas.
     * <p>
     * El comercial recibe un incremento del 10% sobre el total de ventas.
     * </p>
     *
     * @return El monto extra calculado sobre las ventas.
     */
    @Override
    protected Double calcularExtra() {
        return 0.10 * ventas;
    }

    /**
     * Obtiene el sueldo total del comercial.
     * <p>
     * El sueldo total se calcula como el sueldo base más un 10% del total de ventas realizadas.
     * </p>
     *
     * @return El sueldo total incluyendo el bono por ventas.
     */
    @Override
    public Double getSueldo() {
        return super.getSueldoBase() + calcularExtra();
    }

}

