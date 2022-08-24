package uz.shokirov.yuzishtz.service

import retrofit2.Call
import retrofit2.http.*
import uz.shokirov.yuzishtz.model.Costumer
import uz.shokirov.yuzishtz.model.LoginModel
import uz.shokirov.yuzishtz.model.Orders
import uz.shokirov.yuzishtz.model.SearchMijoz
import uz.shokirov.yuzishtz.model.buyurtma_topshirish.Buyurtma_topshirish

interface AuthService {

    @FormUrlEncoded
    @POST("token")
    fun checkUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginModel>

    @GET("giving_orders")
    fun getOrders(
        @Query("page") page: Int,
        @Query("driver") driver: Int,
        @Query("type") type: String
    ): Call<List<Orders>>


    @POST("search_costumer")
    fun searchCostumer(
        @Query("content") content: String
    ): Call<List<SearchMijoz>>

    @POST("zakazni_topshirish/{order_id}")
    fun zakarTopshirish(
        @Path("order_id") order_id: Int,
        @Query("berilgan_summa") berilgan_summa: Int,
        @Query("tolov_turi") tolov_turi: String
    ): Call<Any>

    @GET("ready_order_view/{order_id}")
    fun ready_order_view(
        @Path("order_id") order_id: String
    ): Call<Buyurtma_topshirish>


}