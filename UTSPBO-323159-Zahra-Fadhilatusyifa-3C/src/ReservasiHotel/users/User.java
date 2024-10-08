/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReservasiHotel.users;

/**
 *
 * @author lala_
 */
// class user sebagai superclass untuk Customer dan Admin (Inheritance)
public abstract class User {
    protected String username;  // Atribut untuk menyimpan nama pengguna (protected agar bisa diakses oleh subclass)
    protected String kataSandi; // atribut katasandi pengguna, hanya bisa diakses oleh subclass
    
    // konstruktor untuk menginisialisasi nama pengguna dan kata sandi saat objek user dibuat.
    public User(String username, String kataSandi){
        this.username = username;
        this.kataSandi = kataSandi;
    }
    
    public String getUsername(){
        return username; // getter untuk nama pengguna
    }
    
    public String getKatSan(){
        return kataSandi;
    }

    
    // method abstrak yang harus diimplementasikan oleh subclass
    public abstract void tampilkanInfo();
    
}

