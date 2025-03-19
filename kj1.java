// Kelas yang bertanggung jawab untuk membuat laporan transaksi
class PembuatLaporanTransaksi {
    public String buatLaporanPenambahan(String namaAkun, double jumlah) {
        String laporan = "Penambahan saldo: " + jumlah + " pada akun " + namaAkun;
        System.out.println("Laporan dibuat: " + laporan);
        return laporan;
    }

    public String buatLaporanPenarikan(String namaAkun, double jumlah) {
        String laporan = "Penarikan saldo: " + jumlah + " dari akun " + namaAkun;
        System.out.println("Laporan dibuat: " + laporan);
        return laporan;
    }
}

// Kelas yang hanya bertanggung jawab untuk mengelola saldo akun
class AplikasiKeuangan {
    private double saldo;
    private String namaAkun;
    private String email;
    private PembuatLaporanTransaksi pembuatLaporan;

    public AplikasiKeuangan(String namaAkun, String email, double saldoAwal) {
        this.namaAkun = namaAkun;
        this.email = email;
        this.saldo = saldoAwal;
        this.pembuatLaporan = new PembuatLaporanTransaksi();
    }

    public void tambahSaldo(double jumlah) {
        this.saldo += jumlah;
        System.out.println("Saldo bertambah: " + jumlah);

        // Menggunakan kelas terpisah untuk membuat laporan
        pembuatLaporan.buatLaporanPenambahan(namaAkun, jumlah);
    }

    public void tarikSaldo(double jumlah) {
        if (jumlah <= saldo) {
            this.saldo -= jumlah;
            System.out.println("Penarikan saldo: " + jumlah);

            // Menggunakan kelas terpisah untuk membuat laporan
            pembuatLaporan.buatLaporanPenarikan(namaAkun, jumlah);
        } else {
            System.out.println("Saldo tidak mencukupi");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

public class kj1 {
    public static void main(String[] args) {
        AplikasiKeuangan akun = new AplikasiKeuangan("John Doe", "john@example.com", 1000000);
        akun.tambahSaldo(500000);
        akun.tarikSaldo(200000);
        System.out.println("Saldo akhir: " + akun.getSaldo());
    }
}