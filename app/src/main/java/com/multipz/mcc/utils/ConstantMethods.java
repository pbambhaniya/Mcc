package com.multipz.mcc.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Admin on 22-11-2017.
 */

public class ConstantMethods {

    public static void Toaster(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
