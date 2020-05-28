package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface {

	public int signUp(User user) {
		String INSERT_USERS_SQL = "INSERT INTO USERS(email, password)VALUES(?,?)";

		int result = 0;
		try
		{
			Connection connection = ConnectionManager.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1,user.getEmail());
			preparedStatement.setString(2,user.getPassword());
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public boolean loginUser(User user) {
		boolean status = false;
		try{
			Connection connection = ConnectionManager.getConnection();
		
			if(connection!=null) {
				// Step 2:Create a statement using connection object

				System.out.println("establish");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email = ? and password = ? ");
		
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
           System.out.println(user.getEmail());
           System.out.println(user.getPassword());
         			
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			//status = rs.next();
			status=true;
			}
			else
				System.out.println("not");
		} catch (SQLException e) {
			// process sql exception
			System.out.println(e);
		}
		System.out.println("status:"+status);
		return status;
	}

}
