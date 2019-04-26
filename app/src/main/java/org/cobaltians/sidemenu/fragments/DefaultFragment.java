package org.cobaltians.sidemenu.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.cobaltians.cobalt.Cobalt;
import org.cobaltians.cobalt.pubsub.PubSubInterface;
import org.cobaltians.sidemenu.activities.WithSidemenuActivity;
import org.json.JSONObject;

import org.cobaltians.cobalt.fragments.CobaltFragment;

public class DefaultFragment extends CobaltFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Cobalt.subscribeToChannel("sidemenu:disable", new PubSubInterface() {
            @Override
            public void onMessageReceived(@Nullable JSONObject message, @NonNull String channel) {
                Activity activity = getActivity();
                if (activity instanceof WithSidemenuActivity) {
                    ((WithSidemenuActivity) activity).setDrawerState(false);
                }
            }
        });

        Cobalt.subscribeToChannel("sidemenu:enable", new PubSubInterface() {
            @Override
            public void onMessageReceived(@Nullable JSONObject message, @NonNull String channel) {
                Activity activity = getActivity();
                if (activity instanceof WithSidemenuActivity) {
                    ((WithSidemenuActivity) activity).setDrawerState(true);
                }
            }
        });

        Cobalt.subscribeToChannel("sidemenu:show", new PubSubInterface() {
            @Override
            public void onMessageReceived(@Nullable JSONObject message, @NonNull String channel) {
                Activity activity = getActivity();
                if (activity instanceof WithSidemenuActivity) {
                    ((WithSidemenuActivity) activity).setDrawerVisible(true);
                }
            }
        });

        Cobalt.subscribeToChannel("sidemenu:hide", new PubSubInterface() {
            @Override
            public void onMessageReceived(@Nullable JSONObject message, @NonNull String channel) {
                Activity activity = getActivity();
                if (activity instanceof WithSidemenuActivity) {
                    ((WithSidemenuActivity) activity).setDrawerVisible(false);
                }
            }
        });
        Cobalt.subscribeToChannel("sidemenu:toggle", new PubSubInterface() {
            @Override
            public void onMessageReceived(@Nullable JSONObject message, @NonNull String channel) {
                Activity activity = getActivity();
                if (activity instanceof WithSidemenuActivity) {
                    ((WithSidemenuActivity) activity).setDrawerToggle();
                }
            }
        });

        super.onCreate(savedInstanceState);
    }
}
