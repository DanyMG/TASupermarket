/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;
import java.sql.*;
/**
 *
 * @author DanyMG
 */
public class KoneksiMySQL {
    String url,usr,pass,dbn;
    public KoneksiMySQL(String dbn){
        this.url = "jdbc:mysql://localhost/" + dbn;
        this.usr = "root";
        this.pass = "";
    }
    public KoneksiMySQL(String host,String user, String pass, String dbn){
        this.url = "jdbc:mysql://" + host + "/" + dbn;
        this.usr=user;
        this.pass=pass;
    }
    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.usr,
            this.pass);
        } catch (ClassNotFoundException e) {
            System.out.println ("Error #1 : " + e.getMessage());
            System.exit(0);
        } catch (SQLException e) {
            System.out.println ("Error #2 : " + e.getMessage());
            System.exit(0);
        }
        return con;
    }
    
}
