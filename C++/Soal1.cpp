/*
 * Anggota Kelompok :
 * - Wilson Angelie Tan (140810230024)
 * - Stan Fedheric (140810230046)
 * - Theopillus Samuel Ghozalli (140810230054)
 * 
 * Deskripsi : Soal 1 dalam Bahasa Pemograman C++
 */
#include <iostream>
using namespace std;

class Waktu {
    private:
        int jam, menit, detik;

    public:
        Waktu() {
            jam = 0;
            menit = 0;
            detik = 0;
        }

        void setJam() {
            jam = inputBatas("Masukkan Jam (0-23): ", 0, 23);
        }

        void setMenit() {
            menit = inputBatas("Masukkan Menit (0-59): ", 0, 59);
        }

        void setDetik() {
            detik = inputBatas("Masukkan Detik (0-59): ", 0, 59);
        }

        int inputBatas(string kata, int min, int max) {
            int data;
            do {
                cout << kata;
                cin >> data;
            } while (data < min || data > max);
            return data;
        }

        int getDetik() {
            return detik;
        }

        int getJam() {
            return jam;
        }

        int getMenit() {
            return menit;
        }

        void selisihWaktu(Waktu mulai, Waktu selesai) {
            if(selesai.detik - mulai.detik < 0) {
                menit -= 1;
                detik += selesai.detik - mulai.detik;
            }
            else{
                detik += selesai.detik - mulai.detik;
            }

            if(selesai.menit - mulai.menit < 0) {
                jam -= 1;
                menit += selesai.menit - mulai.menit;
            }
            else{
                menit += selesai.menit - mulai.menit;
            }

            jam = selesai.jam - mulai.jam;

            if(jam < 0){
                jam += 24;
            }
        }

        float lamaLari() {
            return (jam * 60) + menit + (float)detik/60;
        }

};

class UjianTPB{
    private:
        string nama, npm;
        Waktu mulai, selesai;

    public:
        UjianTPB(){
            nama = "";
            npm = "";
        }

        void setNama(){
            cout << "Masukkan Nama : ";
            cin >> nama;
        }
        

        void setMulai(){
            cout << "\n\n\tJam Mulai" << endl;
            cout << "=======================" << endl;

            mulai.setJam();
            mulai.setMenit();
            mulai.setDetik();            
        }

        void setSelesai(){
            cout << "\n\n\tJam Selesai" << endl;
            cout << "=======================" << endl;

            selesai.setJam();
            selesai.setMenit();
            selesai.setDetik();            
        }

        void setNpm(){
            cout << "Masukkan NPM : ";
            cin >> npm;
        }

        string getNama(){
            return nama;
        }

        string getNpm(){
            return npm;
        }  

        Waktu getMulai() {
            return mulai;
        }

        Waktu getSelesai() {
            return selesai;
        }

        char HurufMutu(float lamaLari) {
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

        string status(char HurufMutu) {
            if(HurufMutu == 'A' || HurufMutu == 'B' || HurufMutu == 'C'){
                return "Lulus";
            }
            else {
                return "Gagal";
            }
        }

        void tampilan() {
            Waktu selisih;
            selisih.selisihWaktu(mulai, selesai);
            
            cout << "\n\n\tOUTPUT" << endl;
            cout << "===========================" << endl;
            cout << "Nama : " << nama << endl;
            cout << "NPM : " << npm << endl;
            cout << "Huruf Mutu : " << HurufMutu(selisih.lamaLari()) << endl;
            cout << "Status : " << status(HurufMutu(selisih.lamaLari())) << endl;
            cout << "Waktu Mulai : " << mulai.getJam() << ":" << mulai.getMenit() << ":" << mulai.getDetik() << endl;
            cout << "Waktu Selesai : " << selesai.getJam() << ":" << selesai.getMenit() << ":" << selesai.getDetik() << endl;
            cout << "Lama Lari : " << selisih.lamaLari() << " Menit\n\n";
        }
};



void Menu(){
        UjianTPB dataMhs;
        
        dataMhs.setNama(); //set nama
        dataMhs.setNpm();  // set npm
        dataMhs.setMulai();
        dataMhs.setSelesai();
        dataMhs.tampilan();
    }

int main(){
    Menu();
}