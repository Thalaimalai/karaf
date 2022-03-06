package com.theatmo.studentdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.theatmo.databaseconnection.DatabaseConnection;
import com.theatmo.studentmodel.Student;
import com.theatmo.studentexception.CustomException.SQLSyntaxErrorException;

/**
 * StudentRecordDAOImpl.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentDAOImpl implements StudentDAO {

	/**
	 * Insert the Admin informations.
	 * 
	 * @param adminName
	 * @param adminEmail
	 * @param password
	 */
	public boolean insertAdminDetails(final String adminName, final String adminEmail, final String password) {
		final String insertQuery = "insert into admin_records values(?, ?, ?)";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			statement.setString(1, adminName);
			statement.setString(2, adminEmail);
			statement.setString(3, password);

			return statement.executeUpdate() > 0;
		} catch (SQLException exception) {
			throw new SQLSyntaxErrorException("Database Access Denied");
		}
	}

	/**
	 * Admin login.
	 * 
	 * @param adminEmail
	 * @param password
	 */
	public boolean loginAdmin(final String adminEmail, final String password) {
		final String adminLogin = "select adminemail, password from admin_records where BINARY adminemail = ? and BINARY password = ? ";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(adminLogin);) {
			preparestatement.setString(1, adminEmail);
			preparestatement.setString(2, password);

			try (ResultSet resultset = preparestatement.executeQuery();) {

				while (resultset.next()) {
					return true;
				}
			}
		} catch (SQLException exception) {
			throw new SQLSyntaxErrorException("Database Access Denied");
		}
		return false;
	}

	/**
	 * Student login.
	 * 
	 * @param rollNumber
	 * @param studentName
	 */
	public boolean studentLogin(final String rollNumber, final String studentName) {
		final String studentLogin = "select rollnumber, name from student_records where rollnumber = ? and name = ?";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(studentLogin);) {
			preparestatement.setString(1, rollNumber);
			preparestatement.setString(2, studentName);

			try (ResultSet resultset = preparestatement.executeQuery();) {

				while (resultset.next()) {
					return true;
				}
			}
		} catch (SQLException exception) {
			throw new SQLSyntaxErrorException("Database Access Denied");
		}
		return false;
	}

	/**
	 * Insert student details.
	 * 
	 * @param student
	 */
	public boolean insertStudentDetails(final Student student) {
		final String insertQuery = "insert into student_records values (?, ?, ?, ?, ?, ?, ?)";
		final String query = "insert into marks (rollnumber, grade) values (?, ?)";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(insertQuery);
				PreparedStatement preparestatement1 = connection.prepareStatement(query);) {

			preparestatement.setString(1, student.getRollNumber());
			preparestatement.setString(2, student.getName());
			preparestatement.setString(3, student.getDepartmentName());
			preparestatement.setString(4, student.getEmail());
			preparestatement.setString(5, student.getGender());
			preparestatement.setDate(6, student.getDateOfBirth());
			preparestatement.setString(7, student.getAddress());

			preparestatement.executeUpdate();

			preparestatement1.setString(1, student.getRollNumber());
			preparestatement1.setString(2, student.getGrade());

			return preparestatement1.executeUpdate() > 0;
		} catch (SQLException exception) {
			throw new SQLSyntaxErrorException("Database Access Denied");
		}
	}

	/**
	 * Get student records.
	 * 
	 * @param rollNumber
	 */
	public Student selectStudentDetail(final String rollNumber) {
		final String getQuery = "select student_records.*, marks.* from student_records left join marks on student_records.rollnumber = marks.rollnumber where student_records.rollnumber = ?";
		Student student = null;

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(getQuery);) {
			preparestatement.setString(1, rollNumber);

			try (ResultSet resultset = preparestatement.executeQuery();) {

				while (resultset.next()) {
					String studentName = resultset.getString(2);
					String departmentName = resultset.getString(3);
					String email = resultset.getString(4);
					String gender = resultset.getString(5);
					Date dateOfBirth = resultset.getDate(6);
					String address = resultset.getString(7);
					String grade = resultset.getString(10);

					student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address,
							grade);
				}
			}
		} catch (SQLException exception) {
			throw new SQLSyntaxErrorException("Database Access Failed");
		}
		return student;
	}

	/**
	 * Delete student records.
	 * 
	 * @param rollNumber
	 */
	public boolean deleteStudentDetails(final String rollNumber) {
		final String deleteQuery = "DELETE student_records, marks from student_records left join marks on student_records.rollnumber = marks.rollnumber where student_records.rollnumber = ?";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(deleteQuery);) {
			preparestatement.setString(1, rollNumber);

			return preparestatement.executeUpdate() > 0;
		} catch (SQLException exception) {
			throw new SQLSyntaxErrorException("Database Access Denied");
		}
	}

	/**
	 * Update student details.
	 * 
	 * @param student
	 */
	public boolean updateStudentDetails(final Student student) {
		final String updateQuery = "UPDATE student_records left join marks on student_records.rollnumber = marks.rollnumber SET student_records.name = ?, student_records.departmentname = ?, student_records.email = ?, student_records.gender = ?, student_records.dateofbirth = ?, student_records.address = ?, marks.grade = ? where student_records.rollnumber = ?";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(updateQuery);) {

			preparestatement.setString(1, student.getName());
			preparestatement.setString(2, student.getDepartmentName());
			preparestatement.setString(3, student.getEmail());
			preparestatement.setString(4, student.getGender());
			preparestatement.setDate(5, student.getDateOfBirth());
			preparestatement.setString(6, student.getAddress());
			preparestatement.setString(7, student.getGrade());
			preparestatement.setString(8, student.getRollNumber());

			return preparestatement.executeUpdate() > 0;
		} catch (SQLException exception) {
			throw new SQLSyntaxErrorException("Database Access Denied");
		}
	}

	/**
	 * List to add all admin emails.
	 */
	public List<String> getAdminEmail() {
		final List<String> emailList = new ArrayList<String>();
		final String getEmail = "select adminemail from admin_records";

		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery(getEmail);) {

			while (resultset.next()) {
				String email = resultset.getString(1);
				emailList.add(email);
			}
		} catch (SQLException exception) {
			throw new SQLSyntaxErrorException("Database Access Denied");
		}
		return emailList;
	}

	/**
	 * Get all student records in a map.
	 */
	public Map<String, Student> getAllStudents() {
		final String getstudent = "select student_records.*, marks.grade from student_records left join marks on student_records.rollnumber = marks.rollnumber";
		final Map<String, Student> studentList = new HashMap<String, Student>();

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(getstudent);
				ResultSet resultset = statement.executeQuery();) {

			while (resultset.next()) {
				Student student = new Student(resultset.getString("rollnumber"), resultset.getString("name"),
						resultset.getString("departmentname"), resultset.getString("email"),
						resultset.getString("gender"), resultset.getDate("dateofbirth"), resultset.getString("address"),
						resultset.getString("grade"));

				studentList.put(student.getRollNumber(), student);
			}
		} catch (SQLException e) {
			throw new SQLSyntaxErrorException("Database Access Failed");
		}
		return studentList;
	}
}