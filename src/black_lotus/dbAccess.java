/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package black_lotus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Yasitha Milan
 */
public class dbAccess {
    
    static Connection conn = dbCon.connect();
    
    static PreparedStatement pst1 = null;
    static ResultSet rs=null;
    
    public static boolean addjob(String jobNo,String date,String Brandmanager,String des,String est,String createby)
    {
        boolean status =false;
        
        try{
 
            String qury = "INSERT INTO pendingjob (pendingjobNo,date,brandManager,description,estimate,createddBy) values ('"+jobNo+"','"+date+"','"+Brandmanager+"','"+des+"','"+est+"','"+createby+"')";
            
            pst1 = conn.prepareStatement(qury);
            pst1.execute();
            
            status = true;
        }
        catch(Exception e){

            System.out.println(e);

        }
        
        return status;
    }
    
    public static boolean removejob(String pjobNo){
             boolean status=false;
             try {
                 String sql = "DELETE FROM pendingjob WHERE pendingjobNo = '"+pjobNo+"'";
                  pst1 = conn.prepareStatement(sql);
                   pst1.execute();
                   status=true;
             } catch (Exception e) {
                 System.out.println(e);
             }
             return status;
         }
    
    public static boolean updatejob(String jobNo,String date,String Brandmanager,String des,String est,String createby){
           
            boolean status=false;
            try {
            String sql = "UPDATE pendingjob SET pendingjobNo = '"+jobNo+"', date= '"+date+"', brandManager= '"+Brandmanager+"', description= '"+des+"',estimate= '"+est+"', createddBy= '"+createby+"' WHERE pendingjobNo = '"+jobNo+"'";           
            pst1 = conn.prepareStatement(sql);
            pst1.execute();
            status=true;
             } 
             catch (Exception e) {
                 System.out.println(e);
             }
             
             return status;
         
         }
}
