 # Anggota Kelompok :
 # - Wilson Angelie Tan (140810230024)
 # - Stan Fedheric (140810230046)
 # - Theopillus Samuel Ghozalli (140810230054) 
 # Deskripsi : Soal 2 dalam Bahasa Pemograman Python
 
class Waktu:
    def __init__(self):
        self.__hari = 0
        self.__bulan = 0
        self.__tahun = 0
        self.__jam = 0
        self.__menit = 0
        self.__detik = 0

    def input_batas(self, pesan, min_val, max_val):
        while True:
            try:
                data = int(input(pesan))
                if min_val <= data <= max_val:
                    return data
            except ValueError:
                pass

    def set_tahun(self):
        self.__tahun = self.input_batas("Tahun: ", 0, 200000)

    def set_bulan(self):
        self.__bulan = self.input_batas("Bulan (1-12): ", 1, 12)

    def set_hari(self):
        if self.__bulan == 2:
            if (self.__tahun % 4 == 0 and self.__tahun % 100 != 0) or (self.__tahun % 400 == 0):
                self.__hari = self.input_batas("Tanggal (1-29): ", 1, 29)
            else:
                self.__hari = self.input_batas("Tanggal (1-28): ", 1, 28)
        elif (self.__bulan % 2 == 1 and self.__bulan <= 7) or (self.__bulan % 2 == 0 and self.__bulan >= 8):
            self.__hari = self.input_batas("Tanggal (1-31): ", 1, 31)
        else:
            self.__hari = self.input_batas("Tanggal (1-30): ", 1, 30)

    def set_jam(self):
        self.__jam = self.input_batas("Masukkan Jam (0-23): ", 0, 23)

    def set_menit(self):
        self.__menit = self.input_batas("Masukkan Menit (0-59): ", 0, 59)

    def set_detik(self):
        self.__detik = self.input_batas("Masukkan Detik (0-59): ", 0, 59)

    def selisih_waktu(self, kedatangan):
        selisih = Waktu()

        if kedatangan.__detik < self.__detik:
            kedatangan.__menit -= 1
            selisih.__detik = 60 + kedatangan.__detik - self.__detik
        else:
            selisih.__detik = kedatangan.__detik - self.__detik

        if kedatangan.__menit < self.__menit:
            kedatangan.__jam -= 1
            selisih.__menit = 60 + kedatangan.__menit - self.__menit
        else:
            selisih.__menit = kedatangan.__menit - self.__menit

        if kedatangan.__jam < self.__jam:
            kedatangan.__hari -= 1
            selisih.__jam = 24 + kedatangan.__jam - self.__jam
        else:
            selisih.__jam = kedatangan.__jam - self.__jam

        if kedatangan.__hari < self.__hari:
            kedatangan.__bulan -= 1
            if self.__bulan == 2:
                if (self.__tahun % 4 == 0 and self.__tahun % 100 != 0) or (self.__tahun % 400 == 0):
                    hari_bulan_ini = 29
                else:
                    hari_bulan_ini = 28
            elif (self.__bulan % 2 == 1 and self.__bulan <= 7) or (self.__bulan % 2 == 0 and self.__bulan >= 8):
                hari_bulan_ini = 31
            else:
                hari_bulan_ini = 30
            selisih.__hari = hari_bulan_ini + kedatangan.__hari - self.__hari
        else:
            selisih.__hari = kedatangan.__hari - self.__hari

        if kedatangan.__bulan < self.__bulan:
            kedatangan.__tahun -= 1
            selisih.__bulan = 12 + kedatangan.__bulan - self.__bulan
        else:
            selisih.__bulan = kedatangan.__bulan - self.__bulan

        selisih.__tahun = kedatangan.__tahun - self.__tahun

        return selisih

    def tampilkan(self):
        print(f"{self.__tahun} tahun {self.__bulan} bulan {self.__hari} hari {self.__jam} jam {self.__menit} menit {self.__detik} detik")


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
