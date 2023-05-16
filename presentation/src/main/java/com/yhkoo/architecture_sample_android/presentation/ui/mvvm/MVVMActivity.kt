package com.yhkoo.architecture_sample_android.presentation.ui.mvvm

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import com.yhkoo.architecture_sample_android.presentation.base.BaseActivity
import com.yhkoo.architecture_sample_android.presentation.databinding.ActivityMvvmBinding
import com.yhkoo.architecture_sample_android.presentation.util.repeatCallDefaultOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MVVMActivity : BaseActivity<ActivityMvvmBinding>(ActivityMvvmBinding::inflate) {

    override val viewModel: MVVMViewModel by viewModels()

    override fun initLayout() {
        bind {
            vm = viewModel
            lifecycleOwner = this@MVVMActivity
        }
    }

    override fun setupCollect() {
        repeatCallDefaultOnStarted {
            viewModel.event.collect { event ->
                when (event) {
                    MVVMViewEvent.BeerList -> {
                        viewModel.getBeerList()
                    }
                }
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MVVMActivity::class.java)
        }
    }
}