package studi.kasus.pembelian;

import java.math.BigDecimal;

public interface Diskon {
    BigDecimal hitung(Pembelian pembelian);
}
