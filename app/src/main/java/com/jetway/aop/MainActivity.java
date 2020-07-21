package com.jetway.aop;

import android.Manifest;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * 摇一摇模块
     */
    @BehaviorTrace(value = "摇一摇", type = 1)
    public void btn_shake(View view) {
        //统计用户行为的逻辑
        // Log.i(TAG, "摇一摇 ：统计使用时间 "+mSimpleDateFormat.format(new Date()));
        // long beagin=System.currentTimeMillis();
        //摇一摇的代码逻辑
        {
            SystemClock.sleep(3000);
            Log.i(TAG, "  摇到一个嫩模：  约不约");
        }
        //Log.i(TAG,"消耗时间：  "+(System.currentTimeMillis()-beagin)+"ms");
    }

    /**
     * 语音的模块
     *
     * @param view
     */
    @BehaviorTrace(value = "语音", type = 2)
    public void btn_audio(View view) {
        // long beagin=System.currentTimeMillis();

        //摇一摇的代码逻辑
        {
            SystemClock.sleep(3000);

            Log.i(TAG, "  美女  睡不着   热不热");

        }

        // Log.i(TAG,"消耗时间：  "+(System.currentTimeMillis()-beagin)+"ms");

    }

    @BehaviorTrace(value = "文字", type = 3)
    public void btn_text(View view) {
        //统计用户行为 的逻辑
        //  Log.i(TAG,"文字：  使用时间：   "+mSimpleDateFormat.format(new Date()));
        // long beagin=System.currentTimeMillis();

        //摇一摇的代码逻辑
        {
            SystemClock.sleep(3000);
            Log.i(TAG, "  热   我们去18");

        }

        // Log.i(TAG,"消耗时间：  "+(System.currentTimeMillis()-beagin)+"ms");
    }

    @permissionCheck(value = Manifest.permission.CAMERA)
    @CheckNet
    public void btn_net(View view) {
        Log.i(TAG, "  热   我们去18");

    }
}
