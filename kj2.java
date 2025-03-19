import java.util.ArrayList;
import java.util.List;

class Produk {
    private String nama;
    private String kategori;
    private double harga;

    public Produk(String nama, String kategori, double harga) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }
}

public interface Discount {
    double applyDiscount(double price);
}

class ElektronikDiscount implements Discount {
    public double applyDiscount(double price) {
        return price * 0.9; // 10% discount
    }
}

class PakaianDiscount implements Discount {
    public double applyDiscount(double price) {
        return price * 0.8; // 20% discount
    }
}

class MakananDiscount implements Discount {
    public double applyDiscount(double price) {
        return price * 0.95; // 5% discount
    }
}

class BukuDiscount implements Discount {
    public double applyDiscount(double price) {
        return price * 0.85; // 15% discount
    }
}

class NoDiscount implements Discount {
    public double applyDiscount(double price) {
        return price; // No discount
    }
}

class PengelolaDiskon {
    public Discount getDiscount(String kategori) {
        switch (kategori) {
            case "Elektronik":
                return new ElektronikDiscount();
            case "Pakaian":
                return new PakaianDiscount();
            case "Makanan":
                return new MakananDiscount();
            case "Buku":
                return new BukuDiscount();
            default:
                return new NoDiscount();
        }
    }

    public double hitungHargaSetelahDiskon(Produk produk) {
        Discount discount = getDiscount(produk.getKategori());
        return discount.applyDiscount(produk.getHarga());
    }
}

class KeranjangBelanja {
    private List<Produk> daftarProduk = new ArrayList<>();
    private PengelolaDiskon pengelolaDiskon = new PengelolaDiskon();

    public void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
    }

    public double hitungTotalHarga() {
        double total = 0;
        for (Produk produk : daftarProduk) {
            total += pengelolaDiskon.hitungHargaSetelahDiskon(produk);
        }
        return total;
    }
}

public class kj2 {
    public static void main(String[] args) {
        KeranjangBelanja keranjang = new KeranjangBelanja();
        keranjang.tambahProduk(new Produk("Laptop", "Elektronik", 12000000));
        keranjang.tambahProduk(new Produk("Kemeja", "Pakaian", 350000));
        keranjang.tambahProduk(new Produk("Buku Java", "Buku", 250000));

        System.out.println("Total belanja setelah diskon: Rp" + keranjang.hitungTotalHarga());
    }
}