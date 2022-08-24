package uz.shokirov.yuzishtz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.shokirov.yuzishtz.adapters.TartiblanganAdapter
import uz.shokirov.yuzishtz.adapters.TartiblanganAdapterClick
import uz.shokirov.yuzishtz.adapters.TartiblanmaganAdapter
import uz.shokirov.yuzishtz.adapters.TartiblanmaganAdapterClick
import uz.shokirov.yuzishtz.databinding.FragmentTayyorBuyurtmalarBinding
import uz.shokirov.yuzishtz.model.Orders
import uz.shokirov.yuzishtz.retrofit_client.RetrofitClient


class TayyorBuyurtmalarFragment : Fragment() {
    lateinit var binding: FragmentTayyorBuyurtmalarBinding
    lateinit var arrangedOrders: ArrayList<Orders>
    lateinit var notArrangedOrders: ArrayList<Orders>
    private val TAG = "TayyorBuyurtmalarFragme"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTayyorBuyurtmalarBinding.inflate(layoutInflater)

        getOrders(-1, 0, "notarranged")
        getOrders(-1, 0, "arranged")

        binding.tvOrderNumber.setOnClickListener {
            findNavController().navigate(R.id.buyurtmaQabulQilsihFragment)
        }
        binding.tvSkladNumber.setOnClickListener {
            findNavController().navigate(R.id.skladFragment)
        }


        return binding.root
    }


    private fun getOrders(page: Int, driver: Int, type: String) {
        notArrangedOrders = ArrayList()
        arrangedOrders = ArrayList()
        RetrofitClient.getRetrofit().getOrders(page, driver, type)
            .enqueue(object : Callback<List<Orders>> {
                override fun onResponse(
                    call: Call<List<Orders>>,
                    response: Response<List<Orders>>
                ) {
                    if (response.code() == 200) {
                        if (type == "notarranged") {
                            var list = response.body()
                            notArrangedOrders.addAll(list!!)
                        } else if (type == "arranged") {
                            var list = response.body()
                            arrangedOrders.addAll(list!!)
                        }
                        setAdapter()
                    }
                }

                override fun onFailure(call: Call<List<Orders>>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                }

            })
    }

    private fun setAdapter() {
        var notarranged =
            TartiblanmaganAdapter(
                requireContext(),
                notArrangedOrders,
                object : TartiblanmaganAdapterClick {
                    override fun topshirish(orders: Orders) {
                        Log.d(TAG, "topshirish: ${orders.order_id}")
                        findNavController().navigate(
                            R.id.infoBuyurtmaFragment,
                            bundleOf("order" to orders)
                        )

                    }

                    override fun count(orders: Orders) {

                    }
                })
        binding.tartiblanmaganBuyurtmaRv.adapter = notarranged


        var arranged = TartiblanganAdapter(arrangedOrders, object : TartiblanganAdapterClick {
            override fun topshirish(orders: Orders) {
                findNavController().navigate(
                    R.id.infoBuyurtmaFragment,
                    bundleOf("order" to orders)
                )
            }

            override fun count() {

            }
        })

        binding.tartiblanganBuyurtmaRv.adapter = arranged
    }


    override fun onResume() {
        super.onResume()
        getOrders(1, 0, "notarranged")
        getOrders(1, 0, "arranged")
    }


}