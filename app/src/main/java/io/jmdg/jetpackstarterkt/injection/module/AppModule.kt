package io.jmdg.jetpackstarterkt.injection.module

import dagger.Module
import dagger.Provides
import io.jmdg.jetpackstarterkt.App
import javax.inject.Singleton

/**
 * Created by Joshua de Guzman on 25/07/2018.
 */

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApp(): App = app
}