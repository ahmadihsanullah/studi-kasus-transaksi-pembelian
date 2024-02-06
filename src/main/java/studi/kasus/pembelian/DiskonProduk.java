package studi.kasus.pembelian;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DiskonProduk implements Diskon{
    private static final List<String> DAFTAR_PRODUK_DISKON
            = Arrays.asList("P-01","P-02","P-03");

    private static final BigDecimal PERSENTASE_DISKON = new BigDecimal(0.15);
    @Override
    public BigDecimal hitung(Pembelian pembelian) {
        BigDecimal hasil = BigDecimal.ZERO;

        for(PembelianDetail detailPembelian : pembelian.getDetailDaftarPembelian()){
            Produk p = detailPembelian.getProduk();
            if(DAFTAR_PRODUK_DISKON.contains(p.getKode())){
                hasil = hasil.add(PERSENTASE_DISKON.multiply(detailPembelian.subTotal()));
            }
        }
        return hasil;
    }
}
