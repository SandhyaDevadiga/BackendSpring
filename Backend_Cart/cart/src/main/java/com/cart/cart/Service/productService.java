package com.cart.cart.Service;

import com.cart.cart.Service.Product;
import com.cart.cart.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
// import java.util.List;

@Service
public class productService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart addProductToCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId)
                .orElse(new Cart());
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        cart.getProducts().add(product);
        cart.setTotalAmount(cart.getTotalAmount() + product.getPrice());
        return cartRepository.save(cart);
    }

    public Cart removeProductFromCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        cart.getProducts().remove(product);
        cart.setTotalAmount(cart.getTotalAmount() - product.getPrice());
        return cartRepository.save(cart);
    }

    public Cart viewCart(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }
}

