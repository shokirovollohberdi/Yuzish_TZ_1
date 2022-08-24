package uz.shokirov.yuzishtz.model.buyurtma_topshirish

data class Buyurtma_topshirish(
    val buyurtmalar: List<Buyurtmalar>,
    val costumer: Costumer,
    val geoplugin_latitude: String,
    val geoplugin_longitude: String,
    val izoh: String,
    val izoh2: String,
    val izoh3: String,
    val jami_chegirma: Int,
    val jami_soni: Int,
    val jami_summa: Int,
    val jami_tushish_chegirma: Int,
    val nomer: Int,
    val `operator`: Operator,
    val own: Int,
    val own_chegirma: Int,
    val qayta_yuvish_chegirma: Int,
    val tushish_chegirma: Int,
    val yakuniy_summa: Int
)