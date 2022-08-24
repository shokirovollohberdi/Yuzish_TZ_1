package uz.shokirov.yuzishtz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.shokirov.yuzishtz.adapters.QaytaYuvishAdapter
import uz.shokirov.yuzishtz.adapters.YakunlanmaganBuyurtmalarAdapter
import uz.shokirov.yuzishtz.adapters.YangiBuyurtmalarAdapter
import uz.shokirov.yuzishtz.databinding.FragmentBuyurtmaQabulQilsihBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BuyurtmaQabulQilsihFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BuyurtmaQabulQilsihFragment : Fragment() {
    lateinit var binding: FragmentBuyurtmaQabulQilsihBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentBuyurtmaQabulQilsihBinding.inflate(layoutInflater)


        setAdapter()
        binding.scrollView.bindSpringToParent = true

        return binding.root
    }

    private fun setAdapter() {
        var list = ArrayList<String>()
        for (i in 0..15){
            list.add("Shokirov Ollohberdi")
        }
        var qaytaYuvishAdapter = QaytaYuvishAdapter(list)
        binding.qaytaYuvishRv.adapter = qaytaYuvishAdapter
        var yakunlanmaganBuyurtmalarAdapter = YakunlanmaganBuyurtmalarAdapter(list)
        binding.yakunlanmaganRv.adapter = yakunlanmaganBuyurtmalarAdapter
        var yangiBuyurtmalarAdapter = YangiBuyurtmalarAdapter(list)
        binding.yangiBuyurtmaRv.adapter = yangiBuyurtmalarAdapter
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BuyurtmaQabulQilsihFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BuyurtmaQabulQilsihFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}