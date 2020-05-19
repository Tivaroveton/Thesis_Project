package com.codemobiles.project_eva

data class ProjectClass(
    val error: Boolean,
    val error_msg: String,
    var rows: List<ProjectRow>? = null
)

data class ProjectRow(
    var projectID : String,
    var staffID : String,
    var buildingName : String,
    var projectName : String,
    var inspectiondate : String
)
