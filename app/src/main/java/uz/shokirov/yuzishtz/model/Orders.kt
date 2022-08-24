package uz.shokirov.yuzishtz.model

import java.io.Serializable

data class Orders(
    val costumer: Costumer?,
    val geoplugin_latitude: String,
    val geoplugin_longitude: String,
    val izoh: String,
    val izoh2: String,
    val izoh3: String,
    val nomer: Int,
    val `operator`: Operator?,
    val order_id: Int,
    val own: Int,
    val product_count: Int,
    val qayta: Int,
    val tartib_raqam: Int,
    val topshir_sana: String
):Serializable