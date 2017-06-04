package com.yftech.uiautomator2demo.sample;


import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.yftech.uiautomator2demo.page.HomeStartPage;
import com.yftech.uiautomator2demo.utils.InitializeApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.yftech.uiautomator2demo.page.HomeStartPage;

/**
 * 进入Facebook登录页面示例
 * Created by 薛东磊 on 2017/6/4.
 */
@RunWith(AndroidJUnit4.class)
public class OpenLenovoApp extends InitializeApp{

    @Test
    public void regist() {
        HomeStartPage.clickFacebookButton();
    }

}
