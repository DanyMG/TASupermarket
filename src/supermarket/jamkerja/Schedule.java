/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.jamkerja;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import supermarket.KoneksiMySQL;

/**
 *
 * @author DanyMG
 */
public class Schedule {
    private Connection con;
    private Statement stm;
    private ResultSet RsSW;
    public Schedule(){
        try{
            KoneksiMySQL kon= new KoneksiMySQL("localhost", "root", "", "supermarket");
            con=kon.getConnection();
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }
    public String[][] getAllShiftWork(){
        String[][] SW;        
        try{    
            stm=con.createStatement();
            RsSW=stm.executeQuery("select * from jamkerja");
            SW=new String[countRowRs(RsSW)][7];
            for(int i=0;RsSW.next();i++){
                SW[i][0]=RsSW.getString("id_jamkerja");
                SW[i][1]=RsSW.getString("tgl_jamkerja");
                SW[i][2]=RsSW.getString("hari_jamkerja");                
            }            
        } catch (SQLException e){
            System.out.println("Error : "+e);
            SW=new String[0][0];
        }
        return SW;
    }
    public int countRowRs(ResultSet rs) throws SQLException{
        rs.last();
        int count=rs.getRow();
        rs.beforeFirst();
        return count;
    }
    public boolean addShiftWork(Date sun, Date sat){
        
    }
}
