package wl.hgwxr.com.commmodule;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.net.URI;
import java.util.regex.Pattern;

/**
 * Created by hgwxr on 2017/10/15.
 */

public class CommRouter {
    private static class Instance{
        private static CommRouter instance=new CommRouter();
    }
    private CommRouter(){}
    public static CommRouter getSingleInstance(){
        return Instance.instance;
    }
    public void jump(String path){
        try {
            Intent intent = new Intent();
            intent.setAction(path);
            BaseMultApplication.mContext.startActivity(intent);
        }catch (ActivityNotFoundException e){
            Toast.makeText(BaseMultApplication.mContext,"NOT found Activity",Toast.LENGTH_LONG).show();
        }
    }
    public void jumpUri(String path){
        try {
            Uri uri = Uri.parse(path);

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            //PackageManager packageManager=BaseMultApplication.mContext.getPackageManager();
           // ComponentName componentName=intent.resolveActivity(packageManager);
           // if (componentName!=null){
                BaseMultApplication.mContext.startActivity(intent);
           // }
        } catch (Exception e) {
            Toast.makeText(BaseMultApplication.mContext,"NOT found Activity",Toast.LENGTH_LONG).show();
        }
    }
}
