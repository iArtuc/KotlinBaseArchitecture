package kotlintutorial.tretton37.com.kotlintutorial.di.component;

import kotlintutorial.tretton37.com.kotlintutorial.BaseApplication
import timber.log.Timber;

/**
 * Created by ilkinartuc on 2017-06-28.
 */

interface BaseApplicationComponent {

    fun inject(application: BaseApplication)

    fun tree(): Timber.Tree
}