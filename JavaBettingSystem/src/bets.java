
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bozhidar
 */
/**
 * to do list
 * database has : betID, userID, gameID, teamName
 * top ones are foreign key or primary keys
 * bet, stake, odds, returns
 *
 */
public class bets {

    
    public  int betID;
    public  int userID;
    public  int gameID;
    public  String team1;
    public  String team2;
    public  String bet;
    public  int stake;
    public  double odds ;
    //public static bets[] betList = new bets[6];
    //public static int arrayInteger = -1;
    //public static String betStatus = " testing for now";
   // public static int bet_returs = 1111111;
   
    

    public bets(int betID,int userID, int gameID, String team1, String team2, String bet, double odds) {
       this.betID = betID;
       this.userID = user.getUser_ID();
       this.team1 = team1;
       this.team1 = team1;
       this.team2 = team2;
       this.bet = bet;
       this.odds = odds; 
       this.userID = userID;   
       this.gameID = gameID;

    }
    // getters for arrays used
    public int getUserID1(){
     return userID;   
    }
    
    public int getBetID1(){
     return betID;   
    }
    
    public int getGameID1(){
        return gameID;
    }
    
    public String getTeam11(){
     return team1;   
    }
    
    public String getTeam21(){
     return team2;   
    }
    
    public String getBet1(){        
     return bet;   
    }
    
    public double getStake1(){
        return stake;
    }
    
    public double getOdds1(){
        return odds;
    }
    // getters and setter to be accessable from any other gui
//    public static int getUserID() {
//        return userID;
//    }
//
//    public static void setUserID(int userID) {
//        bets.userID = userID;
//    }
//
//    public static int getBetID() {
//        return betID;
//    }
//
//    public static void setBetID(int betID) {
//        bets.betID = betID;
//    }
//
//    public static int getGameID() {
//        return gameID;
//    }
//
//    public static void setGameID(int gameID) {
//        bets.gameID = gameID;
//    }
//
//    public static String getTeam1() {
//        return team1;
//    }
//
//    public static void setTeam1(String team1) {
//        bets.team1 = team1;
//    }
//
//    public static String getTeam2() {
//        return team2;
//    }
//
//    public static void setTeam2(String team2) {
//        bets.team2 = team2;
//    }
//
//    public static String getBet() {
//        return bet;
//    }
//
//    public static void setBet(String bet) {
//        bets.bet = bet;
//    }
//
//    public static int getStake() {
//        return stake;
//    }
//
//    public static void setStake(int stake) {
//        bets.stake = stake;
//    }
//
//    public static double getOdds() {
//        return odds;
//    }
//
//    public static void setOdds(double odds) {
//        bets.odds = odds;
//    }
//    
//    public static void arrayInteger(){
//        arrayInteger++;
//    }

//    bets(int randomNumber, int user_ID, int gameID, String team1, String team2, String bet, double finalOdds) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public String toString() {
        return "bets{" +this.getBet1()+ '}';
    }
    
    

  
}
