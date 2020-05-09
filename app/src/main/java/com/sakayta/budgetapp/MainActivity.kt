package com.sakayta.budgetapp

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.sakayta.budgetapp.activity.HomeViewModel
import com.sakayta.budgetapp.activity.home.Home
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :
    BaseActivity(),
    Home.HomeInteractionListener,
    ViewModelGetter {

    lateinit var viewModel: HomeViewModel


    override fun displayProgressBar(bool: Boolean) {
        if(bool){
            progress_bar.visibility = View.VISIBLE
        }
        else{
            progress_bar.visibility = View.GONE
        }
    }

    override fun isLoading(flag: Boolean) {
       displayProgressBar(bool = flag)
    }


    override fun getParentViewModel(): HomeViewModel {
        return viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel =   ViewModelProvider(this).get(HomeViewModel::class.java)
    }
}


interface ViewModelGetter{
    fun getParentViewModel():HomeViewModel
}

