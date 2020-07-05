package com.dicoding.picodiploma.mycomputershopapp

object ItemsData {
    private val itemNames = arrayOf(
        "Iphone X 64 GB",
        "Iphone XR 128 GB",
        "Iphone XS 256 GB",
        "Iphone SE 2020 64 GB",
        "Ipad Pro 2020 512 GB",
        "Samsung Galaxy S20 256 GB",
        "Samsung Galaxy Note 20 512 GB",
        "Samsung Galaxy Fold 128 GB",
        "Samsung Galaxy Z Flip 128 GB",
        "Samsung Galaxy Tab S6 256 GB"
    )

    private val itemDetails = arrayOf(
        "Iphone X 64 GB Fullset White",
        "Iphone XR 128 GB Fullset Red Edition",
        "Iphone XS 256 GB Fullset Space Grey",
        "Iphone SE 2020 64 GB Fullset Red Edition",
        "Ipad Pro 2020 512 GB Fullset Space Grey",
        "Samsung Galaxy S20 256 GB Fullset Black",
        "Samsung Galaxy Note 10 512 GB Fullset Black Bonus Wireless Charging",
        "Samsung Galaxy Fold 128 GB Fullset Black Bonus Samsung Galaxy Watch",
        "Samsung Galaxy Z Flip 128 GB Fullset Black Bonus Galaxy Earbuds",
        "Samsung Galaxy Tab S6 256 GB Fullset Mountain Grey"
    )

    private val itemPrices = arrayOf(
        "6500000",
        "8900000",
        "10250000",
        "7250000",
        "16500000",
        "15900000",
        "18900000",
        "44900000",
        "34900000",
        "12500000"
    )

    private val itemImages = arrayOf(
        R.drawable.img_iphx_silver,
        R.drawable.img_iphxr_red,
        R.drawable.img_iphx_silver,
        R.drawable.img_iph_se2020_red,
        R.drawable.img_ipadpro2020_spacegrey,
        R.drawable.img_samsungs20_black,
        R.drawable.img_samsungnote10_black,
        R.drawable.img_galaxyfold_black,
        R.drawable.img_galaxyzflip_black,
        R.drawable.img_tabs6_mountaingrey
    )

    val listData: ArrayList<Items>
        get() {
            val list = arrayListOf<Items>()
            for (position in itemNames.indices) {
                val items = Items()
                items.itemName = itemNames[position]
                items.itemDetail = itemDetails[position]
                items.itemPrice = itemPrices[position]
                items.itemPhoto = itemImages[position]
                list.add(items)
            }
            return list
        }

}