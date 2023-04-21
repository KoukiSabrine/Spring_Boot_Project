package tn.dev;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.dev.fullstack.entities.Product;

@SpringBootApplication
public class FullStackTrainingApplication {
   public static List<Product> products=new ArrayList<>();
	public static void main(String[] args) {
		Product p1=new Product(1,"hp","hp@hotmail.fr","awesome");
		Product p2=new Product(2,"asus","asus@gmail.com","nice one");
		Product p3=new Product(3,"msi","msi@outlook.com","great");
		products.add(p1);
		products.add(p2);
		products.add(p3);

		SpringApplication.run(FullStackTrainingApplication.class, args);
		System.out.println(products);
	}

}
