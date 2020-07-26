package space.aioilight.kazenone

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        findPreference<ListPreference>("themes")?.apply {
            setOnPreferenceChangeListener { preference, newValue ->
                val id = newValue as String
                AppCompatDelegate.setDefaultNightMode(when (id) {
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
                true
            }
        }
    }
}