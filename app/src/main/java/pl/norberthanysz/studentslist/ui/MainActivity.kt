package pl.norberthanysz.studentslist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import pl.norberthanysz.studentslist.R

class MainActivity : AppCompatActivity() {

    private var wasBackButtonClicked = false
    private val backButtonDelay: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (wasBackButtonClicked) {
            super.finish()
            return
        }

        this.wasBackButtonClicked = true
        Toast.makeText(this, getString(R.string.close_app_info_text), Toast.LENGTH_SHORT).show()

        Handler().postDelayed({ wasBackButtonClicked = false }, backButtonDelay)
    }
}