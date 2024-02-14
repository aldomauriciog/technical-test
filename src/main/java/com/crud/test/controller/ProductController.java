package com.crud.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.test.model.ProductBean;
import com.crud.test.model.ResponseBean;
import com.crud.test.service.InterfaceProductService;

@RestController
@RequestMapping("api/techtest/product")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private InterfaceProductService interfaceProductService;
	
	@GetMapping("/list")
	public ResponseEntity<List<ProductBean>> list(){
		var result = interfaceProductService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/list-for-name/{name}")
	public ResponseEntity<List<ProductBean>> listForName(@PathVariable String name){
		var result = interfaceProductService.findForName(name);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<ResponseBean> save(@RequestBody ProductBean product){
		ResponseBean responseBean = new ResponseBean();
		int result = interfaceProductService.save(product);
		if(result == 1) {
			responseBean.setMessage("Item saved with success!");
		}
		return new ResponseEntity<>(responseBean, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ResponseBean> update(@RequestBody ProductBean product){
		ResponseBean responseBean = new ResponseBean();
		int result = interfaceProductService.update(product);
		if(result == 1) {
			responseBean.setMessage("Item update with success!");
		}
		return new ResponseEntity<>(responseBean, HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<ResponseBean> update(@PathVariable int id){
		ResponseBean responseBean = new ResponseBean();
		int result = interfaceProductService.deleteById(id);
		if(result == 1) {
			responseBean.setMessage("Item deleted with success!");
		}
		return new ResponseEntity<>(responseBean, HttpStatus.OK);
	}
}
