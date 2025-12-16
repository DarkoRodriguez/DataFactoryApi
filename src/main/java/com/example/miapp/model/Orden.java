package com.example.miapp.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Esta clase se convierte en tabla
@Data // Lombok genera getters/setters/toString/etc.
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor 
@Table(name="orden")

public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "numero_orden", unique = true, nullable = false)
    private String numeroOrden;

    
    private String estado = "PENDIENTE";

    @Column(name = "total")
    private Double total;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    private String apellidos;
    private String correo;
    private String calle;
    private String departamento;
    private String region;
    private String comuna;

    @Column(columnDefinition = "TEXT")
    private String indicaciones;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonManagedReference
    private List<OrdenItem> items = new ArrayList<>();

    public void setItems(List<OrdenItem> items) {
    this.items = items;
    if (items != null) {
        for(OrdenItem item : items) {  item.setOrden(this); // <-- ¡ESTA LÍNEA ES LA MAGIA!
        }
    }
    }
    public void addOrdenItem(OrdenItem item) {
        items.add(item);
        item.setOrden(this);
    }
    public void removeOrdenItem(OrdenItem item) {
        items.remove(item);
        item.setOrden(null);
    }
}

