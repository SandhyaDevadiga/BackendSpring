
package com.cart.cart.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.cart.Model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
