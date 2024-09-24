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

    
}