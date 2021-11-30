package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;
import subscribe.Subscribe;

public class SubscribeDAO {
   public void idcheck(AgencySkt skt) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
      String sql = "select SKT_ID from SKT Where SKT_ID = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, skt.getId());
      ResultSet resultset = statement.executeQuery();

      if (resultset.next() && skt.getId().equals(resultset.getString("SKT_ID"))) {
         System.out.println("                                 이미 가입된 아이디 입니다.");
         Subscribe.subscribe();
      } else if (skt.getId().equals("")) {
         System.out.println("                       올바르지 않은 입력입니다. 아이디를 입력하세요.");
         Subscribe.subscribe();
      } else {
         System.out.println("                              회원가입이 가능한 아이디 입니다.");
      }
      resultset.close();
      statement.close();
      connection.close();
   }

   public void idcheck(AgencyKt kt) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
      String sql = "select kt_ID from kt Where kt_ID = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, kt.getId());
      ResultSet resultset = statement.executeQuery();

      if (resultset.next() && kt.getId().equals(resultset.getString("kt_ID"))) {
         System.out.println("                                 이미 가입된 아이디 입니다.");
         Subscribe.subscribe();
      } else if (kt.getId().equals("")) {
         System.out.println("                       올바르지 않은 입력입니다. 아이디를 입력하세요.");
         Subscribe.subscribe();
      } else {
         System.out.println("                              회원가입이 가능한 아이디 입니다.");
      }
      resultset.close();
      statement.close();
      connection.close();
   }

   public void idcheck(AgencyLgu lgu) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
      String sql = "select lgu_ID from lgu Where lgu_ID = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, lgu.getId());
      ResultSet resultset = statement.executeQuery();

      if (resultset.next() && lgu.getId().equals(resultset.getString("lgu_ID"))) {
         System.out.println("                                 이미 가입된 아이디 입니다.");
         Subscribe.subscribe();
      } else if (lgu.getId().equals("")) {
         System.out.println("                       올바르지 않은 입력입니다. 아이디를 입력하세요.");
         Subscribe.subscribe();
      } else {
         System.out.println("                              회원가입이 가능한 아이디 입니다.");
      }
      resultset.close();
      statement.close();
      connection.close();
   }

   public void insertSkt(AgencySkt skt) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");

      Statement statement2 = connection.createStatement();
      StringBuilder builder = new StringBuilder();
      builder.append(" INSERT INTO SKT");
      builder.append("    ( SKT_ID, SKT_PASSWORD, SKT_NAME, SKT_NUMBER ) ");
      builder.append(" VALUES");
      builder.append("    ( " + "'" + skt.getId() + "'" + "," + "'" + skt.getPassword() + "'" + " ," + "'"
            + skt.getName() + "'" + " , " + "'" + skt.getHpNumber() + "'" + " )");
      int result = statement2.executeUpdate(builder.toString());
      if (result > 0) {
         System.out.println("                                  회원가입 된 것을 축하합니다.");
         // } else if (skt.getId() == resultSet.getString("SKT_ID")) {
         statement2.close();
         connection.close();
      }
   }

   public void insertKt(AgencyKt kt) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");

      Statement statement2 = connection.createStatement();
      StringBuilder builder = new StringBuilder();
      builder.append(" INSERT INTO KT");
      builder.append("    ( KT_ID, KT_PASSWORD, KT_NAME, KT_NUMBER ) ");
      builder.append(" VALUES");
      builder.append("    ( " + "'" + kt.getId() + "'" + "," + "'" + kt.getPassword() + "'" + " ," + "'"
            + kt.getName() + "'" + " , " + "'" + kt.getHpNumber() + "'" + " )");
      int result = statement2.executeUpdate(builder.toString());
      if (result > 0) {
         System.out.println("                                  회원가입 된 것을 축하합니다.");
         // } else if (skt.getId() == resultSet.getString("SKT_ID")) {
         statement2.close();
         connection.close();
      }
   }

   public void insertLgu(AgencyLgu lgu) throws Exception {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");

      Statement statement2 = connection.createStatement();
      StringBuilder builder = new StringBuilder();
      builder.append(" INSERT INTO LGU");
      builder.append("    ( LGU_ID, LGU_PASSWORD, LGU_NAME, LGU_NUMBER ) ");
      builder.append(" VALUES");
      builder.append("    ( " + "'" + lgu.getId() + "'" + "," + "'" + lgu.getPassword() + "'" + " ," + "'"
            + lgu.getName() + "'" + " , " + "'" + lgu.getHpNumber() + "'" + " )");
      int result = statement2.executeUpdate(builder.toString());
      if (result > 0) {
         System.out.println("                                  회원가입 된 것을 축하합니다.");
         // } else if (skt.getId() == resultSet.getString("SKT_ID")) {
         statement2.close();
         connection.close();
      }
   }

   
}