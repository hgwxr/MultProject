package wl.hgwxr.com.commmodule;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by hgwxr on 2017/10/15.
 */

public class BaseMultApplication  extends Application {
  public static final String Tag="MAIN";
    public  static Context mContext;

    @Override
    public void onCreate() {
        Log.e(Tag, "onCreate: ");
        super.onCreate();
        mContext=this;
    }
}
