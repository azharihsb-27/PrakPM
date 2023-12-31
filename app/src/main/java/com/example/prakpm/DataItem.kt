package com.example.prakpm

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DataItem : Serializable {
    @field:SerializedName("staff_name")
    val staffName: String? = null

    @field:SerializedName("staff_id")
    val staffId: String? = null

    @field:SerializedName("staff_hp")
    val staffHp: String? = null

    @field:SerializedName("staff_address")
    val staffAddress: String? = null
}