package com.sakayta.budgetapp.activity.add_account

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController

import com.sakayta.budgetapp.R
import com.sakayta.budgetapp.ViewModelGetter
import com.sakayta.budgetapp.activity.HomeViewModel
import com.sakayta.budgetapp.model.Account
import com.sakayta.budgetapp.util.Constants
import kotlinx.android.synthetic.main.add_account_fragment.*
import kotlinx.android.synthetic.main.add_account_fragment.budget
import java.lang.ClassCastException

class AddAcount : Fragment() {


    private lateinit var viewModel: HomeViewModel
    private  lateinit var mlistener:ViewModelGetter
    private var account:Account? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ViewModelGetter){
            mlistener = context
        }else{
            throw ClassCastException("HomeIntereactionListener must be implemented!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments!=null){
            val account = requireArguments().getParcelable(Constants.ACCOUNT_KEY) as Account?
            this.account = account
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.add_account_fragment, container, false);
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =   mlistener.getParentViewModel()

        setView()
        submit.setOnClickListener{
            if(this.account==null){
                saveAccount()
            }else{
                updateAccount()
            }
        }

    }

    private fun saveAccount(){

        if(TextUtils.isEmpty(account_name.text.toString()) ||
            TextUtils.isEmpty(budget.text.toString())){
            Toast.makeText(context,"All fields are required!",Toast.LENGTH_LONG).show()
        }else{
            val amount = budget.text.toString().toDouble()
            val accountName = account_name.text.toString()
            val account = Account(
                acount_name =  accountName,
                amount_budget=amount)
            account.amount_balance = amount
            viewModel.addAccount(account)


            budget.setText("")
            account_name.setText("")
            account_name.requestFocus()
        }



    }

    private fun updateAccount(){
        if(TextUtils.isEmpty(account_name.text.toString())){
            Toast.makeText(context,"Input some text!",Toast.LENGTH_LONG).show()
        }else{
            this.account!!.acount_name =account_name.text.toString()
            viewModel.updateAccount(this.account!!)
            findNavController().popBackStack()
        }

    }

    private fun setView(){
        if(this.account!=null){
            budget.visibility=View.GONE
            lblBudget.visibility=View.GONE
            account_name.setText(this.account!!.acount_name)
            account_name.selectAll()
            account_name.requestFocus()
        }
    }
}

