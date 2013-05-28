package main.edu.pwu.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import main.edu.pwu.model.Subject;
import main.edu.pwu.model.Subject.SUBJECT_TYPE;

public class SubjectDaoImp implements SubjectDao {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/pwudb";
	
	static final String USER = "root";
	static final String PASSWORD = "root";

	@Override
	public void add(Subject subject) {
		// TODO Add subject to database		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO () VALUES ()";
		
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subject.getCode());
			pstmt.setString(2, subject.getTitle());
			pstmt.setString(3, subject.getDescription());
			pstmt.setInt(4, subject.getUnits());
			pstmt.setInt(5, (subject.getType() == SUBJECT_TYPE.ACADEMIC) ? 1 : 0);
			pstmt.executeUpdate();


			System.out.println("Connected database successfully");
			
		}
		catch (Exception e) {
			System.out.println("Error connecting to database...");
			System.out.println(e.getMessage());
		}
		finally{
			try{
				if(conn != null){
					conn.close();
					conn = null;
					System.out.println("Connection was closed successfully");
				}
			}
			catch (SQLException e) {
				System.out.println("An error occurred while trying to close the connection");
			}
		}		
	}

	@Override
	public void update(Subject subject) {
		// TODO Update subject in database
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE (?,?,?,?) VALUES () WHERE subjectCode = ?";
		
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subject.getTitle());
			pstmt.setString(2, subject.getDescription());
			pstmt.setInt(3, subject.getUnits());
			pstmt.setInt(4, (subject.getType() == SUBJECT_TYPE.ACADEMIC) ? 1 : 0);
			pstmt.setString(5, subject.getCode());
			pstmt.executeUpdate();

			System.out.println("Connected database successfully");
			
		}
		catch (Exception e) {
			System.out.println("Error connecting to database...");
			System.out.println(e.getMessage());
		}
		finally{
			try{
				if(conn != null){
					conn.close();
					conn = null;
					System.out.println("Connection was closed successfully");
				}
			}
			catch (SQLException e) {
				System.out.println("An error occurred while trying to close the connection");
			}
		}

	}

	@Override
	public void delete(Subject subject) {
		// TODO Delete subject in database		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM subject WHERE subjectCode = ?";
		
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subject.getCode());
			pstmt.executeUpdate();
			
			System.out.println("Connected database successfully");
			
		}
		catch (Exception e) {
			System.out.println("Error connecting to database...");
			System.out.println(e.getMessage());
		}
		finally{
			try{
				if(conn != null){
					conn.close();
					conn = null;
					System.out.println("Connection was closed successfully");
				}
			}
			catch (SQLException e) {
				System.out.println("An error occurred while trying to close the connection");
			}
		}
	}

	@Override
	public Subject get(String code) {
		
		Subject subject = null;		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM subject WHERE subjectCode = ?";
		
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			if(rs.first()){
				subject = new Subject();
				do{
					subject.setCode(rs.getString("subjectCode"));
					subject.setTitle(rs.getString("title"));
					subject.setUnits(rs.getInt("totalUnits"));
					subject.setType(rs.getInt("academicUnits") == 0 ? SUBJECT_TYPE.NON_ACADEMIC:SUBJECT_TYPE.ACADEMIC);
				}while(rs.next());
			}
			
			rs.close();
			System.out.println("Connected database successfully");
			
		}
		catch (Exception e) {
			System.out.println("Error connecting to database...");
			System.out.println(e.getMessage());
		}
		finally{
			try{
				if(conn != null){
					conn.close();
					conn = null;
					System.out.println("Connection was closed successfully");
				}
			}
			catch (SQLException e) {
				System.out.println("An error occurred while trying to close the connection");
			}
		}
		
		return subject;
	}

	@Override
	public List<Subject> getAll() {
		
		List<Subject> subjects = null;		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM subject";
		
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.first()){
				subjects = new ArrayList<>();
				do{
					Subject subject = new Subject();
					subject.setCode(rs.getString("subjectCode"));
					subject.setTitle(rs.getString("title"));
					subject.setUnits(rs.getInt("totalUnits"));
					
					subject.setType(rs.getInt("academicUnits") == 0 ? SUBJECT_TYPE.NON_ACADEMIC:SUBJECT_TYPE.ACADEMIC);
					subjects.add(subject);
				}while(rs.next());
			}
			
			rs.close();
			
			System.out.println("Connected database successfully");
			
		}
		catch (Exception e) {
			System.out.println("Error connecting to database...");
			System.out.println(e.getMessage());
		}
		finally{
			try{
				if(conn != null){
					conn.close();
					conn = null;
					System.out.println("Connection was closed successfully");
				}
			}
			catch (SQLException e) {
				System.out.println("An error occurred while trying to close the connection");
			}
		}
		
		return subjects;
	}

}
