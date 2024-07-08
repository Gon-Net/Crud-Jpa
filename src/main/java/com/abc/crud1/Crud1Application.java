package com.abc.crud1;

import com.abc.crud1.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class Crud1Application {

	public static void main(String[] args) {

		SpringApplication.run(Crud1Application.class, args);

	}

}
