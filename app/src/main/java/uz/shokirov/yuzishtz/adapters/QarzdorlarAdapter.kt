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

class QarzdorlarAdapter(var list: ArrayList<String>, var context: Context) :
    RecyclerView.Adapter<QarzdorlarAdapter.Vh>() {
    inner class Vh(var itemRv: QarzlarRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(string: String, position: Int) {
            itemRv.tvName.text = string
            setAdapter()
        }

        private fun setAdapter() {
            var types = ArrayList<String>()
            types.add("Naqd")
            types.add("Plastic")
            types.add("Click")
            var arrayAdapter = ArrayAdapter(context, R.layout.dropdown_item, types)
            itemRv.coastType.setAdapter(arrayAdapter)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(QarzlarRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}