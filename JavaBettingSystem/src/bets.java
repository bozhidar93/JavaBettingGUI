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

    public static int userID;
    public static int betID;
    public static int gameID;
    public static String team1;
    public static String team2;
    public static String bet;
    public static int stake = 123;
    public static int odds ;
    public static String betStatus = " testing for now";
    public static int bet_returs = 1111111;
    

    public bets(int betID, int gameID, String team1, String team2, String bet, int odds) {
       bets.betID = betID;
       bets.userID = user.getUser_ID();
       bets.team1 = team1;
       bets.team2 = team2;
       bets.bet = bet;
       bets.odds = odds;      

    }

    /*
    betID trqbva da se pravi nqkaksi avotmatichno
    team1 i team2 moga da gi zema ot list2
    odds e ot tablicata
    gameID
    if team1 ot list2 = team1 ot tablicata
    i team2 ot list2 = team2 ot tablicata
    eto ti go gameID reda
    */

    
}
