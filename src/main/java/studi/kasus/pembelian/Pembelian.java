package studi.kasus.pembelian;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Pembelian {
    public LocalDateTime getWaktuSekarang() {
        return waktuSekarang;
    }

    public void setWaktuSekarang(LocalDateTime waktuSekarang) {
        this.waktuSekarang = waktuSekarang;
    }

    private LocalDateTime waktuSekarang = LocalDateTime.now();
    private Customer customer;
    private List<PembelianDetail> detailDaftarPembelian = new ArrayList<>();
    private List<Diskon> daftarDiskon = new ArrayList<>();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<PembelianDetail> getDetailDaftarPembelian() {
        return detailDaftarPembelian;
    }

    public void setDetailDaftarPembelian(List<PembelianDetail> detailPembelian) {
        this.detailDaftarPembelian = detailPembelian;
    }

    public BigDecimal total(){
        BigDecimal hasil = BigDecimal.ZERO;
        for(PembelianDetail detail : detailDaftarPembelian){
            hasil = hasil.add(detail.subTotal());
        }
        return hasil;
    }

    public BigDecimal totalDiskon(){
        BigDecimal hasil = BigDecimal.ZERO;
        for(Diskon d : daftarDiskon){
            hasil = hasil.add(d.hitung(this)); //dia akan menghitung diskon yang ada dilist
        }
        return hasil;
    }

    public List<Diskon> getDaftarDiskon() {
        return daftarDiskon;
    }

    public void setDaftarDiskon(List<Diskon> daftarDiskon) {
        this.daftarDiskon = daftarDiskon;
    }

    public BigDecimal totalBayar(){
        return total().subtract(totalDiskon());
    }

    public void rincianDiskon() {
        NumberFormat formatter = DecimalFormat.getCurrencyInstance(new Locale("in","id"));

        for (Diskon d : daftarDiskon){
            System.out.println(d.getClass().getSimpleName()
                + " : "
                    + formatter.format(d.hitung(this).setScale(0, RoundingMode.HALF_EVEN)));
        }
    }
}
