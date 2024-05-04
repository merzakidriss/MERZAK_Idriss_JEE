package ma.enset.springproject.repository;

import ma.enset.springproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByNameContains(String m);

    @Query("select p from Product p where p.name like :x")
    List <Product> search(@Param("x") String b);

    List<Product>findByPriceGreaterThan(double a);


    @Query("select p from Product p where p.price >:x")
    List<Product> searchByPrice(@Param("x") double a);

}
