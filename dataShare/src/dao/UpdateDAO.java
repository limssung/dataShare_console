package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;

public class UpdateDAO {
	public void updateSktPW(AgencySkt skt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "UPDATE SKT SET SKT_PASSWORD = ? " + "WHERE SKT_ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, skt.getPassword());
		statement.setString(2, skt.getId());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                           회원 정보 변경이 완료되었습니다!                        ||");
			System.out
					.println("=======================================================================================");
		} else {
			System.out
					.println("=======================================================================================");
			System.out.println("||                               잘못된 정보를 입력하셨습니다.                       ||");
			System.out
					.println("=======================================================================================");
		}
		statement.close();
		connection.close();
	}

	public void updateKtPW(AgencyKt kt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "UPDATE KT SET KT_PASSWORD = ? \r\n" + "WHERE KT_ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, kt.getPassword());
		statement.setString(2, kt.getId());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                           회원 정보 변경이 완료되었습니다!                        ||");
			System.out
					.println("=======================================================================================");
		} else {
			System.out
					.println("=======================================================================================");
			System.out.println("||                               잘못된 정보를 입력하셨습니다.                       ||");
			System.out
					.println("=======================================================================================");
		}
		statement.close();
		connection.close();
	}

	public void updateLguPW(AgencyLgu lgu) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "UPDATE LGU SET LGU_PASSWORD = ? \r\n" + "WHERE LGU_ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, lgu.getPassword());
		statement.setString(2, lgu.getId());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                           회원 정보 변경이 완료되었습니다!                        ||");
			System.out
					.println("=======================================================================================");
		} else {
			System.out
					.println("=======================================================================================");
			System.out.println("||                               잘못된 정보를 입력하셨습니다.                       ||");
			System.out
					.println("=======================================================================================");
		}
		statement.close();
		connection.close();
	}

	public void updateSktHpNum(AgencySkt skt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "UPDATE SKT SET SKT_NUMBER = ? " + "WHERE SKT_ID = ? AND SKT_PASSWORD = ? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, skt.getHpNumber());
		statement.setString(2, skt.getId());
		statement.setString(3, skt.getPassword());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                           회원 정보 변경이 완료되었습니다!                        ||");
			System.out
					.println("=======================================================================================");
		} else {
			System.out
					.println("=======================================================================================");
			System.out.println("||                               잘못된 정보를 입력하셨습니다.                       ||");
			System.out
					.println("=======================================================================================");
		}
		statement.close();
		connection.close();
	}

	public void updateKtHpNum(AgencyKt kt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "UPDATE KT SET KT_NUMBER = ? " + "WHERE KT_ID = ? AND KT_PASSWORD = ? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, kt.getHpNumber());
		statement.setString(2, kt.getId());
		statement.setString(3, kt.getPassword());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                           회원 정보 변경이 완료되었습니다!                        ||");
			System.out
					.println("=======================================================================================");
		} else {
			System.out
					.println("=======================================================================================");
			System.out.println("||                               잘못된 정보를 입력하셨습니다.                       ||");
			System.out
					.println("=======================================================================================");
		}
		statement.close();
		connection.close();
	}
	
	public void updateLguHpNum(AgencyLgu lgu) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "UPDATE LGU SET LGU_NUMBER = ? " + "WHERE LGU_ID = ? AND LGU_PASSWORD = ? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, lgu.getHpNumber());
		statement.setString(2, lgu.getId());
		statement.setString(3, lgu.getPassword());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                           회원 정보 변경이 완료되었습니다!                        ||");
			System.out
					.println("=======================================================================================");
		} else {
			System.out
					.println("=======================================================================================");
			System.out.println("||                               잘못된 정보를 입력하셨습니다.                       ||");
			System.out
					.println("=======================================================================================");
		}
		statement.close();
		connection.close();
	}
	
	
}
