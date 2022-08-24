package uz.shokirov.yuzishtz

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import uz.shokirov.yuzishtz.databinding.FragmentAddNewMijozBinding
import uz.shokirov.yuzishtz.databinding.SaveOrUnsaveDialogBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddNewMijozFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddNewMijozFragment : Fragment() {
    lateinit var binding: FragmentAddNewMijozBinding

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
        binding = FragmentAddNewMijozBinding.inflate(layoutInflater)


        setAdapter()

        binding.enterLayout.setOnClickListener {
            saveOrNotDialog()
/*
            var t = binding.languageAutocomplete.text
            Toast.makeText(requireContext(), t, Toast.LENGTH_SHORT).show()*/
        }


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setAdapter()
    }

    private fun saveOrNotDialog() {
        var dialog = AlertDialog.Builder(requireContext()).create()
        var item = SaveOrUnsaveDialogBinding.inflate(layoutInflater)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setView(item.root)
        item.btnCancel.setOnClickListener {
            dialog.hide()
        }
        item.btnAccept.setOnClickListener {
            dialog.hide()
        }


        dialog.show()
    }

    private fun setAdapter() {
        var languages = ArrayList<String>()
        languages.add("O'zbek")
        languages.add("Qirg'iz")
        languages.add("Tojik")
        languages.add("Rus")
        languages.add("Tatar")
        var languagesArrayAdapter =
            ArrayAdapter(requireContext(), R.layout.dropdown_item, languages)
        binding.languageAutocomplete.setAdapter(languagesArrayAdapter)

        val manbaa = ArrayList<String>()
        manbaa.add("Telegram")
        manbaa.add("Instagram")
        manbaa.add("You Tube")
        manbaa.add("Gazeta")
        manbaa.add("Banner")
        manbaa.add("Odamlar")

        var manbaaAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, manbaa)
        binding.manbaaAutocomplate.setAdapter(manbaaAdapter)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddNewMijozFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddNewMijozFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}