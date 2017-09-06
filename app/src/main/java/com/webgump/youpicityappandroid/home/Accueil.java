package com.webgump.youpicityappandroid.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;
import com.webgump.youpicityappandroid.R;
import com.webgump.youpicityappandroid.account.SettingsFragment;
import com.webgump.youpicityappandroid.fragment.SampleFragmentPagerAdapter;

public class Accueil extends AppCompatActivity implements View.OnClickListener{

    private ResideMenu resideMenu;
    private Context mContext;
    private ResideMenuItem itemAccount;
    private ResideMenuItem itemSettings;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Slide slideIn = new Slide(Gravity.RIGHT);
        getWindow().setEnterTransition(slideIn);

        mContext = this;
        setUpMenu();
        //if( savedInstanceState == null )
        //    changeFragment(new HomeFragment());


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager()));

        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameLayout f = (FrameLayout) findViewById(R.id.main_fragment);
                f.setVisibility(FrameLayout.GONE);
            }
        });
        tabsStrip.setViewPager(viewPager);
        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override

            public void onPageSelected(int position) {

                FrameLayout f = (FrameLayout) findViewById(R.id.main_fragment);
                f.setVisibility(FrameLayout.GONE);
                Toast.makeText(Accueil.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }

    private void setUpMenu() {

        resideMenu = new ResideMenu(this);

        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        resideMenu.setScaleValue(0.6f);

        itemAccount     = new ResideMenuItem(this, R.drawable.ic_account, "Mon compte");
        itemSettings = new ResideMenuItem(this, R.drawable.ic_settings, "Settings");

        itemAccount.setOnClickListener(this);
        itemSettings.setOnClickListener(this);

        resideMenu.addMenuItem(itemAccount, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemSettings, ResideMenu.DIRECTION_RIGHT);

        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);

        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {

        FrameLayout f = (FrameLayout) findViewById(R.id.main_fragment);
        f.setVisibility(FrameLayout.VISIBLE);

        if (view == itemAccount){
            changeFragment(new HomeFragment());
        }else if (view == itemSettings){
            changeFragment(new SettingsFragment());
        }

        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {

        }

        @Override
        public void closeMenu() {

        }
    };

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public ResideMenu getResideMenu(){
        return resideMenu;
    }
}