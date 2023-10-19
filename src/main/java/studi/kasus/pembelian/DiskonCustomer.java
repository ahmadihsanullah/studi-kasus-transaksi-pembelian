package studi.kasus.pembelian;

import java.math.BigDecimal;
import java.util.List;

public class DiskonCustomer implements Diskon{
    private static final List<String> NAMA_DISKON =
            List.of("agus","agustina");
    private static final BigDecimal PERSENTASE_DISKON = new BigDecimal(0.05);
    @Override
    public BigDecimal hitung(Pembelian pembelian) {
        Customer c = pembelian.getCustomer();
        String nama  = c.getNama();
        if(NAMA_DISKON.contains(nama.toLowerCase().trim())){
            return PERSENTASE_DISKON.multiply(pembelian.total());
        }
        return BigDecimal.ZERO;
    }
}
