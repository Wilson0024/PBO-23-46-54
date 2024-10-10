class Date:
    def __init__(self):
        self.tanggal = 0
        self.bulan = 0
        self.tahun = 0

    def input_batas(self, kata, min_val, max_val):
        while True:
            data = int(input(kata))
            if min_val <= data <= max_val:
                return data

    def set_tahun(self):
        self.tahun = self.input_batas("Tahun : ", 0, 200000)

    def set_bulan(self):
        self.bulan = self.input_batas("Bulan (1-12): ", 1, 12)

    def set_tanggal(self):
        if self.bulan == 2:
            if (self.tahun % 4 == 0 and self.tahun % 100 != 0) or (self.tahun % 400 == 0):
                self.tanggal = self.input_batas("tanggal (1-29) : ", 1, 29)
            else:
                self.tanggal = self.input_batas("tanggal (1-28) : ", 1, 28)
        elif (self.bulan % 2 == 1 and self.bulan <= 7) or (self.bulan % 2 == 0 and self.bulan <= 12 and self.bulan > 7):
            self.tanggal = self.input_batas("tanggal (1-31) : ", 1, 31)
        else:
            self.tanggal = self.input_batas("tanggal (1-30) : ", 1, 30)

    def set_bulan_value(self, bulan):
        self.bulan = bulan

    def set_tahun_value(self, tahun):
        self.tahun = tahun

    def set_tanggal_value(self, tanggal):
        self.tanggal = tanggal

    def get_tahun(self):
        return self.tahun

    def get_bulan(self):
        return self.bulan

    def get_tanggal(self):
        return self.tanggal


class Time:
    def __init__(self):
        self.jam = 0
        self.detik = 0
        self.menit = 0

    def input_batas(self, kata, min_val, max_val):
        while True:
            data = int(input(kata))
            if min_val <= data <= max_val:
                return data

    def set_jam(self):
        self.jam = self.input_batas("Masukkan Jam (0-23): ", 0, 23)

    def set_menit(self):
        self.menit = self.input_batas("Masukkan Menit (0-59): ", 0, 59)

    def set_detik(self):
        self.detik = self.input_batas("Masukkan Detik (0-59): ", 0, 59)

    def set_detik_value(self, detik):
        self.detik = detik

    def set_jam_value(self, jam):
        self.jam = jam

    def set_menit_value(self, menit):
        self.menit = menit

    def get_detik(self):
        return self.detik

    def get_jam(self):
        return self.jam

    def get_menit(self):
        return self.menit


class Waktu:
    def __init__(self):
        self.time = Time()
        self.date = Date()

    def input_batas(self, kata, min_val, max_val):
        while True:
            data = int(input(kata))
            if min_val <= data <= max_val:
                return data

    def set_time(self, s):
        print(f"\n\n\t{s}")
        print("=======================")
        self.time.set_jam()
        self.time.set_menit()
        self.time.set_detik()

    def set_date(self, s):
        print(f"\n\n\t{s}")
        print("=======================")
        self.date.set_tahun()
        self.date.set_bulan()
        self.date.set_tanggal()

    def get_date(self):
        return self.date

    def get_time(self):
        return self.time

    def get_days_in_month(self, bulan, tahun):
        if bulan == 2:
            if (tahun % 4 == 0 and tahun % 100 != 0) or (tahun % 400 == 0):
                return 29
            else:
                return 28
        elif bulan in [4, 6, 9, 11]:
            return 30
        else:
            return 31

    def selisih_waktu(self, kedatangan):
        selisih = Waktu()

        selisih_detik = kedatangan.get_time().get_detik() - self.get_time().get_detik()
        if selisih_detik < 0:
            selisih_detik += 60
            kedatangan.get_time().set_menit_value(kedatangan.get_time().get_menit() - 1)
        selisih.get_time().set_detik_value(selisih_detik)

        selisih_menit = kedatangan.get_time().get_menit() - self.get_time().get_menit()
        if selisih_menit < 0:
            selisih_menit += 60
            kedatangan.get_time().set_jam_value(kedatangan.get_time().get_jam() - 1)
        selisih.get_time().set_menit_value(selisih_menit)

        selisih_jam = kedatangan.get_time().get_jam() - self.get_time().get_jam()
        if selisih_jam < 0:
            selisih_jam += 24
            kedatangan.get_date().set_tanggal_value(kedatangan.get_date().get_tanggal() - 1)
        selisih.get_time().set_jam_value(selisih_jam)

        days_in_month = self.get_days_in_month(kedatangan.get_date().get_bulan(), kedatangan.get_date().get_tahun())
        selisih_tanggal = kedatangan.get_date().get_tanggal() - self.get_date().get_tanggal()
        if selisih_tanggal < 0:
            selisih_tanggal += days_in_month
            kedatangan.get_date().set_bulan_value(kedatangan.get_date().get_bulan() - 1)
        selisih.get_date().set_tanggal_value(selisih_tanggal)

        selisih_bulan = kedatangan.get_date().get_bulan() - self.get_date().get_bulan()
        if selisih_bulan < 0:
            selisih_bulan += 12
            kedatangan.get_date().set_tahun_value(kedatangan.get_date().get_tahun() - 1)
        selisih.get_date().set_bulan_value(selisih_bulan)

        selisih_tahun = kedatangan.get_date().get_tahun() - self.get_date().get_tahun()
        selisih.get_date().set_tahun_value(selisih_tahun)

        return selisih


class Perjalanan:
    def __init__(self, keberangkatan, kedatangan):
        self.keberangkatan = keberangkatan
        self.kedatangan = kedatangan
        self.selisih = keberangkatan.selisih_waktu(kedatangan)

    def lama_perjalanan(self):
        tahun = self.selisih.get_date().get_tahun()
        bulan = self.selisih.get_date().get_bulan()
        tanggal = self.selisih.get_date().get_tanggal()
        jam = self.selisih.get_time().get_jam()
        menit = self.selisih.get_time().get_menit()
        detik = self.selisih.get_time().get_detik()

        print("\nLama Perjalanan: ", end='')

        if tahun != 0:
            print(f"{tahun} tahun ", end='')
        if bulan != 0:
            print(f"{bulan} bulan ", end='')
        if tanggal != 0:
            print(f"{tanggal} hari ", end='')
        if jam != 0:
            print(f"{jam} jam ", end='')
        if menit != 0:
            print(f"{menit} menit ", end='')
        if detik != 0:
            print(f"{detik} detik", end='')
        print()


if __name__ == "__main__":
    keberangkatan = Waktu()
    kedatangan = Waktu()

    keberangkatan.set_date("Tanggal berangkat")
    keberangkatan.set_time("Waktu berangkat")

    kedatangan.set_date("Tanggal Kedatangan")
    kedatangan.set_time("Waktu Kedatangan")

    perjalanan = Perjalanan(keberangkatan, kedatangan)
    perjalanan.lama_perjalanan()

