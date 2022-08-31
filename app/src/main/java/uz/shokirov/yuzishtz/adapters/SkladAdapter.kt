package uz.shokirov.yuzishtz.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.shokirov.yuzishtz.databinding.SkladBuyurtmalarRvBinding
import uz.shokirov.yuzishtz.model.warehouse_orders.Warehouse_orders
import java.util.*
import kotlin.collections.ArrayList

class SkladAdapter(var context: Context, var list: ArrayList<Warehouse_orders>) :
    RecyclerView.Adapter<SkladAdapter.Vh>() {
    inner class Vh(var itemRv: SkladBuyurtmalarRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("ResourceAsColor", "SetTextI18n")
        fun onBind(warehouseOrders: Warehouse_orders, position: Int) {
            itemRv.tvKvitansiyaNumber.text = "Kvitansiya №: "+"${warehouseOrders.nomer}"
            itemRv.tvComment.text = warehouseOrders.izoh
            itemRv.tvName.text = warehouseOrders.costumer.costumer_name
            itemRv.tvPhone.text = warehouseOrders.costumer.costumer_phone_1
            try {
                itemRv.tvLocation.text = getCompleteAddressString(
                    warehouseOrders.geoplugin_latitude.toDouble(),
                    warehouseOrders.geoplugin_longitude.toString().toDouble()
                )
            } catch (e: Exception) {
                itemRv.tvLocation.text = "-"
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
            SkladBuyurtmalarRvBinding.inflate(
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