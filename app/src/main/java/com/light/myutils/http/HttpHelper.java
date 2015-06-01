package com.light.myutils.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * 
 * @usage HTTP访问辅助工具类 
 * @author arjinmc
 * @email arjinmc@hotmail.com
 * @website http://www.hicsg.com
 * @version 2014-1-16
 */
public class HttpHelper {

	/**
	 * 判断网络是否可用
	 * @return
	 */
	public static  boolean isNeworkWorking(Context context) { 
		ConnectivityManager manager = null;
		if(context!=null){
			manager = (ConnectivityManager) context  
		    		   .getSystemService(  
		                     Context.CONNECTIVITY_SERVICE);  
		}
		
       if (manager == null) {  
           return false;  
       }  
        
       NetworkInfo networkinfo = manager.getActiveNetworkInfo();  
        
       if (networkinfo == null || !networkinfo.isAvailable()) {  
           return false;  
       }  
   
       return true;  
	}  
	
	/**
     * 以流的方式读返回信息
     * @param is
     * @return
     * @throws IOException
     */
    private static String readInputStream(InputStream is) throws IOException{
        if(is == null)
            return null;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        int len = 0;
        byte[] buf = new byte[1024];
        while((len = is.read(buf))!=-1)
        {
            bout.write(buf, 0, len);
        }
        is.close();
        return new String(bout.toByteArray());
    }
	
}
