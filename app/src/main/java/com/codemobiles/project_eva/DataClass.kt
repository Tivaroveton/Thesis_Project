package com.codemobiles.project_eva

data class DataClass(
    val error: Boolean,
    val error_msg: String,
    var rows: List<DataRow>? = null
)

data class DataRow(
    var projectName: String,
    var buildingName: String,
    var inspectiondate: String,
    var latitude: Float,
    var longtitude: Float,
    var districtID: Int,
    var districtName: String,
    var subdistrictID: Int,
    var subdistrictName: String,
    var haveBTS: Int,
    var haveMRT: Int,
    var haveBRT: Int,
    var nearestBTS: String,
    var distanceFromBTS: Int,
    var buildingControlAct: Int,

    var buildingFloor: Int,
    var units: Int,
    var buildingAge: Int,
    var buildingCondition: Int,
    var lobby: Int,
    var lift: Int,
    var swimmingPool: Int,
    var fitness: Int,
    var suana: Int,
    var jacuzzi: Int,
    var steam: Int,
    var library: Int,
    var garden: Int,
    var kidplay: Int,
    var parklot: Int,
    var automateParklot: Int,
    var golfCourse: Int,
    var movieRoom: Int,
    var shop: Int,
    var camFee: Float,

    var floor: String,
    var areaRoom: Float,
    var pricebyGov: Int,
    var fireInsurance: Int,
    var roomType: Int,
    var roomPosition: Int,
    var roomView: Int,
    var materialDesign: Int,
    var maintananceCondition: Int

)