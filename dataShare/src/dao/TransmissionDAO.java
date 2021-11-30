package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;
import data.Data;

public class TransmissionDAO {

	public void transmissionSKT(AgencySkt skt) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = " UPDATE SKT SET  SKT_DATA = SKT_DATA - ? WHERE SKT_ID = ?\r\n" + "    AND EXISTS ( SELECT 1 \r\n"
				+ "               FROM SKT\r\n" + "                  WHERE SKT_ID = ?\r\n"
				+ "                    AND SKT_DATA - ?>=0 \r\n" + "             )\r\n"
				+ "    AND EXISTS ( SELECT 1 \r\n" + "                   FROM SKT\r\n"
				+ "                  WHERE SKT_NUMBER = ?\r\n" + "                  )";
		// 받는사람
		String sql2 = "UPDATE SKT SET  SKT_DATA = SKT_DATA + ? WHERE SKT_NUMBER = ? \r\n"
				+ "    AND EXISTS ( SELECT 1 FROM SKT\r\n" + "                         WHERE SKT_ID = ?\r\n"
				+ "                             AND SKT_DATA - ? >=0 )\r\n"; // 받는 사람 쿼리문
		String sql3 = "SELECT SKT_ID, SKT_NAME, SKT_DATA FROM SKT WHERE SKT_ID = ?";
		String sql4 = "SELECT SKT_ID, SKT_NAME, SKT_DATA FROM SKT WHERE SKT_NUMBER = ?";
		String sql5 = "INSERT into LOG(LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_SKTFEE)\r\n"
				+ " VALUES(?, ?, ?, SUBSTR(SYSTIMESTAMP, 1, 20), 'SKT', '발송', 0)";
		String sql6 = "INSERT into LOG(LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_SKTFEE)\r\n"
				+ " VALUES(?, ?, ?, SUBSTR(SYSTIMESTAMP, 1, 20), 'SKT', '수신', 0)";
		PreparedStatement statement = connection.prepareStatement(sql);
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		PreparedStatement statement3 = connection.prepareStatement(sql3);
		PreparedStatement statement4 = connection.prepareStatement(sql4);
		PreparedStatement statement5 = connection.prepareStatement(sql5);
		PreparedStatement statement6 = connection.prepareStatement(sql6);
		statement.setInt(1, skt.getData());
		statement.setString(2, skt.getId());
		statement.setString(3, skt.getId());
		statement.setInt(4, skt.getData());
		statement.setString(5, skt.getHpNumber());
		int result = statement.executeUpdate();
		statement2.setInt(1, skt.getData());
		statement2.setString(2, skt.getHpNumber());
		statement2.setString(3, skt.getId());
		statement2.setInt(4, skt.getData());
		int result2 = statement2.executeUpdate();
		statement3.setString(1, skt.getId());
		ResultSet resultSet = statement3.executeQuery();
		if (resultSet.next()) {
		}
		statement4.setString(1, skt.getHpNumber());
		ResultSet resultSet2 = statement4.executeQuery();

