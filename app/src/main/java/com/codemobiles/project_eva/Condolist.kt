package com.codemobiles.project_eva

data class CondoBean(
    val error: Boolean,
    val error_msg: String,
    val condos: List<Condo>
)


data class Condo(
    val id: String,
    val subtitle: String,
    val title: String
//    ,val image: String
){
    constructor(): this("","", "")
}