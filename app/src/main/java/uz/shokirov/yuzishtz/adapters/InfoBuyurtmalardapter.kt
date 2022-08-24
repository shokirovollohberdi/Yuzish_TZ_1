package uz.shokirov.yuzishtz.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.yuzishtz.R
import uz.shokirov.yuzishtz.databinding.InfoBuyurtmaRvBinding
import uz.shokirov.yuzishtz.databinding.KpiRvBinding
import uz.shokirov.yuzishtz.databinding.SkladBuyurtmalarRvBinding
import uz.shokirov.yuzishtz.model.buyurtma_topshirish.Buyurtmalar
import uz.shokirov.yuzishtz.model.buyurtma_topshirish.Product


class InfoBuyurtmalardapter(var list: ArrayList<Buyurtmalar>) :
    RecyclerView.Adapter<InfoBuyurtmalardapter.Vh>() {
    inner class Vh(var itemRv: InfoBuyurtmaRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(buyurtmalar: Buyurtmalar, position: Int) {
            itemRv.tvProduct.text = buyurtmalar.name


            var listProduct = ArrayList<Product>()
            listProduct.addAll(list[position].products)

            var adapter = InfoIchkiBuyurtmalardapter(listProduct,list)
            itemRv.infoIchiRv.adapter = adapter


            itemRv.tvCountAndSumma.text = "${listProduct.size} ta | ${buyurtmalar.summa}"

            itemRv.imageHideShow.setOnClickListener {
                hideShow()
            }
            itemRv.root.setOnClickListener {
                hideShow()
            }
        }

        private fun hideShow() {
            if (itemRv.infoIchiRv.visibility == View.GONE) {
                itemRv.infoIchiRv.visibility = View.VISIBLE
                itemRv.allLinear.visibility = View.VISIBLE
                itemRv.imageHideShow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                itemRv.infoIchiRv.visibility = View.GONE
                itemRv.allLinear.visibility = View.GONE
                itemRv.imageHideShow.setImageResource(R.drawable.ic_arrow_down)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(InfoBuyurtmaRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}