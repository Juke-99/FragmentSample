package juke_99.com.fragmentsample

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener: View.OnClickListener = View.OnClickListener { view ->
            var fragment: Fragment? = null

            if(view == button1) {
                fragment = DynamicFragment1()
            } else {
                fragment = DynamicFragment2()
            }

            val manager: FragmentManager = supportFragmentManager
            val transaction: FragmentTransaction = manager.beginTransaction()
            transaction.replace(R.id.dynamicFragmentOutput, fragment as Fragment)
            transaction.commit()
        }

        val btnC1: Button = button1
        btnC1.setOnClickListener(listener)

        val btnC2: Button = button2
        btnC2.setOnClickListener(listener)
    }
}