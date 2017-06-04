package com.yftech.uiautomator2demo.utils;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by 薛东磊 on 2017/6/4.
 */

public class AppElementObject extends UiObject {

    private String ACCESS_ID;
    private String TEXT;
    private String CLASS_NAME;


    /**
     * Constructs a UiObject to represent a view that matches the specified
     * selector criteria.
     *
     * @param selector
     * @since API Level 16
     * @deprecated Use {@link UiDevice#findObject(UiSelector)} instead. This version hides
     * UiObject's dependency on UiDevice and is prone to misuse.
     */
    public AppElementObject(UiSelector selector,String id,String text,String classname) {
        super(selector);
        this.ACCESS_ID = id;
        this.TEXT = text;
        this.CLASS_NAME = classname;
    }



    public String getACCESS_ID() {
        return ACCESS_ID;
    }

    public String getTEXT() {
        return TEXT;
    }

    public String getCLASS_NAME() {
        return CLASS_NAME;
    }
}
