/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReservasiHotel.users;
import Reservasi.Hotel;
/**
 *
 * @author lala_
 */
// class customer yang mengimplementasikan interface DetailPesanan
public class Customer extends User implements DetailPesanan {
    private int nomorKamarDipesan = -1;
    
    
    public Customer(String username, String kataSandi){
        super(username, kataSandi);
    }
    
    @Override
    public void LihatDetailPesanan(){
        if (nomorKamarDipesan != -1){
            System.out.println("\nDetail Pesanan : ");
            System.out.println("+----------------------------------------------------+");
            System.out.println("          Anda telah memesan kamar no : " + nomorKamarDipesan);
        } else {
            System.out.println("+----------------------------------------------------+");
            System.out.println("|            belum ada kamar yang dipesan.           |");
        }
         System.out.println("+----------------------------------------------------+\n\n");
    }
    
    public void setnomorKamarDipesan(int nomorKamar){
        this.nomorKamarDipesan = nomorKamar;
    }
    
    @Override
    public void tampilkanInfo(){
        System.out.println("HALLO " + getUsername() + "!");
    }
}
