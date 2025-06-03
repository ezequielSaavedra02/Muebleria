/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany; // Si MateriaPrima tiene muchos productos

// Importar List si se usa una colección
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Entity
public class MateriaPrima implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMateriaPrima;
    private String nombre;
    private double costoUnitario;
    private int stock;

    // Relación Many-to-Many con Producto, a través de la tabla DetalleProducto
    // Esto se maneja mejor en DetalleProducto, por lo que aquí no es necesario
    // Si quisieras acceder a los productos directamente desde MateriaPrima,
    // sería @ManyToMany(mappedBy = "materiasPrimas")
    // private List<Producto> productos;

    public MateriaPrima() {
    }

    public MateriaPrima(Long idMateriaPrima, String nombre, double costoUnitario, int stock) {
        this.idMateriaPrima = idMateriaPrima;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
        this.stock = stock;
    }

    // Getters y Setters
    public Long getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(Long idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}