package com.example.mydestination.service;

import com.example.mydestination.dto.Cartdto;
import com.example.mydestination.model.Cart;
import com.example.mydestination.model.Products;
import com.example.mydestination.model.Users;
import com.example.mydestination.repository.CartRepo;
import com.example.mydestination.repository.ProductsRepo;
import com.example.mydestination.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;
    @Autowired
    ProductsRepo productsRepo;
    @Autowired
    UserRepo userRepo;

    public Cart addtocart(Long id,Long proid)
    {
        Users user= userRepo.findById(id).orElseThrow(() -> new RuntimeException("failed to find user"));
        Products product= productsRepo.findById(proid).orElseThrow(() -> new RuntimeException("failed to find product"));
        Cart avblCart = cartRepo.findPresentCart(product.getProid(), user.getId());
        if (avblCart != null)
        {
            Integer getQuadity = avblCart.getQuantity();
            avblCart.setQuantity(getQuadity + 1);
            cartRepo.save(avblCart);
            return avblCart;
        }
        else
        {
            Cart cart= new Cart();
            cart.setUser(user);
            cart.setQuantity(1);
            cart.setProducts(product);
            cartRepo.save(cart);
            return cart;
        }
    }
    public String decrementproduct(Long id,Long proid)
    {
        Users user= userRepo.findById(id).orElseThrow(() -> new RuntimeException("failed to find user"));
        Products product= productsRepo.findById(proid).orElseThrow(() -> new RuntimeException("failed to find product"));
        Cart avblCart = cartRepo.findPresentCart(product.getProid(), user.getId());
        if(avblCart != null)
        {
            Integer getquantity= avblCart.getQuantity();
            avblCart.setQuantity(getquantity - 1);
            cartRepo.save(avblCart);
            return "successfully decremented the quantity";
        }
        return "no pdt";
    }
    public String removecart(Long id, Long proid)
    {
        Users user= userRepo.findById(id).orElseThrow(() -> new RuntimeException("failed to find user"));
        Products product= productsRepo.findById(proid).orElseThrow(() -> new RuntimeException("failed to find product"));
        Cart avblCart = cartRepo.findPresentCart(product.getProid(), user.getId());
        if (avblCart != null)
        {
            cartRepo.delete(avblCart);
            return "cart deleted successfully";
        }
        else
        {
            return "Cart is empty";
        }
    }

    public List<Cartdto> findCartDetails(Long userId) throws Exception
    {
        List<Cartdto> cartdtos = new ArrayList<>();
        List<Cart> carts = cartRepo.findCartDetailsOfAUser(userId);
        for (Cart individualCart: carts)
        {
            Cartdto newCartDto = new Cartdto();
            newCartDto.setPdtName(individualCart.getProducts().getProname());
            newCartDto.setQuantity(individualCart.getQuantity());
            newCartDto.setTotalPrice(individualCart.getQuantity() * individualCart.getProducts().getProprize());
            cartdtos.add(newCartDto);
        }
        return cartdtos;
    }


}
