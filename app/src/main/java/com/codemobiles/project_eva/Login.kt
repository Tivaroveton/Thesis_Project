package com.codemobiles.project_eva

data class LoginClass(
    val error: Boolean,
    val error_msg: String,
    var rows: List<Row>? = null
)

data class Row(
    var staffID: String,
    var staffType: Int
)
