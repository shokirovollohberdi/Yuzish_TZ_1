package uz.shokirov.yuzishtz.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.yuzishtz.databinding.TartiblanganBuyurtmaRvBinding
import uz.shokirov.yuzishtz.model.Orders

class TartiblanganAdapter(var list: ArrayList<Orders>, var onclick: TartiblanganAdapterClick) :
    RecyclerView.Adapter<TartiblanganAdapter.Vh>() {
    inner class Vh(var itemRv: TartiblanganBuyurtmaRvBinding) :
        RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(orders: Orders, position: Int) {
            itemRv.tvName.text = orders.costumer?.costumer_name
            itemRv.tvNumber.text = orders.costumer?.costumer_phone_1
            itemRv.tvOperator.text  = orders.operator?.fullname

            itemRv.cardTopshirish.setOnClickListener {
                onclick.topshirish(orders)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            TartiblanganBuyurtmaRvBinding.inflate(
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

interface TartiblanganAdapterClick {
    fun topshirish(orders: Orders)
    fun count()
}