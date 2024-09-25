 # Anggota Kelompok :
 # - Wilson Angelie Tan (140810230024)
 # - Stan Fedheric (140810230046)
 # - Theopillus Samuel Ghozalli (140810230054)
 # 
 # Deskripsi : Soal 1 dalam Bahasa Pemograman Python
 #
class Waktu :
    def __init__(self):
        self.__nama = ""
        self.__npm = ""
        self.__jam = 0
        self.__menit = 0
        self.__detik = 0
        
    def inputBatas(self,kata, min, max):
        data = -1
        while data < min or data > max :
            data = int(input(kata))
        return data
    
    def setNama(self):
        self.__nama = str(input("Masukkan Nama :"))
    
    def setNpm(self):
        self.__npm = str(input("Masukkan NPM : "))
    
    def setJam(self):
        self.__jam = self.inputBatas("Masukkan Jam : ", 0, 23)
    
    def setMenit(self):
        self.__menit = self.inputBatas("Masukkan Menit : ", 0, 59)
    
    def setDetik(self):
        self.__detik = self.inputBatas("Masukkan Detik : ", 0, 59)
        
    def getDetik(self):
        return self.__detik

    def getJam(self):
        return self.__jam

    def getMenit(self):
        return self.__menit

    def getNama(self):
        return self.__nama

    def getNpm(self):
        return self.__npm
   
    def lamaLari(self, selesai):
        ja = selesai.__jam - self.__jam
        if ja < 0 :
            ja = ja+24
        return ja*60 + (selesai.__menit - self.__menit) + (selesai.__detik - self.__detik)/60.0
    
    def hurufMutu(self, lamaLari):
        if lamaLari >= 0 and lamaLari < 7.5 :
            return 'A'
        elif lamaLari >= 7.5 and lamaLari < 12.5:
            return 'B'
        elif lamaLari >= 12.5 and lamaLari < 30:
            return 'C'
        else :
            return 'D'

    def status(self, hurufMutu):
        if hurufMutu == 'A' or hurufMutu == 'B' or hurufMutu == 'C' :
            return "Lulus"
        else : 
            return "Gagal"
        
    
    def tampilan(self, selesai):
        lama = self.lamaLari(selesai)
        print("\n\nNama:", self.getNama())
        print("NPM:", self.getNpm())
        print("Huruf Mutu:", self.hurufMutu(lama))
        print("Status:", self.status(self.hurufMutu(lama)))
        print("Waktu Mulai:", self.getJam(), ":", self.getMenit(), ":", self.getDetik())
        print("Waktu Selesai:", selesai.getJam(), ":", selesai.getMenit(), ":", selesai.getDetik())
        print("Lama Lari:", lama, "Menit\n\n")
        
dataMhs = Waktu()
selesai = Waktu()

dataMhs.setNama()
dataMhs.setNpm()

print("\n\n\tJam Mulai")
print("=======================")

dataMhs.setJam()
dataMhs.setMenit()
dataMhs.setDetik()


print("\n\n\tJam Selesai")
print("=======================")

selesai.setJam()
selesai.setMenit()
selesai.setDetik()

dataMhs.tampilan(selesai)