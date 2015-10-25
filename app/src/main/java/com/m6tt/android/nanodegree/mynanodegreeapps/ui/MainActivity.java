package com.m6tt.android.nanodegree.mynanodegreeapps.ui;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.m6tt.android.nanodegree.mynanodegreeapps.BaseActivity;
import com.m6tt.android.nanodegree.mynanodegreeapps.R;
import com.m6tt.android.nanodegree.mynanodegreeapps.events.ProjectListItemClickEvent;
import com.squareup.otto.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *  ----------------------------------------------
 * My NanoDegree Apps - MainActivity
 * ----------------------------------------------
 *
 * @author Matt Woodfield
 * @date 24/10/15.
 * @description
 * Main Activity for App Showcase app. Uses collapsable toolbar to
 * transition large toolbar to small.
 */
public class MainActivity extends BaseActivity {

    /** Wraps around toolbar to allow collapsing behaviour **/
    @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);

        // Get toolbar and set as actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // When using collapsing toolbar title must be set here rather than toolbar
        mToolbar.setTitle(getResources().getString(R.string.app_name));
    }

    @Subscribe
    public void onProjectListItemClickEvent(ProjectListItemClickEvent event) {
        Toast.makeText(this, event.getProject().getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
