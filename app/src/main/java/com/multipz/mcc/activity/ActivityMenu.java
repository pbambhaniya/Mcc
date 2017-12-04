package com.multipz.mcc.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Base64;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.multipz.mcc.R;
import com.multipz.mcc.fragment.ChatFragment;
import com.multipz.mcc.fragment.ExpertFragment;
import com.multipz.mcc.fragment.FeedsFragment;
import com.multipz.mcc.fragment.InquiryFragment;
import com.multipz.mcc.fragment.NotificationFragment;
import com.multipz.mcc.fragment.SettingFragment;
import com.multipz.mcc.fragment.ShopFragment;
import com.multipz.mcc.fragment.UnderDevelopment;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ActivityMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Context context;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("My City Care");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        context = this;

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomMenu();
        sideMenu();

        //getHashKey();

        openFragment(R.id.action_feed);
    }

    private void sideMenu() {
        findViewById(R.id.lnr_feeds).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(R.id.action_feed);
            }
        });

        findViewById(R.id.lnr_shop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(R.id.lnr_shop);
            }
        });

        findViewById(R.id.lnr_wallet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(R.id.lnr_wallet);
            }
        });

        findViewById(R.id.lnr_inquiry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(R.id.lnr_inquiry);
            }
        });

        findViewById(R.id.lnr_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(R.id.lnr_setting);
            }
        });

        findViewById(R.id.lnr_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(R.id.lnr_logout);
            }
        });
    }

    private void bottomMenu() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                openFragment(item.getItemId());
                return true;
            }
        });
    }

    void removeShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode");
        }
    }

    private void getHashKey() {

        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    void openFragment(int id){

        Fragment fragment = null;
        String title = "My City Care";
        switch (id){
            case R.id.action_feed:
                fragment = new FeedsFragment();
                break;

            case R.id.action_notification:
                fragment = new NotificationFragment();
                title = "Notification";
                break;

            case R.id.action_expert:
                fragment = new ExpertFragment();
                title = "Expert";
                break;

            case R.id.action_chat:
                fragment = new ChatFragment();
                title = "Chat";
                break;

            case R.id.lnr_shop:
                fragment = new ShopFragment();
                title = "Shop";
                break;

            case R.id.lnr_wallet:
                fragment = new UnderDevelopment();
                title = "Wallet";
                break;

            case R.id.lnr_inquiry:
                fragment = new InquiryFragment();
                title = "Inquiry";
                break;

            case R.id.lnr_setting:
                fragment = new SettingFragment();
                title = "Setting";
                break;

            case R.id.lnr_logout:
                Intent i = new Intent(context, ActivityLogin.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;
        }
        getSupportActionBar().setTitle(title);

        try {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment).commit();

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }catch (Exception e){

        }
    }
}
