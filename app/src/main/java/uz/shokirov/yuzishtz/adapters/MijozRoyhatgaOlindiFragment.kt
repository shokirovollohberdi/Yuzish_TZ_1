package uz.shokirov.yuzishtz.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.yuzishtz.databinding.KpiRvBinding
import uz.shokirov.yuzishtz.databinding.MijozRoyhatgaOlindiRvBinding
import uz.shokirov.yuzishtz.databinding.SkladBuyurtmalarRvBinding

class MijozRoyhatgaOlindiAdapter(var list: ArrayList<String>) :
    RecyclerView.Adapter<MijozRoyhatgaOlindiAdapter.Vh>() {
    inner class Vh(var itemRv: MijozRoyhatgaOlindiRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(string: String, position: Int) {
           itemRv.tvName.text = string
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(MijozRoyhatgaOlindiRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}