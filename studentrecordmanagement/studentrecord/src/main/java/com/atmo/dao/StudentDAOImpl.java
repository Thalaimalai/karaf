package com.atmo.dao;

import com.atmo.connection.DatabaseConnection;
import com.atmo.exception.ConnectionFailedException;
import com.atmo.model.Student;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * StudentRecordDAOImpl.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentDAOImpl implements StudentDAO {

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
			throw new ConnectionFailedException("Database Access Denied-Check SQL Syntax");
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
			throw new ConnectionFailedException("Database Access Failed-Check SQL Syntax");
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
			throw new ConnectionFailedException("Database Access Denied-Check SQL Syntax");
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
			throw new ConnectionFailedException("Database Access Denied-Check SQL Syntax");
		}
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
			throw new ConnectionFailedException("Database Access Failed-Check SQL Syntax");
		}
		return studentList;
	}
}