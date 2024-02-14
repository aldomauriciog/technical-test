package com.crud.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.test.model.ProductBean;
import com.crud.test.repository.InterfaceProductRepository;

@Service
public class ProductService implements InterfaceProductService{
	
	@Autowired
	private InterfaceProductRepository interfaceProductRepository;

	@Override
	public List<ProductBean> findAll() {
		List<ProductBean> list;
		try {
			list = interfaceProductRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return list;
	}
	
	@Override
	public List<ProductBean> findForName(String name) {
		List<ProductBean> list;
		try {
			list = interfaceProductRepository.findForName(name);
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public int save(ProductBean product) {
		int row;
		try {
			row = interfaceProductRepository.save(product);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}

	@Override
	public int update(ProductBean product) {
		int row;
		try {
			row = interfaceProductRepository.update(product);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}

	@Override
	public int deleteById(int id) {
		int row;
		try {
			row = interfaceProductRepository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}

}
