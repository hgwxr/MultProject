package wl.hgwxr.com.adapterdemo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class PopWindowActivity extends AppCompatActivity {

    private TextView tv;
    private CommonPopupWindow window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_window);
        tv = (TextView) findViewById(R.id.tv);
        final LayoutGravity layoutGravity = new LayoutGravity( LayoutGravity.TO_ABOVE);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showPopUpWindowbootom1();
                //showPop1();
                showPopUpWindowbootom();

//                layoutGravity.setHoriGravity(LayoutGravity.TO_ABOVE);
//                window.showBashOfAnchor(tv,layoutGravity,0,0);

            }
        });

        window = new CommonPopupWindow(this, R.layout.pop_layout, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT) {
            @Override
            protected void initView() {
            }

            @Override
            protected void initEvent() {}
        };
    }

    private void showPop1() {
        // 用于PopupWindow的View
        View contentView= LayoutInflater.from(PopWindowActivity.this).inflate(R.layout.pop_layout, null, false);
        // 创建PopupWindow对象，其中：
        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
        PopupWindow window=new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        // 设置PopupWindow的背景
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        window.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        window.setTouchable(true);
        window.showAsDropDown(tv);
        // 显示PopupWindow，其中：
        // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
//                window.showAsDropDown(tv, xoff, yoff);
        // 或者也可以调用此方法显示PopupWindow，其中：
        // 第一个参数是PopupWindow的父View，第二个参数是PopupWindow相对父View的位置，
        // 第三和第四个参数分别是PopupWindow相对父View的x、y偏移
        // window.showAtLocation(parent, gravity, x, y);
    }

    private void showPopUpWindowbootom1() {

        View view = LayoutInflater.from(PopWindowActivity.this).inflate(R.layout.pop_layout, null,false);
        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.showAsDropDown(tv);
//        PopupWindowCompat.showAsDropDown(popupWindow,tv,0,0, Gravity.BOTTOM);
//        popupWindow.showAtLocation(tv, Gravity.BOTTOM, 0, 0);

    }
    private void showPopUpWindowbootom() {

        View view = LayoutInflater.from(this).inflate(R.layout.pop_layout, null);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
//        popupWindow.showAsDropDown(tv);
        PopupWindowCompat.showAsDropDown(popupWindow,tv,-tv.getWidth(),-tv.getHeight()*5, Gravity.NO_GRAVITY);
//        popupWindow.showAtLocation(tv, Gravity.BOTTOM, 0, 0);

    }
}
