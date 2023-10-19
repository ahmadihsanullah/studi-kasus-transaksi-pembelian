package studi.kasus.pembelian;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

class DemoPembelianTest {
    @Test
    void testPembelian() {
        Produk p1 = new Produk();
        p1.setKode("P-01");
        p1.setNama("Macbook Air 2017");
        p1.setHarga(new BigDecimal(28_000_000));

        Produk p2 = new Produk();
        p2.setKode("P-02");
        p2.setNama("Macbook Pro 2017");
        p2.setHarga(new BigDecimal(33_000_000));

        Produk p3 = new Produk();
        p3.setKode("P-03");
        p3.setNama("Macbook Pro-M2 2020");
        p3.setHarga(new BigDecimal(37_000_000));

        Customer c1 = new Customer();
        c1.setNama("agus");
        c1.setEmail("agus@gmail.com");

        DetailPembelian dp1 = new DetailPembelian();
        dp1.setProduk(p1);
        dp1.setJumlah(2);

        DetailPembelian dp2 = new DetailPembelian();
        dp2.setProduk(p3);
        dp2.setJumlah(1);

        Pembelian pembelian1 = new Pembelian();
        pembelian1.setCustomer(c1);
        pembelian1.getDetailDaftarPembelian().add(dp1);
        pembelian1.getDetailDaftarPembelian().add(dp2);

        NumberFormat formatter = DecimalFormat.getInstance(new Locale("in", "id"));
        System.out.println("Pembelian oleh " + pembelian1.getCustomer().getNama());
        System.out.println("=====Rincian =====");
        for(DetailPembelian dp: pembelian1.getDetailDaftarPembelian()){
            System.out.println("Produk : " + dp.getProduk().getNama());
            System.out.println("Harga : Rp. " + formatter.format(dp.getProduk().getHarga()));
            System.out.println("Jumlah : " + dp.getJumlah());
            System.out.println("Subtotal : Rp. " + formatter.format(dp.subTotal()));
            System.out.println("---------");
        }
        System.out.println("============");
        System.out.println("Total : Rp. " + formatter.format( pembelian1.total()));

        //aplikasikan diskon ke pembelian
        pembelian1.getDaftarDiskon().add(new DiskonTotal()); //diskon total
        pembelian1.getDaftarDiskon().add(new DiskonProduk()); //diskon produk
        pembelian1.getDaftarDiskon().add(new DiskonCustomer()); //diskon customer
        pembelian1.getDaftarDiskon().add(new DiskonAkhirBulan()); //diskon Akhir Bulan

        //tampilkan rincian diskon
        pembelian1.rincianDiskon();
        System.out.println("================");
        System.out.println("Total Diskon : "+ formatter.format(pembelian1.totalDiskon()));
        System.out.println("Total Bayar : "+ formatter.format(pembelian1.totalBayar()));
    }
}