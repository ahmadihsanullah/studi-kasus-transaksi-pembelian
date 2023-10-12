package studi.kasus.pembelian;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pembelian {
    private Customer customer;
    private List<DetailPembelian> detailDaftarPembelian = new ArrayList<>();

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

}
