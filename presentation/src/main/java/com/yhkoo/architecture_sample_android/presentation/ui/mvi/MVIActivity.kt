package com.yhkoo.architecture_sample_android.presentation.ui.mvi

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import com.yhkoo.architecture_sample_android.presentation.base.BaseActivity
import com.yhkoo.architecture_sample_android.presentation.databinding.ActivityMviBinding
import com.yhkoo.architecture_sample_android.presentation.util.repeatCallDefaultOnStarted
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MVIActivity : BaseActivity<ActivityMviBinding>(ActivityMviBinding::inflate) {

    override val viewModel: MVIViewModel by viewModels()

    override fun initLayout() {
        bind {
            vm = viewModel
            lifecycleOwner = this@MVIActivity
        }

        viewModel.event(MVIContract.Event.RequestBeerInfo)
    }

    override fun setupCollect() {
        repeatCallDefaultOnStarted {
            viewModel.effect.collectLatest { effect ->
                when (effect) {
                    is MVIContract.Effect.ShowToast -> {
                        Toast.makeText(this@MVIActivity, effect.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MVIActivity::class.java)
        }
    }
}