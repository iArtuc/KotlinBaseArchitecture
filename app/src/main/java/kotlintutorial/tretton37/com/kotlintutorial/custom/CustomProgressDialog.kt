package kotlintutorial.tretton37.com.kotlintutorial.custom

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import kotlintutorial.tretton37.com.kotlintutorial.R

/**
 * Created by ilkinartuc on 2017-07-08 with awesomeness.
 */


class CustomProgressDialog : Dialog {


    private val imageview: ImageView

    constructor(context: Context) : super(context, R.style.TransparentProgressDialog) {
        val windowmanger = window!!.attributes
        windowmanger.gravity = Gravity.CENTER_HORIZONTAL
        window!!.attributes = windowmanger
        setTitle(null)
        setCancelable(false)
        setOnCancelListener(null)
        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL
        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .WRAP_CONTENT, ViewGroup.LayoutParams
                .WRAP_CONTENT)
        imageview = ImageView(context)
        imageview.setBackgroundResource(R.drawable.progress_animation)
        layout.addView(imageview, params)
        addContentView(layout, params)

    }


    override fun show() {
        super.show()
        val frameAnimation = imageview.getBackground() as AnimationDrawable
        frameAnimation.start()

    }

}
