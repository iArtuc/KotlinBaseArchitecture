package kotlintutorial.tretton37.com.kotlintutorial.restservices.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by ilkinartuc on 2017-07-03.
 */


class UserResponse(@SerializedName("isSuccess") val isSuccess: Boolean) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<UserResponse> = object : Parcelable.Creator<UserResponse> {
            override fun createFromParcel(source: Parcel): UserResponse = UserResponse(source)
            override fun newArray(size: Int): Array<UserResponse?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            1 == source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt((if (isSuccess) 1 else 0))
    }
}