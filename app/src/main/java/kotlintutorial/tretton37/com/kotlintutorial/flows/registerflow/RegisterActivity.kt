package kotlintutorial.tretton37.com.kotlintutorial.flows.registerflow

import android.app.FragmentManager
import android.os.Bundle
import kotlintutorial.tretton37.com.kotlintutorial.R
import kotlintutorial.tretton37.com.kotlintutorial.base.BaseAppCompatActivity
import kotlintutorial.tretton37.com.kotlintutorial.base.BaseFragment
import kotlintutorial.tretton37.com.kotlintutorial.di.component.ApplicationComponent
import kotlintutorial.tretton37.com.kotlintutorial.di.module.ActivityModule

/**
 * Created by ilkinartuc on 2017-07-04.
 */


class RegisterActivity : BaseAppCompatActivity() {


    override fun getActivityLayout(): Int {
        return R.layout.activity_register
    }

    override fun injectDependencies(appComponent: ApplicationComponent) {
        return appComponent.plus(ActivityModule(this)).inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        if (savedInstanceState == null) {
            changeFragment(RegisterFragment())
        }

//        getSupportFragmentManager().beginTransaction().add(R.id.fr_login_fragment_holder,
//               LoginFragment()).commit()


    }

    fun changeFragment(f: BaseFragment, cleanStack: Boolean = false) {
        val ft = supportFragmentManager.beginTransaction()
        if (cleanStack) {
            clearBackStack()
        }
        ft.setCustomAnimations(
                R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        ft.replace(R.id.fr_register_layout_holder, f)
        ft.addToBackStack(null)
        ft.commit()
    }

    fun clearBackStack() {
        val manager = supportFragmentManager;
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    /**
     * Finish activity when reaching the last fragment.
     */
    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager;
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}