package studi.kasus.pembelian;

import java.math.BigDecimal;

public class DiskonTotal implements Diskon{
    private static final BigDecimal BATAS_DISKON = new BigDecimal(20_000_000);
    private static final BigDecimal PERSENTASE = new BigDecimal(0.1);
    @Override
    public BigDecimal hitung(Pembelian pembelian) {
//        batas diskon jarus lebih kecil dari total pembelian
        if(BATAS_DISKON.compareTo(pembelian.total()) == -1){
            return PERSENTASE.multiply(pembelian.total());
        }else{
            return BigDecimal.ZERO;
        }
    }
}
