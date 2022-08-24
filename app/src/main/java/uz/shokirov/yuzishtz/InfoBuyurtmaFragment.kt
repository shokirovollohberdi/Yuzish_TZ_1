package uz.shokirov.yuzishtz

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.shokirov.yuzishtz.adapters.InfoBuyurtmalardapter
import uz.shokirov.yuzishtz.databinding.FragmentInfoBuyurtmaBinding
import uz.shokirov.yuzishtz.model.Orders
import uz.shokirov.yuzishtz.model.buyurtma_topshirish.Buyurtma_topshirish
import uz.shokirov.yuzishtz.model.buyurtma_topshirish.Buyurtmalar
import uz.shokirov.yuzishtz.retrofit_client.RetrofitClient
import java.util.*
import kotlin.collections.ArrayList


class InfoBuyurtmaFragment : Fragment() {
    lateinit var binding: FragmentInfoBuyurtmaBinding
    lateinit var buyurtmalar: ArrayList<Buyurtmalar>
    lateinit var buyurtma:Buyurtma_topshirish
    lateinit var order:Orders
    private val TAG = "InfoBuyurtmaFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBuyurtmaBinding.inflate(layoutInflater)


        order = arguments?.getSerializable("order") as Orders
        getList(order.order_id)


       // binding.tvAllPayment.text = "Jami summa: ${buyurtma}"

        try {
            binding.tvLocation.text = getCompleteAddressString(order.geoplugin_latitude.toDouble(),order.geoplugin_longitude.toDouble())
        }catch (e:Exception){
            binding.tvLocation.text = "-"
        }





        setAdapterSpinner()


        binding.btnTopshirildi.setOnClickListener {
            topshirish(order.order_id,buyurtma.jami_summa,binding.typeAutocomplete.text.toString())
        }



        return binding.root
    }

    private fun getCompleteAddressString(LATITUDE: Double, LONGITUDE: Double): String? {
        var strAdd = ""
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        try {
            val addresses: List<Address>? = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1)
            if (addresses != null) {
                val returnedAddress: Address = addresses[0]
                val strReturnedAddress = StringBuilder("")
                for (i in 0..returnedAddress.getMaxAddressLineIndex()) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n")
                }
                strAdd = strReturnedAddress.toString()
                Log.w("My Current loction address", strReturnedAddress.toString())
            } else {
                Log.w("My Current loction address", "No Address returned!")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.w("My Current loction address", "Canont get Address!")
        }
        return strAdd
    }

    private fun topshirish(orderId: Int, jamiSumma: Int, type: String) {
        RetrofitClient.getRetrofit().zakarTopshirish(orderId,jamiSumma,type).enqueue(object :Callback<Any>{
            override fun onResponse(call: Call<Any>, response: Response<Any>) {

            }

            override fun onFailure(call: Call<Any>, t: Throwable) {

            }

        })

    }

    private fun setAdapterSpinner() {
        var type = ArrayList<String>()
        type.add("naqd")
        type.add("plastik")
        type.add("click")
        var typeAdapter =
            ArrayAdapter(requireContext(), R.layout.dropdown_item, type)
        binding.typeAutocomplete.setAdapter(typeAdapter)
    }

    private fun dialogInfo() {

    }

    private fun setAdapter() {
        var adapter = InfoBuyurtmalardapter(buyurtmalar)
        binding.infoBuyurtmaRv.adapter = adapter
    }

    private fun getList(orderId: Int) {
        buyurtmalar = ArrayList()

        RetrofitClient.getRetrofit().ready_order_view(orderId.toString())
            .enqueue(object : Callback<Buyurtma_topshirish> {
                override fun onResponse(
                    call: Call<Buyurtma_topshirish>,
                    response: Response<Buyurtma_topshirish>
                ) {
                    if (response.isSuccessful && response.code() == 200) {
                        buyurtmalar.addAll(response.body()!!.buyurtmalar)
                        buyurtma = response.body()!!
                        setAdapter()
                        setTexts()
                    } else {
                        Log.d(TAG, "onResponse: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<Buyurtma_topshirish>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                }
            })


    }

    private fun setTexts() {
        binding.tvKvitansiyaNumber.text = "KVITANSIYA №: " + order.nomer.toString()
        binding.tvName.text = order.costumer?.costumer_name
        binding.tvNumber.text = order.costumer?.costumer_phone_1
        binding.tvJami.text = "Jami: "+buyurtma.jami_soni.toString()
        binding.tvAllSumma.text = "Jami summa: ${buyurtma.jami_summa}"
    }

}