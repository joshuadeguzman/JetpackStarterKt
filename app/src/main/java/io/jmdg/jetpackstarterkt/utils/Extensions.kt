package io.jmdg.jetpackstarterkt.utils

import android.app.Activity
import android.arch.lifecycle.*
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import io.jmdg.jetpackstarterkt.App
import io.jmdg.jetpackstarterkt.injection.Injector

/**
 * Created by Joshua de Guzman on 25/07/2018.
 */

/**
 * App injection
 */
val Activity.app: App get() = application as App
fun AppCompatActivity.getAppInjector(): Injector = (app).injector

/**
 * Simplifies view model injection to the view
 */
inline fun <reified T : ViewModel> FragmentActivity.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : ViewModel> FragmentActivity.withViewModel(viewModelFactory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = getViewModel<T>(viewModelFactory)
    vm.body()
    return vm
}