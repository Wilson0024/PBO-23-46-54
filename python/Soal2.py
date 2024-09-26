 # Anggota Kelompok :
 # - Wilson Angelie Tan (140810230024)
 # - Stan Fedheric (140810230046)
 # - Theopillus Samuel Ghozalli (140810230054) 
 # Deskripsi : Soal 2 dalam Bahasa Pemograman Python
 
class Waktu:
    def __init__(self):
        self.hari = 0
        self.bulan = 0
        self.tahun = 0
        self.jam = 0
        self.menit = 0
        self.detik = 0

    def input_batas(self, pesan, min_val, max_val):
        while True:
            try:
                data = int(input(pesan))
                if min_val <= data <= max_val:
                    return data
            except ValueError:
                pass

    def set_tahun(self):
        self.tahun = self.input_batas("Tahun: ", 0, 200000)

    def set_bulan(self):
        self.bulan = self.input_batas("Bulan (1-12): ", 1, 12)

    def set_hari(self):
        if self.bulan == 2:
            if (self.tahun % 4 == 0 and self.tahun % 100 != 0) or (self.tahun % 400 == 0):
                self.hari = self.input_batas("Tanggal (1-29): ", 1, 29)
            else:
                self.hari = self.input_batas("Tanggal (1-28): ", 1, 28)
        elif (self.bulan % 2 == 1 and self.bulan <= 7) or (self.bulan % 2 == 0 and self.bulan >= 8):
            self.hari = self.input_batas("Tanggal (1-31): ", 1, 31)
        else:
            self.hari = self.input_batas("Tanggal (1-30): ", 1, 30)

    def set_jam(self):
        self.jam = self.input_batas("Masukkan Jam (0-23): ", 0, 23)

    def set_menit(self):
        self.menit = self.input_batas("Masukkan Menit (0-59): ", 0, 59)

    def set_detik(self):
        self.detik = self.input_batas("Masukkan Detik (0-59): ", 0, 59)

    def selisih_waktu(self, kedatangan):
        selisih = Waktu()

        if kedatangan.detik < self.detik:
            kedatangan.menit -= 1
            selisih.detik = 60 + kedatangan.detik - self.detik
        else:
            selisih.detik = kedatangan.detik - self.detik

        if kedatangan.menit < self.menit:
            kedatangan.jam -= 1
            selisih.menit = 60 + kedatangan.menit - self.menit
        else:
            selisih.menit = kedatangan.menit - self.menit

        if kedatangan.jam < self.jam:
            kedatangan.hari -= 1
            selisih.jam = 24 + kedatangan.jam - self.jam
        else:
            selisih.jam = kedatangan.jam - self.jam

        if kedatangan.hari < self.hari:
            kedatangan.bulan -= 1
            if self.bulan == 2:
                if (self.tahun % 4 == 0 and self.tahun % 100 != 0) or (self.tahun % 400 == 0):
                    hari_bulan_ini = 29
                else:
                    hari_bulan_ini = 28
            elif (self.bulan % 2 == 1 and self.bulan <= 7) or (self.bulan % 2 == 0 and self.bulan >= 8):
                hari_bulan_ini = 31
            else:
                hari_bulan_ini = 30
            selisih.hari = hari_bulan_ini + kedatangan.hari - self.hari
        else:
            selisih.hari = kedatangan.hari - self.hari

        if kedatangan.bulan < self.bulan:
            kedatangan.tahun -= 1
            selisih.bulan = 12 + kedatangan.bulan - self.bulan
        else:
            selisih.bulan = kedatangan.bulan - self.bulan

        selisih.tahun = kedatangan.tahun - self.tahun

        return selisih

    def tampilkan(self):
        print(f"{self.tahun} tahun {self.bulan} bulan {self.hari} hari {self.jam} jam {self.menit} menit {self.detik} detik")


if __name__ == "__main__":
    print("Berangkat :")
    t1 = Waktu()
    t1.set_tahun(); t1.set_bulan(); t1.set_hari(); t1.set_jam(); t1.set_menit(); t1.set_detik()

    print("\nKedatangan :")
    t2 = Waktu()
    t2.set_tahun(); t2.set_bulan(); t2.set_hari(); t2.set_jam(); t2.set_menit(); t2.set_detik()

    selisih = t1.selisih_waktu(t2)

    print("\nLama Perjalanan :")
    selisih.tampilkan()
