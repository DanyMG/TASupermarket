/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.barang;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import supermarket.KoneksiMySQL;

/**
 *
 * @author asus
 */
public class Goods {
    private Connection con;
    private Statement stm;
    private ResultSet RsKaryawan;//rdgoods
    public Goods(){
        try{
            KoneksiMySQL kon= new KoneksiMySQL("localhost", "root", "", "supermarket");
            con=kon.getConnection();
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }
    public String[][] getAllGoods(){
        String[][] employee;        
        try{    
            stm=con.createStatement();
            RsKaryawan=stm.executeQuery("select * from barang");
            employee=new String[countRowRs(RsKaryawan)][7];
            for(int i=0;RsKaryawan.next();i++){
                employee[i][0]=RsKaryawan.getString("id_barang");
                employee[i][1]=RsKaryawan.getString("nama_barang");
                employee[i][2]=RsKaryawan.getString("jumlah");
                employee[i][3]=RsKaryawan.getString("harga_beli");
                employee[i][4]=RsKaryawan.getString("harga_jual");
                
            }            
        } catch (SQLException e){
            System.out.println("Error : "+e);
            employee=new String[0][0];
        }
        return employee;
    }
    public String[] getGoods(String[][] allGoods, int id){
        String[] goods= new String[6];
        for(String[] item:allGoods){
            if(Integer.parseInt(item[0])==id){
                goods=item;
                break;
            }
        }        
        return goods;
    }
    public int countRowRs(ResultSet rs) throws SQLException{
        rs.last();
        int count=rs.getRow();
        rs.beforeFirst();
        return count;
    } 
    public boolean addGoods(String[] newEData){
        try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO "
                    + "barang(id_barang, nama_barang, jumlah, harga_beli, harga_jual) "
                    + "VALUES (NULL,'"+newEData[1]+"', '"+newEData[2]+"', '"+newEData[3]+"', '"+newEData[4]+"')");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
        }
    }
    public int getLastId(String[][] eData){             
        return Integer.parseInt(eData[eData.length-1][0]);
    }
    public boolean editGoods(String[] goods){
        try{
            stm=con.createStatement();
            stm.executeUpdate("UPDATE barang SET nama_barang = '"+goods[1]+"', harga_beli = '"+goods[3]+"',"
                    + " harga_jual = '"+goods[4]+"' WHERE barang.id_barang = "+goods[0]+"");
            return true;
        }catch(SQLException e){
            System.out.println("Error : "+e);
            return false;
        }
    }
    public boolean discardGoods(String[] discard,String[] goods){
        int jml=Integer.parseInt(goods[2])-Integer.parseInt(discard[4]);
        try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO "
                    + "pembuangan (id_pembuangan, id_barang, id_karyawan, tgl_pembuangan, jml_buang, ket_pembuangan) "
                    + "VALUES (NULL,'"+discard[1]+"', '"+discard[2]+"', '"+discard[3]+"', '"+discard[4]+"', '"+discard[5]+"')");
            stm.executeUpdate("UPDATE barang SET jumlah= '"+jml+"' WHERE barang.id_barang = "+goods[0]+"");
            return true;
        }catch(SQLException e){
            System.out.println("Error discard : "+e);
            return false;
        }
    }
    public boolean orderGoods(String[] order,String[] goods){
        int jml=Integer.parseInt(goods[2])+Integer.parseInt(order[5]);
        try{
            stm=con.createStatement();
            stm.executeUpdate("INSERT INTO "
                    + "pemesanan (id_pemesanan, id_barang, id_karyawan, id_suplier, tgl_pemesanan, jml_pesanan) "
                    + "VALUES (NULL,'"+order[1]+"', '"+order[2]+"', '"+order[3]+"', '"+order[4]+"', '"+order[5]+"')");
            stm.executeUpdate("UPDATE barang SET jumlah= '"+jml+"' WHERE barang.id_barang = "+goods[0]+"");
            return true;            
        }catch(SQLException e){
            System.out.println("Error discard : "+e);
            return false;
        }
    }
    public int getTotalPrice(String[][] allSaleGoods){
        int Total=0;
        for(String[]data:allSaleGoods){
            if(data[3]!=null){
                Total+=Integer.parseInt(data[3]);
            }else break;
        } return Total;
    }
}
