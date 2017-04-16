package com.example.snake.checkpackage;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 원하는 패키지명
        String packageName = "com.apps.morning_market";

        if(isAppInstalled(packageName)){
            Intent intent = this.getPackageManager().getLaunchIntentForPackage(packageName);
            startActivity(intent);

        } else {
            Intent marketIntent = new Intent(
                    Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));

            startActivity(marketIntent);

        }

    }

    // 패키지가 설치되어 있는 지 Check
    boolean isAppInstalled(String strAppPackage) {
        PackageManager pm = getPackageManager();
        PackageInfo pi;

        try {
            pi = pm.getPackageInfo(strAppPackage, PackageManager. GET_ACTIVITIES);
        }
        catch (PackageManager.NameNotFoundException e) {
            return false ;
        }

        return true ;
    }

}
