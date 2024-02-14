package com.crud.test.repository;

import java.util.List;

import com.crud.test.model.ProductBean;

public interface InterfaceProductRepository {
	public List<ProductBean> findAll();
	public List<ProductBean> findForName(String filter);
	public int save(ProductBean product);
	public int update(ProductBean product);
	public int deleteById(int id);
}
