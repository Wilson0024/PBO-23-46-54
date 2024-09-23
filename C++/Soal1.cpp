#include <iostream>
using namespace std;

class Waktu {
    private:
        string nama, npm;
        int jam, menit, detik;

    public:
        Waktu() {
            nama = "";
            npm = "";
            jam = 0;
            menit = 0;
            detik = 0;
        }

        void setNama() {
            cout << "Masukkan Nama : ";
            cin >> nama;
        }

        void setNpm() {
            cout << "Masukkan NPM : ";
            cin >> npm;
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

        string getNama() {
            return nama;
        }

        string getNpm() {
            return npm;
        }

        float lamaLari(Waktu selesai) {
            float ja = selesai.jam - jam;
            ja = (ja < 0)? ja+24 : ja;
            float totalMenit = ja*60 + (selesai.menit - menit) + (float)(selesai.detik - detik)/60;
            return totalMenit;
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

        void tampilan(Waktu selesai) {
            cout << "\n\nNama : " << nama << "\n";
            cout << "NPM : " << npm << "\n";
            cout << "Huruf Mutu : " << HurufMutu(lamaLari(selesai)) << "\n";
            cout << "Status : " << status(HurufMutu(lamaLari(selesai))) << "\n";
            cout << "Waktu Mulai : " << jam << ":" << menit << ":" << detik << "\n";
            cout << "Waktu Selesai : " << selesai.jam << ":" << selesai.menit << ":" << selesai.detik << "\n";
            cout << "Lama Lari : " << lamaLari(selesai) << " Menit\n\n";
        }
};

int main() {
    Waktu dataMhs;
    Waktu selesai;

    dataMhs.setNama();
    dataMhs.setNpm();

    cout << "\n\nJam Mulai\n";
    cout << "=======================\n";

    dataMhs.setJam();
    dataMhs.setMenit();
    dataMhs.setDetik();

    cout << "\n\nJam Selesai\n";
    cout << "=======================\n";

    selesai.setJam();
    selesai.setMenit();
    selesai.setDetik();

    dataMhs.tampilan(selesai);
}