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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import supermarket.KoneksiMySQL;

/**
 *
 * @author DanyMG
 */
public class Schedule {
    private Connection con;
    private Statement stm;
    private ResultSet RsSchedule;
    private Calendar cal=Calendar.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public Schedule(){
        try{
            KoneksiMySQL kon= new KoneksiMySQL("localhost", "root", "", "supermarket");
            con=kon.getConnection();
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }
    public Date[] getDaysOfWeek(Date selDate){
        Date[] date=new Date[7];
        for(int i=0;i<date.length;i++){
            if(i==0) date[i]=getFirstDayOfWeek(selDate);
            else {
                cal.setTime(date[i-1]);
                cal.add(Calendar.DATE, 1);
                date[i]=cal.getTime();
            }         
        }
        return date;
    }
    public Date getFirstDayOfWeek(Date selDate){        
        cal.setTime(selDate);
        int i=cal.get(Calendar.DAY_OF_WEEK)-cal.getFirstDayOfWeek();
        cal.add(Calendar.DATE,-i);        
        return cal.getTime();
    }
    public Date getLastDayOfWeek(Date[] allDaysOfWeek){
        return allDaysOfWeek[allDaysOfWeek.length-1];
    }
    public Date[] getPrevWeek(Date[] allDaysOfWeek){
        Date[] prevWeek=new Date[7];
        for(int i=0;i<prevWeek.length;i++){
            if(i==0){
                cal.setTime(allDaysOfWeek[i]);
                cal.add(Calendar.DATE,-(cal.get(Calendar.DAY_OF_WEEK)-cal.getFirstDayOfWeek())-7);
            }
            else{
                cal.setTime(prevWeek[i-1]);
                cal.add(Calendar.DATE, 1);               
            }
            prevWeek[i]=cal.getTime();
        }
        return prevWeek;
    }    
    public Date[] getNextWeek(Date[] allDaysOfWeek){
       Date[] nextWeek=new Date[7];
        for(int i=0;i<nextWeek.length;i++){
            if(i==0){
                cal.setTime(allDaysOfWeek[i]);
                cal.add(Calendar.DATE,-(cal.get(Calendar.DAY_OF_WEEK)-cal.getFirstDayOfWeek())+7);
            }
            else{
                cal.setTime(nextWeek[i-1]);
                cal.add(Calendar.DATE, 1);                
            }
            nextWeek[i]=cal.getTime();
        }
        return nextWeek;
    }
    public String[][] getAllSchedule(){
        String[][] schedule;
        try{    
            stm=con.createStatement();
            RsSchedule=stm.executeQuery("select * from jadwal");
            schedule=new String[countRowRs(RsSchedule)][2];
            for(int i=0;RsSchedule.next();i++){
                schedule[i][0]=RsSchedule.getString("id_karyawan");
                schedule[i][1]=RsSchedule.getString("tgl_jadwal");                
            }            
        } catch (SQLException e){
            System.out.println("Error : "+e);
            schedule=new String[0][0];
        }
        
        return schedule;
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
    public boolean addEmployeeSchedule(String[] eS){
        try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO "
                    + "jadwal_karyawan(id_jk, id_jadwal, id_karyawan, waktu_mulai, waktu_selesai, nama_jk) "
                    + "VALUES (NULL,'"+eS[1]+"', '"+eS[2]+"', '"+eS[3]+"', '"+eS[4]+"', '"+eS[5]+"')");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
        }
    }
    public String[] getEmployeSchedule(int id,Date date, String[][] allEmployeeSchedule){
        String[] eSchedule=new String[6];
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
        return eSchedule;
    }    
    public int countRowRs(ResultSet rs) throws SQLException{
        rs.last();
        int count=rs.getRow();
        rs.beforeFirst();
        return count;
    }    
}
