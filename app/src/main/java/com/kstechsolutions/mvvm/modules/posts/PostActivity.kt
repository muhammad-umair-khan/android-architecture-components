package com.kstechsolutions.mvvm.modules.posts

import android.os.Bundle
import com.kstechsolutions.mvvm.R
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by muhammadumairshafique on 29/09/2019.
 */

class PostActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
