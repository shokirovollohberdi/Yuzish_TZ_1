package uz.shokirov.yuzishtz.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.yuzishtz.databinding.KpiRvBinding
import uz.shokirov.yuzishtz.databinding.SkladBuyurtmalarRvBinding

class KPIAdapter(var list: ArrayList<String>) :
    RecyclerView.Adapter<KPIAdapter.Vh>() {
    inner class Vh(var itemRv: KpiRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(string: String, position: Int) {
           itemRv.tvName.text = string
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(KpiRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}