package chapter20.memo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

// Data Access Object: 직접 데이터베이스에 접속해서 데이터 처리
// MemoDao (X) MemoDAO(O)
public class MemoDAO {
	public List<MemoVO> selectList() throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc13","java");
		Statement statement = connection.createStatement();	//워크시트 만들기
		// 문자열 결합
		// 1. + 기호
		// 2. StringBuilder(StringBuffer) : 속도가 빠르다.			StringBuilder과 StringBuffer는 HashMap과 HashTable 같은 관계.
		// 1. String sql = ("SELECT");
		//			 sql+= ("id,") '''''				            문자열 앞이나 뒤를 띄어주어야 에러안남.
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     id,");						 			//as seq로 alias를 줄 수 있음.
		builder.append("     title,");
		builder.append("     contents,");
		builder.append("     register_date,");
		builder.append("     modify_date");
		builder.append(" FROM");
		builder.append("     memo");
		String sql = builder.toString();
		
		ResultSet resultSet = statement.executeQuery(sql);
		// 결과가 : 0 ~ 무한대(flux)이므로 while문 사용.
		List<MemoVO> list = new ArrayList<>();						//받은 데이터를 목록으로 만들기 위한 배열선언
		while(resultSet.next()) {
			int id = resultSet.getInt("id");						// seq로 alias 줬을 경우 seq로 써야함.
			String title = resultSet.getString("title");
			String contents = resultSet.getString("contents");
			Date registerDate = resultSet.getDate("register_date");
			Date modifyDate = resultSet.getDate("modify_date");
			list.add(new MemoVO(id, title, contents, registerDate, modifyDate)); //목록을 만들기 위한 list추가
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;															//return list여야 list가 반환됨. return null은 error발생.
	}
	public MemoVO selectOne(int searchId) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc13","java");
		Statement statement = connection.createStatement();				            
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     id,");						 			
		builder.append("     title,");
		builder.append("     contents,");
		builder.append("     register_date,");
		builder.append("     modify_date");
		builder.append(" FROM");
		builder.append("     memo");
		builder.append("  WHERE");
		builder.append("      id = " + searchId);
		String sql = builder.toString();
		
		ResultSet resultSet = statement.executeQuery(sql);
		// 결과가 0 or 1(Mono)
		MemoVO vo = null;														  //split
		if(resultSet.next()) {
			int id = resultSet.getInt("id");						
			String title = resultSet.getString("title");
			String contents = resultSet.getString("contents");
			Date registerDate = resultSet.getDate("register_date");
			Date modifyDate = resultSet.getDate("modify_date");
			vo = new MemoVO(id, title, contents, registerDate, modifyDate);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}
	public int insertMemo(MemoVO vo) throws Exception {								// 매개변수 다시 지정하는 대신 MemoVO에서 가져옴.
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc13","java");
		StringBuilder builder = new StringBuilder();
		builder.append(" INSERT INTO memo ( ");
		builder.append("     id, ");
		builder.append("     title, ");
		builder.append("     contents ");
		builder.append(")  VALUES (");
		builder.append("     memo_seq.nextval, ");									// memo시퀀스 nextvalue -> 자동으로 1씩증가.
		builder.append("     ?, ");
		builder.append("     ?");
		builder.append(")");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);				// 쿼리의 형태를 미리 짜놓는다. (printf형식 지정하는것 처럼)			
		statement.setString(1, vo.getTitle());										// 위에 물음표 순서대로 ""안의 내용이 들어간다.
		statement.setString(2, vo.getContents());
		// insert, update, delete가 모두 executeUpdate()메소드를 호출
		int executeUpdate = statement.executeUpdate();								// 지금은 이미 쿼리가 들어가 있어서 업데이트괄호안에 아무것도 안 넣어도됨.
		statement.close();
		connection.close();
		return executeUpdate;
	}
	public int updateMemo(MemoVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc13","java");
		StringBuilder builder = new StringBuilder();
		builder.append(" UPDATE memo");
		builder.append("     SET ");
		builder.append("         title = ?, ");
		builder.append("         contents = ?,");
		builder.append("         modify_date = SYSDATE ");
		builder.append(" WHERE ");									
		builder.append("     id = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);				
		statement.setString(1, vo.getTitle());										
		statement.setString(2, vo.getContents());
		statement.setInt(3, vo.getId());
		int executeUpdate = statement.executeUpdate();							
		statement.close();
		connection.close();
		return executeUpdate;
	}
	public int deleteMemo(int deleteId) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc13","java");
		StringBuilder builder = new StringBuilder();
		builder.append("DELETE FROM  ");
		builder.append("memo  ");
		builder.append("WHERE ");
		builder.append("id = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);				
		statement.setInt(1,deleteId);										
		int executeUpdate = statement.executeUpdate();							
		statement.close();
		connection.close();
		return executeUpdate;
	}
}
