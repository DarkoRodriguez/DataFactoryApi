package com.example.miapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.miapp.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
