/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import static javafx.beans.binding.Bindings.select;


/**
 *
 * @author bozhidar
 */
public class user {

    private static int user_ID;
    private static String username;
    private static String  password;
    private static double balance;
    private static int secredKey;
    private static final String USERNAME = "bc55432548644e";
    private static final String PASSWORD ="8c3bf9ae";
    private static final String str = "jdbc:mysql://eu-cdbr-azure-north-e.cloudapp.net:3306/btashevDatabase?zeroDateTimeBehavior=convertToNull";
    //jdbc:mysql://eu-cdbr-azure-north-e.cloudapp.net:3306/btashevDatabase?zeroDateTimeBehavior=convertToNull [bc55432548644e on Default schema]
    
   // private static final String str = "jdbc:sqlserver://tashevserver.database.windows.net:1433;database=btashev;user=btashev@tashevserver;password={Myproject1};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            
            private static Statement stmt = null;
    private static Connection conn = null;
    //private static final String query = "SELECT * FROM user";
    private static String query;    

    public user() {
    }

    public static void makeConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection(str,USERNAME, PASSWORD);
            //conn = DriverManager.getConnection(str);
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ARRR");
        }
    }
    
    public static void closeConnecton() throws SQLException{
        stmt.close();
        conn.close();
        
        System.out.println("COnnection closed from .closeConnection");
    }
    public static void getAllUsersDetails() throws SQLException{
        System.out.println("Getting all users....");
        //String getAllUser = "SELECT * FROM user";
        conn = DriverManager.getConnection(str,USERNAME, PASSWORD);
        //conn = DriverManager.getConnection(str);
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(user.query);
            while(rs.next()){
                user_ID = rs.getInt("user_ID");
                username = rs.getString("username");
                password = rs.getString("password");
                balance = rs.getDouble("balance");
                secredKey = rs.getInt("secretKey");
                System.out.println("UserID is " + user_ID);
                System.out.println("USername is "+username);
                System.out.println("User password is "+password);
                System.out.println("User balance is "+balance); 
                System.out.println("User secred key:" + secredKey);
                
                
            }
            
        }catch (Exception e){
                e.printStackTrace();
                System.out.println("ARRR");
            } finally {
        if (stmt != null) { 
            stmt.close(); }
            conn.close();
            
        }
    }
    public static int getUser_ID() {
        return user_ID; 
    }
    

    public static String getUsername() {
        return user.username;
    }
    public String getUsername1() {
        return user.username;
    }

    public String getPassword() {
        return password;
    }

    public static double getBalance() {
        return balance;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void removeBalance(double balance) {
        this.balance -= balance;
    }
    
    public static String getConnectionUsername(){
        return USERNAME;
    }
    
    public static String getConnectionPassword(){
        return PASSWORD;
    }
    
    public static String getConnectionURL(){
        return str;
    }

    public static String validateUSer(String username1, String password1) throws SQLException {
        //this.query = "SELECT * FROM user where username = 'name1' AND password = 'password1'";
       user.query = "SELECT * FROM user WHERE username = '"+username1+"'AND password = '"+password1+"'";
        
        user.getAllUsersDetails();
       // if (this.username.matches(username1) & this.password.matches(password1)) {
       
       if(user.username!=null || user.password!=null){
           if (user.username.compareTo(username1) == 0 && user.password.compareTo(password1) == 0) {
            System.out.println("User validated");            
            return "User validated";
           }
//        } else if (user.username.compareTo(username1) !=0) {
//      // else if (user.username.matches(username1)) {
//            System.out.println("Username invalid");            
//             return "Username invalid";
//        } else if (user.password.compareTo(password1) != 0) {
//      // else if (user.password.matches(password1)){
//            System.out.println("Invalid password");            
//            return "Invalid password";
//        } else {
//            System.out.println("ERROR");            
//            return "ERROR";
//        } 
       }
           return "Invalid username or password. Please try again";  
       
       
       
    }
    

}
