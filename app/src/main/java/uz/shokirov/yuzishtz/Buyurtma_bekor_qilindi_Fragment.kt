package uz.shokirov.yuzishtz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.shokirov.yuzishtz.adapters.BuyurtmaBekorQilindiAdapter
import uz.shokirov.yuzishtz.databinding.FragmentBuyurtmaBekorQilindiBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Buyurtma_bekor_qilindi_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Buyurtma_bekor_qilindi_Fragment : Fragment() {
    lateinit var binding:FragmentBuyurtmaBekorQilindiBinding
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
        binding = FragmentBuyurtmaBekorQilindiBinding.inflate(layoutInflater)


        setAdapter()

        return binding.root
    }

    private fun setAdapter() {
        var list = ArrayList<String>()
        for (i in 0..10){
            list.add("Shokirov Ollohberdi")
        }
        var adapter = BuyurtmaBekorQilindiAdapter(list)
        binding.buyurtmaBekorQilindiRv.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Buyurtma_bekor_qilindi_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Buyurtma_bekor_qilindi_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}