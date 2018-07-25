package io.jmdg.jetpackstarterkt.ui.post

import android.arch.lifecycle.ViewModel
import io.jmdg.jetpackstarterkt.repository.PostRepository
import javax.inject.Inject

/**
 * Created by Joshua de Guzman on 24/07/2018.
 */

class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel()