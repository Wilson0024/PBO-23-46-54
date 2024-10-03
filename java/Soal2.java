/*
 * Anggota Kelompok :
 * - Wilson Angelie Tan (140810230024)
 * - Stan Fedheric (140810230046)
 * - Theopillus Samuel Ghozalli (140810230054)
 * 
 * Deskripsi : Soal 2 dalam Bahasa Pemograman Java
 */
import java.util.Scanner;

class Date{
    static Scanner sc = new Scanner(System.in);
    private int tanggal;
    private int bulan;
    private int tahun;

    public Date(){
        this.tanggal = 0;
        this.bulan = 0;
        this.tahun = 0;
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

    public void setTahun(){
        this.tahun = inputBatas("Tahun : ", 0, 200000);
    }

    public void setBulan(){
        this.bulan = inputBatas("Bulan (1-12): ", 1, 12);
    }

    public void setTanggal(){
        if(this.bulan == 2){
            if((this.tahun % 4 == 0 && this.tahun % 100 != 0) || (this.tahun % 400 == 0)){
                this.tanggal = inputBatas("tanggal (1-29) : ", 1, 29);
            } 
            else{
                this.tanggal = inputBatas("tanggal (1-28) : ", 1, 28);
            }
        } 
        else if((this.bulan % 2 == 1 && this.bulan <= 7) || (this.bulan % 2 == 0 && this.bulan <= 12 && this.bulan > 7)){
            this.tanggal = inputBatas("tanggal (1-31) : ", 1, 31);
        } 
        else{
            this.tanggal = inputBatas("tanggal (1-30) : ", 1, 30); 
        }
    }

    public void setBulan(int bulan) {
        this.bulan = bulan;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void setTanggal(int tanggal) {
        this.tanggal = tanggal;
    }

    public int getTahun() {
        return this.tahun;
    }

    public int getBulan() {
        return this.bulan;
    }

    public int getTanggal() {
        return this.tanggal;
    }
}

class Time{
    static Scanner sc = new Scanner(System.in);
    private int jam;
    private int detik;
    private int menit;

    public Time(){
        this.jam = 0;
        this.detik = 0;
        this.menit = 0;
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

    public void setJam(){
        this.jam = inputBatas("Masukkan Jam (0-23): ", 0, 23);
    }

    public void setMenit(){
        this.menit = inputBatas("Masukkan Menit (0-59): ", 0, 59);
    }

    public void setDetik(){
        this.detik = inputBatas("Masukkan Detik (0-59): ", 0, 59);
    }

    public void setDetik(int detik) {
        this.detik = detik;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    public void setMenit(int menit) {
        this.menit = menit;
    }    
    
    public int getDetik() {
        return this.detik;
    }

    public int getJam() {
        return this.jam;
    }

    public int getMenit() {
        return this.menit;
    }

}

class Waktu{
    static Scanner sc = new Scanner(System.in);
    private Time time;
    private Date date;

    public Waktu(){
        this.time = new Time();
        this.date = new Date();
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

    public void setTime(String s){
        System.out.println("\n\n\t" + s);
        System.out.println("=======================");

        time.setJam();
        time.setMenit();
        time.setDetik();
    }

    public void setDate(String s){
        System.out.println("\n\n\t" + s);
        System.out.println("=======================");

        date.setTahun();
        date.setBulan();
        date.setTanggal();
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getDaysInMonth(int bulan, int tahun) {
        switch (bulan) {
            case 2:
                if ((tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0)) {
                    return 29; // Februari pada tahun kabisat
                } else {
                    return 28; // Februari pada tahun biasa
                }
            case 4: case 6: case 9: case 11:
                return 30; // Bulan dengan 30 hari
            default:
                return 31; // Bulan dengan 31 hari
        }
    }

    public Waktu selisihWaktu(Waktu kedatangan) {
        Waktu selisih = new Waktu();
        
        // Hitung selisih detik
        int selisihDetik = kedatangan.getTime().getDetik() - this.getTime().getDetik();
        if (selisihDetik < 0) {
            selisihDetik += 60;
            kedatangan.getTime().setMenit(kedatangan.getTime().getMenit() - 1);
        }
        selisih.getTime().setDetik(selisihDetik);
    
        // Hitung selisih menit
        int selisihMenit = kedatangan.getTime().getMenit() - this.getTime().getMenit();
        if (selisihMenit < 0) {
            selisihMenit += 60;
            kedatangan.getTime().setJam(kedatangan.getTime().getJam() - 1);
        }
        selisih.getTime().setMenit(selisihMenit);
    
        // Hitung selisih jam
        int selisihJam = kedatangan.getTime().getJam() - this.getTime().getJam();
        if (selisihJam < 0) {
            selisihJam += 24;
            kedatangan.getDate().setTanggal(kedatangan.getDate().getTanggal() - 1);
        }
        selisih.getTime().setJam(selisihJam);
    
        // Hitung selisih tanggal
        int daysInMonth = getDaysInMonth(kedatangan.getDate().getBulan(), kedatangan.getDate().getTahun());
        int selisihTanggal = kedatangan.getDate().getTanggal() - this.getDate().getTanggal();
        if (selisihTanggal < 0) {
            selisihTanggal += daysInMonth;
            kedatangan.getDate().setBulan(kedatangan.getDate().getBulan() - 1);
        }
        selisih.getDate().setTanggal(selisihTanggal);
    
        // Hitung selisih bulan
        int selisihBulan = kedatangan.getDate().getBulan() - this.getDate().getBulan();
        if (selisihBulan < 0) {
            selisihBulan += 12;
            kedatangan.getDate().setTahun(kedatangan.getDate().getTahun() - 1);
        }
        selisih.getDate().setBulan(selisihBulan);
    
        // Hitung selisih tahun
        int selisihTahun = kedatangan.getDate().getTahun() - this.getDate().getTahun();
        selisih.getDate().setTahun(selisihTahun);
    
        return selisih;
    }
    
    
}

class Perjalanan {
    private Waktu keberangkatan;
    private Waktu kedatangan;
    private Waktu selisih;

    public Perjalanan(Waktu keberangkatan, Waktu kedatangan) {
        this.keberangkatan = keberangkatan;
        this.kedatangan = kedatangan;
        this.selisih = keberangkatan.selisihWaktu(kedatangan);
    }

    public void lamaPerjalanan() {
        // Akses date dan time melalui getter
        int tahun = selisih.getDate().getTahun();
        int bulan = selisih.getDate().getBulan();
        int tanggal = selisih.getDate().getTanggal();
        int jam = selisih.getTime().getJam();
        int menit = selisih.getTime().getMenit();
        int detik = selisih.getTime().getDetik();
    
        System.out.print("\nLama Perjalanan: ");
    
        if (tahun != 0) {
            System.out.print(tahun + " tahun ");
        }
        if (bulan != 0) {
            System.out.print(bulan + " bulan ");
        }
        if (tanggal != 0) {
            System.out.print(tanggal + " hari ");
        }
        if (jam != 0) {
            System.out.print(jam + " jam ");
        }
        if (menit != 0) {
            System.out.print(menit + " menit ");
        }
        if (detik != 0) {
            System.out.print(detik + " detik");
        }
        System.out.println();
    }
}


public class Soal2{
    public static void main(String[] args) {
        Waktu keberangkatan = new Waktu();
        Waktu kedatangan = new Waktu();

        keberangkatan.setDate("Tanggal berangkat");
        keberangkatan.setTime("Waktu berangkat");

        kedatangan.setDate("Tanggal Kedatangan");
        kedatangan.setTime("Waktu Kedatangan");

        Perjalanan perjalanan = new Perjalanan(keberangkatan, kedatangan);
        perjalanan.lamaPerjalanan();
    }
}