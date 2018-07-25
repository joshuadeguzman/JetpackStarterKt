package io.jmdg.jetpackstarterkt.injection.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.jmdg.jetpackstarterkt.annotations.ViewModelKey
import io.jmdg.jetpackstarterkt.factories.ViewModelFactory
import io.jmdg.jetpackstarterkt.ui.post.PostViewModel
import io.jmdg.jetpackstarterkt.ui.user.UserViewModel

/**
 * Created by Joshua de Guzman on 24/07/2018.
 */

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    internal abstract fun userViewModel(viewModel: UserViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    internal abstract fun postViewModel(viewModel: PostViewModel): ViewModel
}