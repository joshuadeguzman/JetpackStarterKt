package io.jmdg.jetpackstarterkt.ui.user

import android.os.Bundle
import android.util.Log
import io.jmdg.jetpackstarterkt.R
import io.jmdg.jetpackstarterkt.base.BaseActivity
import io.jmdg.jetpackstarterkt.factories.ViewModelFactory
import io.jmdg.jetpackstarterkt.ui.post.PostViewModel
import io.jmdg.jetpackstarterkt.utils.getAppInjector
import io.jmdg.jetpackstarterkt.utils.withViewModel
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.support.v4.swipeRefreshLayout
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Joshua de Guzman on 24/07/2018.
 */

class UserActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity)
        getAppInjector().inject(this)

        // Usage of a specific view model (eg. UserViewModel) with the usage of implementation of withViewModel in Extensions
        withViewModel<UserViewModel>(viewModelFactory) {
            loginUser("demo", "demo0000")
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .subscribe({
                        // Do anything to proceed with the logged in user
                    }, {
                        Timber.d(it)
                    })
        }
    }

}