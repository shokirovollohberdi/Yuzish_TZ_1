package uz.shokirov.yuzishtz.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.yuzishtz.R
import uz.shokirov.yuzishtz.databinding.BuyurtmalarHolatiRvBinding
import uz.shokirov.yuzishtz.databinding.InfoBuyurtmaRvBinding
import uz.shokirov.yuzishtz.databinding.KpiRvBinding
import uz.shokirov.yuzishtz.databinding.SkladBuyurtmalarRvBinding


class BuyurtmalarHolatidapter(var list: ArrayList<String>) :
    RecyclerView.Adapter<BuyurtmalarHolatidapter.Vh>() {
    inner class Vh(var itemRv: BuyurtmalarHolatiRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(string: String, position: Int) {
           // itemRv.tvStatus.text = string

            var list = ArrayList<String>()
            for (i in 0..5) {
                list.add("Summa")
            }

            var adapter = BuyurtmalarHolatIchkidapter(list)
            itemRv.ichkiRv.adapter = adapter

            itemRv.root.setOnClickListener {
                hideshow()
            }

          /*  itemRv.imageHideShow.setOnClickListener {
                if (itemRv.ichkiRv.visibility == View.GONE) {
                    itemRv.ichkiRv.visibility = View.VISIBLE
                    itemRv.imageHideShow.setImageResource(R.drawable.ic_arrow_up)
                } else {
                    itemRv.ichkiRv.visibility = View.GONE
                    itemRv.imageHideShow.setImageResource(R.drawable.ic_arrow_down)
                }
            }*/
        }

        private fun hideshow() {
            if (itemRv.ichkiRv.visibility == View.GONE){
                itemRv.ichkiRv.visibility = View.VISIBLE
            }else{
                itemRv.ichkiRv.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            BuyurtmalarHolatiRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}