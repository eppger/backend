package ee.epp.backend.controller;

import ee.epp.backend.entity.Category;
import ee.epp.backend.entity.Product;
import ee.epp.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor //tõmbab sisse Repository mida ma siin all loetlen
@CrossOrigin("*") // turvaviga

public class ProductController {

    private final ProductRepository productRepository;

    //https://699edb8f78dda56d396b9d19.mockapi.io
    //localhost aadress: http://localhost:8080
    // hiljem serverisse üles (render.com) --> saab õige aadressi

    // front-endis
    // epp-webshop.web.app
    // localhost:5173

    //localhost:8080/products
    //render-epp.com/products
    @GetMapping("products")
    public List<Product> getProducts() {
        return productRepository.findByOrderByIdAsc();
    }

    @PostMapping("products")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PostMapping("products/list")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productRepository.saveAll(products);
    }
    @DeleteMapping("products/{id}")
    public List<Product> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return productRepository.findByOrderByIdAsc();
    }

    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    //muutmise päring
    @PutMapping("products/{id}")
    public Product editProduct(@PathVariable Long id, @RequestBody Product product) {
        if(!id.equals(product.getId())) {
            throw new RuntimeException("Product id does not match");
        }
        return productRepository.save(product);
    }

}