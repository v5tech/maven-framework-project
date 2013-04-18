package com.fengjing.framework.spring.jdbc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.simple.ParameterizedSingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import com.fengjing.framework.spring.jdbc.dao.ProductDao;
import com.fengjing.framework.spring.jdbc.model.Product;

@Repository(value="jdbcProductDaoImpl")
public class ProductDaoImpl implements ProductDao {
	public final static String OPTION_SAVE="save"; 	
	public final static String OPTION_MODIFY="modify"; 	
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Resource(name="jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public Product findById(long id) {
		/*return getJdbcTemplate().queryForObject("select * from product where id = ? ",new Long[]{id}, new RowMapper<Product>(){

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getFloat(3));
				product.setDescription(rs.getString(4));
				product.setCategoryid(rs.getString(5));
				return product;
			}
			
		});*/
		
		return getJdbcTemplate().queryForObject("select * from product where id = ? ", new ParameterizedSingleColumnRowMapper<Product>(){
			
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getFloat(3));
				product.setDescription(rs.getString(4));
				product.setCategoryid(rs.getString(5));
				return product;
			}
			
		},id);
		
	}

	@Override
	public void modify(Product t) {
		//getJdbcTemplate().update("update product set name =?,price=?,description=?,categoryid=?  where id =? ", new Object[]{t.getName(),t.getPrice(),t.getDescription(),t.getCategoryid()});
		getJdbcTemplate().update("update product set name =?,price=?,description=?,categoryid=?  where id =? ", new ProductPreparedStatementSetter(t,OPTION_MODIFY));
	}

	@Override
	public void save(Product t) {
		//getJdbcTemplate().update("insert into product(name,price,description,categoryid) values(?,?,?,?)", new Object[]{t.getName(),t.getPrice(),t.getDescription(),t.getCategoryid()});
		getJdbcTemplate().update("insert into product(name,price,description,categoryid) values(?,?,?,?)", new ProductPreparedStatementSetter(t,OPTION_SAVE));
	}
	
	
	
	class ProductPreparedStatementSetter implements PreparedStatementSetter{
		
		private Product product;
		
		private String option_type;
		
		public ProductPreparedStatementSetter() {
		}
		
		public ProductPreparedStatementSetter(Product product,String option_type) {
			super();
			this.product = product;
			this.option_type=option_type;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public String getOption_type() {
			return option_type;
		}

		public void setOption_type(String option_type) {
			this.option_type = option_type;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, product.getName());
			ps.setFloat(2, product.getPrice());
			ps.setString(3, product.getDescription());
			ps.setString(4, product.getCategoryid());
			if(OPTION_MODIFY.equals(option_type)){
				ps.setInt(5, product.getId());
			}
		}
		
	}
	
	
	

	@Override
	public void deleteById(long id) {
		getJdbcTemplate().update("delete from product where id= ? ",new Object[]{id});
	}

	@Override
	public void delete(Product t) {
		
	}

	@Override
	public List<Product> listAll() {
		return getJdbcTemplate().query("select * from product",new BeanPropertyRowMapper<Product>(Product.class));
	}


	@Override
	public List<Product> getProductListByCategory(String name) {
		return getJdbcTemplate().query("select * from product inner join category on product.categoryid=category.id where category.name = ? ",new Object[]{name},new BeanPropertyRowMapper<Product>(Product.class));
	}

}
