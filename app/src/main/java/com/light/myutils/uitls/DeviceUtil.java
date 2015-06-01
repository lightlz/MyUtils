package com.light.myutils.uitls;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * @desciption 设备信息的工具类
 * @create 2014年10月20日
 */
public class DeviceUtil {
	
	/**
	 * @desciption 获取状态栏的高度
	 * @create 2014年10月20日
	 * @param context
	 * @return
	 */
	public static int getStatusBarHeight(Context context){
		Rect frame = new Rect();
    	((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
    	return frame.top;
	}
	
	/**
	 * @desciption 获取屏幕的宽度
	 * @create 2014年12月9日
	 * @param context
	 * @return
	 */
	public static int getScreenWith(Context context){
		WindowManager windowManager = ((Activity) context).getWindowManager();  
		Display display = windowManager.getDefaultDisplay();  
		return display.getWidth();
	}
	
	/**
	 * @desciption 获取屏幕的高度
	 * @create 2014年12月9日
	 * @param context
	 * @return
	 */
	public static int getScreenHeight(Context context){
		WindowManager windowManager = ((Activity) context).getWindowManager();  
		Display display = windowManager.getDefaultDisplay();  
		return display.getHeight();
	}
	
	/**
	 * @desciption 隐藏键盘
	 * @create 2014年11月8日
	 * @param context
	 */
	public static void hideKeyboard(Context context,View view){
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		//imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
		imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

		//((Activity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}
	
	
	/**
	 * @desciption 显示软键盘
	 * @create 2014年11月29日
	 */
	public static void showKeyboard(EditText editText){
		editText.requestFocus();
		InputMethodManager inputManager =
		(InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		inputManager.showSoftInput(editText, 0);
	}
	
	/**
	 * @desciption 获取手机的设备号
	 * @create 2014年12月19日
	 * @param context
	 * @return
	 */
	public static String getDeviceId(Context context){
		TelephonyManager TelephonyMgr = (TelephonyManager)context
				.getSystemService(Context.TELEPHONY_SERVICE); 
		return TelephonyMgr.getDeviceId();
	}

}
