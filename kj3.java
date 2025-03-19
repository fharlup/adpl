import java.util.ArrayList;
import java.util.List;

// Notifikasi biasa
class Notifikasi {
    private String pesan;

    public Notifikasi(String pesan) {
        this.pesan = pesan;
    }

    public String getPesan() {
        return pesan;
    }

    public void kirim(String tujuan) {
        System.out.println("Mengirim notifikasi ke " + tujuan + ": " + pesan);
    }
}

// Notifikasi SMS sebagai class terpisah
class NotifikasiSMS {
    private String pesan;

    public NotifikasiSMS(String pesan) {
        this.pesan = pesan;
    }

    public String getPesan() {
        return pesan;
    }

    public void kirim(String nomorTelepon) {
        if (!nomorTelepon.startsWith("+")) {
            System.out.println("Nomor telepon harus diawali dengan kode negara (+)");
            return;
        }
        System.out.println("Mengirim SMS ke " + nomorTelepon + ": " + pesan);
    }
}

// Pengirim untuk notifikasi biasa
class PengirimNotifikasi {
    public void kirimNotifikasi(Notifikasi notifikasi, String tujuan) {
        notifikasi.kirim(tujuan);
    }

    public void kirimSemuaNotifikasi(List<Notifikasi> daftarNotifikasi, String tujuan) {
        for (Notifikasi notifikasi : daftarNotifikasi) {
            notifikasi.kirim(tujuan);
        }
    }
}

// Pengirim khusus untuk SMS
class PengirimSMS {
    public void kirimSMS(NotifikasiSMS notifikasi, String nomorTelepon) {
        notifikasi.kirim(nomorTelepon);
    }

    public void kirimSemuaSMS(List<NotifikasiSMS> daftarNotifikasi, String nomorTelepon) {
        for (NotifikasiSMS notifikasi : daftarNotifikasi) {
            notifikasi.kirim(nomorTelepon);
        }
    }
}

public class kj3 {
    public static void main(String[] args) {
        // Contoh penggunaan notifikasi biasa
        List<Notifikasi> notifikasiBiasa = new ArrayList<>();
        notifikasiBiasa.add(new Notifikasi("Pengumuman penting!"));
        notifikasiBiasa.add(new Notifikasi("Info terbaru"));

        PengirimNotifikasi pengirimBiasa = new PengirimNotifikasi();
        pengirimBiasa.kirimSemuaNotifikasi(notifikasiBiasa, "user@example.com");

        // Contoh penggunaan notifikasi SMS
        List<NotifikasiSMS> notifikasiSMS = new ArrayList<>();
        notifikasiSMS.add(new NotifikasiSMS("Kode verifikasi: 123456"));

        PengirimSMS pengirimSMS = new PengirimSMS();
        pengirimSMS.kirimSemuaSMS(notifikasiSMS, "+6281234567890");
    }
}