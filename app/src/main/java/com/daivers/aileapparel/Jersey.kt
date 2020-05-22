package com.daivers.aileapparel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Jersey (
    var id: Int ?=0,
    var image: Int ?=0,
    var title: String ?="",
    var desc: String ?="",
    var harga: String ?=""
): Parcelable