package com.yftech.uiautomator2demo.sample;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.widget.ListView;
import android.widget.Switch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by 80736 on 2017/5/28.
 */

@RunWith(AndroidJUnit4.class)
public class LaunchSettings {
    private UiDevice mDevices;

    @Before
    public void setUp(){
        mDevices = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    // TODO 重要注意： 在运行该测试代码的时候 需要先把手机语言环境设置为英文。
    @Test
    public void testDemo() throws UiObjectNotFoundException {

        // 模拟 HOME 键点击事件
        mDevices.pressHome();

        // 现在打开了主屏应用，模拟点击所有应用按钮操作来启动所有应用界面。
        // 如果你使用了uiautomatorviewer来查看主屏，则可以发现“所有应用”按钮的
        // content-description 属性为“Apps”。可以使用该属性来找到该按钮。
        UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));

        // 模拟点击所有应用按钮，并等待所有应用界面起来
        allAppsButton.clickAndWaitForNewWindow();

        if (allAppsButton.exists() && allAppsButton.isEnabled()) {
            // allAppsButton在当前界面已经不可见了 所以这里不会执行
            allAppsButton.click();
        }

        // 在所有应用界面，时钟应用位于Apps tab界面中。下面模拟用户点击Apps tab操作。
        // 找到 Apps tab 按钮
        //UiObject appsTab = new UiObject(new UiSelector().text("Apps"));

        // 模拟点击 Apps tab.
        //appsTab.click();

        // 然后在 Apps tab界面，模拟用户滑动到时钟应用的操作。
        // 由于Apps界面是可以滚动的，所有用
        // UiScrollable 对象.
        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        if (appViews.exists()){
            // 设置滚动模式为水平滚动(默认为垂直滚动)
            appViews.setAsVerticalList();
            // 查找时钟应用并点击
            UiObject settingsApp = appViews.getChildByText(
                    new UiSelector().className(android.widget.TextView.class.getName()), "Clock");
            settingsApp.clickAndWaitForNewWindow();
        } else {
            UiObject clock = new UiObject(new UiSelector().text("Clock"));
            clock.clickAndWaitForNewWindow();
        }






        // 验证当前显示 的应用包名为时钟

        UiObject settingsValidation = new UiObject(new UiSelector().packageName("com.google.android.deskclock"));
        // 如果不存在则出错提示
        //assertTrue("Unable to detect Clock", settingsValidation.exists());

        // 模拟点击时间tab
        UiObject clock = new UiObject(new UiSelector().description("Clock"));
        clock.clickAndWaitForNewWindow();
        // 模拟点击下方的闹钟图标
        UiObject alarms = new UiObject(new UiSelector().description("Alarms"));
        alarms.clickAndWaitForNewWindow();

        UiScrollable list = new UiScrollable(new UiSelector().className(ListView.class.getName()));
        if (list.getChildCount() > 0) {
            UiObject listIndex0 = list.getChild(new UiSelector().index(0));
            UiObject switchBtn = listIndex0.getChild(new UiSelector().className(Switch.class.getName()));

            boolean isChecked = switchBtn.isChecked();

            switchBtn.click();
        }
        // 模拟点击返回键
        mDevices.pressBack();

        UiObject timer = new UiObject(new UiSelector().description("Timer"));
        timer.clickAndWaitForNewWindow();

    }
}
