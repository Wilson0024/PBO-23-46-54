/*
 * Anggota Kelompok :
 * - Wilson Angelie Tan (140810230024)
 * - Stan Fedheric (140810230046)
 * - Theopillus Samuel Ghozalli (140810230054)
 * 
 * Deskripsi : Soal 2 dalam Bahasa Pemograman C++
 */

#include <iostream>
using namespace std;

class Waktu {
private:
    int hari, bulan, tahun, jam, menit, detik;

public:
    Waktu() : hari(0), bulan(0), tahun(0), jam(0), menit(0), detik(0) {}

    int inputBatas(string pesan, int min, int max) {
        int data;
        do {
            cout << pesan;
            cin >> data;
        } while (data < min || data > max);
        return data;
    }

    void setTahun() {
        tahun = inputBatas("Tahun: ", 0, 200000);
    }

    void setBulan() {
        bulan = inputBatas("Bulan (1-12): ", 1, 12);
    }

    void setHari() {
        if (bulan == 2) {
            if ((tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0)) {
                hari = inputBatas("Hari (1-29): ", 1, 29);
            } else {
                hari = inputBatas("Hari (1-28): ", 1, 28);
            }
        } else if ((bulan % 2 == 1 && bulan <= 7) || (bulan % 2 == 0 && bulan >= 8)) {
            hari = inputBatas("Hari (1-31): ", 1, 31);
        } else {
            hari = inputBatas("Hari (1-30): ", 1, 30);
        }
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

    Waktu selisihWaktu(Waktu kedatangan) {
        Waktu selisih;

        if (kedatangan.detik < detik) {
            kedatangan.menit--;
            selisih.detik = 60 + kedatangan.detik - detik;
        } else {
            selisih.detik = kedatangan.detik - detik;
        }

        if (kedatangan.menit < menit) {
            kedatangan.jam--;
            selisih.menit = 60 + kedatangan.menit - menit;
        } else {
            selisih.menit = kedatangan.menit - menit;
        }

        if (kedatangan.jam < jam) {
            kedatangan.hari--;
            selisih.jam = 24 + kedatangan.jam - jam;
        } else {
            selisih.jam = kedatangan.jam - jam;
        }

        if (kedatangan.hari < hari) {
            kedatangan.bulan--;
            if (kedatangan.bulan == 2) {
                if ((kedatangan.tahun % 4 == 0 && kedatangan.tahun % 100 != 0) || (kedatangan.tahun % 400 == 0)) {
                    kedatangan.hari += 29;
                } else {
                    kedatangan.hari += 28;
                }
            } else if ((kedatangan.bulan % 2 == 1 && kedatangan.bulan <= 7) || (kedatangan.bulan % 2 == 0 && kedatangan.bulan >= 8)) {
                kedatangan.hari += 31;
            } else {
                kedatangan.hari += 30;
            }
        }
        selisih.hari = kedatangan.hari - hari;

        if (kedatangan.bulan < bulan) {
            kedatangan.tahun--;
            kedatangan.bulan += 12;
        }
        selisih.bulan = kedatangan.bulan - bulan;

        selisih.tahun = kedatangan.tahun - tahun;

        return selisih;
    }

    void tampilkanSelisih() {
        cout << tahun << " tahun " << bulan << " bulan " << hari << " hari "
             << jam << " jam " << menit << " menit " << detik << " detik" << endl;
    }
};

int main() {
    Waktu t1, t2, selisih;

    cout << "Berangkat:\n";
    t1.setTahun();
    t1.setBulan();
    t1.setHari();
    t1.setJam();
    t1.setMenit();
    t1.setDetik();

    cout << "\nKedatangan:\n";
    t2.setTahun();
    t2.setBulan();
    t2.setHari();
    t2.setJam();
    t2.setMenit();
    t2.setDetik();

    selisih = t1.selisihWaktu(t2);

    cout << "\nLama Perjalanan:\n";
    selisih.tampilkanSelisih();

    return 0;
}
