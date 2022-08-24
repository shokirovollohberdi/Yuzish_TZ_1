package uz.shokirov.yuzishtz.model.buyurtma_topshirish

data class Product(
    val clean_hajm: Double,
    val gilam_boyi: Double,
    val gilam_eni: Double,
    val id: Int,
    val joy: String,
    val narx: Int,
    val reclean_place: Int,
    val summa: Int
)