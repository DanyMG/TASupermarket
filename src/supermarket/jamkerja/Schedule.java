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
            RsSchedule=stm.executeQuery("select * from jadwal");
            schedule=new String[countRowRs(RsSchedule)][2];
            for(int i=0;RsSchedule.next();i++){
                schedule[i][0]=RsSchedule.getString("id_jadwal");
                schedule[i][1]=RsSchedule.getString("tgl_jadwal");                
            }            
        } catch (SQLException e){
            System.out.println("Error : "+e);
            SW=new String[0][0];
        }
        return SW;
    }
    public String[][] getAllEmployeeSchedule(){
        String[][] eSchedule;
        try{    
            stm=con.createStatement();
            RsSchedule=stm.executeQuery("select * from jadwal_karyawan");
            eSchedule=new String[countRowRs(RsSchedule)][6];
            for(int i=0;RsSchedule.next();i++){
                eSchedule[i][0]=RsSchedule.getString("id_jk");
                eSchedule[i][1]=RsSchedule.getString("id_jadwal");
                eSchedule[i][2]=RsSchedule.getString("id_karyawan");
                eSchedule[i][3]=RsSchedule.getString("waktu_mulai");
                eSchedule[i][4]=RsSchedule.getString("waktu_selesai");
                eSchedule[i][5]=RsSchedule.getString("nama_jk");
            }            
        } catch (SQLException e){
            System.out.println("Error : "+e);
            eSchedule=new String[0][0];
        }
        return eSchedule;
    }
    public boolean addSchedule(Date schedule){
        try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO "
                    + "jadwal(id_jadwal, tgl_jadwal ) "
                    + "VALUES (NULL,'"+sdf.format(schedule)+"')");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
        }
    }
    public boolean addEmployeeSchedule(String[] eS){
        try{
            stm=con.createStatement();
            System.out.println(eS[2]);
            stm.executeUpdate("INSERT INTO "
                    + "jadwal_karyawan(id_jk, id_jadwal, id_karyawan, waktu_mulai, waktu_selesai, nama_jk) "
                    + "VALUES (NULL,'"+eS[1]+"', '"+eS[2]+"', '"+eS[3]+"', '"+eS[4]+"', '"+eS[5]+"')");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
        }
    }
    public boolean isAnyDate(String selDate, String[][] allSchedule) throws ParseException{
        for(String[] schedule:allSchedule){
            System.out.println(schedule[1]+" ?? "+selDate);
            if(schedule[1].equals(selDate)) return true;
        }
        return false;
    }
    public int getIdSchedule(Date seldate,String[][] allSchedule) throws ParseException{
        for(String[] schedule:allSchedule){
            if(sdf.parse(schedule[1])==seldate) return  Integer.parseInt(schedule[0]);
        }
        return 0;
    }
    public String[] getEmployeSchedule(int id,Date date, String[][] allEmployeeSchedule){
        String[] eSchedule=new String[6];
        if(allEmployeeSchedule.length!=0){
            try{
                for(String[] es:allEmployeeSchedule){
                    if(sdf.parse(es[1])==date && Integer.parseInt(es[2])==id){                    
                        eSchedule=es;
                    }else{
                        eSchedule[0]=Integer.toString(id);
                        eSchedule[1]=sdf.format(date);
                        eSchedule[2]=null;
                        eSchedule[3]=null;
                        eSchedule[4]=null;
                        eSchedule[5]=null;
                    }
                }
            }catch(NumberFormatException | ParseException e){
                System.out.println("Error : "+e);
            }
        }else{
            eSchedule[0]=Integer.toString(id);
                        eSchedule[1]=sdf.format(date);
                        eSchedule[2]=null;
                        eSchedule[3]=null;
                        eSchedule[4]=null;
                        eSchedule[5]=null;
        }                
        return eSchedule;
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
