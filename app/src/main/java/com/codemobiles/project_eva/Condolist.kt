package com.codemobiles.project_eva

import com.google.android.gms.maps.model.LatLng

data class CondoBean(
    val error: Boolean,
    val error_msg: String,
    val condos: List<Condo>
)

class Condo private constructor(
    var id: String?,
    var subtitle: String?,
    var title: String?
) {
    data class Builder(
        var id: String? = null,
        var subtitle: String? = null,
        var title: String? = null
    ) {

        fun id(id: String) = apply { this.id = id }
        fun subtitle(subtitle: String) = apply { this.subtitle = subtitle }
        fun title(title: String) = apply { this.title = title }
        fun build() = Condo(id, subtitle, title)
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
