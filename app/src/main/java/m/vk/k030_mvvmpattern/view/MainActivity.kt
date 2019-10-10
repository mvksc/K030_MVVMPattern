package m.vk.k030_mvvmpattern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import m.vk.k030_mvvmpattern.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameMain, LoginFragment.newInstance())
            .commit()
    }
}
