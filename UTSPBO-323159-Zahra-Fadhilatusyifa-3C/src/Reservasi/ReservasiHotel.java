/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Reservasi;
import ReservasiHotel.users.*;
import java.util.Scanner;
/**
 *
 * @author lala_
 */
public class ReservasiHotel {
    private static User[] pengguna = new User[100]; 
    private static int jumlahPengguna = 0;

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Hotel hotel = new Hotel(8);
        
        while(true){
            System.out.println("\n+========================================================+");
            System.out.println("|    SELAMAT DATANG DI APLIKASI RESERVASI HOTEL ZAFA!    |");
            System.out.println("+========================================================+");
            System.out.println("1. Daftar Akun");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan anda :  ");
            int pil = input.nextInt();
            input.nextLine();
           
            switch (pil) {
                case 1:
                System.out.println("\n+========================================================+");
                System.out.print("Masukkan username   : ");
                String username = input.nextLine();
                System.out.print("Masukkan Kata Sandi : ");
                String kataSandi = input.nextLine();
                System.out.print("Masuk sebagai (Admin / Customer) : ");
                String peran = input.nextLine();
               
                if(peran.equalsIgnoreCase("Admin")){
                    pengguna[jumlahPengguna++] = new Admin(username, kataSandi);
                    System.out.println("+========================================================+");
                    System.out.println("|       Selamat Akun Admin Anda Berhasil Dibuat!         |");
                    System.out.println("+========================================================+\n");
                } else if (peran.equalsIgnoreCase("Customer")){
                    pengguna[jumlahPengguna++] = new Customer(username, kataSandi);
                    System.out.println("+========================================================+");
                    System.out.println("|       Selamat Akun Customer Anda Berhasil Dibuat!      |");
                    System.out.println("+========================================================+\n");
                } else {
                    System.out.println("+========================================================+");
                    System.out.println("       pilihan anda tidak valid. Silahkan Coba lagi.     |");
                    System.out.println("+========================================================+\n");
                } 
                break;
               
                case 2:
                System.out.println("\n+========================================================+");
                System.out.print("Masukkan username   : ");
                String loginNama = input.nextLine();
                System.out.print("Masukkan Kata Sandi : ");
                String loginKatsan = input.nextLine();
                System.out.println("+========================================================+");
                
                User user = null; 
                for (int i = 0; i < jumlahPengguna; i++){
                    if (pengguna[i].getUsername().equals(loginNama) && pengguna[i].getKatSan().equals(loginKatsan)) {
                        user = pengguna[i];
                        break;
                    }
                }
                
                if (user != null){
                    System.out.println("|                     Login berhasil!                    |");
                    System.out.println("+========================================================+\n");
                   
                    
                    if (user instanceof Admin){
                        Admin admin = (Admin) user;
                        while(true) {
                            user.tampilkanInfo();
                            System.out.println("+=========================+");
                            System.out.println("|1. Lihat Daftar Kamar    |");
                            System.out.println("|2. Batalkan Pesanan      |");
                            System.out.println("|3. Logout                |");
                            System.out.println("+=========================+");
                            System.out.print("Masukkkan pilihan anda (1-3) : ");
                            int adminPil = input.nextInt();
                            
                            switch (adminPil){
                                case 1:
                                    admin.lihatDaftarKamar(hotel);
                                    break;
                                case 2:
                                    System.out.println("\n\n              Pembatalan Pesanan Kamar");
                                    System.out.println("+----------------------------------------------------+");
                                    System.out.print(" Masukkan nomor kamar yang ingin dibatalkan : ");
                                    int nomorKamar = input.nextInt();
                                    admin.batalkanPesanan(hotel, nomorKamar);
                                    break;
                                case 3: 
                                    System.out.println("+========================================================+");
                                    System.out.println("|                     Anda telah Logout                  |");
                                    System.out.println("+========================================================+\n");
                                    break;
                                default:
                                   System.out.println("+========================================================+");
                                   System.out.println("|        Pilihan yang anda masukkan tidak valid.         |");
                                   System.out.println("+========================================================+\n");
                            }
                            if (adminPil == 3) break;
                        }
                    } else if (user instanceof Customer){
                        Customer cus = (Customer) user;
                        while (true){
                            user.tampilkanInfo();
                            System.out.println("+============================+");
                            System.out.println("|1. Cek ketersediaan Kamar   |");
                            System.out.println("|2. Pesan Kamar              |");
                            System.out.println("|3. Lihat Detail Pesanan     |");
                            System.out.println("|4. Logout                   |");
                            System.out.println("+============================+");
                            System.out.print("Masukkan pilihan Anda (1-4) : ");
                            int customerPil = input.nextInt();
                            
                            switch (customerPil){
                                case 1:
                                    hotel.cekKetersediaanKamar();
                                    break;
                                case 2:
                                    System.out.println("\n\n                Pemesanan Kamar");
                                    System.out.println("+----------------------------------------------------+");
                                    System.out.print(" Masukkan nomor kamar yang ingin dipesan  : ");
                                    int nomorKamarPesan = input.nextInt();
                                    hotel.pesanKamar(nomorKamarPesan);
                                    cus.setnomorKamarDipesan(nomorKamarPesan);
                                    break;
                                case 3:
                                    cus.LihatDetailPesanan();
                                    break;
                                case 4:
                                    System.out.println("+========================================================+");
                                    System.out.println("|                     Anda telah Logout                  |");
                                    System.out.println("+========================================================+\n");
                                    break;
                                default:
                                   System.out.println("+========================================================+");
                                   System.out.println("|        Pilihan yang anda masukkan tidak valid.         |");
                                   System.out.println("+========================================================+\n");
                            } 
                            if (customerPil == 4) break; 
                        }
                    }
                } else {
                    System.out.println("\n+=================================================================+");
                    System.out.println("| Login gagal. username atau kata sandi yang anda masukkan salah  |");
                    System.out.println("+=================================================================+\n\n");
                }
                break;
                
                case 3:
                    System.out.println("+========================================================+");
                    System.out.println("|     Terima Kasih telah menggunakan aplikasi ini        |");
                    System.out.println("+========================================================+\n\n");
                    input.close();
                    return;
                    
                default:
                    System.out.println("+========================================================+");
                    System.out.println("|        Pilihan yang anda masukkan tidak valid.         |");
                    System.out.println("+========================================================+\n\n");
                    break;
            }       
            
            
        }
    }
    
}
    