package com.example.prakpm

import retrofit2.Call
import retrofit2.Response

class Presenter2 (val crudView: ActivityUpdateAdd) {
    fun addData(name : String, hp : String, address : String) {
        NetworkConfig.getService()
            .addStaff(name, hp, address)
            .enqueue(object : retrofit2.Callback<ResultStatus> {
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorAdd(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                   if (response.isSuccessful && response.body()?.status == 200) {
                       crudView.onSuccessAdd(response.body()?.pesan ?: "")
                   } else {
                       crudView.onErrorAdd(response.body()?.pesan ?: "")
                   }

                }
            })
    }
    fun updateData(id : String, name: String, hp: String, address: String) {
        NetworkConfig.getService()
            .updateStaff(id, name, hp, address)
            .enqueue(object : retrofit2.Callback<ResultStatus> {
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorUpdate(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessUpdate(response.body()?.pesan?: "")

                    } else{
                        crudView.onErrorUpdate(response.body()?.pesan?: "")
                    }
                }
            })
    }

}