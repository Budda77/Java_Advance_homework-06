package ua.homework.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.homework.dao.MagazineDao;
import ua.homework.domain.Magazine;
import ua.homework.utils.ConnectionUtils;

public class MagazineDaoImpl implements MagazineDao{
	
	private static String READ_ALL = "select * from magazine";
	private static String CREATE = "insert into magazine(name, description, price) values (?,?,?)";
	private static String READ_BY_ID = "select * from magazine where id = ?";
	private static String UPDATE_BY_ID = "update magazine set name = ?, description = ?, price = ? where id = ?";
	private static String DELETE_BY_ID = "delete from magazine where id =?";
	
	private static Logger LOGGER = Logger.getLogger(MagazineDaoImpl.class);
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public MagazineDaoImpl() 
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Magazine create(Magazine magazine) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, magazine.getName());
			preparedStatement.setString(2, magazine.getDescription());
			preparedStatement.setDouble(3, magazine.getPrice());
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			magazine.setId(rs.getInt(1));
			
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return magazine;
	}

	@Override
	public Magazine read(Integer id) {
		Magazine magazine = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);	
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			
			Integer magazineId = result.getInt("id");
			String name = result.getString("name");	
			String description = result.getString("description");	
			Double purchasePrice = result.getDouble("price");
			
			magazine = new Magazine(magazineId, name, description, purchasePrice);
				
		} catch (SQLException e) {
			LOGGER.error(e);
		}	
		return magazine;
	}

	@Override
	public Magazine update(Magazine magazine) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, magazine.getName());
			preparedStatement.setString(2, magazine.getDescription());
			preparedStatement.setDouble(3, magazine.getPrice());
			preparedStatement.setInt(4, magazine.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}	
		return magazine;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<Magazine> readAll() {
		List<Magazine> magazineRecords = new ArrayList<>();	
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();

			while(result.next()) {
				
				Integer magazineId = result.getInt("id");
				String name = result.getString("name");	
				String description = result.getString("description");	
				Double purchasePrice = result.getDouble("price");
				
				magazineRecords.add(new Magazine(magazineId, name, description, purchasePrice));		
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}		
		return magazineRecords;
	}
	

}
