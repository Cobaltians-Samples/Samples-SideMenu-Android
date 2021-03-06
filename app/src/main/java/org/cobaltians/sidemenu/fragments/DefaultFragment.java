package org.cobaltians.sidemenu.fragments;

import android.app.Activity;

import org.cobaltians.sidemenu.activities.WithSidemenuActivity;
import org.json.JSONObject;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public class DefaultFragment extends CobaltFragment {

    @Override
    protected boolean onUnhandledCallback(String callback, JSONObject data) {
        return false;
    }

    @Override
    protected boolean onUnhandledEvent(String event, JSONObject data, String callback) {
        Activity activity = getActivity();
        if (activity != null
            && activity instanceof WithSidemenuActivity) {
            switch (event) {
                case "sidemenu:disable":
                    ((WithSidemenuActivity) activity).setDrawerState(false);
                    return true;
                case "sidemenu:enable":
                    ((WithSidemenuActivity) activity).setDrawerState(true);
                    return true;
                case "sidemenu:show":
                    ((WithSidemenuActivity) activity).setDrawerVisible(true);
                    return true;
                case "sidemenu:hide":
                    ((WithSidemenuActivity) activity).setDrawerVisible(false);
                    return true;
                case "sidemenu:toggle":
                    ((WithSidemenuActivity) activity).setDrawerToggle();
                    return true;
                default:
                    return false;
            }
        }

        return false;
    }

    @Override
    protected boolean onUnhandledMessage(JSONObject message) {
        return false;
    }
}
