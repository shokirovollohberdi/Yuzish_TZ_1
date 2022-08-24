package uz.shokirov.yuzishtz

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import uz.shokirov.yuzishtz.adapters.QarzdorlarAdapter
import uz.shokirov.yuzishtz.adapters.YuklanmaganQarzlarAdapter
import uz.shokirov.yuzishtz.databinding.FilterDialogBinding
import uz.shokirov.yuzishtz.databinding.FragmentQarzdorlarBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QarzdorlarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QarzdorlarFragment : Fragment() {
    lateinit var binding: FragmentQarzdorlarBinding

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
        binding = FragmentQarzdorlarBinding.inflate(layoutInflater)


        setAdapter()

        binding.cardFilter.setOnClickListener {
            dialogFilter()
        }

        return binding.root
    }

    private fun dialogFilter() {
        var dialog = AlertDialog.Builder(requireContext()).create()
        var item = FilterDialogBinding.inflate(layoutInflater)
        dialog.setView(item.root)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        var types = ArrayList<String>()
        types.add("Naqd")
        types.add("Plactic")
        types.add("Click")
        var arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, types)
        item.autocomplete.setAdapter(arrayAdapter)
        dialog.show()

    }

    private fun setAdapter() {
        var list = ArrayList<String>()
        for (i in 0..10) {
            list.add("Shokirov Ollohberdi")
        }
        var qarzdorlarAdapter = QarzdorlarAdapter(list, requireContext())
        binding.qarzlarRv.adapter = qarzdorlarAdapter

        var yuklanmaganQarzlar = YuklanmaganQarzlarAdapter(list)
        binding.yuklanmaganQarzlarRv.adapter = yuklanmaganQarzlar
    }


    override fun onResume() {
        super.onResume()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QarzdorlarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QarzdorlarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}