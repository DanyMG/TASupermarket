/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.anggota;

import java.sql.Connection;
import java.sql.ResultSet;
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
    public boolean addMember(String[] mData){
        
    }
            
}
