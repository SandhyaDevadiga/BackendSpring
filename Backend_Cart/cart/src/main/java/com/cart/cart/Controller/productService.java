package com.cart.cart.Controller;

import com.cart.cart.Model.*;
import com.cart.cart.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class productService{

    @Autowired
    private productService cartService;


    @PostMapping("/{cartId}/add/{productId}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        Cart updatedCart = cartService.addProductToCart(cartId, productId);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK); 
    }

    @DeleteMapping("/{cartId}/remove/{productId}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        Cart updatedCart = cartService.removeProductFromCart(cartId, productId);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> viewCart(@PathVariable Long cartId) {
        Cart cart = cartService.viewCart(cartId);
        if (cart != null) {
            return new ResponseEntity<>(cart, HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
        }
    }
}
