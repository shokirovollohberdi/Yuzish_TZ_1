package uz.shokirov.yuzishtz.model

data class SearchMijoz(
    val active_orders: List<ActiveOrder>,
    val costumer1: Costumer1,
    val qabulqilinadigan_order_id: Int,
    val tasdilanadigan_order_id: Int
)