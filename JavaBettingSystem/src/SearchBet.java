
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bozhidar
 */
public class SearchBet extends javax.swing.JFrame {

    /**
     * Creates new form SearchBet
     */
    private static Statement stmt = null;
    private static Connection conn;
    

        
    public SearchBet() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(this);
        //this.jComboBox1.removeAllItems();
        
         //user.makeConnection();
         
       

       
        
        
         
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsTextField = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Today", "Yesterday", "This week", "Last week", "This month", "Last month" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(resultsTextField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jComboBox1)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.setVisible(false);        
    }//GEN-LAST:event_exitButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
      
       
       String query = "";
       
//       java.sql.Timestamp date2 = new java.sql.Timestamp(new java.util.Date().getTime());
//System.out.println("date2"+ date2);

DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());


dateFormat.format(date);



        // Print dates of the current week starting on Monday
        //DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

//
//        System.out.println("Start Date = " + startDate);
//        System.out.println("End Date = " + endDate);

        System.out.println("date" + date);
        
        if(this.jComboBox1.getSelectedIndex()== 0){
                       System.out.println("query" + query);                       
                       long tomorrow = 1* 24 * 60 * 60 * 1000;
                       query ="select * from bet where timeOfBet > '"+dateFormat.format(date)+"' AND timeOfBet <'"+ dateFormat.format(new java.sql.Timestamp(date.getTime() + tomorrow)) +"'";
                       System.out.println("query2"+ query);
                       System.out.println("<<>> + "+dateFormat.format(date));
                       System.out.println("..." + dateFormat.format(new java.sql.Timestamp(date.getTime() + tomorrow)));
 }
        if(this.jComboBox1.getSelectedIndex()== 1){
            System.out.println("query" + query); 
                       long yesterday = 1* 24 * 60 * 60 * 1000;
                       query ="select * from bet where timeOfBet > '"+dateFormat.format(new java.sql.Timestamp(date.getTime() - yesterday))+"' AND timeOfBet <'"+ dateFormat.format(date) +"'";
                       System.out.println("query2"+ query);
        }
        
        if(this.jComboBox1.getSelectedIndex()== 2){
            Calendar c = GregorianCalendar.getInstance();
            c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                       String startDate = "",
                        endDate = "";
                       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                       startDate = dateFormat.format(c.getTime());
                       c.add(Calendar.DATE, 6);
                       
                       endDate = dateFormat.format(c.getTime());

                       System.out.println("query" + query);
                       Date d1 = null;
                       Date d2 = null;
                        {
                           try {
                               d1 = df.parse(startDate);
                               d2 = df.parse(endDate);
                           } catch (ParseException ex) {
                               Logger.getLogger(SearchBet.class.getName()).log(Level.SEVERE, null, ex);
                           }
                       }
                       long monday = d1.getTime();
                       long sunday = d2.getTime();
                       System.out.println("monday" + monday);
                       System.out.println("sunday" + sunday);
                       query ="select * from bet where timeOfBet > '" + dateFormat.format(new java.sql.Timestamp(monday)) + "' AND timeOfBet <'" + dateFormat.format(new java.sql.Timestamp(sunday)) + "'";
                       System.out.println("dateFormat.format(new java.sql.Timestamp(monday)) " + dateFormat.format(new java.sql.Timestamp(monday)));
                       System.out.println("dateFormat.format(new java.sql.Timestamp(sunday)) "+ dateFormat.format(new java.sql.Timestamp(sunday)));
       
        }
        
        if(this.jComboBox1.getSelectedIndex()== 3){
            Calendar c = GregorianCalendar.getInstance();
            c.add(Calendar.WEEK_OF_YEAR, -1);
            //c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() -6);
            
            
            String startDate = "",
                        endDate = "";
                       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                       startDate = dateFormat.format(c.getTime());
                       
                       c.add(Calendar.DATE, 6);
                       
                       endDate = dateFormat.format(c.getTime());

                       System.out.println("query" + query);
                       Date d1 = null;
                       Date d2 = null;
                        {
                           try {
                               d1 = df.parse(startDate);
                               d2 = df.parse(endDate);
                           } catch (ParseException ex) {
                               Logger.getLogger(SearchBet.class.getName()).log(Level.SEVERE, null, ex);
                           }
                       }
                       long monday = d1.getTime();
                       long sunday = d2.getTime();
                       System.out.println("monday" + monday);
                       System.out.println("sunday" + sunday);
                       query ="select * from bet where timeOfBet > '" + dateFormat.format(new java.sql.Timestamp(monday)) + "' AND timeOfBet <'" + dateFormat.format(new java.sql.Timestamp(sunday)) + "'";
                       System.out.println("dateFormat.format(new java.sql.Timestamp(monday)) " + dateFormat.format(new java.sql.Timestamp(monday)));
                       System.out.println("dateFormat.format(new java.sql.Timestamp(sunday)) "+ dateFormat.format(new java.sql.Timestamp(sunday)));
        }

        
        if(this.jComboBox1.getSelectedIndex()== 4){
            Calendar c = GregorianCalendar.getInstance();
            c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
            //Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
            String startDate = "",
                    endDate = "";
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            startDate = dateFormat.format(c.getTime());

           // c.add(Calendar.DATE, 6);
            c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
            endDate = dateFormat.format(c.getTime());

            System.out.println("query" + query);
            Date d1 = null;
            Date d2 = null;
            {
                try {
                    d1 = df.parse(startDate);
                    d2 = df.parse(endDate);
                } catch (ParseException ex) {
                    Logger.getLogger(SearchBet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            long monday = d1.getTime();
            long sunday = d2.getTime();
            System.out.println("monday" + monday);
            System.out.println("sunday" + sunday);
            query = "select * from bet where timeOfBet > '" + dateFormat.format(new java.sql.Timestamp(monday)) + "' AND timeOfBet <'" + dateFormat.format(new java.sql.Timestamp(sunday)) + "'";
            System.out.println("dateFormat.format(new java.sql.Timestamp(monday)) " + dateFormat.format(new java.sql.Timestamp(monday)));
            System.out.println("dateFormat.format(new java.sql.Timestamp(sunday)) " + dateFormat.format(new java.sql.Timestamp(sunday)));

        }
        if(this.jComboBox1.getSelectedIndex()== 5){
            Calendar c = GregorianCalendar.getInstance();
            c.add(Calendar.MONTH, -1) ;
            c.set(Calendar.DATE, 1);  
            
            
            String startDate = "",
            endDate = "";
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            startDate = dateFormat.format(c.getTime());

           // c.add(Calendar.DATE, 6);
            c.set(Calendar.DATE,c.getActualMaximum(Calendar.DAY_OF_MONTH));
            endDate = dateFormat.format(c.getTime());

            System.out.println("query" + query);
            Date d1 = null;
            Date d2 = null;
            {
                try {
                    d1 = df.parse(startDate);
                    d2 = df.parse(endDate);
                } catch (ParseException ex) {
                    Logger.getLogger(SearchBet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            long monday = d1.getTime();
            long sunday = d2.getTime();
            System.out.println("monday" + monday);
            System.out.println("sunday" + sunday);
            query = "select * from bet where timeOfBet > '" + dateFormat.format(new java.sql.Timestamp(monday)) + "' AND timeOfBet <'" + dateFormat.format(new java.sql.Timestamp(sunday)) + "'";
            System.out.println("dateFormat.format(new java.sql.Timestamp(monday)) " + dateFormat.format(new java.sql.Timestamp(monday)));
            System.out.println("dateFormat.format(new java.sql.Timestamp(sunday)) " + dateFormat.format(new java.sql.Timestamp(sunday)));

            
        }
//
//        
//       if(jComboBox1.getSelectedIndex())_
//                       System.out.println("query" + query);                       
//                       long tomorrow = 1* 24 * 60 * 60 * 1000;
//                       query ="select * from bet where timeOfBet > '"+dateFormat.format(date)+"' AND timeOfBet <'"+ dateFormat.format(new java.sql.Timestamp(date.getTime() + tomorrow)) +"'";
//                       System.out.println("query2"+ query);
//                       System.out.println("<<>> + "+dateFormat.format(date));
//                       System.out.println("..." + dateFormat.format(new java.sql.Timestamp(date.getTime() + tomorrow)));                       
//    }                          
//                   case 1:
//                      
//                        System.out.println("query" + query); 
//                       long yesterday = 1* 24 * 60 * 60 * 1000;
//                       query ="select * from bet where timeOfBet > '"+dateFormat.format(new java.sql.Timestamp(date.getTime() - yesterday))+"' AND timeOfBet <'"+ dateFormat.format(date) +"'";
//                       System.out.println("query2"+ query);
//                   case 2:  
//                       String startDate = "",
//                        endDate = "";
//                       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//                       startDate = dateFormat.format(c.getTime());
//                       c.add(Calendar.DATE, 6);
//                       endDate = dateFormat.format(c.getTime());
//
//                       System.out.println("query" + query);
//                       Date d1 = null;
//                       Date d2 = null;
//                        {
//                           try {
//                               d1 = df.parse(startDate);
//                               d2 = df.parse(endDate);
//                           } catch (ParseException ex) {
//                               Logger.getLogger(SearchBet.class.getName()).log(Level.SEVERE, null, ex);
//                           }
//                       }
//                       long monday = d1.getTime();
//                       long sunday = d2.getTime();
//                       System.out.println("monday" + monday);
//                       System.out.println("sunday" + sunday);
//                       query ="select * from bet where timeOfBet > '" + dateFormat.format(new java.sql.Timestamp(monday)) + "' AND timeOfBet <'" + dateFormat.format(new java.sql.Timestamp(sunday)) + "'";
//
//                       break;
//                   case 3:
//                       userSelection =7;
//                       break;
//                   case 4:
//                       userSelection =1;
//                       break;  
//                   case 5:
//                       userSelection = 1;
//                   default:
//                       System.out.println("..");
//                       break;
//
//               }
//       
String desc ="";
        try {

         //user.makeConnection();
            conn = DriverManager.getConnection(user.getConnectionURL(),user.getConnectionUsername(), user.getConnectionPassword());
            stmt = conn.createStatement();    
            
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){                  
                 desc = desc+ rs.getString("bet") + "\n";
                System.out.println("dwadawdaw" + desc);
              
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(Help.class.getName()).log(Level.SEVERE, null, ex);
        }
                this.resultsTextField.setText("" + desc+ "\n");
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(SearchBet.class.getName()).log(Level.SEVERE, null, ex);
        }
            

               
               System.out.println("jComboBox1.getSelectedIndex("+ jComboBox1.getSelectedIndex());
            
              
               
//                long miliseconds = days* 24 * 60 * 60 * 1000;
//                System.out.println(""+ new java.sql.Timestamp(date2.getTime() - miliseconds));
               

               
               
    }//GEN-LAST:event_searchButtonActionPerformed

    /**
     * @param args the command line arguments
     */



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane resultsTextField;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
