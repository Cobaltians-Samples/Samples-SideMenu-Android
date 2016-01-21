package org.cobaltians.sidemenu;

import android.app.Application;

import org.cobaltians.cobalt.Cobalt;

public class SideMenuApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Cobalt.getInstance(getApplicationContext()).setResourcePath("common/");
    }
}
