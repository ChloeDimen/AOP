package com.jetway.aop;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * 文件名：com.jetway.aop
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/7/21
 */
public class PermissionManager {
    private static volatile PermissionManager permissionManager;

    public PermissionManager(){}

    //DCL单例模式
    public static PermissionManager getInstance(){
        if (permissionManager == null){
            synchronized (PermissionManager.class){
                if (permissionManager == null){
                    permissionManager = new PermissionManager();
                }
            }
        }
        return permissionManager;
    }

    private static class InnerInsatance{
        public static final PermissionManager instance = new PermissionManager();
    }

    //内部类单例模式
    public static PermissionManager getInnerInstance(){
        synchronized (PermissionManager.class){
            return InnerInsatance.instance;
        }
    }

    public boolean checkPermission(Context context, String permission){
        Log.i("tag00","检查的权限："+permission);
        if (ContextCompat.checkSelfPermission(context,permission) == PackageManager.PERMISSION_GRANTED){
            return true;
        }
//        if (permission.equals("android.permission.CAMERA")){
//            return true;
//        }
        return false;
    }




}
