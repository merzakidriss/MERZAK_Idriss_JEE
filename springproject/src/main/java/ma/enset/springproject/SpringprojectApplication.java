package ma.enset.springproject;

import ma.enset.springproject.entities.Product;
import ma.enset.springproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringprojectApplication  implements CommandLineRunner {
     @Autowired
    private ProductRepository productrepository ;

    public static void main(String[] args) {

        SpringApplication.run(SpringprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       /* productrepository.save(new Product(null,"computer",200,1));
        productrepository.save(new Product(null,"smartphone",100,4));
        productrepository.save(new Product(null,"computer",300,6));
*/
        List<Product> all = productrepository.findAll();
        all.forEach(product -> {
            System.out.println(product.toString());
        });
        Product product= productrepository.findById(Long.valueOf(1)).get();
        System.out.println("***********");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("************");
        List<Product> c = productrepository.findByNameContains("C");
        c.forEach(product1 -> {
            System.out.println(product1);
        });
        System.out.println("-----------");
        List<Product> b = productrepository.search("%C%");
        b.forEach(product1 -> {
            System.out.println(product1);
        });
        System.out.println("-----------");
        List<Product> k = productrepository.findByPriceGreaterThan(200);
        k.forEach(product1 -> {
            System.out.println(product1);
        });
        System.out.println("-----------");
        List<Product> o = productrepository.searchByPrice(200);
        o.forEach(product1 -> {
            System.out.println(product1);
        });


    }
}
