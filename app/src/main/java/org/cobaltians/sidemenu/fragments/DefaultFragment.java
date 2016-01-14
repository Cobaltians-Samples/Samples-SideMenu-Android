package org.cobaltians.sidemenu.fragments;

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

        switch (event) {
            case "sidemenu:disable" :
                if (getActivity() instanceof WithSidemenuActivity)
                    ((WithSidemenuActivity) getActivity()).setDrawerState(false);
                break;

            case "sidemenu:enable" :
                if (getActivity() instanceof WithSidemenuActivity)
                    ((WithSidemenuActivity) getActivity()).setDrawerState(true);
                break;

            case "sidemenu:show" :
                if (getActivity() instanceof WithSidemenuActivity)
                    ((WithSidemenuActivity) getActivity()).setDrawerVisible(true);
                break;

            case "sidemenu:hide" :
                if (getActivity() instanceof WithSidemenuActivity)
                    ((WithSidemenuActivity) getActivity()).setDrawerVisible(false);
                break;

            case "sidemenu:toggle" :
                if (getActivity() instanceof WithSidemenuActivity)
                    ((WithSidemenuActivity) getActivity()).setDrawerToggle();
                break;

            default:
                return false;
        }
        return true;
    }

    @Override
    protected void onUnhandledMessage(JSONObject message) {

    }
}
