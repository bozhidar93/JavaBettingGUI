
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.text.SimpleDateFormat;
import static javafx.beans.binding.Bindings.select;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bozhidar
 */
public class NewClass {
                private static final String USERNAME = "bc55432548644e";
                private static final String PASSWORD ="8c3bf9ae";
                private static final String url ="Database=b.tashev;Data Source=eu-cdbr-azure-north-d.cloudapp.net;User Id=b4a0b236938a80;Password=f0e9b6fd";
                private static final String url2 ="eu-cdbr-azure-north-d.cloudapp.net";
                private static final String str = "jdbc:mysql://eu-cdbr-azure-north-d.cloudapp.net:3306/b.tashev?zeroDateTimeBehavior=convertToNull";
                private static final String st = "jdbc:mysql://eu-cdbr-azure-north-e.cloudapp.net:3306/btashevDatabase?zeroDateTimeBehavior=convertToNull";
                private static final String lll = "jdbc:sqlserver://tashevserver.database.windows.net:1433;database=btashev;user=btashev@tashevserver;password=Myproject1;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;ssl=require;";
                private static Statement stmt = null;
                private static String query =  "SELECT * FROM user";
 
               // private static String insert = "INSERT INTO 'btashev'.'user' VALUES ('"+user_ID+"','"+username+"','"+password+"','"+balance+"')";
                
                public static void main(String[] args){        
                   
                    
            Connection conn = null;
            
            try{               
               conn = DriverManager.getConnection(st,USERNAME,PASSWORD);             
                System.out.println(query);
              stmt =conn.createStatement();
              ResultSet rs = stmt.executeQuery(query);
                 int user_ID = 123456889;
                 String username = "test544644";
                 int password = 1234789; 
                 double balance = 999.99;
              //String insert = "INSERT INTO 'btashev'.'user' VALUES ('"+user_ID+"','"+username+"','"+password+"','"+balance+"')";
                
             // String insert = "INSERT INTO 'user' VALUES ('+user_ID+','"+username+"','"+password+"','+balance+')";
                stmt.executeUpdate("INSERT INTO user " + "VALUES (6284286, 'n06mae21', 'pa6ssw2ord1',9595.54,55.5)");  
                java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                
              
               
              // SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
               SimpleDateFormat noMilliSecondsFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                
                System.out.println("sdf!!!!" + noMilliSecondsFormatter);
//                int i = 888;
//                int b = 4654;
//                String desc = "testDescr";
//                 String temp2 = "INSERT INTO userProblems " + "VALUES ("+i+", "+b+",'"+desc+"')";  
//                String temp3 = "INSERT INTO useRProblems VALUES (555,4654,'ddd')";
//               stmt.executeUpdate(temp2);
               //stmt.executeUpdate("INSERT INTO user " + "VALUES ('"+user_ID+"', '"+username+"', '"+password+"',"+balance+")");     
               
                
                System.out.println("HEYYY");
            }catch (Exception e){
                e.printStackTrace();
                
                System.out.println("ARRR");
            }
            
        }

  
}
