package com.abrahamgcc.shealthbypass;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class BaseModule implements IXposedHookLoadPackage {

    /**
     * @abrahamgcc on 18/06/2022
     *
     * Working on SHealth >= v6.20.1.005
     * Bypass consists on edit checkKnoxCompromised method, but edit the apk is a pain so let's simplify it into a Xposed module.
     *
     * **/

    private final static String TAG = "SHealthBypass";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {

        if (lpparam.packageName.equals("com.sec.android.app.shealth")) {
            // Using System.out.println since app is not debbugable
            System.out.println(TAG + " - SHealth started");
            XposedHelpers.findAndHookMethod("com.samsung.android.sdk.healthdata.privileged.KnoxControl", lpparam.classLoader, "checkKnoxCompromised", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam param) {
                    System.out.println(TAG + " - KnoxControl - checkKnoxCompromised - 0");
                    return 0;
                }
            });
        }

    }

}
