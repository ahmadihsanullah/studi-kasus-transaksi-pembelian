package studi.kasus.pembelian;

import java.math.BigDecimal;

public interface Diskon {
    BigDecimal hitung(Pembelian pembelian);
}

//implementasi
//1. Diskon total dari pembelian
//2. Diskon dari input produk tertentu
//3. Diskon untuk customer yang namanya Agus
//4. Diskon gajian, 3 hari terakhir setiap bulan
