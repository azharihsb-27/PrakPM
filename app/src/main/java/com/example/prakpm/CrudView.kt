package com.example.prakpm

interface CrudView {
    //get data
    fun onSuccessGet(data : List<DataItem>?)
    fun onErrorGet(msg : String)

    //menambah data
    fun onSuccessAdd(msg : String)
    fun onErrorAdd(msg : String)

    //update data
    fun onSuccessUpdate(msg : String)
    fun onErrorUpdate(msg : String)

    //hapus data
    fun onSuccessDelete(msg : String)
    fun onErrorDelete(msg : String)
}