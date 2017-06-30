package kotlintutorial.tretton37.com.kotlintutorial.custom

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import kotlintutorial.tretton37.com.kotlintutorial.R

/**
 * Created by ilkinartuc on 2017-07-08 with awesomeness.
 */

class CustomTextView : AppCompatTextView {


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setAntiAlliasSubPixel()
        parseAttributes(context, attrs)

    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        setAntiAlliasSubPixel()
        parseAttributes(context, attrs)
    }


    constructor(context: Context) : super(context) {
        setAntiAlliasSubPixel()
    }


    fun setAntiAlliasSubPixel() {
        this.paint.isAntiAlias = true
        this.paint.isSubpixelText = true
    }

    private fun parseAttributes(context: Context, attrs: AttributeSet) {
        val values = context.obtainStyledAttributes(attrs, R.styleable.CustomText)

        //The value 0 is a default, but shouldn't ever be used since the attr is an enum
        val typeface = values.getInt(R.styleable.CustomText_typeface, 0)

        when (typeface) {
            0 -> setTypeface(Typeface.createFromAsset(getContext()
                    .assets, "fonts/Roboto-Regular.ttf"))
            1 -> setTypeface(Typeface.createFromAsset(getContext()
                    .assets, "fonts/Roboto-Medium.ttf"))
            2 -> setTypeface(Typeface.createFromAsset(getContext()
                    .assets, "fonts/Roboto-Light.ttf"))
            else -> setTypeface(Typeface.createFromAsset(getContext()
                    .assets, "fonts/Roboto-Regular.ttf"))
        }

        values.recycle()
    }
}
