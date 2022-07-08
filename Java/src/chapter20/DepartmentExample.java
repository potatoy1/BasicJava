package chapter20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentExample {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.3:1521:xe","sem","java");
		Statement statement = connection.createStatement(); 
		ResultSet resultSet = statement.executeQuery("select dept_id, dept_name, dept_tel from department");
		while(resultSet.next()) {
			String deptId = resultSet.getString("dept_id");
			String deptName = resultSet.getString("dept_name");
			String deptTel = resultSet.getString("dept_tel");
			System.out.printf("%s\t %s\t %s\n",deptId, deptName, deptTel);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
	}
}
