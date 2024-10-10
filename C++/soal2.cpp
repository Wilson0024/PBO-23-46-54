/*
 * Anggota Kelompok :
 * - Wilson Angelie Tan (140810230024)
 * - Stan Fedheric (140810230046)
 * - Theopillus Samuel Ghozalli (140810230054)
 * 
 * Deskripsi : Soal 2 dalam Bahasa Pemrograman C++
 */

#include <iostream>
#include <string>

using namespace std;

class Date {
private:
    int tanggal;
    int bulan;
    int tahun;

public:
    Date() {
        this->tanggal = 0;
        this->bulan = 0;
        this->tahun = 0;
    }

    int inputBatas(string kata, int min, int max) {
        int data;
        do {
            cout << kata;
            cin >> data;
        } while (data < min || data > max);
        return data;
    }

    void setTahun() {
        this->tahun = inputBatas("Tahun : ", 0, 200000);
    }

    void setBulan() {
        this->bulan = inputBatas("Bulan (1-12): ", 1, 12);
    }

    void setTanggal() {
        if (this->bulan == 2) {
            if ((this->tahun % 4 == 0 && this->tahun % 100 != 0) || (this->tahun % 400 == 0)) {
                this->tanggal = inputBatas("tanggal (1-29) : ", 1, 29);
            } else {
                this->tanggal = inputBatas("tanggal (1-28) : ", 1, 28);
            }
        } else if ((this->bulan % 2 == 1 && this->bulan <= 7) || (this->bulan % 2 == 0 && this->bulan <= 12 && this->bulan > 7)) {
            this->tanggal = inputBatas("tanggal (1-31) : ", 1, 31);
        } else {
            this->tanggal = inputBatas("tanggal (1-30) : ", 1, 30);
        }
    }

    void setBulan(int bulan) {
        this->bulan = bulan;
    }

    void setTahun(int tahun) {
        this->tahun = tahun;
    }

    void setTanggal(int tanggal) {
        this->tanggal = tanggal;
    }

    int getTahun() {
        return this->tahun;
    }

    int getBulan() {
        return this->bulan;
    }

    int getTanggal() {
        return this->tanggal;
    }
};

class Time {
private:
    int jam;
    int detik;
    int menit;

public:
    Time() {
        this->jam = 0;
        this->detik = 0;
        this->menit = 0;
    }

    int inputBatas(string kata, int min, int max) {
        int data;
        do {
            cout << kata;
            cin >> data;
        } while (data < min || data > max);
        return data;
    }

    void setJam() {
        this->jam = inputBatas("Masukkan Jam (0-23): ", 0, 23);
    }

    void setMenit() {
        this->menit = inputBatas("Masukkan Menit (0-59): ", 0, 59);
    }

    void setDetik() {
        this->detik = inputBatas("Masukkan Detik (0-59): ", 0, 59);
    }

    void setDetik(int detik) {
        this->detik = detik;
    }

    void setJam(int jam) {
        this->jam = jam;
    }

    void setMenit(int menit) {
        this->menit = menit;
    }

    int getDetik() {
        return this->detik;
    }

    int getJam() {
        return this->jam;
    }

    int getMenit() {
        return this->menit;
    }
};

class Waktu {
private:
    Time time;
    Date date;

public:
    Waktu() {
        this->time = Time();
        this->date = Date();
    }

    int inputBatas(string kata, int min, int max) {
        int data;
        do {
            cout << kata;
            cin >> data;
        } while (data < min || data > max);
        return data;
    }

    void setTime(string s) {
        cout << "\n\n\t" << s << endl;
        cout << "=======================" << endl;

        time.setJam();
        time.setMenit();
        time.setDetik();
    }

    void setDate(string s) {
        cout << "\n\n\t" << s << endl;
        cout << "=======================" << endl;

        date.setTahun();
        date.setBulan();
        date.setTanggal();
    }

    void setTime(Time time){
        this->time = time;
    }

    void setDate(Date date){
        this->date = date;
    }

    Date getDate() {
        return date;
    }

