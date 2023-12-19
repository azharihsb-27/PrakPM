package com.example.prakpm

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.prakpm.databinding.ActivityUpdateAddBinding

@Suppress("SENSELESS_COMPARISON")
class ActivityUpdateAdd : AppCompatActivity(), CrudView {
    private lateinit var presenter: Presenter2
    private lateinit var binding: ActivityUpdateAddBinding
    @SuppressLint("SexTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter2(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        if(itemDataItem == null) {
            binding.btnAction.text = "Tambah"
            binding.btnAction.setOnClickListener {
                
                presenter.addData(
                    binding.etName.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etAddress.text.toString())
            }
        } else if (itemDataItem != null){
            binding.btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            binding.etName.setText(item?.staffName.toString())
            binding.etPhone.setText(item?.staffHp.toString())
            binding.etAddress.setText(item?.staffAddress.toString())
            binding.btnAction.setOnClickListener {
                presenter.updateData(
                    item?.staffId ?: "",
                    binding.etName.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etAddress.text.toString())
                finish()
            }
        }
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

    override fun onErrorUpdate(msg: String) {}

    override fun onSuccessGet(data: List<DataItem>?) {}

    override fun onErrorGet(msg: String) {}

    override fun onSuccessDelete(msg: String) {}

    override fun onErrorDelete(msg: String) {}
}