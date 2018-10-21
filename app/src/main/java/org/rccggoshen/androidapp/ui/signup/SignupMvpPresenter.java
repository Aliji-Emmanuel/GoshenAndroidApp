package org.rccggoshen.androidapp.ui.signup;

import org.rccggoshen.androidapp.ui.base.MvpPresenter;

public interface SignupMvpPresenter extends MvpPresenter {
    void onServerSignupClick(String email, String password);

    void onGoogleSignupClick();

    void onFacebookSignupClick();
}
