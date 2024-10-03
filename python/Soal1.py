class Waktu:
    def __init__(self):
        self.__jam = 0
        self.__menit = 0
        self.__detik = 0

    def setJam(self):
        self.__jam = self.inputBatas("Masukkan Jam (0-23): ", 0, 23)

    def setMenit(self):
        self.__menit = self.inputBatas("Masukkan Menit (0-59): ", 0, 59)

    def setDetik(self):
        self.__detik = self.inputBatas("Masukkan Detik (0-59): ", 0, 59)
    
    def getJam(self):
        return self.__jam
    
    def getMenit(self):
        return self.__menit
    
    def getDetik(self):
        return self.__detik
    
    def inputBatas(self, kata, min_val, max_val):
        while True:
                data = int(input(kata))
                if min_val <= data <= max_val:
                    return data
                else:
                    print(f"Input harus antara {min_val} dan {max_val}")

    def selisihWaktu(self, mulai, selesai):
        self.__detik = selesai.__detik - mulai.__detik
        self.__menit = selesai.__menit - mulai.__menit
        self.__jam = selesai.__jam - mulai.__jam
        
        if self.__detik < 0:
            self.__detik += 60
            self.__menit -= 1
        if self.__menit < 0:
            self.__menit += 60
            self.__jam -= 1
        if self.__jam < 0:
            self.__jam += 24

    def lamaLari(self):
        return (self.__jam * 60) + self.__menit + (self.__detik / 60.0)


class UjianTPB:
    def __init__(self):
        self.__nama = ""
        self.__npm = ""
        self.__mulai = Waktu()
        self.__selesai = Waktu()

    def setNama(self):
        self.__nama = input("Masukkan Nama : ")

    def setNpm(self):
        self.__npm = input("Masukkan NPM : ")

    def setMulai(self):
        print("\n\n\tJam Mulai")
        print("=======================")
        self.__mulai.setJam()
        self.__mulai.setMenit()
        self.__mulai.setDetik()

    def setSelesai(self):
        print("\n\n\tJam Selesai")
        print("=======================")
        self.__selesai.setJam()
        self.__selesai.setMenit()
        self.__selesai.setDetik()
        

    def HurufMutu(self, lamaLari):
        if 0 <= lamaLari < 7.5:
            return 'A'
        elif 7.5 <= lamaLari < 12.5:
            return 'B'
        elif 12.5 <= lamaLari < 30:
            return 'C'
        else:
            return 'D'

    def status(self, hurufMutu):
        if hurufMutu in ['A', 'B', 'C']:
            return "Lulus"
        else:
            return "Gagal"

    def tampilan(self):
        selisih = Waktu()
        selisih.selisihWaktu(self.__mulai, self.__selesai)

        lama_lari = selisih.lamaLari()
        huruf_mutu = self.HurufMutu(lama_lari)

        print("\n\n\tOUTPUT")
        print("===========================")
        print(f"\n\nNama : {self.__nama}")
        print(f"NPM : {self.__npm}")
        print(f"Huruf Mutu : {huruf_mutu}")
        print(f"Status : {self.status(huruf_mutu)}")
        print(f"Waktu Mulai : {self.__mulai.getJam()}:{self.__mulai.getMenit()}:{self.__mulai.getDetik()}")
        print(f"Waktu Selesai : {self.__selesai.getJam()}:{self.__selesai.getMenit()}:{self.__selesai.getDetik()}")
        print(f"Lama Lari : {lama_lari:.2f} Menit\n\n")


def Menu():
    dataMhs = UjianTPB()

    dataMhs.setNama()  # set nama
    dataMhs.setNpm()  # set npm
    dataMhs.setMulai() # set jam Mulai
    dataMhs.setSelesai() # set jam selesai
    dataMhs.tampilan() # tampilan output


if __name__ == "__main__":
    Menu()
