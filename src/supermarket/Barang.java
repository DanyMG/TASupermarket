/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

/**
 *
 * @author gustafsn1
 */
public class Barang {
    private int id;
    private String nama;
    private int jml;
    private int hrg_beli;
    private int hrg_jual;
    public Barang(int id, String nama, int jml, int hrg_beli, int hrg_jual){
        this.id=id;
        this.nama=nama;
        this.jml=jml;
        this.hrg_beli=hrg_beli;
        this.hrg_jual=hrg_jual;
    }
    int getID(){
        return this.id;
    }
    String getNama(){
        return this.nama;
    }
    int getJml(){
        return this.jml;
    }
    int getHrgBeli(){
        return this.hrg_beli;
    }
    int getHrgJual(){
        return this.hrg_jual;
    }
    void setId(int id){
        this.id=id;
    }
    void setNama(String nama){
        this.nama=nama;
    }
    void tambahJml(int penambahan){
        this.jml+=penambahan;
    }
    void kurangJml(int pengurangan){
        this.jml-=pengurangan;
    }
    void setHrgBeli(int beli){
        this.hrg_beli=beli;
    }
    void setHrgJual(int jual){
        this.hrg_jual=jual;
    }
}
