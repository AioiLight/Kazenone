package space.aioilight.kazenone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val pref = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val theme = pref.getString("themes", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM.toString())
        AppCompatDelegate.setDefaultNightMode(when (theme) {
            "0" -> {
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            }
            "1" -> {
                AppCompatDelegate.MODE_NIGHT_NO
            }
            "2" -> {
                AppCompatDelegate.MODE_NIGHT_YES
            }
            else -> {
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            }
        })

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}