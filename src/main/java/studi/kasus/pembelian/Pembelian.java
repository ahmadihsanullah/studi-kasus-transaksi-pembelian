package studi.kasus.pembelian;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pembelian {
    private LocalDateTime waktuSekarang = LocalDateTime.now();
    private Customer customer;
    private List<DetailPembelian> detailDaftarPembelian = new ArrayList<>();
    private List<Diskon> daftarDiskon = new ArrayList<>();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<DetailPembelian> getDetailDaftarPembelian() {
        return detailDaftarPembelian;
    }

    public void setDetailDaftarPembelian(List<DetailPembelian> detailPembelian) {
        this.detailDaftarPembelian = detailPembelian;
    }

    public BigDecimal total(){
        BigDecimal hasil = BigDecimal.ZERO;
        for(DetailPembelian detail : detailDaftarPembelian){
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
}
