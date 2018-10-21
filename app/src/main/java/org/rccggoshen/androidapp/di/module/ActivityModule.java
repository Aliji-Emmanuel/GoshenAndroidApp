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
// it is in this class all the classes to be created with new keyword in activity are injected thorough this module.
package org.rccggoshen.androidapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import org.rccggoshen.androidapp.di.ActivityContext;
import org.rccggoshen.androidapp.di.PerActivity;
import org.rccggoshen.androidapp.ui.login.LoginMvpPresenter;
import org.rccggoshen.androidapp.ui.login.LoginMvpView;
import org.rccggoshen.androidapp.ui.login.LoginPresenter;
import org.rccggoshen.androidapp.ui.main.MainMvpPresenter;
import org.rccggoshen.androidapp.ui.main.MainMvpView;
import org.rccggoshen.androidapp.ui.main.MainPresenter;
import org.rccggoshen.androidapp.ui.splash.SplashMvpPresenter;
import org.rccggoshen.androidapp.ui.splash.SplashMvpView;
import org.rccggoshen.androidapp.ui.splash.SplashPresenter;
import org.rccggoshen.androidapp.utils.rx.AppSchedulerProvider;
import org.rccggoshen.androidapp.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

// all presenters and views.

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }
    }