    Time getTime() {
        return time;
    }

    int getDaysInMonth(int bulan, int tahun) {
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

Waktu selisihWaktu(Waktu& kedatangan) {
    Waktu selisih;

    // Hitung selisih detik
    int selisihDetik = kedatangan.getTime().getDetik() - getTime().getDetik();
    if (selisihDetik < 0) {
        selisihDetik += 60;
        kedatangan.time.setMenit(kedatangan.getTime().getMenit() - 1);
    }
    selisih.time.setDetik(selisihDetik);

    // Hitung selisih menit
    int selisihMenit = kedatangan.getTime().getMenit() - getTime().getMenit();
    if (selisihMenit < 0) {
        selisihMenit += 60;
        kedatangan.time.setJam(kedatangan.getTime().getJam() - 1);
    }
    selisih.time.setMenit(selisihMenit);

    // Hitung selisih jam
    int selisihJam = kedatangan.getTime().getJam() - getTime().getJam();
    if (selisihJam < 0) {
        selisihJam += 24;
        kedatangan.date.setTanggal(kedatangan.getDate().getTanggal() - 1);
    }
    selisih.time.setJam(selisihJam);

    // Hitung selisih tanggal
    int selisihTanggal = kedatangan.getDate().getTanggal() - getDate().getTanggal();
    int daysInPrevMonth = getDaysInMonth(kedatangan.getDate().getBulan() - 1 == 0 ? 12 : kedatangan.getDate().getBulan() - 1, kedatangan.getDate().getTahun());

    if (selisihTanggal < 0) {
        selisihTanggal += daysInPrevMonth;
        kedatangan.date.setBulan(kedatangan.getDate().getBulan() - 1);
    }
    selisih.date.setTanggal(selisihTanggal);

    // Hitung selisih bulan
    int selisihBulan = kedatangan.getDate().getBulan() - getDate().getBulan();
    if (selisihBulan < 0) {
        selisihBulan += 12;
        kedatangan.date.setTahun(kedatangan.getDate().getTahun() - 1);
    }
    selisih.date.setBulan(selisihBulan);

    // Hitung selisih tahun
    int selisihTahun = kedatangan.getDate().getTahun() - getDate().getTahun();
    selisih.date.setTahun(selisihTahun);

    return selisih;
}

};

class Perjalanan {
private:
    Waktu keberangkatan;
    Waktu kedatangan;
    Waktu selisih;

public:
    Perjalanan(Waktu keberangkatan, Waktu kedatangan) {
        this->keberangkatan = keberangkatan;
        this->kedatangan = kedatangan;
        this->selisih = keberangkatan.selisihWaktu(kedatangan);
    }

        void lamaPerjalanan() {
        // Akses date dan time melalui getter
        int tahun = selisih.getDate().getTahun();
        int bulan = selisih.getDate().getBulan();
        int tanggal = selisih.getDate().getTanggal();
        int jam = selisih.getTime().getJam();
        int menit = selisih.getTime().getMenit();
        int detik = selisih.getTime().getDetik();

        cout << "\nLama Perjalanan: ";

        if (tahun != 0) {
            cout << tahun << " tahun ";
        }
        if (bulan != 0) {
            cout << bulan << " bulan ";
        }
        if (tanggal != 0) {
            cout << tanggal << " hari ";
        }
        if (jam != 0) {
            cout << jam << " jam ";
        }
        if (menit != 0) {
            cout << menit << " menit ";
        }
        if (detik != 0) {
            cout << detik << " detik";
        }

        cout << endl;
    }
};

int main() {
    Waktu waktuKeberangkatan, waktuKedatangan;

    waktuKeberangkatan.setDate("Tanggal Keberangkatan");
    waktuKeberangkatan.setTime("Waktu Keberangkatan");

    waktuKedatangan.setDate("Tanggal Kedatangan");
    waktuKedatangan.setTime("Waktu Kedatangan");

    Perjalanan perjalanan(waktuKeberangkatan, waktuKedatangan);

    perjalanan.lamaPerjalanan();
}

