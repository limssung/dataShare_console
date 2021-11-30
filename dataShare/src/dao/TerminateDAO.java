package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;

public class TerminateDAO {
	public void terminateSkt(AgencySkt skt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "DELETE FROM SKT WHERE SKT_ID = ? AND SKT_PASSWORD = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, skt.getId());
		statement.setString(2, skt.getPassword());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                    회원 탈퇴가 완료되었습니다! 안녕히 가십시오.                   ||");
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
	public void terminateKt(AgencyKt kt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "DELETE FROM KT WHERE KT_ID = ? AND KT_PASSWORD = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, kt.getId());
		statement.setString(2, kt.getPassword());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                    회원 탈퇴가 완료되었습니다! 안녕히 가십시오.                   ||");
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
	
	public void terminateLgu(AgencyLgu lgu) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "DELETE FROM LGU WHERE LGU_ID = ? AND LGU_PASSWORD = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, lgu.getId());
		statement.setString(2, lgu.getPassword());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                    회원 탈퇴가 완료되었습니다! 안녕히 가십시오.                   ||");
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
	public void terminateMSkt(AgencySkt skt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "DELETE FROM SKT WHERE SKT_ID = ? AND SKT_NUMBER = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, skt.getId());
		statement.setString(2, skt.getHpNumber());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out.println("=======================================================================================");
			System.out.println("||                              회원 삭제가 완료되었습니다!                          ||");
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
	public void terminateMKt(AgencyKt kt) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "DELETE FROM KT WHERE KT_ID = ? AND KT_NUMBER = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, kt.getId());
		statement.setString(2, kt.getHpNumber());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out.println("=======================================================================================");
			System.out.println("||                              회원 삭제가 완료되었습니다!                          ||");
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
	public void terminateMLgu(AgencyLgu lgu) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "DELETE FROM LGU WHERE LGU_ID = ? AND LGU_NUMBER = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, lgu.getId());
		statement.setString(2, lgu.getHpNumber());
		int result = statement.executeUpdate();
		if (result > 0) {
			System.out.println("=======================================================================================");
			System.out.println("||                              회원 삭제가 완료되었습니다!                          ||");
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
