package ma.enset.springproject.web;

import ma.enset.springproject.entities.Product;
import ma.enset.springproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductWebService {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/Products")
     public  List<Product> Products(){
        return productRepository.findAll();
    }
    @GetMapping("Products/{a}")
    public Product findProduct(@PathVariable Long a){
        Product product = productRepository.findById(a).orElse(null);
        return product;
    }




}
