package uz.shokirov.yuzishtz.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.yuzishtz.R
import uz.shokirov.yuzishtz.databinding.QarzlarRvBinding
import uz.shokirov.yuzishtz.databinding.SkladBuyurtmalarRvBinding
import uz.shokirov.yuzishtz.databinding.YuklanmaganQarzlarRvBinding

class YuklanmaganQarzlarAdapter(var list: ArrayList<String>) :
    RecyclerView.Adapter<YuklanmaganQarzlarAdapter.Vh>() {
    inner class Vh(var itemRv: YuklanmaganQarzlarRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(string: String, position: Int) {
            itemRv.tvName.text = string

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(YuklanmaganQarzlarRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}