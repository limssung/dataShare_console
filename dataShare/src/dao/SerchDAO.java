package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;

public class SerchDAO {
	public static void serchIdSkt(AgencySkt skt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "SELECT SKT_ID FROM SKT WHERE SKT_NAME = ? AND SKT_NUMBER = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, skt.getName());
		statement.setString(2, skt.getHpNumber());
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			System.out.println("=======================================================================================");
			System.out.println("                                  회원님의 아이디는 : " + resultSet.getString("SKT_ID") + " 입니다.");
			System.out.println("=======================================================================================");
		} else {
			System.out.println("=======================================================================================");
			System.out.println("                                 일치하는 아이디가 없습니다.");
			System.out.println("=======================================================================================");
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
	
	public static void serchIdKt(AgencyKt kt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "SELECT KT_ID FROM KT WHERE KT_NAME = ? AND KT_NUMBER = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, kt.getName());
		statement.setString(2, kt.getHpNumber());
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			System.out.println("=======================================================================================");
			System.out.println("                                  회원님의 아이디는 : " + resultSet.getString("KT_ID") + " 입니다.");
			System.out.println("=======================================================================================");
		} else {
			System.out.println("=======================================================================================");
			System.out.println("                                 일치하는 아이디가 없습니다.");
			System.out.println("=======================================================================================");
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
	
	public static void serchIdLgu(AgencyLgu lgu) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "SELECT LGU_ID FROM LGU WHERE LGU_NAME = ? AND LGU_NUMBER = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, lgu.getName());
		statement.setString(2, lgu.getHpNumber());
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			System.out.println("=======================================================================================");
			System.out.println("                                  회원님의 아이디는 : " + resultSet.getString("LGU_ID") + " 입니다.");
			System.out.println("=======================================================================================");
		} else {
			System.out.println("=======================================================================================");
			System.out.println("                                 일치하는 아이디가 없습니다.");
			System.out.println("=======================================================================================");
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
	public static void serchPwSkt(AgencySkt skt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "SELECT SKT_PASSWORD FROM SKT WHERE SKT_ID = ? AND SKT_NAME = ? AND SKT_NUMBER = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, skt.getId());
		statement.setString(2, skt.getName());
		statement.setString(3, skt.getHpNumber());
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			System.out.println("=======================================================================================");
			System.out.println("                                회원님의 비밀번호는 : " + resultSet.getString("SKT_PASSWORD") + " 입니다.");
			System.out.println("=======================================================================================");
		} else {
			System.out.println("=======================================================================================");
			System.out.println("                                 일치하는 아이디가 없습니다.");
			System.out.println("=======================================================================================");
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
	
	public static void serchPwKt(AgencyKt kt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "SELECT KT_PASSWORD FROM KT WHERE KT_ID = ? AND KT_NAME = ? AND KT_NUMBER = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, kt.getId());
		statement.setString(2, kt.getName());
		statement.setString(3, kt.getHpNumber());
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			System.out.println("=======================================================================================");
			System.out.println("                                회원님의 비밀번호는 : " + resultSet.getString("KT_PASSWORD") + " 입니다.");
			System.out.println("=======================================================================================");
		} else {
			System.out.println("=======================================================================================");
			System.out.println("                                 일치하는 아이디가 없습니다.");
			System.out.println("=======================================================================================");
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
	public static void serchPwLgu(AgencyLgu lgu) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "SELECT LGU_PASSWORD FROM LGU WHERE LGU_ID = ? AND LGU_NAME = ? AND LGU_NUMBER = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, lgu.getId());
		statement.setString(2, lgu.getName());
		statement.setString(3, lgu.getHpNumber());
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			System.out.println("=======================================================================================");
			System.out.println("                                회원님의 비밀번호는 : " + resultSet.getString("LGU_PASSWORD") + " 입니다.");
			System.out.println("=======================================================================================");
		} else {
			System.out.println("=======================================================================================");
			System.out.println("                                 일치하는 아이디가 없습니다.");
			System.out.println("=======================================================================================");
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
	
}
