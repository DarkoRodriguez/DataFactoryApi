package com.example.miapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.miapp.model.Producto;
import com.example.miapp.repository.ProductoRepository;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Permite peticiones desde frontend
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los libros
    @GetMapping
    public List<Producto> getAllproductos() {
        return productoRepository.findAll();
    }

    // Obtener libro por ID
    @GetMapping("/{id}")
    public Producto getproductoById(@PathVariable Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("producto not found"));
    }

    // Crear un nuevo libro
    @PostMapping
    public Producto createproducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar libro existente
    @PutMapping("/{id}")
    public Producto updateproducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("producto not found"));

        // producto.setTitle(productoDetails.getTitle());
        // producto.setAuthor(productoDetails.getAuthor());
        return productoRepository.save(producto);
    }

    // Eliminar libro
    @DeleteMapping("/{id}")
    public void deleteproducto(@PathVariable Long id) {
        productoRepository.deleteById(id);
    }
}
