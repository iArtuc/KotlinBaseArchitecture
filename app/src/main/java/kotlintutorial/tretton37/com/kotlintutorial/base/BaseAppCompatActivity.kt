package kotlintutorial.tretton37.com.kotlintutorial.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlintutorial.tretton37.com.kotlintutorial.BaseApplication
import kotlintutorial.tretton37.com.kotlintutorial.BaseApplication.Companion.appComponent
import kotlintutorial.tretton37.com.kotlintutorial.custom.CustomProgressDialog
import kotlintutorial.tretton37.com.kotlintutorial.di.component.ActivityComponent
import kotlintutorial.tretton37.com.kotlintutorial.di.component.ApplicationComponent
import kotlintutorial.tretton37.com.kotlintutorial.di.module.ActivityModule

/**
 * Created by ilkinartuc on 2017-06-28.
 */


abstract class BaseAppCompatActivity : AppCompatActivity(), BaseView {

    companion object {
        //        @JvmStatic lateinit var appComponent: ApplicationComponent
        @JvmStatic lateinit var activityComponent: ActivityComponent
    }


    abstract fun getActivityLayout(): Int

    abstract fun injectDependencies(appComponent: ApplicationComponent)

    lateinit var progressDialog: CustomProgressDialog

    override fun onContentChanged() {
        super.onContentChanged()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityLayout())
        injectDependencies(BaseApplication.appComponent)
        activityComponent = appComponent.plus(ActivityModule(this))
        initProgressDialog()


    }

    private fun initProgressDialog() {
//        progressDialog = ProgressDialog(this)
//        progressDialog?.setProgressStyle(ProgressDialog.STYLE_SPINNER)
//        progressDialog?.setMessage(getString(R.string.please_wait))

        progressDialog = CustomProgressDialog(this)
        progressDialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog.setCancelable(false)


    }


    override fun showProgress() {
//        progressDialog?.show()
        progressDialog.show()
    }

    override fun hideProgress() {
//        progressDialog?.hide()

        if (progressDialog.isShowing)
            progressDialog.hide()

    }

    override fun showMessage(message: String) {

    }

    fun getComponent(): ActivityComponent {
        return activityComponent
    }

    override fun onDestroy() {
        super.onDestroy()
        progressDialog.dismiss()
    }
}
