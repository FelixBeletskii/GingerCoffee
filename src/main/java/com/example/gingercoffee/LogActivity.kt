package com.example.gingercoffee

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.gingercoffee.databinding.ActivityLogBinding

class LogActivity : AppCompatActivity() {
    lateinit var bind: ActivityLogBinding
    val dataModel: DataModel by viewModels()
    val arrayOfUsers = ArrayList<User>()
    var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLogBinding.inflate(layoutInflater)
        setContentView(bind.root)
        openFrag(AuthFragment(), R.id.view_pager)
        var AuthIsActive = true


        with(bind) {
            btnToReg.setOnClickListener {
                if (AuthIsActive) {
                    openFrag(RegFragment(), R.id.view_pager)
                    AuthIsActive = false
                    btnToReg.setText(R.string.auth_button)

                    btnAuth.setText(R.string.sign_up)

                } else {
                    openFrag(AuthFragment(), R.id.view_pager)
                    AuthIsActive = true
                    btnToReg.setText(R.string.registration_button)

                    btnAuth.setText(R.string.sign_in)

                }
            }
            btnAuth.setOnClickListener {
                val intent = Intent(this@LogActivity, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }


    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager.beginTransaction().replace(idHolder, f).commit()
    }
}


