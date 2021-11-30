package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;

public class DatacheckDAO { // 데이터조회결과
   public AgencySkt check(String memid) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
      Statement statement = connection.createStatement();
      StringBuilder builder = new StringBuilder();
      builder.append("SELECT");
      builder.append("    SKT_NAME,");
      builder.append("    SKT_NUMBER,");
      builder.append("    SKT_DATA,");
      builder.append("    SKT_FEE");
      builder.append("  FROM");
      builder.append("    SKT");
      builder.append(" WHERE SKT_ID = " + "'" + memid + "'");
      ResultSet resultSet = statement.executeQuery(builder.toString());
      AgencySkt vo = null;
      if (resultSet.next()) {
         String memName = resultSet.getString("SKT_NAME");
         String memhpNum = resultSet.getString("SKT_NUMBER");
         int memdata = resultSet.getInt("SKT_DATA");
         int memfee = resultSet.getInt("SKT_FEE");
         vo = new AgencySkt(memid, memName, memhpNum, memhpNum, memdata, memfee);
      }
      return vo;
   }
   
   public AgencyKt checkKt(String memid) throws Exception {
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
      ResultSet resultSet = statement.executeQuery(builder.toString());
      AgencyKt vo = null;
      if (resultSet.next()) {
         String memName = resultSet.getString("KT_NAME");
         String memhpNum = resultSet.getString("KT_NUMBER");
         int memdata = resultSet.getInt("KT_DATA");
         int memfee = resultSet.getInt("KT_FEE");
         vo = new AgencyKt(memid, memName, memhpNum, memdata, memfee);
      }
      return vo;
   }
   
   public AgencyLgu checkLgu(String memid) throws Exception {
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
      ResultSet resultSet = statement.executeQuery(builder.toString());
      AgencyLgu vo = null;
      if (resultSet.next()) {
         String memName = resultSet.getString("LGU_NAME");
         String memhpNum = resultSet.getString("LGU_NUMBER");
         int memdata = resultSet.getInt("LGU_DATA");
         int memfee = resultSet.getInt("LGU_FEE");
         vo = new AgencyLgu(memid, memName, memhpNum, memdata, memfee);
      }
      return vo;
   }
}