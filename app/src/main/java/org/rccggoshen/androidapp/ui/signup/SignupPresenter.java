package org.rccggoshen.androidapp.ui.signup;


import org.rccggoshen.androidapp.data.DataManager;
import org.rccggoshen.androidapp.ui.base.BasePresenter;
import org.rccggoshen.androidapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

// TODO: implement main intent call and signup api calls.
public class SignupPresenter<V extends SignupMvpView> extends BasePresenter implements SignupMvpPresenter {

    @Inject
    public SignupPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

}
