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
    
    private Connection con;
    private Statement stm;
    private ResultSet RsSuplier;
    
    public Suplier() {
        try{
            KoneksiMySQL kon= new KoneksiMySQL("localhost", "root", "", "supermarket");
            con=kon.getConnection();
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }   
    public boolean addSuplier(String[] newSData){        
        try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO suplier"
                    + "(id_suplier, nama_suplier, almt_suplier, kota_suplier, notelp_suplier, deleted) "
                    + "VALUES (NULL,'"+newSData[1]+"', '"+newSData[2]+"', '"+newSData[3]+"', '"+newSData[4]+"', FALSE)");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
        }        
    }
    public String[][] getAllSuplier(){
        String[][] suplier;
        try{
            stm=con.createStatement();
            RsSuplier=stm.executeQuery("select * from karyawan");
            suplier=new String[countRowRs(RsSuplier)][7];
            for(int i=0;RsSuplier.next();i++){
                suplier[i][0]=RsSuplier.getString("id_karyawan");
                suplier[i][1]=RsSuplier.getString("nama_karyawan");
                suplier[i][2]=RsSuplier.getString("almt_karyawan");
                suplier[i][3]=RsSuplier.getString("kota_karyawan");
                suplier[i][4]=RsSuplier.getString("notelp_karyawan");
                suplier[i][5]=RsSuplier.getString("kategori_karyawan");
                suplier[i][6]=RsSuplier.getString("deleted");
            }            
        }catch(SQLException e){
            System.out.println("Error : "+e);
            suplier=new String[0][0];
        }
        return suplier;
    }
    public int countRowRs(ResultSet rs) throws SQLException{
        rs.last();
        int count=rs.getRow();
        rs.beforeFirst();
        return count;
    }
    public String[] getSuplier(String[][] sData, int id){
        String[] suplier= new String[6];
        for(String[] item:sData){
            if(Integer.parseInt(item[0])==id){
                suplier=item;
                break;
            }
        }        
        return suplier;
    }
    public int getLastId(String[][] sData){             
        return Integer.parseInt(sData[sData.length-1][0]);
    }
    
    public boolean editSuplier(String[] sData){        
        try{
            stm=con.createStatement();
            stm.executeUpdate("UPDATE suplier SET nama_suplier = '"+sData[1]+"', almt_suplier = '"+sData[2]+"'"
                    + ", kota_suplier = '"+sData[3]+"', notelp_suplier = '"+sData[4]+"' WHERE suplier.id_suplier = "+sData[0]+"");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
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
}
