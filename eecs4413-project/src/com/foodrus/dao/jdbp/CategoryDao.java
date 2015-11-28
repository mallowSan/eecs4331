package com.foodrus.dao.jdbp;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.foodrus.bean.vo.Category;
import com.foodrus.dao.RowMapper;
import com.foodrus.util.DaoHelper;

public class CategoryDao extends GenericDaoJdbc<Category> {
	
	// *** constants used by this DAO
	public static final String SELECT_CATEGORY_BY_ID = "select * from roumani.category where id = ?";
	public static final String SELECT_ALL_CATEGORIES = "select * from roumani.category";
	public static final RowMapper<Category> CATEGORY_ROW_MAPPER = new RowMapper<Category>(){
		@Override
		public Category mapRow(ResultSet resultSet, int rowNumber)
				throws SQLException {
			Category category = new Category();
			category.setDescription(resultSet.getString("Description"));
			category.setId(resultSet.getInt("Id"));
			category.setName(resultSet.getString("Name"));
			// *** since Picture is saved as Blob, it should be 
			// *** converted to byte[] to decouples model frm 
			Blob picAsBlob = resultSet.getBlob("Picture");
			byte[] picAsBytes =  picAsBlob.getBytes(1, (int)picAsBlob.length());
			category.setPicture(picAsBytes);
			return category;
		}
	};

	/**
	 * Default Constructor
	 * @throws NamingException
	 */
	public CategoryDao() throws NamingException {
		super(Category.class);
	}
	
	public CategoryDao(DataSource dataSource){
		super(Category.class, dataSource);
	}

	@Override
	public Category get(Object... pks) throws SQLException {
		Connection conn = getDataSource().getConnection();
		Map<Integer, Object> params = new HashMap<>();
		if(pks != null){
			params.put(1, pks[0]);
		}
		Category category = (Category) DaoHelper.
				queryForFirstResult(SELECT_CATEGORY_BY_ID, params, conn, CATEGORY_ROW_MAPPER);
		conn.close();
		return category;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Category> getAll() throws SQLException {
		Connection conn = getDataSource().getConnection();
		List<Category> categories = (List<Category>) DaoHelper.
				queryForList(SELECT_ALL_CATEGORIES, conn, CATEGORY_ROW_MAPPER);
		conn.close();
		return categories;
	}
}