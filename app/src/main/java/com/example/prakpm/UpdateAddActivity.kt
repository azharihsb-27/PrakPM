package com.example.prakpm

<<<<<<< Updated upstream
=======
import android.annotation.SuppressLint
import android.content.Intent
>>>>>>> Stashed changes
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class UpdateAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_add)
    }

    override fun onSuccessAdd(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onErrorAdd(msg: String) {}

    override fun onSuccessUpdate(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onErrorupdate(msg: String) {}

    override fun onSuccessGet(data: List<DataItem>?) {}

    override fun onFailedGet(msg: String) {}

    override fun onSuccessDelete(msg: String) {}

    override fun onErrorDelete(msg: String) {}
}