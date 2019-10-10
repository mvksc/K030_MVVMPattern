package m.vk.k030_mvvmpattern.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_login.*
import m.vk.k030_mvvmpattern.viewmodel.LoginViewModel
import android.widget.Toast
import m.vk.k030_mvvmpattern.R

class LoginFragment : Fragment(){
    companion object {
        lateinit var loginViewModel: LoginViewModel
        @JvmStatic
        fun newInstance() = LoginFragment().apply {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        tvLogin.setOnClickListener{
            onLogin()
        }
        loginViewModel.loginStatus.observe(this, Observer { result ->
            pbLogin.visibility = View.INVISIBLE
            Toast.makeText(activity, result, Toast.LENGTH_SHORT).show()
        })
    }
    private fun onLogin(){
        var username = edUsername.text.toString()
        var password = edPassword.text.toString()
        pbLogin.visibility = View.VISIBLE
        loginViewModel.doLogin(username,password)
    }
}
