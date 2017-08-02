package com.example.frank.apprealm;

import android.app.Application;
import android.widget.EditText;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by frank on 8/2/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);
    }
}
