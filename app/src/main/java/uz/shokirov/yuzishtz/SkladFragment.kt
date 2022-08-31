package uz.shokirov.yuzishtz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.shokirov.yuzishtz.adapters.SkladAdapter
import uz.shokirov.yuzishtz.databinding.FragmentSkladBinding
import uz.shokirov.yuzishtz.model.warehouse_orders.Warehouse_orders
import uz.shokirov.yuzishtz.retrofit_client.RetrofitClient


class SkladFragment : Fragment() {
    lateinit var binding: FragmentSkladBinding
    lateinit var list: ArrayList<Warehouse_orders>
    private val TAG = "SkladFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSkladBinding.inflate(layoutInflater)

        list = ArrayList()

        getOrders(0)

        return binding.root
    }

    private fun getOrders(page: Int) {
        RetrofitClient.getRetrofit().orders_ombor(page)
            .enqueue(object : Callback<List<Warehouse_orders>> {
                override fun onResponse(
                    call: Call<List<Warehouse_orders>>,
                    response: Response<List<Warehouse_orders>>
                ) {
                    Log.d(TAG, "onResponse: ${response.code()} ${response.body()}")
                    if (response.code() == 200) {
                        if (response.body()!!.isNotEmpty()) {
                            list.addAll(response.body()!!)
                            Log.d(TAG, "added list: $list")
                            getOrders(page+1)
                        } else {
                            setAdapter(list)
                            Log.d(TAG, "list: $list")
                        }
                    }
                }

                override fun onFailure(call: Call<List<Warehouse_orders>>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    setAdapter(list)
                }

            })

    }

    private fun setAdapter(list: ArrayList<Warehouse_orders>) {
        var skladAdapter = SkladAdapter(requireContext(), this.list)
        binding.skladBuyurtmalarRv.adapter = skladAdapter


    }

}