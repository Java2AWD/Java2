package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Category;

public class CategoryDAOJDBCImpl extends JdbcDAO implements CategoryDAO {

	@Override
	public Category getById(Long id) {
		Connection con = getConnection();
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from Category where category_id = " + id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			if (!resultSet.next()) {
				return null;
			}
			Category category = new Category();
			category.setCategory_id(id);// = category.setCategory_id(resultSet.getLong(1));
			category.setName(resultSet.getString(2));
			category.setDescription(resultSet.getString(3));
			con.close();
			return category;
		} catch (SQLException e) {
			throw new RuntimeException("Can not get category by id", e);
		}
	}

	@Override
	public void save(Category category) {
		Connection con = getConnection();
		try {
			PreparedStatement statement = con.prepareStatement("insert into Category(name, description)" + "values(?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, category.getName());
			statement.setString(2, category.getDescription());
			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();
			rs.next();

			long id = rs.getLong(1);

			category.setCategory_id(id);

			rs.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException("Can not save category", e);
		}
	}

	@Override
	public void update(Category category) {
		try {
			Connection con = getConnection();
			PreparedStatement preStatement = con.prepareStatement("update Category set name = ?, description = ? where category_id= ?");

			preStatement.setString(1, category.getName());
			preStatement.setString(2, category.getDescription());
			preStatement.setLong(3, category.getCategory_id());

			preStatement.executeUpdate();
			con.close();
			preStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException("Can not update data in DB", e);
		}
	}

	@Override
	public void deleteById(Long id) {
		Connection con = getConnection();
		try {
			PreparedStatement statement;
			statement = con.prepareStatement("delete from Category where category_id ="	+ id);
			statement.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException("Can not delete category by id", e);
		}

	}

}
