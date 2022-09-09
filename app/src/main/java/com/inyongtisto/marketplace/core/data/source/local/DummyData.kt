package com.inyongtisto.marketplace.core.data.source.local

import com.inyongtisto.marketplace.R
import com.inyongtisto.marketplace.core.data.source.model.Category
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.core.data.source.model.Slider

object DummyData {
    val listCategory = listOf(
        Category(id = "1", name = "Elektronik", image = R.drawable.asset_elektronik),
        Category(id = "2", name = "Handphone", image = R.drawable.asset_handphone),
        Category(id = "3", name = "Keuangan", image = R.drawable.asset_keuangan),
        Category(id = "4", name = "Komputer", image = R.drawable.asset_komputer),
        Category(id = "5", name = "Perawatan Hewan", image = R.drawable.asset_perawatan_hewan),
        Category(id = "6", name = "Topup", image = R.drawable.asset_topup),
        Category(id = "7", name = "Rumah Tangga", image = R.drawable.asset_rumah_tangga),
        Category(id = "8", name = "Travel", image = R.drawable.asset_travel),
        Category(id = "9", name = "Komputer", image = R.drawable.asset_komputer),
        Category(id = "10", name = "Semua", image = R.drawable.asset_semua),
    )

    val listSlider = listOf(
        Slider(id = "1", name = "Slider1", image = R.drawable.asset_slider1),
        Slider(id = "2", name = "Slider2", image = R.drawable.asset_slider2),
        Slider(id = "3", name = "Slider3", image = R.drawable.asset_slider3),
    )

    val listProduct = listOf(
        Product(
            id = 1,
            name = "OPPO A16 RAM 3/32GB | 13MP TRIPLE CAMERA | FINGERPRINT | 5000mAh - Space Silver",
            price = 1859000,
            pengirirman = "Tangerang",
            terjual = 150,
            rating = 5.0,
            discount = 0,
            grosir = true,
            imageDummy = R.drawable.asset_produk1
        ),
        Product(
            id = 2,
            name = "Apple Mac Mini M1 Chip 2020 Customise 16GB RAM - 16GB/256GB",
            price = 15650000,
            pengirirman = "Tangerang",
            terjual = 150,
            rating = 5.0,
            discount = 10,
            grosir = true,
            imageDummy = R.drawable.asset_produk2
        ),
        Product(
            id = 3,
            name = "4 in 1 Type C Hub To HDMI VGA USB 3.0",
            price = 245000,
            pengirirman = "Jakrta Utara",
            terjual = 530,
            rating = 5.0,
            discount = 15,
            grosir = false,
            imageDummy = R.drawable.asset_produk3
        ),
        Product(
            id = 4,
            name = "Paket Holder Gimbal Stabilizer & Mini LED",
            price = 165000,
            pengirirman = "Kab.Malang",
            terjual = 1150,
            rating = 5.0,
            discount = 0,
            grosir = true,
            imageDummy = R.drawable.asset_produk4
        ),
        Product(
            id = 5,
            name = "Fujifilm XA20 / X-A20 kit XC15-45mm Garansi Resmi Fujifilm Indonesia - Black",
            price = 4999000,
            pengirirman = "Tangerang",
            terjual = 68,
            rating = 5.0,
            discount = 15,
            grosir = false,
            imageDummy = R.drawable.asset_produk5
        ),
        Product(
            id = 6,
            name = "ALLIN BOX TELESIN 3 Slot Charger With 2-Pack Baterai Gopro Hero 8 7 6",
            price = 549000,
            pengirirman = "Bogor",
            terjual = 150,
            rating = 5.0,
            discount = 20,
            grosir = false,
            imageDummy = R.drawable.asset_produk6
        ),
        Product(
            id = 7,
            name = "Kamera Mirrorless Sony Alpha A5100 kit 16mm Sony",
            price = 5350000,
            pengirirman = "Jakarta Pusat",
            terjual = 22,
            rating = 5.0,
            discount = 0,
            grosir = true,
            imageDummy = R.drawable.asset_produk7
        ),
        Product(
            id = 8,
            name = "Sony ILCE-6500 / Alpha A6500 Body - Black",
            price = 12990000,
            pengirirman = "Tangerang",
            terjual = 11,
            rating = 5.0,
            discount = 10,
            grosir = false,
            imageDummy = R.drawable.asset_produk8
        ),
    )
}