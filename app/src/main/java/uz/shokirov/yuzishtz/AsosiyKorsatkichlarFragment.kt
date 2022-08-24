package uz.shokirov.yuzishtz

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import uz.shokirov.yuzishtz.databinding.FragmentAsosiyKorsatkichlarBinding
import java.text.DateFormat
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AsosiyKorsatkichlarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AsosiyKorsatkichlarFragment : Fragment() {
    lateinit var binding: FragmentAsosiyKorsatkichlarBinding

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
        binding = FragmentAsosiyKorsatkichlarBinding.inflate(layoutInflater)


        setDatePicker()

        binding.tvKpi.setOnClickListener {
            findNavController().navigate(R.id.KPIhisobFragment)
        }
        binding.tvMijozRoyhatgaOlindi.setOnClickListener {
            findNavController().navigate(R.id.mijozroyhatgaOlindiFragment)
        }
        binding.tvBuyurtmaBekorQilindi.setOnClickListener {
            findNavController().navigate(R.id.buyurtma_bekor_qilindi_Fragment)
        }
        binding.tvBuyurtmaQabulQilindi.setOnClickListener {
            findNavController().navigate(R.id.olinganBuyurtmaFragment)
        }
        binding.tvMahsulotOlindi.setOnClickListener {
            findNavController().navigate(R.id.mahsulotOlindiFragment)
        }
        binding.topshirildiFragment.setOnClickListener {
            findNavController().navigate(R.id.topshirildiFragment)
        }
        binding.tvQarz.setOnClickListener {
            findNavController().navigate(R.id.qarzlarFragment)
        }
        binding.tvKechildi.setOnClickListener {
            findNavController().navigate(R.id.kechildiFragment)
        }

          binding.tvKunlikMaosh.setOnClickListener {
            findNavController().navigate(R.id.kunlikMaoshFragment)
        }

          binding.tvOlinganMaosh.setOnClickListener {
            findNavController().navigate(R.id.olinganMaoshFragment)
        }

          binding.tvQaytaYuvishgaOlindi.setOnClickListener {
            findNavController().navigate(R.id.qaytaYuvishgaOlindiFragment)
        }
        binding.tvBuyurtmaOlibKelindi.setOnClickListener {
            findNavController().navigate(R.id.buyurtmaOlibKelindiFragment)
        }



        return binding.root
    }


    private fun setDatePicker() {
        binding.tvDateFrom.setOnClickListener {
            val datePickerDialog = DatePickerDialog(requireContext())
            datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                var date = "${dayOfMonth}/${month + 1}/$year"
                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                val formatted = date.format(formatter)
                binding.tvDateFrom.text = formatted
            }
            datePickerDialog.show()

        }
        binding.tvDateTo.setOnClickListener {
            val datePickerDialog = DatePickerDialog(requireContext())
            datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                var date = "${dayOfMonth}/${month + 1}/$year"
                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                val formatted = date.format(formatter)
                binding.tvDateTo.text = formatted
            }
            datePickerDialog.show()

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AsosiyKorsatkichlarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AsosiyKorsatkichlarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}