package com.cart.cart.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.cart.Model.Cart;
@Repository
public interface Cart extends JpaRepository<Product, Long>{

}
