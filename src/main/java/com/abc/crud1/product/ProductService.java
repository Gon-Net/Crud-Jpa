package com.abc.crud1.product;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    HashMap<String, Object> datos;

    public List<Product> getProducts(){
        return this.productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product) {

        Optional<Product> res = productRepository.findProductByName(product.getName());
        datos = new HashMap<>();

        if(res.isPresent() && product.getId()==null){
            datos.put("Error", true);
            datos.put("message","Ya existe un producto con ese nombre");
            //throw new IllegalStateException("Ya existe el producto");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        datos.put("message","Se guardo correctamente");
        if(product.getId()!=null){
            datos.put("message","Se actualizo correctamente");
        }

        productRepository.save(product);
        datos.put("data", product);

        return  new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deleteProduct(Long id){
        datos = new HashMap<>();
        boolean exist = this.productRepository.existsById(id);

        if (!exist){
            datos.put("Error", true);
            datos.put("message","No existe un producto con ese nombre");
            //throw new IllegalStateException("Ya existe el producto");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        productRepository.deleteById(id);
        datos.put("message","Producto eliminado");
        //throw new IllegalStateException("Ya existe el producto");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }
}
