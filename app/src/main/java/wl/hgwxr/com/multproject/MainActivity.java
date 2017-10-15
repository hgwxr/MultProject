package wl.hgwxr.com.multproject;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import wl.hgwxr.com.commmodule.CommRouter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);
        findViewById(R.id.tv).setOnClickListener(this);
        findViewById(R.id.tv1).setOnClickListener(this);
        findViewById(R.id.tv2).setOnClickListener(this);
        findViewById(R.id.tv3).setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                CommRouter.getSingleInstance().jump("app_main2");
                break;
            case R.id.tv1:
                CommRouter.getSingleInstance().jump("module1_main");
                break;
            case R.id.tv2:
                CommRouter.getSingleInstance().jump("module2_main");
                break;
            case R.id.tv3:
                CommRouter.getSingleInstance().jumpUri("module1://main_scheme/index");
                break;
        }
    }




}
