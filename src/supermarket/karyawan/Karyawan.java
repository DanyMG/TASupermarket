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
import supermarket.KoneksiMySQL;

/**
 *
 * @author DanyMG
 */
public class Karyawan {
    private Connection con;
    private Statement stm;
    private ResultSet RsKaryawan;
    
    public Karyawan(){
        try{
            KoneksiMySQL kon= new KoneksiMySQL("localhost", "root", "", "supermarket");
            con=kon.getConnection();
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }
    public void addEmployee(String name, String addr, String city, String phone, String category){
        try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO "
                    + "karyawan(id_karyawan, nama_karyawan, almt_karyawan, kota_karyawan, notelp_karyawan, kategori_karyawan) "
                    + "VALUES (NULL,'"+name+"', '"+addr+"', '"+city+"', '"+phone+"', '"+category+"')");                          
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }
    public int getLastId(){
        int id=0;
        try{
            stm=con.createStatement();
            RsKaryawan=stm.executeQuery("select * from karyawan order by id_karyawan DESC");
            if(RsKaryawan.next()) id=RsKaryawan.getInt("id_karyawan");
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return id;
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
    public String[] getEmployee(int id){
        String[] employee= new String[6];
        try{    
            stm=con.createStatement();
            RsKaryawan=stm.executeQuery("select * from karyawan where id_karyawan='"+id+"'");
            for(int i=0;RsKaryawan.next();i++){
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
        return employee;
    }    
}
