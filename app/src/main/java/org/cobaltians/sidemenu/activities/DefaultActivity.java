package org.cobaltians.sidemenu.activities;

import org.cobaltians.sidemenu.fragments.DefaultFragment;

import fr.cobaltians.cobalt.activities.CobaltActivity;
import fr.cobaltians.cobalt.fragments.CobaltFragment;

/**
 * Created by sebastienfamel on 24/12/15.
 */
public class DefaultActivity extends CobaltActivity {
    @Override
    protected CobaltFragment getFragment() {
        return new DefaultFragment();
    }
}
