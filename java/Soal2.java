import java.util.Scanner;

class Waktu{
    static Scanner sc = new Scanner(System.in);
    private int hari;
    private int bulan;
    private int tahun;
    private int jam;
    private int detik;
    private int menit;

    public Waktu(){
        this.hari = 0;
        this.bulan = 0;
        this.tahun = 0;
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

    public void setTahun(){
        this.tahun = inputBatas("Tahun : ", 0, 200000);
    }

    public void setBulan(){
        this.bulan = inputBatas("Bulan (1-12): ", 1, 12);
    }

    public void setHari(){
        if(this.bulan == 2){
            if((this.tahun % 4 == 0 && this.tahun % 100 != 0) || (this.tahun % 400 == 0)){
                this.hari = inputBatas("Hari (1-29) : ", 1, 29);
            } 
            else{
                this.hari = inputBatas("Hari (1-28) : ", 1, 28);
            }
        } 
        else if((this.bulan % 2 == 1 && this.bulan <= 7) || (this.bulan % 2 == 0 && this.bulan <= 12 && this.bulan > 7)){
            this.hari = inputBatas("Hari (1-31) : ", 1, 31);
        } 
        else{
            this.hari = inputBatas("Hari (1-30) : ", 1, 30); 
        }
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
    

    public int getBulan() {
        return this.bulan;
    }

    public int getDetik() {
        return this.detik;
    }

    public int getHari() {
        return this.hari;
    }

    public int getJam() {
        return this.jam;
    }

    public int getMenit() {
        return this.menit;
    }

    public int getTahun() {
        return this.tahun;
    }

    public Waktu selisihWaktu(Waktu kedatangan) {
        Waktu selisih = new Waktu();

        // Selisih Detik
        if (kedatangan.detik < this.detik) {
            selisih.menit -= 1;
            selisih.detik = 60 + kedatangan.detik - this.detik;
        } else {
        selisih.detik = kedatangan.detik - this.detik;
        }

        // Selisih Menit
        if (kedatangan.menit + selisih.menit < this.menit) {
            selisih.jam -= 1;
            selisih.menit += 60 + kedatangan.menit - this.menit;
        } else {
            selisih.menit += kedatangan.menit - this.menit;
        }

        // Selisih Jam
        if (kedatangan.jam + selisih.jam < this.jam) {
            selisih.hari -= 1;
            selisih.jam += 24 + kedatangan.jam - this.jam;
        } else {
            selisih.jam += kedatangan.jam - this.jam;
        }

        // Selisih Hari
        // Bulan Kedatangan + 1 supaya dapat mengambil banyak hari dalam bulan kedua pada tahun tertentu
        if(kedatangan.bulan == 3){
            // Bulan kedua pada saat tahun kabisat
            if((kedatangan.tahun % 4 == 0 && kedatangan.tahun % 100 != 0) || (kedatangan.tahun % 400 == 0) && (kedatangan.hari + selisih.hari < this.hari)){
                selisih.bulan -= 1;
                selisih.hari += 29 + kedatangan.hari - this.hari;
            } 
            // Bulan kedua pada biasanya
            else{
                selisih.bulan -= 1;
                selisih.hari += 28 + kedatangan.hari - this.hari;
            }
        } 
        // Mencari 31 hari pada bulan tertentu (1,3,5,7,8,10,12)
        else if((kedatangan.bulan % 2 == 0 && kedatangan.bulan <= 7) || (kedatangan.bulan % 2 == 1 && kedatangan.bulan <= 12 && (kedatangan.bulan > 7 || kedatangan.bulan == 1)) && (kedatangan.hari + selisih.hari < this.hari)){
            selisih.bulan -= 1;
            selisih.hari += 31 + kedatangan.hari - this.hari;
        } 
        // Mencari 30 hari pada bulan tertentu (4,6,9,11)
        else if(kedatangan.hari + selisih.hari < this.hari){
            selisih.bulan -= 1;
            selisih.hari += 30 + kedatangan.hari - this.hari; 
        }
        else {
            selisih.hari += kedatangan.hari - this.hari;
        }        

        // Selisih Bulan
        if (kedatangan.bulan + selisih.bulan < this.bulan) {
            selisih.tahun -= 1;
            selisih.bulan += 12 + kedatangan.bulan - this.bulan;
        } else {
            selisih.bulan += kedatangan.bulan - this.bulan;
        }

        // Selisih Tahun
        // Error handling ketika kedatangan.tahun < this.tahun belum ada
        selisih.tahun += kedatangan.tahun - this.tahun;

        return selisih;
    }
}