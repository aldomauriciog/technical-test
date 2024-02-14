package com.crud.test.service;

import java.util.List;

import com.crud.test.model.ProductBean;

public interface InterfaceProductService {
	
	public List<ProductBean> findAll();
	public List<ProductBean> findForName(String name);
	public int save(ProductBean product);
	public int update(ProductBean product);
	public int deleteById(int id);
	
}
