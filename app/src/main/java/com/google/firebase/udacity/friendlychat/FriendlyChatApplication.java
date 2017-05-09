package com.google.firebase.udacity.friendlychat;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import timber.log.Timber;

/**
 * Created by hbaxamoosa on 5/8/17.
 */

public class FriendlyChatApplication extends Application {

    private static Context context;

    public static Context getAppContext() {
        return FriendlyChatApplication.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        FriendlyChatApplication.context = getApplicationContext();

        //Including Jake Wharton's Timber logging library
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Timber.v("Timber.plant(new Timber.DebugTree());");
        } else {
            // Timber.plant(new CrashReportingTree());
        }

        // Facebook Stetho
        Stetho.initializeWithDefaults(this);
    }
}