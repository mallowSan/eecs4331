package com.foodrus.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.foodrus.dao.RowMapper;

public class DaoHelper {

	private DaoHelper() {
	}

	/**
	 * 
	 * @param sql
	 * @param parametersMap
	 * @param conn
	 * @param rowMapper
	 * @return
	 * @throws SQLException
	 */
	public static final List<?> queryForList(String sql, Map<Integer, Object> parametersMap, 
			Connection conn, RowMapper<?> rowMapper) throws SQLException {
		System.out.println("Executing Query ["+sql+"]");
		// Prepare SQL statement
		PreparedStatement stmt = conn.prepareStatement(sql);
		if(parametersMap != null){
			for(Entry<Integer, Object> paramEntry : parametersMap.entrySet()){
				stmt.setObject(paramEntry.getKey(), paramEntry.getValue());
			}
		}
		// Execute SQL and parse beans out of the result set
		List<Object> beans = new ArrayList<>();
		ResultSet res = stmt.executeQuery();
		while(res.next()){
			beans.add(rowMapper.mapRow(res, res.getRow()));
		}
		// release resources
		res.close();
		stmt.close();
		return beans;
	}

	/**
	 * 
	 * @param sql
	 * @param conn
	 * @param rowMapper
	 * @return
	 * @throws SQLException
	 */
	public static final List<?> queryForList(String sql, Connection conn, RowMapper<?> rowMapper) 
			throws SQLException {
		return queryForList(sql, null, conn, rowMapper);
	}
	/**
	 * 
	 * @param sql
	 * @param conn
	 * @param rowMapper
	 * @return
	 * @throws SQLException
	 */
	public static final Object queryForFirstResult(String sql, Map<Integer, Object> parametersMap,
			Connection conn, RowMapper<?> rowMapper) throws SQLException {
		System.out.println("Executing Query ["+sql+"]");
		return queryForList(sql, parametersMap, conn, rowMapper).get(0);
	}

	/**
	 * 
	 * @param sql
	 * @param conn
	 * @param rowMapper
	 * @return
	 * @throws SQLException
	 */
	public static final Object queryForFirstResult(String sql, Connection conn, RowMapper<?> rowMapper) 
			throws SQLException {
		System.out.println("Executing Query ["+sql+"]");
		return queryForList(sql, conn, rowMapper).get(0);
	}

}
