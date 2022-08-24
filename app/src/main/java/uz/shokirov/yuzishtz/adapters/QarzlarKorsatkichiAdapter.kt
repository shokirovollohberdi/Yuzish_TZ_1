package uz.shokirov.yuzishtz.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.yuzishtz.R
import uz.shokirov.yuzishtz.databinding.QarzlarKorsatkichiRvBinding
import uz.shokirov.yuzishtz.databinding.QarzlarRvBinding
import uz.shokirov.yuzishtz.databinding.SkladBuyurtmalarRvBinding

class QarzlarKorsatkichiAdapter(var list: ArrayList<String>) :
    RecyclerView.Adapter<QarzlarKorsatkichiAdapter.Vh>() {
    inner class Vh(var itemRv: QarzlarKorsatkichiRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(string: String, position: Int) {
            itemRv.tvName.text = string

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(QarzlarKorsatkichiRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}