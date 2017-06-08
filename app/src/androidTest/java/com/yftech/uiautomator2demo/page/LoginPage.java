package com.yftech.uiautomator2demo.page;

import android.support.test.uiautomator.UiObject;

import com.yftech.uiautomator2demo.utils.ElementAction;
import com.yftech.uiautomator2demo.utils.ElementSelector;

/**
 * Created by 薛东磊 on 2017/6/4.
 */

public class LoginPage {
    private static final String BACK_BUTTON_TEXT = "Back";
    private static UiObject backButton;

    public static void clickBackButton(){
        ElementAction.clickByText(backButton,BACK_BUTTON_TEXT);
    }

    public static UiObject backButton(){
        return ElementSelector.findByText(BACK_BUTTON_TEXT);
    }
}
