package com.example.prakpm

interface CrudView {
    fun onSuccessGet(data : List<DataItem>?)
    fun onFailedGet(msg : String)

    fun onSuccessAdd(msg : String)
    fun errorAdd(msg : String)

    fun onSuccessUpdate(msg : String)
    fun errorupdate(msg : String)

    fun onSuccessDelete(msg : String)
    fun errorDelete(msg : String)
}