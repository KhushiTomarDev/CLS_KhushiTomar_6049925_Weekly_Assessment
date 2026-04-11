package cg.example.Product.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cg.example.Product.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}