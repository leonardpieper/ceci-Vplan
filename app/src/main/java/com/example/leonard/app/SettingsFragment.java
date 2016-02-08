package com.example.leonard.app;

import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.leonard.app.R.xml.preferences;

public class SettingsFragment extends PreferenceFragment {

    public static SettingsFragment theFragment;
    public SettingsFragment(){
        theFragment = this;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        //Login-Button
        Preference loginButton = (Preference)findPreference("prefLogin");
        loginButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                SettingsActivity.theActivity.prefLogin();
                return true;
            }
        });
        //Button um den Dialog für Tage und Zeiten zu starten
        Preference daysButton = (Preference)findPreference("prefDays");
        daysButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                DialogFragment dialogFragment = new SetLessonsDayDialog();
                dialogFragment.show(getFragmentManager(), "SetLessonsDayDialog");
                return true;
            }
        });

    }

    protected String getValueFromList(String listName){
        ListPreference listPreference = (ListPreference) findPreference(listName);
        String value = listPreference.getValue();
        return value;
    }
}