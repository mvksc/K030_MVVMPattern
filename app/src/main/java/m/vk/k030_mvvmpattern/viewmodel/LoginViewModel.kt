package m.vk.k030_mvvmpattern.viewmodel

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    var loginStatus = MutableLiveData<String>()
    var mHandler: Handler = Handler()
    fun doLogin(username: String,password: String){
        if (!(username.trim() == "" || password.trim() == "")){
            //check your server login
            mHandler.postDelayed({
                loginStatus.postValue("Login successful.")
            },3000)
        }else{
            loginStatus.postValue("Login fail check enter username and password.")
        }
    }
}