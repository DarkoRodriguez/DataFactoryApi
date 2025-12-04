package com.example.miapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Esta clase se convierte en tabla
@Data // Lombok genera getters/setters/toString/etc.
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor
@Table(name="productos") // Constructor con todos los campos
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    private String imagen;

    private boolean oferta;

    private Double descuento;

    private Integer stock;


}

