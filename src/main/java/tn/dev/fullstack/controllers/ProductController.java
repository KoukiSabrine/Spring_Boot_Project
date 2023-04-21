package tn.dev.fullstack.controllers;

import org.springframework.stereotype.Controller;
import java.util.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tn.dev.fullstack.entities.Product;

import static tn.dev.FullStackTrainingApplication.products;
@Controller
@RequestMapping("/Product")
public class ProductController {
	
@GetMapping("/list")
public String productsList(Model m) {
	m.addAttribute("products", products);
	return "product/productsList";
	}

@GetMapping("/add")
public String addProduct(Model m) {
	m.addAttribute("product", new Product());
	return "product/addProduct";
	}

@PostMapping("/add")
//public String saveProduct(@RequestParam("id")Integer id,@RequestParam("name")String name,
//		@RequestParam("email")String email,@RequestParam("description")String description) {
//Product p=new Product(id,name,email,description);

public String saveProduct(Product p) {
	products.add(p);
	return "redirect:list";
}

@GetMapping("/details/{id}")
public String productDetails(Model m,@PathVariable("id") int id) {
	for(Product pr: products) {
		if(pr.getId() == id) {
			m.addAttribute("product", pr);
            break;
		}
	}
	return "product/productDetails";
	}

@GetMapping("/delete/{id}")
public String productDelete(Model m,@PathVariable("id") int id) {
	for(Product pr: products) {
		if(pr.getId() == id) {
			m.addAttribute("product", pr);
			//System.out.println("kkkkkkkk"+' '+pr.getName());

			products.remove(pr);
            break;
		}
	}
	return "redirect:../list";
	}

@GetMapping("/update/{id}")
public String productUpdate(Model m,@PathVariable("id") int id) {
	for(Product pr: products) {
		if(pr.getId() == id) {
			m.addAttribute("product", pr);
            break;
		}
	}
	return "product/editProduct";
	}

@PostMapping("/update")
public String updateProduct(Product p) {
	for (Product pr:products) {
		if(pr.getId() == p.getId() ) {
			products.set(products.indexOf(pr),p);
			break;
		}
	}
	return "redirect:list";
}
		
		}
