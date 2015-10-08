package com.example.admin.android_drawer_base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.admin.android_drawer_base.fragments.*;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new MainFragment()).commit();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigation = (NavigationView) findViewById(R.id.navigation);
        mNavigation.setNavigationItemSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(mNavigation);
            }
        });
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

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        int id = menuItem.getItemId();

        switch (id) {
            case R.id.menu_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new MainFragment()).commit();
                mDrawerLayout.closeDrawer(mNavigation);
                break;
            case R.id.menu_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new HelpFragment()).commit();
                mDrawerLayout.closeDrawer(mNavigation);
                break;
            case R.id.menu_close:
                mDrawerLayout.closeDrawer(mNavigation);
                break;
            default:
                break;
        }
        return false;

    }
}
