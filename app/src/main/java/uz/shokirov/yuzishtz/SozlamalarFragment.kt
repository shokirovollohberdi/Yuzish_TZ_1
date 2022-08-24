package uz.shokirov.yuzishtz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import uz.shokirov.yuzishtz.databinding.FragmentSozlamalarBinding



class SozlamalarFragment : Fragment() {
    lateinit var binding: FragmentSozlamalarBinding
    private val TAG = "SozlamalarFragment"
    var see = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            Log.d(TAG, "onCreateView: 1")
        } else {
            Log.d(TAG, "onCreateView: 2")
        }
        binding = FragmentSozlamalarBinding.inflate(layoutInflater)




        return binding.root
    }

    override fun onResume() {
        super.onResume()

    }


}