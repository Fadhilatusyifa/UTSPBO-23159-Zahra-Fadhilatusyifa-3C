/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservasi;

/**
 *
 * @author lala_
 */
// Class hotel untuk mengatur daftar kamar dan status pemesanan di hotel
public class Hotel {
     private Kamar[] daftarKamar;     // array untuk menyimpan daftar kamar di hotel
   
   
   // konstruktor hotel untuk membuat daftar kamar berdasarkan jumlah kamar yang diberikan
   public Hotel(int jumlahKamar){
    daftarKamar = new Kamar[jumlahKamar];   // inisialisai array daftarKamar dengan panjang sesuai jumlah kamar yang diberikan
    
    // mengisi array daftarKamar dengan objek Kamar baru
    for(int i = 0; i < jumlahKamar; i++){
        daftarKamar[i] = new Kamar(i + 1);   // memnuat kamar dengan nomor berurutan (dimmulai dari 1)
    }
   }
   
   // Method untuk menampilkan kamar yang tersedia (belum dipesan)
   public void cekKetersediaanKamar(){
       System.out.println("\n\n      Daftar Kamar Hotel ZAFA");
       System.out.println("+-----------------------------------+");
       System.out.println("|    Nomor Kamar   |     Status     |");
       System.out.println("+------------------+----------------+");
       
       // looping melalui setiap kamar di daftarKamar
       for (Kamar K : daftarKamar){
           if (!K.isDipesan()) {    // jika kamar belum dipesan, tampilkan status "Tersedia"
               System.out.println("|        " + K.getNomorKamar() + "         |    Tersedia    |");
           } else {
               // jika kamar sudah dipesan, tampilkan status "Dipesan"
               System.out.println("|        " + K.getNomorKamar() + "         |    Dipesan     |");
           }
       }
       System.out.println("+-----------------------------------+\n");
   }
   
   // method untuk menampilkan seluruh daftar kamar beserta statusnya, baik yang sudah dipesan maupun yang belum dipesan.
   public void lihatDaftarKamar(){
       System.out.println("\n\n      Daftar Kamar Hotel ZAFA");
       System.out.println("+-----------------------------------+");
       System.out.println("|    Nomor Kamar   |     Status     |");
       System.out.println("+------------------+----------------+");
       
       // loop untuk menampilkan informasi seluruh kamar dalam hotel
       for (Kamar K : daftarKamar){
           // menggunakan if-else untuk mengecek apakah kamar sudah dipesan atau belum
           if (K.isDipesan()){
               System.out.println("|        " + K.getNomorKamar() + "         |    Dipesan     |");
           } else {
               System.out.println("|        " + K.getNomorKamar() + "         |    Tersedia    |");
           }
       }
       
       System.out.println("+------------------+----------------+\n\n");
   }
   
   // method untuk memesan kamar berdasarkan nomor kamar yang diberikan
   public void pesanKamar(int nomor){
       // mengecek apakah nomot kamar valid dan apakah kamar belum dipesan
       if (nomor > 0 && nomor <= daftarKamar.length && !daftarKamar[nomor - 1].isDipesan()){
           daftarKamar[nomor - 1].setDipesan(true);   // set status kamar menjadi dipesan (true)
           System.out.println("\n+----------------------------------------------------+");
           System.out.println("     Terima Kasih, Kamar No " + nomor + " berhasil dipesan.                  |"); // konfirmasi pesanan 
       } else {
           // jika kamar sudah dipesan atau nomor kamar tidak valid, tampilkan pesan "kamar tidak tersedia atau sudah dipesan."
           System.out.println("+----------------------------------------------------+");
           System.out.println("|       Kamar tidak tersedia atau sudah dipesan.     |");
       }
       System.out.println("+----------------------------------------------------+\n");
   }
   
   // method untuk membatalkan pemesanan kamar
   public void batalkanPesanan(int nomor){
       // Mengecek apakah nomor kamar valid dan sudah dipesan
       if (nomor > 0 && nomor <= daftarKamar.length && daftarKamar[nomor -1].isDipesan()){
           daftarKamar[nomor - 1].setDipesan(false);  // set status kamar menjadi belum dipesan (false)
           System.out.println("+----------------------------------------------------+");
           System.out.println("     Pesanan Kamar No " + nomor + " telah dibatalkan.  ");
       } else {
           // jika kamar belum dipesan atau nomor kamar tidak valid, tampilkan pesan kesalahan
           System.out.println("+----------------------------------------------------+");
           System.out.println("| Kamar belum dipesan atau nomor kamar tidak valid.  |");
       }
       
       System.out.println("+----------------------------------------------------+\n");
   }
}


