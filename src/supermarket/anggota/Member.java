/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.anggota;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import supermarket.KoneksiMySQL;

/**
 *
 * @author DanyMG
 */
public class Member {
    
    private Connection con;
    private Statement stm;
    private ResultSet RsSuplier;
    
    public Member(){
        try{
            KoneksiMySQL kon= new KoneksiMySQL("localhost", "root", "", "supermarket");
            con=kon.getConnection();
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }
     public int getLastId(String[][] mData){             
        return Integer.parseInt(mData[mData.length-1][0]);
    }
    public boolean addMember(String[] mData){
         try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO anggota"
                    + "(id_anggota, nama_anggota, almt_anggota, notelp_anggota, poin_anggota) "
                    + "VALUES (NULL,'"+mData[1]+"', '"+mData[2]+"', '"+mData[3]+"', '"+mData[4]+"')");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
        }   
    }
    
    public int countRowRs(ResultSet rs) throws SQLException{
        rs.last();
        int count=rs.getRow();
        rs.beforeFirst();
        return count;
    }
    public String[][] getAllMember(){
      String[][] member;
      try{
          stm=con.createStatement();
          RsSuplier=stm.executeQuery("select * from anggota");
          member=new String[countRowRs(RsSuplier)][6];
          for(int i=0;RsSuplier.next();i++){
              member[i][0]=RsSuplier.getString("id_anggota");
              member[i][1]=RsSuplier.getString("nama_anggota");
              member[i][2]=RsSuplier.getString("almt_anggota");
              member[i][3]=RsSuplier.getString("notelp_anggota");
              member[i][4]=RsSuplier.getString("poin_anggota");                
          }            
      }catch(SQLException e){
          System.out.println("Error : "+e);
          member=new String[0][0];
      }
      return member;
    }
    public String[] getMember(String[][] mData, int id){
        String[] member= new String[6];
        for(String[] item:mData){
            if(Integer.parseInt(item[0])==id){
                member=item;
                break;
            }
        }        
        return member;
    }
    public boolean editSuplier(String[] sData){        
        try{
            stm=con.createStatement();
            stm.executeUpdate("UPDATE anggota SET nama_anggota = '"+sData[1]+"', almt_anggota = '"+sData[2]+"'"
                    + ", notelp_anggota = '"+sData[3]+"' WHERE suplier.id_suplier = "+sData[0]+"");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
        }
    }
}
