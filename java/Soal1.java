import java.util.Scanner;
class Waktu{
    static Scanner sc = new Scanner(System.in);

    private String nama;
    private String npm;
    private int jamMulai, jamSelesai;
    private int menitMulai , menitSelesai;
    private int detikMulai, detikSelesai;

    public Waktu(){
        this.nama = "";
        this.npm = "";
        this.jamMulai = 0;
        this.menitMulai = 0;
        this.detikMulai = 0;
        this.jamSelesai = 0;
        this.menitSelesai = 0;
        this.detikSelesai = 0;
    }

    public void setNama(){
        System.out.print("Masukkan Nama : ");
        this.nama = sc.nextLine();
    }

    public void setNpm(){
        System.out.print("Masukkan NPM : ");
        this.npm = sc.nextLine();
    }

    public void setJamMulai(){
        this.jamMulai = inputBatas("Masukkan Jam Mulai (0-23): ", 0, 23);
    }

    public void setMenitMulai(){
        this.menitMulai = inputBatas("Masukkan Menit Mulai (0-59): ", 0, 59);

    }

    public void setDetikMulai(){
        this.detikMulai = inputBatas("Masukkan Detik Mulai (0-59): ", 0, 59);

    }

    public void setJamSelesai(){
        this.jamSelesai = inputBatas("Masukkan Jam Selesai (0-23): ", 0, 23);

    }

    public void setMenitSelesai(){
        this.menitSelesai = inputBatas("Masukkan Menit Selesai (0-59): ", 0, 59);

    }

    public void setDetikSelesai(){
        this.detikSelesai = inputBatas("Masukkan Detik Selesai (0-59): ", 0, 59);
        
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

    public int getDetikMulai(){
        return this.detikMulai;
    }

    public int getJamMulai(){
        return this.jamMulai;
    }

    public int getMenitMulai(){
        return this.menitMulai;
    }

    public int getDetikSelesai(){
        return this.detikSelesai;
    }

    public int getJamSelesai(){
        return this.jamSelesai;
    }

    public int getMenitSelesai(){
        return this.menitSelesai;
    }

    public String getNama(){
        return this.nama;
    }

    public String getNpm(){
        return this.npm;
    }

    public float lamaLari(){
        float totalMenit = (this.jamSelesai - this.jamMulai)*60 + (this.menitSelesai - this.menitMulai) + (float)(this.detikSelesai - this.detikMulai)/60;
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
        if(HurufMutu == 'A'){
            return "Lulus";
        }
        else if(HurufMutu == 'B'){
            return "Lulus";
        }
        else if(HurufMutu == 'C'){
            return "Lulus";
        }
        else{
            return "Gagal";
        }
    }

    // Tampilkan  Nama, NPM, HM, status lulus, waktu mulai, waktu selesai dan lama lari
    public void tampilan(){
        System.out.println("\n\nNama : " + this.nama);
        System.out.println("NPM : " + this.npm);
        System.out.println("Huruf Mutu : " + HurufMutu(lamaLari()));
        System.out.println("Status : " + status(HurufMutu(lamaLari())));
        System.out.println("Waktu Mulai : " + this.jamMulai + ":" + this.menitMulai + ":" + this.detikMulai);
        System.out.println("Waktu Selesai : " + this.jamSelesai + ":" + this.menitSelesai + ":" + this.detikSelesai);
        System.out.println("Lama Lari : " + lamaLari() + " Menit\n\n");
    }
}

public class Soal1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Waktu dataMhs = new Waktu();

        dataMhs.setNama();
        dataMhs.setNpm();
        
        System.out.println("\n\n\tJam Mulai");
        System.out.println("=======================");

        
        dataMhs.setJamMulai();
        dataMhs.setMenitMulai();
        dataMhs.setDetikMulai();


        System.out.println("\n\n\tJam Selesai");
        System.out.println("=======================");

        dataMhs.setJamSelesai();
        dataMhs.setMenitSelesai();
        dataMhs.setDetikSelesai();
        
        dataMhs.tampilan();
        sc.close();
    }
}
