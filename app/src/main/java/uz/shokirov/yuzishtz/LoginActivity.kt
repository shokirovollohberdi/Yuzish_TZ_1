package uz.shokirov.yuzishtz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.shokirov.yuzishtz.data.DataSources
import uz.shokirov.yuzishtz.databinding.ActivityLoginBinding
import uz.shokirov.yuzishtz.model.LoginModel
import uz.shokirov.yuzishtz.retrofit_client.RetrofitClient


var token = ""

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private val TAG = "LoginActivity"
    val dataSources = DataSources()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        checkUser()

        binding.btnLogin.setOnClickListener {
            auth(
                binding.edtUsername.text.toString().trim(),
                binding.edtUsername.text.toString().trim()
            )
        }


    }

    override fun onRestart() {
        finishAffinity()
        super.onRestart()
    }

    private fun checkUser() {
        if (dataSources.isLogin(this)) {
            startActivity(Intent(this, MainActivity::class.java))
            token = dataSources.getToken(this)
        }
    }

    private fun auth(username: String, password: String) {
        RetrofitClient.getRetrofit().checkUser(username, password)
            .enqueue(object : Callback<LoginModel> {
                override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                    if (response.isSuccessful) {
                        if (response.code() == 200) {
                            if (response.body()?.role == "transport") {
                                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                                dataSources.setLogin(this@LoginActivity, true)
                                dataSources.saveToken(
                                    this@LoginActivity,
                                    response.body()!!.access_token
                                )
                                dataSources.saveRole(this@LoginActivity, response.body()!!.role)
                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Ushbu hisobga kira olaysiz",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Log.d(TAG, "onResponse: ${response.code()}")
                            Toast.makeText(
                                this@LoginActivity,
                                "Xatolik yuz berdi",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                }

                override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Xatolik yuz berdi", Toast.LENGTH_SHORT)
                        .show()
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                }

            })

    }
}