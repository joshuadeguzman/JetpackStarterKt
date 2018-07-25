package io.jmdg.jetpackstarterkt.injection.module

import dagger.Binds
import dagger.Module
import io.jmdg.jetpackstarterkt.repository.PostRepository
import io.jmdg.jetpackstarterkt.repository.UserRepository

/**
 * Created by Joshua de Guzman on 25/07/2018.
 */

@Module
abstract class RepositoryModule{
    @Binds
    abstract fun  bindUserRepository(repository: UserRepository): UserRepository

    @Binds
    abstract fun  bindPostRepository(repository: PostRepository): PostRepository
}