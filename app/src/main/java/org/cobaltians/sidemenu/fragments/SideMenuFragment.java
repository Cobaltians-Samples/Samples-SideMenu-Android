package org.cobaltians.sidemenu.fragments;

import org.json.JSONObject;

import fr.cobaltians.cobalt.fragments.CobaltFragment;

public class SideMenuFragment extends CobaltFragment {

    @Override
    protected String getPage() {
        return "sidemenu.html";
    }

    @Override
    protected boolean onUnhandledCallback(String callback, JSONObject data) {
        return false;
    }

    @Override
    protected boolean onUnhandledEvent(String event, JSONObject data, String callback) {
        return false;
    }

    @Override
    protected void onUnhandledMessage(JSONObject message) {

    }
}
