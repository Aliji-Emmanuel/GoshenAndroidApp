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

package org.rccggoshen.androidapp.di.module;

// all the classes that should span application life cycle are created in this module for injection.

import android.app.Application;
import android.content.Context;

import org.rccggoshen.androidapp.BuildConfig;
import org.rccggoshen.androidapp.R;
import org.rccggoshen.androidapp.data.AppDataManager;
import org.rccggoshen.androidapp.data.DataManager;
import org.rccggoshen.androidapp.data.db.AppDbHelper;
import org.rccggoshen.androidapp.data.db.DbHelper;
import org.rccggoshen.androidapp.data.network.ApiHeader;
import org.rccggoshen.androidapp.data.network.ApiHelper;
import org.rccggoshen.androidapp.data.network.AppApiHelper;
import org.rccggoshen.androidapp.data.prefs.AppPreferencesHelper;
import org.rccggoshen.androidapp.data.prefs.PreferencesHelper;
import org.rccggoshen.androidapp.di.ApiInfo;
import org.rccggoshen.androidapp.di.ApplicationContext;
import org.rccggoshen.androidapp.di.DatabaseInfo;
import org.rccggoshen.androidapp.di.PreferenceInfo;
import org.rccggoshen.androidapp.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
/**
 * Created by janisharali on 27/01/17.
 */

// note that the name of the method does not matter it is the return type that dagger uses.
// for methods that return strings the return object is stored in the anotation.
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    /*
    @Provides
    @ApiInfo
    String provideApiKey() {

        return BuildConfig.API_KEY;
    }
    */

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    /*
    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }
    */

}
