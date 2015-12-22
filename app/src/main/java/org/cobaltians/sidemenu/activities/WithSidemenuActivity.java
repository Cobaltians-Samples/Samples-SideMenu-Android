package org.cobaltians.sidemenu.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import fr.cobaltians.cobalt.Cobalt;
import fr.cobaltians.cobalt.activities.CobaltActivity;
import fr.cobaltians.cobalt.fragments.CobaltFragment;

import org.cobaltians.sidemenu.R;
import org.cobaltians.sidemenu.fragments.DefaultFragment;

public class WithSidemenuActivity extends CobaltActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    /***********************************************************************************************
     *
     * LIFECYCLE
     *
     **********************************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                R.string.open_drawer,
                R.string.close_drawer);

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    /***********************************************************************************************
     *
     * MENU
     *
     **********************************************************************************************/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle.
        // if it returns true, then it has handled the app icon touch event
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    /***********************************************************************************************
     *
     * COBALT
     *
     **********************************************************************************************/

    @Override
    protected int getLayoutToInflate() {
        return R.layout.activity_sidemenu;
    }

    @Override
    public String getInitController() {
        return "withSidemenu";
    }

    @Override
    public String getInitPage() {
        return "home.html";
    }

    @Override
    protected CobaltFragment getFragment() {
        return Cobalt.getInstance(this).getFragmentForController(DefaultFragment.class,
                "withSidemenu",
                "home.html");
    }
}