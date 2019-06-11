/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.suplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import supermarket.KoneksiMySQL;

/**
 *
 * @author DanyMG
 */
public class Suplier {
    private int id;
    private String nama,alamat,kota,notelp;
    
    private Connection con;
    private Statement stm;
    private ResultSet RsSuplier;
    
    public Suplier() {
        open_db();
    }
    public Suplier(int id, String nama, String alamat, String kota, String notelp){
        this.id=id;
        this.nama=nama;
        this.alamat=alamat;
        this.kota=kota;
        this.notelp=notelp;       
    }
    public int getId(){
        return this.id;
    }
    public String getNama(){
        return this.nama;        
    }
    public String getAlamat(){
        return this.alamat;
    }
    public String getKota(){
        return this.kota;
    }
    public String getNotelp(){
        return this.notelp;
    }
    private void open_db(){
        try{
            KoneksiMySQL kon= new KoneksiMySQL("localhost", "root", "", "supermarket");
            con=kon.getConnection();
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }
    public void addSuplier(String nama, String almt, String kota, String notelp){        
        try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO suplier"
                    + "(id_suplier, nama_suplier, almt_suplier, kota_suplier, notelp_suplier) "
                    + "VALUES (NULL,'"+nama+"', '"+almt+"', '"+kota+"', '"+notelp+"')");            
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }        
    }
    public Suplier getSuplier(int id){
        Suplier hasil=new Suplier();
        try{
            stm=con.createStatement();
            RsSuplier=stm.executeQuery("select * from suplier where id_suplier='"+id+"'");            
            if(RsSuplier.next()){
                hasil=new Suplier(RsSuplier.getInt("id_suplier"),RsSuplier.getString("nama_suplier"),
                    RsSuplier.getString("almt_suplier"),RsSuplier.getString("kota_suplier"),
                    RsSuplier.getString("notelp_suplier"));
            }
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return hasil;
    }
    public Suplier[] getAllSuplier(){
        Suplier[] hasil=new Suplier[getLastId()];
        for(int i=0;i<getLastId();i++){
            hasil[i]=getSuplier(i+1);
        }
        return hasil;      
    }
    public void editSuplier(int id,String nama, String almt, String kota, String notelp){
        try{
            stm=con.createStatement();
            stm.executeUpdate("UPDATE suplier SET nama_suplier = '"+nama+"', almt_suplier = '"+almt+"'"
                    + ", kota_suplier = '"+kota+"', notelp_suplier = '"+notelp+"' WHERE suplier.id_suplier = "+id+"");            
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }
    public boolean isAny(String nama){
        boolean cari=false;
        try{
            stm=con.createStatement();
            RsSuplier=stm.executeQuery("select nama_suplier from suplier");
            while(RsSuplier.next()){
                if(RsSuplier.getString("nama_suplier").equalsIgnoreCase(nama)) cari=true;
            }
        }catch (SQLException e){
            System.out.println("Error : "+e);
        }
        return cari;
    }
    public int getLastId(){
        int id=0;
        try{
            stm=con.createStatement();
            RsSuplier=stm.executeQuery("select * from suplier order by id_suplier DESC");
            if(RsSuplier.next()) id=RsSuplier.getInt("id_suplier");
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
        return id;
    }   
    
}
