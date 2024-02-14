package com.crud.test.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.test.model.ProductBean;

@Repository
public class ProductRepository implements InterfaceProductRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ProductBean> findAll() {
		String SQL = "SELECT * FROM product WHERE status = 1";
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(ProductBean.class));
	}
	
	@Override
	public List<ProductBean> findForName(String filter) {
		String SQL = "SELECT * FROM product WHERE product_name like '%" + filter + "%' AND status = 1";
		return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(ProductBean.class));
	}

	@Override
	public int save(ProductBean product) {
		String SQL = "INSERT INTO product VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(SQL, new Object[]{product.getProduct_name(), product.getProduct_desc(), product.getPrice(),
				product.getBrand(), product.getStatus()});
	}

	@Override
	public int update(ProductBean product) {
		String SQL = "UPDATE product SET product_name = ?, product_desc = ?, price = ?, brand = ? WHERE product_id = ?";
		return jdbcTemplate.update(SQL, new Object[]{product.getProduct_name(), product.getProduct_desc(), product.getPrice(),
				product.getBrand(), product.getProduct_id()});
	}

	@Override
	public int deleteById(int id) {
		String SQL = "UPDATE product SET status = 0 WHERE product_id = ?";
		return jdbcTemplate.update(SQL, new Object[] {id});
	}

}
