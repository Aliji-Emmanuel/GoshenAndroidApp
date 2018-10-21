/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package org.rccggoshen.androidapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import org.rccggoshen.androidapp.BuildConfig;
import org.rccggoshen.androidapp.R;
import org.rccggoshen.androidapp.ui.base.BaseActivity;
import org.rccggoshen.androidapp.ui.login.LoginActivity;
import org.rccggoshen.androidapp.ui.main.NavViews.ForumListFragment;
import org.rccggoshen.androidapp.ui.main.NavViews.Home;
import org.rccggoshen.androidapp.ui.main.NavViews.Media;
import org.rccggoshen.androidapp.ui.main.NavViews.Publications;
import org.rccggoshen.androidapp.ui.main.NavViews.Store;
import org.rccggoshen.androidapp.ui.main.NavViews.dummy.DummyContent;
import org.rccggoshen.androidapp.utils.ScreenUtils;

import com.felix.bottomnavygation.BottomNav;
import com.felix.bottomnavygation.ItemNav;
import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;


import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by janisharali on 27/01/17.
 */
// TODO: implement presenter fragment transactions.
// TODO: implement setUp method from BaseActivity.

@Puppet(containerViewId = R.id.tab_views_container)
public class MainActivity extends BaseActivity implements MainMvpView, BottomNavigationView.OnNavigationItemSelectedListener,
        ForumListFragment.OnListFragmentInteractionListener, Media.OnFragmentInteractionListener,
        Store.OnFragmentInteractionListener,Publications.OnFragmentInteractionListener,Home.OnListFragmentInteractionListener{

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        //mPresenter.onAttach(this);

        //getting bottom navigation view and attaching the listener
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_nav);
        bottomNavigation.setOnNavigationItemSelectedListener(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        Fragment fragment = null;
        // Rigger

        switch (item.getItemId()) {
            case R.id.home_nav:
                //fragment = new Home();
                Rigger.getRigger(this).addFragment(R.id.tab_views_container,Home.newInstance(1));
                return true;

            case R.id.forum_nav:
                //fragment = new forumListFragment();
                Rigger.getRigger(this).addFragment(R.id.tab_views_container, ForumListFragment.newInstance(1));
                return true;

            case R.id.media_nav:
               // fragment = new NotificationsFragment();
                Rigger.getRigger(this).addFragment(R.id.tab_views_container, Media.newInstance("boy","girl"));
                return true;

            case R.id.publications_nav:
                //fragment = new ProfileFragment();
                Rigger.getRigger(this).addFragment(R.id.tab_views_container, Publications.newInstance("boy","girl"));
                return true;

            case R.id.store_nav:
                //fragment = new ProfileFragment();
                Rigger.getRigger(this).addFragment(R.id.tab_views_container, Store.newInstance("boy","girl"));
                return true;
        }
        return false;
    }




    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    /*
    @Override
    protected void initBottomNav(){
        bottomNav.addItemNav(new ItemNav(this, R.drawable.home_nav, R.drawable.home_nav_sel, "Home"));
        bottomNav.addItemNav(new ItemNav(this, R.drawable.forum_nav, R.drawable.forum_nav_sel, "Forum"));
        bottomNav.addItemNav(new ItemNav(this, R.drawable.media_nav, R.drawable.media_nav_sel, "Media"));
        bottomNav.addItemNav(new ItemNav(this, R.drawable.publication_nav, R.drawable.publications_nav_sel, "Publications"));
        bottomNav.addItemNav(new ItemNav(this, R.drawable.store_nav, R.drawable.store_nav_sel, "Store"));

    }
    */


    @Override
    public void setUp(){}

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item){

    }
    @Override
    public void onFragmentInteraction(Uri uri){

    }

}
