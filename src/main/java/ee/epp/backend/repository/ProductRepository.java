package ee.epp.backend.repository;

import ee.epp.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Entity - andmebaasi tabel
//Repository - funktsioonide tegemine et sealt andmbaasist saaks controller andmeid kätte
public interface ProductRepository extends JpaRepository<Product,Long> {
List<Product> findByOrderByIdAsc();


}