		try {
			if (resultSet2.next()) {
			}
			statement5.setString(1, resultSet.getString("SKT_ID"));
			statement5.setString(2, resultSet.getString("SKT_NAME"));
			statement5.setInt(3, skt.getData());
			statement6.setString(1, resultSet2.getString("SKT_ID"));
			statement6.setString(2, resultSet2.getString("SKT_NAME"));
			statement6.setInt(3, skt.getData());
		} catch (java.sql.SQLException e) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                                     오류 발생                                     ||");
			System.out.println("||                    2. 받는 사람이 SKT회원인지 확인해주세요.                       ||");
			System.out
					.println("=======================================================================================");
			resultSet2.close();
			Data.setterData();
		} finally {

			int result5 = statement5.executeUpdate();
			int result6 = statement6.executeUpdate();

			if ((result > 0) && (result2 > 0) && (result5 > 0) && (result6 > 0)) {
				System.out.println(
						"=======================================================================================");
				System.out.println("                            데이터 전송이 완료되었습니다!");
				System.out.println(
						"                       전송 후 남은 데이터 량은 : " + resultSet.getString("SKT_DATA") + "MB 입니다.");
				System.out.println(
						"=======================================================================================");
			} else if ((skt.getData() > resultSet.getInt("SKT_DATA"))) {
				System.out.println(
						"=======================================================================================");
				System.out
						.println("||                                     오류 발생                                     ||");
				System.out.println("||                         1. 보유 데이터량을 확인해주세요.                          ||");
				System.out.println(
						"=======================================================================================");
			} else {
				System.out.println(
						"=======================================================================================");
				System.out
						.println("||                                     오류 발생                                     ||");
				System.out.println("||                    2. 받는 사람이 SKT회원인지 확인해주세요.                       ||");
				System.out.println(
						"=======================================================================================");
			}
			resultSet.close();
			resultSet2.close();
			statement.close();
			statement2.close();
			statement3.close();
			connection.close();
		}
	}

	public void transmissionKT(AgencyKt kt) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = " UPDATE KT SET  KT_DATA = KT_DATA - ? WHERE KT_ID = ?\r\n" + "    AND EXISTS ( SELECT 1 \r\n"
				+ "               FROM KT\r\n" + "                  WHERE KT_ID = ?\r\n"
				+ "                    AND KT_DATA - ?>=0 \r\n" + "             )\r\n"
				+ "    AND EXISTS ( SELECT 1 \r\n" + "                   FROM KT\r\n"
				+ "                  WHERE KT_NUMBER = ?\r\n" + "                  )";
		// 받는사람
		String sql2 = "UPDATE KT SET  KT_DATA = KT_DATA + ? WHERE KT_NUMBER = ? \r\n"
				+ "    AND EXISTS ( SELECT 1 FROM KT\r\n" + "                         WHERE KT_ID = ?\r\n"
				+ "                             AND KT_DATA - ? >=0 )\r\n"; // 받는 사람 쿼리문
		String sql3 = "SELECT KT_ID, KT_NAME, KT_DATA FROM KT WHERE KT_ID = ?";
		String sql4 = "SELECT KT_ID, KT_NAME, KT_DATA FROM KT WHERE KT_NUMBER = ?";
		String sql5 = "INSERT into LOG(LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_KTFEE)\r\n"
				+ " VALUES(?, ?, ?, SUBSTR(SYSTIMESTAMP, 1, 20), 'KT', '발송', 0)";
		String sql6 = "INSERT into LOG(LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_KTFEE)\r\n"
				+ " VALUES(?, ?, ?, SUBSTR(SYSTIMESTAMP, 1, 20), 'KT', '수신', 0)";
		PreparedStatement statement = connection.prepareStatement(sql);
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		PreparedStatement statement3 = connection.prepareStatement(sql3);
		PreparedStatement statement4 = connection.prepareStatement(sql4);
		PreparedStatement statement5 = connection.prepareStatement(sql5);
		PreparedStatement statement6 = connection.prepareStatement(sql6);
		statement.setInt(1, kt.getData());
		statement.setString(2, kt.getId());
		statement.setString(3, kt.getId());
		statement.setInt(4, kt.getData());
		statement.setString(5, kt.getHpNumber());
		int result = statement.executeUpdate();
		statement2.setInt(1, kt.getData());
		statement2.setString(2, kt.getHpNumber());
		statement2.setString(3, kt.getId());
		statement2.setInt(4, kt.getData());
		int result2 = statement2.executeUpdate();
		statement3.setString(1, kt.getId());
		ResultSet resultSet = statement3.executeQuery();
		if (resultSet.next()) {
		}
		statement4.setString(1, kt.getHpNumber());
		ResultSet resultSet2 = statement4.executeQuery();
		try {
			if (resultSet2.next()) {
			}
			statement5.setString(1, resultSet.getString("kt_ID"));
			statement5.setString(2, resultSet.getString("kt_NAME"));
			statement5.setInt(3, kt.getData());
			statement6.setString(1, resultSet2.getString("kt_ID"));
			statement6.setString(2, resultSet2.getString("kt_NAME"));
			statement6.setInt(3, kt.getData());
		} catch (java.sql.SQLException e) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                                     오류 발생                                     ||");
			System.out.println("||                    2. 받는 사람이 KT회원인지 확인해주세요.                       ||");
			System.out
					.println("=======================================================================================");
			resultSet2.close();
			Data.setterData();

		} finally {
			int result5 = statement5.executeUpdate();
			int result6 = statement6.executeUpdate();

			if ((result > 0) && (result2 > 0) && (result5 > 0) && (result6 > 0)) {
				System.out.println(
						"=======================================================================================");
				System.out.println("                            데이터 전송이 완료되었습니다!");
				System.out.println(
						"                       전송 후 남은 데이터 량은 : " + resultSet.getString("KT_DATA") + "MB 입니다.");
				System.out.println(
						"=======================================================================================");
			} else if ((kt.getData() > resultSet.getInt("KT_DATA"))) {
				System.out.println(
						"=======================================================================================");
				System.out
						.println("||                                     오류 발생                                     ||");
				System.out.println("||                         1. 보유 데이터량을 확인해주세요.                          ||");
				System.out.println(
						"=======================================================================================");
			} else {
				System.out.println(
						"=======================================================================================");
				System.out
						.println("||                                     오류 발생                                     ||");
				System.out.println("||                    2. 받는 사람이 KT회원인지 확인해주세요.                       ||");
				System.out.println(
						"=======================================================================================");
			}
			resultSet.close();
			statement.close();
			statement2.close();
			statement3.close();
			connection.close();

		}

	}

	public void transmissionLGU(AgencyLgu lgu) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		String sql = " UPDATE LGU SET  LGU_DATA = LGU_DATA - ? WHERE LGU_ID = ?\r\n" + "    AND EXISTS ( SELECT 1 \r\n"
				+ "               FROM LGU\r\n" + "                  WHERE LGU_ID = ?\r\n"
				+ "                    AND LGU_DATA - ?>=0 \r\n" + "             )\r\n"
				+ "    AND EXISTS ( SELECT 1 \r\n" + "                   FROM LGU\r\n"
				+ "                  WHERE LGU_NUMBER = ?\r\n" + "                  )";
		// 받는사람
		String sql2 = "UPDATE LGU SET  LGU_DATA = LGU_DATA + ? WHERE LGU_NUMBER = ? \r\n"
				+ "    AND EXISTS ( SELECT 1 FROM LGU\r\n" + "                         WHERE LGU_ID = ?\r\n"
				+ "                             AND LGU_DATA - ? >= 0 )\r\n"; // 받는 사람 쿼리문
		String sql3 = "SELECT LGU_ID, LGU_NAME, LGU_DATA FROM LGU WHERE LGU_ID = ?";
		String sql4 = "SELECT LGU_ID, LGU_NAME, LGU_DATA FROM LGU WHERE LGU_NUMBER = ?";
		String sql5 = "INSERT into LOG(LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_LGUFEE)\r\n"
				+ " VALUES(?, ?, ?, SUBSTR(SYSTIMESTAMP, 1, 20), 'LGU', '발송', 0)";
		String sql6 = "INSERT into LOG(LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_LGUFEE)\r\n"
				+ " VALUES(?, ?, ?, SUBSTR(SYSTIMESTAMP, 1, 20), 'LGU', '수신', 0)";
		PreparedStatement statement = connection.prepareStatement(sql);
		PreparedStatement statement2 = connection.prepareStatement(sql2);
		PreparedStatement statement3 = connection.prepareStatement(sql3);
		PreparedStatement statement4 = connection.prepareStatement(sql4);
		PreparedStatement statement5 = connection.prepareStatement(sql5);
		PreparedStatement statement6 = connection.prepareStatement(sql6);
		statement.setInt(1, lgu.getData());
		statement.setString(2, lgu.getId());
		statement.setString(3, lgu.getId());
		statement.setInt(4, lgu.getData());
		statement.setString(5, lgu.getHpNumber());
		int result = statement.executeUpdate();
		statement2.setInt(1, lgu.getData());
		statement2.setString(2, lgu.getHpNumber());
		statement2.setString(3, lgu.getId());
		statement2.setInt(4, lgu.getData());
		int result2 = statement2.executeUpdate();
		statement3.setString(1, lgu.getId());
		ResultSet resultSet = statement3.executeQuery();
		if (resultSet.next()) {
		}
		statement4.setString(1, lgu.getHpNumber());
		ResultSet resultSet2 = statement4.executeQuery();
		try {
			if (resultSet2.next()) {
			}
			statement5.setString(1, resultSet.getString("lgu_ID"));
			statement5.setString(2, resultSet.getString("lgu_NAME"));
			statement5.setInt(3, lgu.getData());
			statement6.setString(1, resultSet2.getString("lgu_ID"));
			statement6.setString(2, resultSet2.getString("lgu_NAME"));
			statement6.setInt(3, lgu.getData());

		} catch (java.sql.SQLException e) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                                     오류 발생                                     ||");
			System.out.println("||                    2. 받는 사람이 LGU회원인지 확인해주세요.                       ||");
			System.out
					.println("=======================================================================================");
			resultSet2.close();
			Data.setterData();
		} finally {
			int result5 = statement5.executeUpdate();
			int result6 = statement6.executeUpdate();

			if ((result > 0) && (result2 > 0) && (result5 > 0) && (result6 > 0)) {
				System.out.println(
						"=======================================================================================");
				System.out.println("                            데이터 전송이 완료되었습니다!");
				System.out.println(
						"                       전송 후 남은 데이터 량은 : " + resultSet.getString("LGU_DATA") + "MB 입니다.");
				System.out.println(
						"=======================================================================================");
			} else if ((lgu.getData() > resultSet.getInt("LGU_DATA"))) {
				System.out.println(
						"=======================================================================================");
				System.out
						.println("||                                     오류 발생                                     ||");
				System.out.println("||                         1. 보유 데이터량을 확인해주세요.                          ||");
				System.out.println(
						"=======================================================================================");
			} else {
				System.out.println(
						"=======================================================================================");
				System.out
						.println("||                                     오류 발생                                     ||");
				System.out.println("||                    2. 받는 사람이 LGU회원인지 확인해주세요.                       ||");
				System.out.println(
						"=======================================================================================");
			}
			resultSet.close();
			statement.close();
			statement2.close();
			statement3.close();
			connection.close();
		}
	}
}
