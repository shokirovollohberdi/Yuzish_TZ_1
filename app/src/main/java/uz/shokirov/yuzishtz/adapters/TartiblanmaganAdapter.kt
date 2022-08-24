package uz.shokirov.yuzishtz.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.yuzishtz.databinding.TartiblanmaganBuyurtmaRvBinding
import uz.shokirov.yuzishtz.model.Orders
import java.util.*
import kotlin.collections.ArrayList

class TartiblanmaganAdapter(
    var context: Context,
    var list: ArrayList<Orders>,
    var onclick: TartiblanmaganAdapterClick
) :
    RecyclerView.Adapter<TartiblanmaganAdapter.Vh>() {
    inner class Vh(var itemRv: TartiblanmaganBuyurtmaRvBinding) :
        RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(orders: Orders?, position: Int) {
            itemRv.tvName.text = orders?.costumer?.costumer_name
            itemRv.tvOperator.text = orders?.operator?.fullname
            itemRv.tvNumber.text = orders?.nomer.toString()
            itemRv.tvCount.text = orders?.product_count.toString() + " dona"
            itemRv.tvTartib.text = orders?.tartib_raqam.toString()

            try {
                itemRv.tvLocation.text = getCompleteAddressString(
                    orders?.geoplugin_latitude!!.toDouble(),
                    orders?.geoplugin_longitude!!.toDouble()
                )?.trim()
            } catch (e: Exception) {
                itemRv.tvLocation.text = " "
            }

            itemRv.cardTopshirish.setOnClickListener {
                onclick.topshirish(orders!!)
            }
            itemRv.tvCount.setOnClickListener {
                onclick.count(orders!!)
            }

        }

        private fun getCompleteAddressString(LATITUDE: Double, LONGITUDE: Double): String? {
            var strAdd = ""
            val geocoder = Geocoder(context, Locale.getDefault())
            try {
                val addresses: List<Address>? = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1)
                if (addresses != null) {
                    val returnedAddress: Address = addresses[0]
                    val strReturnedAddress = StringBuilder("")
                    for (i in 0..returnedAddress.getMaxAddressLineIndex()) {
                        strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n")
                    }
                    strAdd = strReturnedAddress.toString()
                    Log.w("My Current loction address", strReturnedAddress.toString())
                } else {
                    Log.w("My Current loction address", "No Address returned!")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.w("My Current loction address", "Canont get Address!")
            }
            return strAdd
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            TartiblanmaganBuyurtmaRvBinding.inflate(
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

interface TartiblanmaganAdapterClick {
    fun topshirish(orders: Orders)
    fun count(orders: Orders)
}