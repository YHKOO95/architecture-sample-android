package com.yhkoo.architecture_sample_android.presentation.ui.home

import androidx.activity.viewModels
import com.yhkoo.architecture_sample_android.presentation.base.BaseActivity
import com.yhkoo.architecture_sample_android.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override val viewModel : MainViewModel by viewModels()

    override fun initLayout() {

    }

    override fun setupCollect() {

    }
}