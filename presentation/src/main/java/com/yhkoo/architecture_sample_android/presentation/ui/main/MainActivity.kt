package com.yhkoo.architecture_sample_android.presentation.ui.main

import androidx.activity.viewModels
import com.yhkoo.architecture_sample_android.presentation.base.BaseActivity
import com.yhkoo.architecture_sample_android.presentation.databinding.ActivityMainBinding
import com.yhkoo.architecture_sample_android.presentation.ui.mvi.MVIActivity
import com.yhkoo.architecture_sample_android.presentation.ui.mvvm.MVVMActivity
import com.yhkoo.architecture_sample_android.presentation.util.repeatCallDefaultOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override val viewModel: MainViewModel by viewModels()

    override fun initLayout() {
        bind {
            vm = viewModel
            lifecycleOwner = this@MainActivity
        }
    }

    override fun setupCollect() {
        repeatCallDefaultOnStarted {
            viewModel.event.collect { event ->
                when (event) {
                    MainViewEvent.MVVM -> {
                        goToMVVMActivity()
                    }
                    MainViewEvent.MVI -> {
                        goToMVIActivity()
                    }
                }
            }
        }
    }

    private fun goToMVVMActivity() {
        startActivity(MVVMActivity.newIntent(this))
    }

    private fun goToMVIActivity() {
        startActivity(MVIActivity.newIntent(this))
    }
}