package uz.shokirov.yuzishtz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.shokirov.yuzishtz.adapters.BuyurtmalarHolatidapter
import uz.shokirov.yuzishtz.databinding.FragmentBuyurtmalarBinding


class BuyurtmalarFragment : Fragment() {
    lateinit var binding: FragmentBuyurtmalarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuyurtmalarBinding.inflate(layoutInflater)

        setAdapter()

        return binding.root
    }

    private fun setAdapter() {

        var list = ArrayList<String>()

        for (i in 0..5) {
            list.add("Status: tayyor")
            list.add("Status: qayta yuvish")
            list.add("Status: quridi")
        }

        var adapter = BuyurtmalarHolatidapter(list)
        binding.rv.adapter = adapter
    }

}