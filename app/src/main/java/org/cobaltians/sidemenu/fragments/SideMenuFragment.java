package org.cobaltians.sidemenu.fragments;

import android.os.Bundle;
import android.util.Log;

import org.cobaltians.sidemenu.activities.WithSidemenuActivity;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import org.cobaltians.cobalt.Cobalt;
import org.cobaltians.cobalt.fragments.CobaltFragment;

public class SideMenuFragment extends CobaltFragment {

    private HashMap<String, CobaltFragment> mFragmentStack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentStack = new HashMap<>();
    }

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

        switch (event) {
            case "sidemenu:switch":
                String page;
                String id;
                String controller;
                JSONObject dataForFragment;
                try {
                    page = data.getString("page");
                    id = data.getString("id");
                    controller = data.getString("controller");
                    dataForFragment = data.optJSONObject("data");
                    CobaltFragment fragment;
                    if (mFragmentStack.containsKey(id)) fragment = mFragmentStack.get(id);
                    else {
                        fragment = Cobalt.getInstance(mContext).getFragmentForController(DefaultFragment.class, controller, page);
                        mFragmentStack.put(id, fragment);
                        ((WithSidemenuActivity) mContext).setDataNavigation(dataForFragment);
                    }
                    ((WithSidemenuActivity) mContext).switchFragment(fragment);
                }
                catch (JSONException e) {
                    Log.d(TAG, TAG + " - onUnhandledEvent - no value for page in event sideMenuSwitch");
                    e.printStackTrace();
                }
                break;
            default :
                return false;
        }
        return true;
    }

    @Override
    protected void onUnhandledMessage(JSONObject message) {

    }
}
