package studi.kasus.pembelian;

import java.math.BigDecimal;

public class PembelianDetail {
    private Produk produk;

    private Integer jumlah;

    public PembelianDetail(Produk produk, Integer jumlah) {
        this.produk = produk;
        this.jumlah = jumlah;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public BigDecimal subTotal(){
        return produk.getHarga().multiply(BigDecimal.valueOf(jumlah));
    }

}
