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
// Class Admin yang bisa mengakses fitur tambahan seperti melihat dan mengatur status kamar
public class Admin extends User {
    
    // konstruktor Admin untuk inisialisasi nama Admin
    public Admin(String username, String kataSandi){
        super(username, kataSandi);
    }
    
    //method untuk melihat daftar kamar yang ada di hotel (untuk admin)
    public void lihatDaftarKamar(Hotel hotel){
        hotel.lihatDaftarKamar();   // memanggil method lihatDaftarKamar dari class Hotel
    }
    
    //method untuk membatalkan pesanan kamar 
    public void batalkanPesanan(Hotel hotel, int nomorKamar){
        hotel.batalkanPesanan(nomorKamar);   // memanggil method batalkanPesanan dari class Hotel
    }
    
    // implementasi method dari superclass User
    @Override
    public void tampilkanInfo(){
        System.out.println("HALLO " + getUsername() + "!");
    }
    
}
