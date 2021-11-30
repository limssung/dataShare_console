package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import agency.AgencyLog;
import manager.Manager;

public class ManagerDAO {
	public static void managerSkt() throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
			String sql = "INSERT INTO LOG (LOG_ID, LOG_DAY, LOG_TYPE, LOG_SKTFEE)\r\n"
					+ " VALUES('MANAGER',SUBSTR(SYSTIMESTAMP, 1, 20),'관리자조회',\r\n" + "(select sum(SKT_FEE) from SKT))";
			String sql2 = "SELECT LOG_DAY, LOG_SKTFEE FROM LOG WHERE LOG_TYPE = '관리자조회' AND LOG_SKTFEE = (SELECT MAX(LOG_SKTFEE) FROM LOG)\r\n"
					+ "AND LOG_DAY = (SELECT MAX(LOG_DAY) FROM LOG)";
			PreparedStatement statement = connection.prepareStatement(sql);
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			int result = statement.executeUpdate();
			ResultSet resultSet = statement2.executeQuery();
			if (resultSet.next()) {
			}
			if (result > 0) {
				System.out.println(
						"=======================================================================================");
				System.out.println("                          SKT 통신사의 총 수익이 업데이트 됐습니다!");
				System.out.println("                               날짜 : " + resultSet.getString("LOG_DAY") + ",");
				System.out.println(
						"                                총 수익 : " + resultSet.getString("LOG_SKTFEE") + "원 입니다.");
				System.out.println(
						"=======================================================================================");

			}
		} catch (java.util.NoSuchElementException e) {
			Manager.managerMode();
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			Manager.managerMode();
		} finally {
			Manager.managerMode();
		}
	}

	public static void managerKt() throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
			String sql = "INSERT INTO LOG (LOG_ID, LOG_DAY, LOG_TYPE, LOG_KTFEE)\r\n"
					+ " VALUES('MANAGER',SUBSTR(SYSTIMESTAMP, 1, 20),'관리자조회',\r\n" + "(select sum(KT_FEE) from KT))";
			String sql2 = "SELECT LOG_DAY, LOG_KTFEE FROM LOG WHERE LOG_TYPE = '관리자조회' AND LOG_KTFEE = (SELECT MAX(LOG_KTFEE) FROM LOG)\r\n"
					+ "AND LOG_DAY = (SELECT MAX(LOG_DAY) FROM LOG)";
			PreparedStatement statement = connection.prepareStatement(sql);
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			int result = statement.executeUpdate();
			ResultSet resultSet = statement2.executeQuery();
			if (resultSet.next()) {
			}
			if (result > 0) {
				System.out.println(
						"=======================================================================================");
				System.out.println("                          KT 통신사의 총 수익이 업데이트 됐습니다!");
				System.out.println("                               날짜 : " + resultSet.getString("LOG_DAY") + ",");
				System.out.println(
						"                                총 수익 : " + resultSet.getString("LOG_KTFEE") + "원 입니다.");
				System.out.println(
						"=======================================================================================");

			}
		} catch (java.util.NoSuchElementException e) {
			Manager.managerMode();
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			Manager.managerMode();
		} finally {
			Manager.managerMode();
		}
	}

	public static void managerLgu() throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
			String sql = "INSERT INTO LOG (LOG_ID, LOG_DAY, LOG_TYPE, LOG_LGUFEE)\r\n"
					+ " VALUES('MANAGER',SUBSTR(SYSTIMESTAMP, 1, 20),'관리자조회',\r\n" + "(select sum(LGU_FEE) from LGU))";
			String sql2 = "SELECT LOG_DAY, LOG_LGUFEE FROM LOG WHERE LOG_TYPE = '관리자조회' AND LOG_LGUFEE = (SELECT MAX(LOG_LGUFEE) FROM LOG)\r\n"
					+ "AND LOG_DAY = (SELECT MAX(LOG_DAY) FROM LOG)";
			PreparedStatement statement = connection.prepareStatement(sql);
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			int result = statement.executeUpdate();
			ResultSet resultSet = statement2.executeQuery();
			if (resultSet.next()) {
			}
			if (result > 0) {
				System.out.println(
						"=======================================================================================");
				System.out.println("                          LGU 통신사의 총 수익이 업데이트 됐습니다!");
				System.out.println("                               날짜 : " + resultSet.getString("LOG_DAY") + ",");
				System.out.println(
						"                                총 수익 : " + resultSet.getString("LOG_LGUFEE") + "원 입니다.");
				System.out.println(
						"=======================================================================================");

			}
		} catch (java.util.NoSuchElementException e) {
			Manager.managerMode();
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			Manager.managerMode();
		} finally {
			Manager.managerMode();
		}
	}

	public static List<AgencyLog> logSkt(String id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "SELECT LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_SKTFEE FROM LOG WHERE LOG_ID = ? AND LOG_AGENCY = 'SKT'";
		String sql2 = "SELECT SKT_ID FROM SKT WHERE SKT_ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		statement.setString(1, id);
		statement2.setString(1, id);
		ArrayList<AgencyLog> list = new ArrayList<AgencyLog>();
		ResultSet resultSet = statement.executeQuery();
		ResultSet resultSet2 = statement2.executeQuery();
		if (resultSet2.next() && id.equals(resultSet2.getString("SKT_ID"))) {
			while (resultSet.next()) {
				String id1 = resultSet.getString("LOG_ID");
				String name = resultSet.getString("LOG_NAME");
				int data = resultSet.getInt("LOG_DATA");
				String day = resultSet.getString("LOG_DAY");
				String agency = resultSet.getString("LOG_AGENCY");
				String type = resultSet.getString("LOG_TYPE");
				int fee = resultSet.getInt("LOG_SKTFEE");
				list.add(new AgencyLog(id1, name, data, day, agency, type, fee));
			}
			resultSet.close();
			resultSet2.close();
			statement.close();
			statement2.close();
			connection.close();
		} else {
			System.out
					.println("=======================================================================================");
			System.out.println("||                               조회하신 회원이 존재하지 않습니다.                  ||");
			System.out
					.println("=======================================================================================");
			resultSet.close();
			resultSet2.close();
			statement.close();
			statement2.close();
			connection.close();
			Manager.managerMode();
		}
		return list;
	}

	public static List<AgencyLog> logKt(String id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "SELECT LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_KTFEE FROM LOG WHERE LOG_ID = ? AND LOG_AGENCY = 'KT'";
		String sql2 = "SELECT KT_ID FROM KT WHERE KT_ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		statement.setString(1, id);
		statement2.setString(1, id);
		ArrayList<AgencyLog> list = new ArrayList<AgencyLog>();
		ResultSet resultSet = statement.executeQuery();
		ResultSet resultSet2 = statement2.executeQuery();
		if (resultSet2.next() && id.equals(resultSet2.getString("KT_ID"))) {

			while (resultSet.next()) {
				String id1 = resultSet.getString("LOG_ID");
				String name = resultSet.getString("LOG_NAME");
				int data = resultSet.getInt("LOG_DATA");
				String day = resultSet.getString("LOG_DAY");
				String agency = resultSet.getString("LOG_AGENCY");
				String type = resultSet.getString("LOG_TYPE");
				int fee = resultSet.getInt("LOG_KTFEE");
				list.add(new AgencyLog(id1, name, data, day, agency, type, fee));
			}
			resultSet.close();
			resultSet2.close();
			statement.close();
			statement2.close();
			connection.close();
		} else {
			System.out
					.println("=======================================================================================");
			System.out.println("||                               조회하신 회원이 존재하지 않습니다.                  ||");
			System.out
					.println("=======================================================================================");
			resultSet.close();
			resultSet2.close();
			statement.close();
			statement2.close();
			connection.close();
			Manager.managerMode();
		}
		return list;
	}

	public static List<AgencyLog> logLgu(String id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = "SELECT LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_LGUFEE FROM LOG WHERE LOG_ID = ? AND LOG_AGENCY = 'LGU'";
		String sql2 = "SELECT LGU_ID FROM LGU WHERE LGU_ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		statement.setString(1, id);
		statement2.setString(1, id);
		ArrayList<AgencyLog> list = new ArrayList<AgencyLog>();
		ResultSet resultSet = statement.executeQuery();
		ResultSet resultSet2 = statement2.executeQuery();
		if (resultSet2.next() && id.equals(resultSet2.getString("LGU_ID"))) {
			while (resultSet.next()) {
				String id1 = resultSet.getString("LOG_ID");
				String name = resultSet.getString("LOG_NAME");
				int data = resultSet.getInt("LOG_DATA");
				String day = resultSet.getString("LOG_DAY");
				String agency = resultSet.getString("LOG_AGENCY");
				String type = resultSet.getString("LOG_TYPE");
				int fee = resultSet.getInt("LOG_LGUFEE");
				list.add(new AgencyLog(id1, name, data, day, agency, type, fee));
			}
			resultSet.close();
			resultSet2.close();
			statement.close();
			statement2.close();
			connection.close();
		} else {
			System.out
					.println("=======================================================================================");
			System.out.println("||                               조회하신 회원이 존재하지 않습니다.                  ||");
			System.out
					.println("=======================================================================================");
			resultSet.close();
			resultSet2.close();
			statement.close();
			statement2.close();
			connection.close();
			Manager.managerMode();
		}
		return list;
	}
}
