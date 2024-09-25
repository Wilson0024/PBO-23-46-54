/*
 * Anggota Kelompok :
 * - Wilson Angelie Tan (140810230024)
 * - Stan Fedheric (140810230046)
 * - Theopillus Samuel Ghozalli (140810230054)
 * 
 * Deskripsi : Soal 1 dalam Bahasa Pemograman Java
 */
import java.util.Scanner;
class Waktu{
    static Scanner sc = new Scanner(System.in);

    private String nama;
    private String npm;
    private int jam;
    private int menit;
    private int detik;

    public Waktu(){
        this.nama = "";
        this.npm = "";
        this.jam = 0;
        this.menit = 0;
        this.detik = 0;
    }

    public void setNama(){
        System.out.print("Masukkan Nama : ");
        this.nama = sc.nextLine();
    }

    public void setNpm(){
        System.out.print("Masukkan NPM : ");
        this.npm = sc.nextLine();
    }

    public void setJam(){
        this.jam = inputBatas("Masukkan Jam (0-23): ", 0, 23);
    }

    public void setMenit(){
        this.menit = inputBatas("Masukkan Menit (0-59): ", 0, 59);

    }

    public void setDetik(){
        this.detik = inputBatas("Masukkan Detik (0-59): ", 0, 59);

    }

    public int inputBatas(String kata, int min, int max){
        int data;
        do{
            System.out.print(kata);
            data = Integer.parseInt(sc.nextLine());
        }
        while(data < min || data > max);
        return data;
    }

    public int getDetik(){
        return this.detik;
    }

    public int getJam(){
        return this.jam;
    }

    public int getMenit(){
        return this.menit;
    }

    public String getNama(){
        return this.nama;
    }

    public String getNpm(){
        return this.npm;
    }

    public float lamaLari(Waktu selesai){
        float ja = selesai.jam - this.jam;
        ja = (ja < 0)? ja+24 : ja;
        float totalMenit = ja*60 + (selesai.menit - this.menit) + (float)(selesai.detik - this.detik)/60;
        return totalMenit;
    }

    public char HurufMutu(float lamaLari){
        if(lamaLari >= 0 && lamaLari < 7.5){
            return 'A';
        }
        else if(lamaLari >= 7.5 && lamaLari < 12.5){
            return 'B';
        }
        else if(lamaLari >= 12.5 && lamaLari < 30){
            return 'C';
        }
        else{
            return 'D';
        }
    }

    public String status(char HurufMutu){
        if(HurufMutu == 'A' || HurufMutu == 'B' || HurufMutu == 'C'){
            return "Lulus";
        }
        else{
            return "Gagal";
        }
    }

    // Tampilkan  Nama, NPM, HM, status lulus, waktu mulai, waktu selesai dan lama lari
    public void tampilan(Waktu selesai){
        System.out.println("\n\nNama : " + this.nama);
        System.out.println("NPM : " + this.npm);
        System.out.println("Huruf Mutu : " + HurufMutu(lamaLari(selesai)));
        System.out.println("Status : " + status(HurufMutu(lamaLari(selesai))));
        System.out.println("Waktu Mulai : " + this.jam + ":" + this.menit + ":" + this.detik);
        System.out.println("Waktu Selesai : " + selesai.jam + ":" + selesai.menit + ":" + selesai.detik);
        System.out.println("Lama Lari : " + lamaLari(selesai) + " Menit\n\n");
        sc.close();
    }
}

public class Soal1 {
    public static void main(String[] args) {
        Waktu dataMhs = new Waktu();
        Waktu selesai = new Waktu();

        dataMhs.setNama();
        dataMhs.setNpm();
        
        System.out.println("\n\n\tJam Mulai");
        System.out.println("=======================");

        dataMhs.setJam();
        dataMhs.setMenit();
        dataMhs.setDetik();


        System.out.println("\n\n\tJam Selesai");
        System.out.println("=======================");

        selesai.setJam();
        selesai.setMenit();
        selesai.setDetik();
        
        dataMhs.tampilan(selesai);
    }
}
