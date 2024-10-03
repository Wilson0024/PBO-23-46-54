import java.util.Scanner;

class UjianTPB{
    static Scanner sc = new Scanner(System.in);

    private String nama;
    private String npm;
    private Waktu mulai;
    private Waktu selesai;


    public UjianTPB(){
        this.nama = "";
        this.npm = "";
        this.mulai = new Waktu();
        this.selesai = new Waktu();
    }

    public void setNama(){
        System.out.print("Masukkan Nama : ");
        this.nama = sc.nextLine();
    }

    public void setMulai() {
        System.out.println("\n\n\tJam Mulai");
        System.out.println("=======================");

        // set jam menit detik mulai
        mulai.setJam(); 
        mulai.setMenit();
        mulai.setDetik();
    }

    public void setSelesai() {
        System.out.println("\n\n\tJam Selesai");
        System.out.println("=======================");

        // set jam menit detik selesai
        selesai.setJam();
        selesai.setMenit();
        selesai.setDetik();
    }

    public void setNpm(){
        System.out.print("Masukkan NPM : ");
        this.npm = sc.nextLine();
    }

    public String getNama(){
        return this.nama;
    }

    public String getNpm(){
        return this.npm;
    }  

    public Waktu getMulai() {
        return mulai;
    }

    public Waktu getSelesai() {
        return selesai;
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
    public void tampilan(){
        Waktu selisih = new Waktu();// nyimpen lama waktu lari
        selisih.selisihWaktu(this.mulai, this.selesai);

        System.out.println("\n\n\tOUTPUT");
        System.out.println("===========================");
        System.out.println("Nama : " + this.nama);
        System.out.println("NPM : " + this.npm);
        System.out.println("Huruf Mutu : " + HurufMutu(selisih.lamaLari()));
        System.out.println("Status : " + status(HurufMutu(selisih.lamaLari())));
        System.out.println("Waktu Mulai : " + mulai.getJam() + ":" + mulai.getMenit() + ":" + mulai.getDetik());
        System.out.println("Waktu Selesai : " + selesai.getJam() + ":" + selesai.getMenit() + ":" + selesai.getDetik());
        System.out.println("Lama Lari : " + selisih.lamaLari() + " Menit\n\n");
    }
}

class Waktu{
    static Scanner sc = new Scanner(System.in);

    private int jam;
    private int menit;
    private int detik;

    public Waktu(){
        this.jam = 0;
        this.menit = 0;
        this.detik = 0;
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

    public void selisihWaktu(Waktu mulai, Waktu selesai){
        if(selesai.detik - mulai.detik < 0){
            this.menit -= 1;
            this.detik = selesai.detik - mulai.detik + 60;
        }
        else{
            this.detik = selesai.detik - mulai.detik;
        }
        
        if(selesai.menit - mulai.menit < 0){
            this.jam -= 1;
            this.menit += selesai.menit - mulai.menit + 60;
        }
        else{
            this.menit += selesai.menit - mulai.menit;
        }

        this.jam += selesai.jam - mulai.jam;
        
        if(this.jam < 0){
            this.jam += 24;
        }
    }

    public float lamaLari(){
        return (this.jam * 60) + this.menit + (float)this.detik/60;
    }
}

public class Soal1 {
    static void Menu(){
        UjianTPB dataMhs = new UjianTPB();
        
        dataMhs.setNama(); //set nama
        dataMhs.setNpm();  // set npm
        dataMhs.setMulai();
        dataMhs.setSelesai();
        dataMhs.tampilan();
    }
    public static void main(String[] args) {
        Menu();
    }
}
