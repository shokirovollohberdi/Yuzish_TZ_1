package uz.shokirov.yuzishtz.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.yuzishtz.databinding.InfoBuyurtmaRvBinding
import uz.shokirov.yuzishtz.databinding.InfoBuyurtmalarIchiRvBinding
import uz.shokirov.yuzishtz.databinding.KpiRvBinding
import uz.shokirov.yuzishtz.databinding.SkladBuyurtmalarRvBinding
import uz.shokirov.yuzishtz.model.buyurtma_topshirish.Buyurtmalar
import uz.shokirov.yuzishtz.model.buyurtma_topshirish.Product


class InfoIchkiBuyurtmalardapter(
    var list: ArrayList<Product>,
    var buyurtmalar: ArrayList<Buyurtmalar>
) :
    RecyclerView.Adapter<InfoIchkiBuyurtmalardapter.Vh>() {
    inner class Vh(var itemRv: InfoBuyurtmalarIchiRvBinding) :
        RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(product: Product, position: Int) {
            Log.d("InfoIchkiBuyurtmalardapter", "onBind: $list\n $buyurtmalar")
            itemRv.tvSumma.text = product.summa.toString() + " so'm"
            itemRv.tvNarx.text = product.narx.toString() + " so'm"
            if (buyurtmalar[position].olchov == "metr") {
                itemRv.tvOlcham.text =
                    "${list[position].gilam_boyi} x ${list[position].gilam_eni} = ${list[position].clean_hajm}"
            }else{
                itemRv.tvOlcham.text = list[position].clean_hajm.toString()
            }
            itemRv.tvStyaj.text = product.joy
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            InfoBuyurtmalarIchiRvBinding.inflate(
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