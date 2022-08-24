package uz.shokirov.yuzishtz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import uz.shokirov.yuzishtz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()




        binding.imageMenu.setOnClickListener {
            binding.drawableRoot.open()
        }


        binding.navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.asosiyKorsatkichlarFragment -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.asosiyKorsatkichlarFragment)
                    binding.drawableRoot.close()
                }
                R.id.yangiBuyurtmaFragment -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.yangiBuyurtmaFragment)
                    binding.drawableRoot.close()

                }
                R.id.buyurtmaQabulQilsihFragment -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.buyurtmaQabulQilsihFragment)
                    binding.drawableRoot.close()
                }
                R.id.tayyorBuyurtmalarFragment -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.tayyorBuyurtmalarFragment)
                    binding.drawableRoot.close()
                }
                R.id.skladFragment -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.skladFragment)
                    binding.drawableRoot.close()
                }
                R.id.qarzdorlarFragment -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.qarzdorlarFragment)
                    binding.drawableRoot.close()
                }
                R.id.buyurtmalarFragment -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.buyurtmalarFragment)
                    binding.drawableRoot.close()
                }
                R.id.sozlamalarFragment -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.sozlamalarFragment)
                    binding.drawableRoot.close()
                }


            }


            true
        }

    }

    /* fun asosiy(view: View) {
         binding.drawableRoot.close()
         findNavController(R.id.fragmentContainerView).navigate(R.id.asosiyKorsatkichlarFragment)


     }

     fun yangi_buyurtma(view: View) {
         binding.drawableRoot.close()
         findNavController(R.id.fragmentContainerView).navigate(R.id.yangiBuyurtmaFragment)


     }

     fun sozlamalar(view: View) {
         binding.drawableRoot.close()
         findNavController(R.id.fragmentContainerView).navigate(R.id.sozlamalarFragment)

     }

     fun buyurtma_qabul_qilish(view: View) {
         binding.drawableRoot.close()
         findNavController(R.id.fragmentContainerView).navigate(R.id.buyurtmaQabulQilsihFragment)
     }

     fun tayyor_buyurtmalar(view: View) {
         binding.drawableRoot.close()
         findNavController(R.id.fragmentContainerView).navigate(R.id.tayyorBuyurtmalarFragment)
     }

     fun sklad_bolimi(view: View) {
         binding.drawableRoot.close()
         findNavController(R.id.fragmentContainerView).navigate(R.id.skladFragment)
     }

     fun qarzdorlar_bolimi(view: View) {
         binding.drawableRoot.close()
         findNavController(R.id.fragmentContainerView).navigate(R.id.qarzdorlarFragment)
     }

     fun buyurtmalar_holati(view: View) {
         binding.drawableRoot.close()
         findNavController(R.id.fragmentContainerView).navigate(R.id.buyurtmalarFragment)
     }*/

}