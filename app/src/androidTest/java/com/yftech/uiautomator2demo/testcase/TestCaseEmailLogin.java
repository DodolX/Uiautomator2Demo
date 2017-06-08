package com.yftech.uiautomator2demo.testcase;

import android.support.test.runner.AndroidJUnit4;
import com.orhanobut.logger.Logger;
import com.yftech.uiautomator2demo.page.HomeStartPage;
import com.yftech.uiautomator2demo.page.LoginPage;
import com.yftech.uiautomator2demo.utils.ElementAction;
import com.yftech.uiautomator2demo.utils.ElementAction;
import com.yftech.uiautomator2demo.utils.InitializeApp;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 邮箱登录测试用例
 * Created by 薛东磊 on 2017/6/4.
 */
@RunWith(AndroidJUnit4.class)
public class TestCaseEmailLogin extends InitializeApp {

    @Test
    public void useEmailLoginWithCorrectPassword(){

        //Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("test start");
        ElementAction.clickElement(HomeStartPage.loginEmailButtons());
        ElementAction.clickElement(LoginPage.backButton());
        ElementAction.clickElement(HomeStartPage.userRegistrationButton());
        Logger.i("test finished");
    }
}
