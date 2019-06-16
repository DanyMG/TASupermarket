/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.karyawan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import supermarket.KoneksiMySQL;

/**
 *
 * @author DanyMG
 */
public class Employee {
    private Connection con;
    private Statement stm;
    private ResultSet RsKaryawan;
    
    public Employee(){
        try{
            KoneksiMySQL kon= new KoneksiMySQL("localhost", "root", "", "supermarket");
            con=kon.getConnection();
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }
    public boolean addEmployee(String[] newEData){
        try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO "
                    + "karyawan(id_karyawan, nama_karyawan, almt_karyawan, kota_karyawan, notelp_karyawan, kategori_karyawan,deleted) "
                    + "VALUES (NULL,'"+newEData[1]+"', '"+newEData[2]+"', '"+newEData[3]+"', '"+newEData[4]+"', '"+newEData[5]+"', FALSE)");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
        }
    }   
    public String[] getEmployee(String[][] eData, int id){
        String[] employee= new String[6];
        for(String[] item:eData){
            if(Integer.parseInt(item[0])==id){
                employee=item;
                break;
            }
        }        
        return employee;
    }
    public int getLastId(String[][] eData){             
        return Integer.parseInt(eData[eData.length-1][0]);
    }
    public String[][] getAllEmployee(){        
        String[][] employee;        
        try{    
            stm=con.createStatement();
            RsKaryawan=stm.executeQuery("select * from karyawan");
            employee=new String[countRowRs(RsKaryawan)][7];
            for(int i=0;RsKaryawan.next();i++){
                employee[i][0]=RsKaryawan.getString("id_karyawan");
                employee[i][1]=RsKaryawan.getString("nama_karyawan");
                employee[i][2]=RsKaryawan.getString("almt_karyawan");
                employee[i][3]=RsKaryawan.getString("kota_karyawan");
                employee[i][4]=RsKaryawan.getString("notelp_karyawan");
                employee[i][5]=RsKaryawan.getString("kategori_karyawan");
                employee[i][6]=RsKaryawan.getString("deleted");
            }            
        } catch (SQLException e){
            System.out.println("Error : "+e);
            employee=new String[0][0];
        }
        return employee;
    }
    public int countRowRs(ResultSet rs) throws SQLException{
        rs.last();
        int count=rs.getRow();
        rs.beforeFirst();
        return count;
    }
    public String[][] findEmployee(String keyword){
        String[][] employee;
        try{    
            stm=con.createStatement();
            RsKaryawan=stm.executeQuery("select * from karyawan where nama_karyawan like '%"+keyword+"%'");            
            employee= new String [countRowRs(RsKaryawan)][6];            
            for(int i=0;RsKaryawan.next();i++){
                employee[i][0]=RsKaryawan.getString("id_karyawan");
                employee[i][1]=RsKaryawan.getString("nama_karyawan");
                employee[i][2]=RsKaryawan.getString("almt_karyawan");
                employee[i][3]=RsKaryawan.getString("kota_karyawan");
                employee[i][4]=RsKaryawan.getString("notelp_karyawan");
                employee[i][5]=RsKaryawan.getString("kategori_karyawan");
                employee[i][6]=RsKaryawan.getString("deleted");
            }            
        } catch (SQLException e){
            System.out.println("Error : "+e);
            employee=new String[0][0];
        }        
        return employee;
    }
    public boolean editEmployee(String[] eData){
        try{
            stm=con.createStatement();
            stm.executeUpdate("UPDATE karyawan SET nama_karyawan = '"+eData[1]+"', almt_karyawan = '"+eData[2]+"'"
                    + ", kota_karyawan = '"+eData[3]+"', notelp_karyawan = '"+eData[4]+"', kategori_karyawan = '"+eData[5]+"' "
                            + "WHERE karyawan.id_karyawan = "+eData[0]+"");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
        }
    }
    public boolean delEmployee(String[] eData){
        try{
            stm=con.createStatement();
            stm.executeUpdate("UPDATE karyawan SET deleted = TRUE WHERE karyawan.id_karyawan = "+eData[0]+"");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
        }
    }
}
