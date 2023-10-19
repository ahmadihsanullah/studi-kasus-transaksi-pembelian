package studi.kasus.pembelian;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DiskonAkhirBulan implements Diskon{
    private static final BigDecimal PERSENTASE_DISKON = new BigDecimal(0.2);

    @Override
    public BigDecimal hitung(Pembelian pembelian) {
        LocalDateTime akhirBulan = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime tigaHariAkhirbulan = akhirBulan.minusDays(2);

        if(pembelian.getWaktuSekarang().isAfter(tigaHariAkhirbulan) &&
            pembelian.getWaktuSekarang().isBefore(akhirBulan)){
            return PERSENTASE_DISKON.multiply(pembelian.total());
        }
        return BigDecimal.ZERO;
    }
}
