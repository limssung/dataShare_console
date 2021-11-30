package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;
import subscribe.Subscribe;

public class CheckDAO {

   public void hpcheck(AgencySkt skt) throws Exception {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
         String sql = "select SKT_NUMBER from SKT Where SKT_NUMBER = ? ";
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setString(1, skt.getHpNumber());
         ResultSet resultset = statement.executeQuery();
         if (resultset.next() && skt.getHpNumber().equals(resultset.getString("SKT_NUMBER"))) {
            Subscribe.subscribe();
         } else {
            System.out.println("                                  사용할 수 있는 번호입니다.");
         }
         resultset.close();
         statement.close();
         connection.close();
      } catch (NullPointerException | ClassNotFoundException e) {
         System.out.println("                              올바르지 않은 입력입니다. 다시 입력하세요.");
         Subscribe.subscribe();
      } catch (SQLException e) {
         System.out.println("                                      사용할 수 없는 번호입니다.");
         e.printStackTrace();
      }

   }

   public void hpcheck(AgencyKt kt) throws Exception {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
         String sql = "select kt_NUMBER from kt Where kt_NUMBER = ?";
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setString(1, kt.getHpNumber());
         ResultSet resultset = statement.executeQuery();

         if (resultset.next() && kt.getHpNumber().equals(resultset.getString("kt_NUMBER"))) {
            Subscribe.subscribe();
         } else if (kt.getHpNumber().equals("")) {
            Subscribe.subscribe();
         } else {
            System.out.println("                                  사용할 수 있는 번호입니다.");
         }
         resultset.close();
         statement.close();
         connection.close();
      } catch (NullPointerException | ClassNotFoundException e) {
         System.out.println("                              올바르지 않은 입력입니다. 다시 입력하세요.");
         Subscribe.subscribe();
      } catch (SQLException e) {
         System.out.println("                                      사용할 수 없는 번호입니다.");
         e.printStackTrace();
      }
   }

   public void hpcheck(AgencyLgu lgu) throws Exception {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.57:1521/xe", "LSM93", "java");
         String sql = "select lgu_NUMBER from lgu Where lgu_NUMBER = ?";
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setString(1, lgu.getHpNumber());
         ResultSet resultset = statement.executeQuery();
         if (resultset.next() && lgu.getHpNumber().equals(resultset.getString("lgu_NUMBER"))) {
            Subscribe.subscribe();
         } else if (lgu.getHpNumber().equals("")) {
            Subscribe.subscribe();
         } else {
            System.out.println("                                  사용할 수 있는 번호입니다.");
         }
         resultset.close();
         statement.close();
         connection.close();
      } catch (NullPointerException | ClassNotFoundException e) {
         System.out.println("                              올바르지 않은 입력입니다. 다시 입력하세요.");
         Subscribe.subscribe();
      } catch (SQLException e) {
         System.out.println("                                      사용할 수 없는 번호입니다.");
         e.printStackTrace();
      }
   }

   public boolean numbercheck(String n) {
      String hpnum = n;
      if (Pattern.matches("01[0-9]{1}-\\d{4}-\\d{4}", hpnum)) {
         return true;
      } else {
         return false;
      }
   }

   public boolean namecheck(String n) { 
      String name = n;
      if (Pattern.matches("[가-힣]{2,4}|[a-zA-Z]{2,10}\\s[a-zA-Z]{2,10}", name)) {
         return true;
      } else {
         return false;
      }
   }
}