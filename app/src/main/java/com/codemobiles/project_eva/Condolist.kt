package com.codemobiles.project_eva

import com.google.android.gms.maps.model.LatLng

data class CondoBean(
    val error: Boolean,
    val error_msg: String,
    val condos: List<Condotest>
)

data class Condotest(
    val id: String,
    val title: String,
    val subtitle: String

) {

}

class Condo private constructor(
    var id: String?,
    var subtitle: String?,
    var title: String?,
    var tabpicture: String?
) {
    data class Builder(
        var id: String? = null,
        var subtitle: String? = null,
        var title: String? = null,
        var tabpicture: String? = null
    ) {

        fun id(id: String) = apply { this.id = id }
        fun subtitle(subtitle: String) = apply { this.subtitle = subtitle }
        fun title(title: String) = apply { this.title = title }
        fun tabpicture(tabpicture: String) = apply { this.tabpicture = tabpicture }
        fun build() = Condo(id, subtitle, title, tabpicture)
    }
}

//class Condo2 private constructor(
//    var id: String?,
//    var subtitle: String?,
//    var title: String?,
//    var condoInfo: String,
//    var latLng: LatLng
//
//) {
//    data class Builder(
//        var id: String? = null,
//        var subtitle: String? = null,
//        var title: String? = null
//    ) {
//
//        fun id(id: String) = apply { this.id = id }
//        fun subtitle(subtitle: String) = apply { this.subtitle = subtitle }
//        fun title(title: String) = apply { this.title = title }
//        fun condoInfo(condoInfo: String) = apply { this.condoInfo = condoInfo }
//        fun latLng(latLng: LatLng) = apply { this.latLng() = latLng }
//        fun build() = Condo2(id, subtitle, title, latLng)
//    }
//}
