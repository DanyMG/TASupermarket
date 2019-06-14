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
    public void addEmployee(String[] newEData){
        try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO "
                    + "karyawan(id_karyawan, nama_karyawan, almt_karyawan, kota_karyawan, notelp_karyawan, kategori_karyawan) "
                    + "VALUES (NULL,'"+newEData[1]+"', '"+newEData[2]+"', '"+newEData[3]+"', '"+newEData[4]+"', '"+newEData[5]+"')");                      
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }
    public boolean isAddSuccess(String[] newEData){
        String[] employee=new String[6];
        try{    
            stm=con.createStatement();
            RsKaryawan=stm.executeQuery("select * from karyawan order by id_karyawan DESC");            
            if(RsKaryawan.next()){
                employee[0]=RsKaryawan.getString("id_karyawan");
                employee[1]=RsKaryawan.getString("nama_karyawan");
                employee[2]=RsKaryawan.getString("almt_karyawan");
                employee[3]=RsKaryawan.getString("kota_karyawan");
                employee[4]=RsKaryawan.getString("notelp_karyawan");
                employee[5]=RsKaryawan.getString("kategori_karyawan");
            }            
        } catch (SQLException e){
            System.out.println("Error : "+e);
        }
        if(Arrays.equals(employee,newEData)) return true;
        else return false;
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
            employee=new String[countRowRs(RsKaryawan)][6];
            for(int i=0;RsKaryawan.next();i++){
                employee[i][0]=RsKaryawan.getString("id_karyawan");
                employee[i][1]=RsKaryawan.getString("nama_karyawan");
                employee[i][2]=RsKaryawan.getString("almt_karyawan");
                employee[i][3]=RsKaryawan.getString("kota_karyawan");
                employee[i][4]=RsKaryawan.getString("notelp_karyawan");
                employee[i][5]=RsKaryawan.getString("kategori_karyawan");
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
            }            
        } catch (SQLException e){
            System.out.println("Error : "+e);
            employee=new String[0][0];
        }        
        return employee;
    }    
}
