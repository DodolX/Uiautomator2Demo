package com.yftech.uiautomator2demo.utils;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;

import java.util.List;

/**
 * Created by 薛东磊 on 2017/6/9.
 */

public class ElementSelector {

    /**
     * 使用id查找元素
     * @param id
     * @return
     */
    public static UiObject findByID(String id){
        return new UiObject(new UiSelector().resourceId(id));
    }

    /**
     * 使用文本查找元素
     * @param text
     * @return
     */
    public static UiObject findByText(String text){
        return new UiObject(new UiSelector().text(text));
    }

    /**
     * 使用classname查找元素
     * @param classname
     * @return
     */
    public static List<UiObject> findByClassName(String classname){
        return (List<UiObject>) new UiObject(new UiSelector().className(classname));
    }


}
