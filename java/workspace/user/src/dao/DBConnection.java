package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   public static Connection getConnection() {
      Connection conn = null;
      
//      연결에 필요한 정보
      String user = "hr";
      String password = "hr";
      String url = "jdbc:oracle:thin:@localhost:1521:XE";
      
      try {
//         드라이버를 메모리에 할당
         Class.forName("oracle.jdbc.driver.OracleDriver");
//         연결 정보를 전달하여 연결된 객체를 가져온다.
         conn = DriverManager.getConnection(url, user, password);
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return conn;
   }
}






