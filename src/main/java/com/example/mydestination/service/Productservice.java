package com.example.mydestination.service;

import com.example.mydestination.dto.Productsdto;
import com.example.mydestination.model.Products;
import com.example.mydestination.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Productservice {

    @Autowired
    ProductsRepo productsRepo;

    public String addproduct(Productsdto productsdto)
    {
        Products product= new Products();
        product.setProname(productsdto.getProname());
        product.setProspec(productsdto.getProspec());
        product.setProprize(productsdto.getProprize());
        productsRepo.save(product);
        return "product added successfully";
    }
    public String editProduct(Long proid,String NewProname,String NewProspec, int NewPrize )
    {
        Products product = productsRepo.findById(proid).orElseThrow(() -> new RuntimeException("product not found"));
        product.setProname(NewProname);
        product.setProspec(NewProspec);
        product.setProprize(NewPrize);
        productsRepo.save(product);
        return "product details updated";
    }
    public Productsdto getProduct(Long proid)
    {
        Products product = productsRepo.findById(proid).orElseThrow(() -> new RuntimeException("failed to get product details"));
        return new Productsdto(product.getProid(),product.getProname(),product.getProspec(),product.getProprize());
    }
    public String deleteProduct(Long proid)
    {
        Products product =productsRepo.findById(proid).orElseThrow(() ->new RuntimeException("failed to delete product"));
        productsRepo.delete(product);
        return "product deleted sucessfully";
    }

    public List<Productsdto> getProductAll() throws Exception
    {
        List<Products> products = productsRepo.findAll();
        List<Productsdto> pdts = new ArrayList<>();
        for (Products pd: products)
        {
            pdts.add(new Productsdto(pd.getProid(), pd.getProname(), pd.getProspec(), pd.getProprize()));
        }
        return pdts;
    }


}
