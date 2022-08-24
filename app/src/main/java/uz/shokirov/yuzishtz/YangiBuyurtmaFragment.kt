package uz.shokirov.yuzishtz

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.shokirov.yuzishtz.adapters.QidirilganYangiBuyurtmalarAdapter
import uz.shokirov.yuzishtz.databinding.FragmentYangiBuyurtmaBinding
import uz.shokirov.yuzishtz.model.Costumer
import uz.shokirov.yuzishtz.model.SearchMijoz
import uz.shokirov.yuzishtz.retrofit_client.RetrofitClient


class YangiBuyurtmaFragment : Fragment() {
    lateinit var binding: FragmentYangiBuyurtmaBinding
    private val TAG = "YangiBuyurtmaFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYangiBuyurtmaBinding.inflate(layoutInflater)


        binding.tvSearchResult.visibility = View.GONE

        binding.cardAdd.setOnClickListener {
            findNavController().navigate(R.id.addNewMijozFragment)
            binding.editSearch.text.clear()
        }


        binding.search.setOnClickListener {
            searchCostumer(binding.editSearch.text.toString().trim())
        }


        return binding.root
    }


    private fun searchCostumer(text: String) {
        RetrofitClient.getRetrofit().searchCostumer(text.trim()).enqueue(object :
            Callback<List<SearchMijoz>> {
            override fun onResponse(
                call: Call<List<SearchMijoz>>,
                response: Response<List<SearchMijoz>>
            ) {
                if (response.isSuccessful && response.code() == 200) {
                    var list = ArrayList<SearchMijoz>()
                    Log.d(TAG, "onResponse: $list")
                    Log.d(TAG, "onResponse: ${response.body()}")
                    list.addAll(response.body()!!)
                    if (response.body() == null) {
                        Toast.makeText(requireContext(), "Hech narsa topilmadi", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        setAdapter(list)
                    }
                } else {
                    Log.d(TAG, "onResponse: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<SearchMijoz>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.localizedMessage}")
            }

        })

    }

    private fun setAdapter(list: ArrayList<SearchMijoz>) {
        var qidirilganYangiBuyurtmalarAdapter = QidirilganYangiBuyurtmalarAdapter(requireContext(),list)
        binding.tvSearchResult.visibility = View.VISIBLE
        binding.tvSearchResult.text = "Qidiruv natijalari ${list.size}ta"
        binding.yangiBuyurtmaRv.adapter = qidirilganYangiBuyurtmalarAdapter

        binding.yangiBuyurtmaRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if (dy > 0) {
                    binding.tvYangiMijoz.visibility = View.VISIBLE
                } else {
                    binding.tvYangiMijoz.visibility = View.GONE
                }

            }
        })

    }


}