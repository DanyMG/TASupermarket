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
    private ResultSet RsSuplier;
    
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
    public void getAllEmployee(){
        
    }
}
