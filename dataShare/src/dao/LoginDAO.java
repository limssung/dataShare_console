package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;

public class LoginDAO {


	public AgencySkt logInSk(String memid, String mempass) throws Exception {
		Connection connection;
		Statement statement;
		ResultSet resultSet;
//		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
			statement = connection.createStatement();
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT");
			builder.append("    SKT_NAME,");
			builder.append("    SKT_NUMBER,");
			builder.append("    SKT_DATA,");
			builder.append("    SKT_FEE");
			builder.append("  FROM");
			builder.append("    SKT");
			builder.append(" WHERE SKT_ID = " + "'" + memid + "'");
			builder.append("   AND  SKT_PASSWORD = " + "'" + mempass + "'");
			resultSet = statement.executeQuery(builder.toString());
			AgencySkt vo = null;
			if (resultSet.next()) {
				String inputMemId = memid;
				String inputPassword = mempass;
				String memname = resultSet.getString("SKT_NAME");
				String memhpNum = resultSet.getString("SKT_NUMBER");
				int memdata = resultSet.getInt("SKT_DATA");
				int memfee = resultSet.getInt("SKT_FEE");
				vo = new AgencySkt(inputMemId, inputPassword, memname, memhpNum, memdata, memfee);

//			} else {
//				System.out.println("잘못 입력 하였습니다. 다시 입력 해주세요.");
//				Login.Login();
//			}
			}
			resultSet.close();
			statement.close();
			connection.close();
			return vo;
			
//		} catch (java.lang.NullPointerException e) {
//			Data.Data(0, null, null);
//		} catch (java.util.NoSuchElementException e) {
//			Data.Data(0, null, null);
//		}
//		return vo;
	}

	public AgencyKt logInKT(String memid, String mempass) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    KT_NAME,");
		builder.append("    KT_NUMBER,");
		builder.append("    KT_DATA,");
		builder.append("    KT_FEE");
		builder.append("  FROM");
		builder.append("    KT");
		builder.append(" WHERE KT_ID = " + "'" + memid + "'");
		builder.append("   AND  KT_PASSWORD = " + "'" + mempass + "'");
		ResultSet resultSet = statement.executeQuery(builder.toString());
		AgencyKt vo = null;
		if (resultSet.next()) {
			String memname = resultSet.getString("KT_NAME");
			String memhpNum = resultSet.getString("KT_NUMBER");
			int memdata = resultSet.getInt("KT_DATA");
			int memfee = resultSet.getInt("KT_FEE");
			vo = new AgencyKt(memid, mempass, memname, memhpNum, memdata, memfee);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}

	public AgencyLgu logInLGU(String memid, String mempass) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    LGU_NAME,");
		builder.append("    LGU_NUMBER,");
		builder.append("    LGU_DATA,");
		builder.append("    LGU_FEE");
		builder.append("  FROM");
		builder.append("    LGU");
		builder.append(" WHERE LGU_ID = " + "'" + memid + "'");
		builder.append("   AND  LGU_PASSWORD = " + "'" + mempass + "'");
		ResultSet resultSet = statement.executeQuery(builder.toString());
		AgencyLgu vo = null;
		if (resultSet.next()) {
			String memname = resultSet.getString("LGU_NAME");
			String memhpNum = resultSet.getString("LGU_NUMBER");
			int memdata = resultSet.getInt("LGU_DATA");
			int memfee = resultSet.getInt("LGU_FEE");
			vo = new AgencyLgu(memid, mempass, memname, memhpNum, memdata, memfee);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}
}
