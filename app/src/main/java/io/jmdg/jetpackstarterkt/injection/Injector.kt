package io.jmdg.jetpackstarterkt.injection

import dagger.Component
import io.jmdg.jetpackstarterkt.injection.module.AppModule
import io.jmdg.jetpackstarterkt.injection.module.NetworkModule
import io.jmdg.jetpackstarterkt.injection.module.ViewModelModule
import io.jmdg.jetpackstarterkt.ui.post.PostActivity
import io.jmdg.jetpackstarterkt.ui.user.UserActivity
import javax.inject.Singleton

/**
 * Created by Joshua de Guzman on 25/07/2018.
 */

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, NetworkModule::class])
interface Injector {
    fun inject(activity: UserActivity)
    fun inject(activity: PostActivity)
}