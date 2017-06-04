package com.yftech.uiautomator2demo.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.yftech.uiautomator2demo.utils.AppElementObject;
import com.yftech.uiautomator2demo.utils.InitializeApp;
import com.yftech.uiautomator2demo.utils.UserAction;

/**
 * Created by 薛东磊 on 2017/6/4.
 */

public class HomeStartPage extends InitializeApp{
    private static final String FACEBOOK_BUTTON_TEXT = "Log In by Facebook";
    private static UiObject loginByFacebookButton;

    private static final String USER_REGISTRATION_BUTTON_TEXT = "New User Registation";
    private static UiObject userRegistrationButton;

    private static final String USER_LOGIN_BUTTON_TEXT = "Log In by Email";
    private static UiObject loginByEmailButton;



    public static void clickFacebookButton()  {
        UserAction.clickByText(loginByFacebookButton,FACEBOOK_BUTTON_TEXT);
    }

    public static void clickRegistationButton(){
        UserAction.clickByText(userRegistrationButton,USER_REGISTRATION_BUTTON_TEXT);
    }


    public static void clickLoginByEmailButton(){
        UserAction.clickByText(loginByEmailButton,USER_LOGIN_BUTTON_TEXT);
    }

}
