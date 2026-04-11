package cg.example.Product.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.example.Product.Repo.ProductRepository;
import cg.example.Product.entities.Product;

@Service
public class ProductService {

	 @Autowired
	    private ProductRepository repo;

    public Product getProduct(int id) {
    	return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}