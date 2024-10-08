/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservasi;

/**
 *
 * @author lala_
 */
public class Kamar {
    private int nomorKamar;     // atribut untuk menyimpan nomor kamar
    private boolean dipesan;    // atribut untuk menandakan apakah kamar sudah dipesan 
    
    //konstruktor kamar untuk menginisialisasi objek kamar dengan nomor kamar tertentu.
    public Kamar(int nomor){
        this.nomorKamar = nomor;   // set nomor kamar sesuai dengan nilai yang diberikan
        this.dipesan = false;      // set awal status kamar menjadi belum dipesan (false)
    }
    
    // mengembalikan nomor kamar
    public int getNomorKamar(){
        return nomorKamar;
    }
   
    // mengecek apakah kamar sudah dipesan atau belum
    public boolean isDipesan(){
        return dipesan;
    }
    
    // mengubah status pemesanan kamar
    // true artinya kamar dipesan, false artinya tidak dipesan.
    public void setDipesan(boolean dipesan){
        this.dipesan = dipesan;
    }
}
