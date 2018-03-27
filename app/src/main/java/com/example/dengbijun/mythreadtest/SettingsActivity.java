package com.example.dengbijun.mythreadtest;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;
import android.util.Log;

public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {

    public static final String TAG = "SettingsActivity";
    public static final boolean DEBUG = true;

    private CheckBoxPreference mWirelessCheckedBoxPreference;
    private CheckBoxPreference mGPSCheckedBoxPreference;
    private CheckBoxPreference mFlyCheckBoxPreference;
    private CheckBoxPreference mInternetCheckBoxPreference;

    private CheckBoxPreference mWifiCheckBoxPreference;
    private Preference mSetttingWifiPreference;

    private CheckBoxPreference mBluetoothCheckedBoxPreference;

    private EditTextPreference mTellNumberEditPreference;
    private ListPreference mDepartValuePreference;

    private String mOldDepartName;//旧部门名称

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {
        addPreferencesFromResource(R.xml.preference_activity);

        mWifiCheckBoxPreference = (CheckBoxPreference) findPreference("apply_wifi");
        mSetttingWifiPreference = findPreference("wifi_setting");

        mInternetCheckBoxPreference = (CheckBoxPreference) findPreference("apply_internet");
        mWirelessCheckedBoxPreference = (CheckBoxPreference) findPreference("apply_wireless");
        mGPSCheckedBoxPreference = (CheckBoxPreference) findPreference("apply_gps");
        mFlyCheckBoxPreference = (CheckBoxPreference) findPreference("apply_fly");
        mBluetoothCheckedBoxPreference = (CheckBoxPreference) findPreference("apply_bluetooth");

        mDepartValuePreference = (ListPreference) findPreference("depart_value");
        mTellNumberEditPreference = (EditTextPreference) findPreference("number_edit");

        //设置监听器
        mInternetCheckBoxPreference.setOnPreferenceChangeListener(this);
        mInternetCheckBoxPreference.setOnPreferenceClickListener(this);

        mDepartValuePreference.setOnPreferenceChangeListener(this);
        mDepartValuePreference.setOnPreferenceClickListener(this);

        mTellNumberEditPreference.setOnPreferenceChangeListener(this);
        mTellNumberEditPreference.setOnPreferenceClickListener(this);

        mSetttingWifiPreference.setOnPreferenceClickListener(this);
        mSetttingWifiPreference.setOnPreferenceChangeListener(this);
    }

    private void operate(Preference preference) {
        if (preference == mWifiCheckBoxPreference) {
            Log.i(TAG, "operate: Wifi ss checked" + mWifiCheckBoxPreference.isChecked());
        } else if (preference.getKey().equals("apply_internet")) {
            Log.i(TAG, "operate: Intenet is checked" + mInternetCheckBoxPreference.isChecked());
        } else if (preference.getKey().equals("depart_value")) {
            Log.i(TAG, "operate: depart is click");
        }
    }

    /**
     * 当Preference的元素值发生改变时，触发该事件。
     *
     * @param preference
     * @param newValue
     * @return 返回值为true则写入sharedPreference文件中
     */
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }

    /**
     * 点击控件时触发
     *
     * @param preference
     * @return 返回true则不再调用onPreferenceTreeClick方法
     */
    @Override
    public boolean onPreferenceClick(Preference preference) {
        operate(preference);
        return true;
    }
}
