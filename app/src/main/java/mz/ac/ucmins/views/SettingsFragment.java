package mz.ac.ucmins.views;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;
import co.mz.ucmins.R;


public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

    }
}
