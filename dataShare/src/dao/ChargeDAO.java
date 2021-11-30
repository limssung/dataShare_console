package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;

public class ChargeDAO {
   public void updateSKT(AgencySkt skt) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
      String sql = "UPDATE SKT SET SKT_DATA = SKT_DATA + ?, SKT_FEE = SKT_FEE + (? * 20) WHERE SKT_ID = ?";
      String sql2 = "SELECT SKT_NAME, SKT_DATA FROM SKT WHERE SKT_ID = ?";
      String sql3 = "INSERT into LOG(LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_SKTFEE)\r\n" + 
              "(SELECT ?, ?, ?, SUBSTR(SYSTIMESTAMP, 1, 20), 'SKT', '충전', ? FROM SKT WHERE SKT_ID = ?)";
//            String sql3 = "INSERT into LOG(LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_SKTFEE)\r\n" + 
//            " VALUES(?, ?, ?, SUBSTR(SYSTIMESTAMP, 1, 20), 'SKT', '충전', (SELECT SKT_FEE FROM SKT WHERE SKT_ID = ?))";
      PreparedStatement statement = connection.prepareStatement(sql);
      PreparedStatement statement2 = connection.prepareStatement(sql2);
      PreparedStatement statement3 = connection.prepareStatement(sql3);
      statement.setInt(1, skt.getData());
      statement.setInt(2, skt.getData());
      statement.setString(3, skt.getId());
      int result = statement.executeUpdate();
      
      statement2.setString(1, skt.getId());
      ResultSet resultset = statement2.executeQuery();
      if (resultset.next()) { 
      }
      
      statement3.setString(1, skt.getId());
      statement3.setString(2, resultset.getString("SKT_NAME"));
      statement3.setInt(3, skt.getData());
      statement3.setInt(4, skt.getFee() + skt.getData() * 20);
      statement3.setString(5, skt.getId());
      int result2 = statement3.executeUpdate();
      
      if (result > 0 && result2 > 0) {
         System.out.println("=======================================================================================");
         System.out.println("                             데이터 충전이 완료되었습니다!");
         System.out.println("                        충전할 데이터 량은 : " + skt.getData() + "MB 이며,");
         System.out.println("                       충전후 데이터 량은 총 : " + resultset.getString("SKT_DATA") + "MB 입니다.");
         System.out.println("                            충전 금액은 총 : " + skt.getData() * 20 + "원 입니다.");
         System.out.println("                         해당 금액은 이번달 요금에 합산됩니다.");
         System.out.println("=======================================================================================");
      } else {
         System.out.println("=======================================================================================");
         System.out.println("||                            데이터 충전에 실패하였습니다.                          ||");
         System.out.println("=======================================================================================");
      }
      resultset.close();
      statement3.close();
      statement2.close();
      statement.close();
      connection.close();
      
   }
   
   public void updateKT(AgencyKt kt) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
      String sql = "UPDATE kt SET kt_DATA = kt_DATA + ?, kt_FEE = kt_FEE + (? * 20) WHERE kt_ID = ?";
      String sql2 = "SELECT kt_NAME, kt_DATA FROM kt WHERE kt_ID = ?";
      String sql3 = "INSERT into LOG(LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_KTFEE)\r\n" + 
            "(SELECT ?, ?, ?, SUBSTR(SYSTIMESTAMP, 1, 20), 'KT', '충전', ? FROM KT WHERE KT_ID = ?)";
      PreparedStatement statement = connection.prepareStatement(sql);
      PreparedStatement statement2 = connection.prepareStatement(sql2);
      PreparedStatement statement3 = connection.prepareStatement(sql3);
      statement.setInt(1, kt.getData());
      statement.setInt(2, kt.getData());
      statement.setString(3, kt.getId());
      int result = statement.executeUpdate();
      
      statement2.setString(1, kt.getId());
      ResultSet resultset = statement2.executeQuery();
      if (resultset.next()) { 
      }
      
      statement3.setString(1, kt.getId());
      statement3.setString(2, resultset.getString("kt_NAME"));
      statement3.setInt(3, kt.getData());
      statement3.setInt(4, kt.getFee() + kt.getData() * 20);
      statement3.setString(5, kt.getId());
      int result2 = statement3.executeUpdate();
      
      if (result > 0 && result2 > 0) {
         System.out.println("=======================================================================================");
         System.out.println("                             데이터 충전이 완료되었습니다!");
         System.out.println("                        충전할 데이터 량은 : " + kt.getData() + "MB 이며,");
         System.out.println("                       충전후 데이터 량은 총 : " + resultset.getString("kt_DATA") + "MB 입니다.");
         System.out.println("                            충전 금액은 총 : " + kt.getData() * 20 + "원 입니다.");
         System.out.println("                         해당 금액은 이번달 요금에 합산됩니다.");
         System.out.println("=======================================================================================");
      } else {
         System.out.println("=======================================================================================");
         System.out.println("||                            데이터 충전에 실패하였습니다.                          ||");
         System.out.println("=======================================================================================");
      }
      resultset.close();
      statement3.close();
      statement2.close();
      statement.close();
      connection.close();
   }
   
   public void updateLGU(AgencyLgu lgu) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
      String sql = "UPDATE lgu SET lgu_DATA = lgu_DATA + ?, lgu_FEE = lgu_FEE + (? * 20) WHERE lgu_ID = ?";
      String sql2 = "SELECT lgu_NAME, lgu_DATA FROM lgu WHERE lgu_ID = ?";
      String sql3 = "INSERT into LOG(LOG_ID, LOG_NAME, LOG_DATA, LOG_DAY, LOG_AGENCY, LOG_TYPE, LOG_LGUFEE)\r\n" + 
            "(SELECT ?, ?, ?, SUBSTR(SYSTIMESTAMP, 1, 20), 'LGU', '충전', ? FROM LGU WHERE LGU_ID = ?)";
      PreparedStatement statement = connection.prepareStatement(sql);
      PreparedStatement statement2 = connection.prepareStatement(sql2);
      PreparedStatement statement3 = connection.prepareStatement(sql3);
      statement.setInt(1, lgu.getData());
      statement.setInt(2, lgu.getData());
      statement.setString(3, lgu.getId());
      int result = statement.executeUpdate();
      
      statement2.setString(1, lgu.getId());
      ResultSet resultset = statement2.executeQuery();
      if (resultset.next()) { 
      }
      
      statement3.setString(1, lgu.getId());
      statement3.setString(2, resultset.getString("lgu_NAME"));
      statement3.setInt(3, lgu.getData());
      statement3.setInt(4, lgu.getFee() + lgu.getData() * 20);
      statement3.setString(5, lgu.getId());
      int result2 = statement3.executeUpdate();
      
      if (result > 0 && result2 > 0) {
         System.out.println("=======================================================================================");
         System.out.println("                             데이터 충전이 완료되었습니다!");
         System.out.println("                        충전할 데이터 량은 : " + lgu.getData() + "MB 이며,");
         System.out.println("                       충전후 데이터 량은 총 : " + resultset.getString("lgu_DATA") + "MB 입니다.");
         System.out.println("                            충전 금액은 총 : " + lgu.getData() * 20 + "원 입니다.");
         System.out.println("                         해당 금액은 이번달 요금에 합산됩니다.");
         System.out.println("=======================================================================================");
      } else {
         System.out.println("=======================================================================================");
         System.out.println("||                            데이터 충전에 실패하였습니다.                          ||");
         System.out.println("=======================================================================================");
      }
      resultset.close();
      statement3.close();
      statement2.close();
      statement.close();
      connection.close();
      
   }
}