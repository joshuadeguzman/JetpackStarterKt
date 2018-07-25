package io.jmdg.jetpackstarterkt

import android.app.Application
import io.jmdg.jetpackstarterkt.injection.DaggerInjector
import io.jmdg.jetpackstarterkt.injection.Injector
import io.jmdg.jetpackstarterkt.injection.module.AppModule
import io.jmdg.jetpackstarterkt.injection.module.NetworkModule
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber

/**
 * Created by Joshua de Guzman on 24/07/2018.
 */

class App : Application() {
    lateinit var injector: Injector

    override fun onCreate() {
        super.onCreate()
        initDagger()
        initTimber()
        initPluginsErrorHandler()
    }

    private fun initDagger() {
        injector = DaggerInjector
                .builder()
                .networkModule(NetworkModule())
                .build()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) run { Timber.plant(Timber.DebugTree()) }
    }


    private fun initPluginsErrorHandler() = RxJavaPlugins.setErrorHandler { Timber.e(it) }
}