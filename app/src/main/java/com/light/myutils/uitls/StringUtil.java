package com.light.myutils.uitls;

import java.text.DecimalFormat;
import java.util.regex.Pattern;


/**
 * @desciption 字符串工具类
 * @create 2014年8月30日
 */
public class StringUtil {

	/**
	 * @desciption 判断字符串是否为空
	 * @create 2014年8月30日
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		boolean isEmpty = false;
		if(str==null || str.trim().length()==0 
				|| str.toLowerCase().equals("null"))
			isEmpty = true;
		return isEmpty;
	}
	
	/**
	 * @desciption 保留一位有效数字
	 * @create 2014年11月2日
	 * @param number
	 * @return
	 */
	public static String keepDotOneNumber(double number){
		DecimalFormat df = new   DecimalFormat("#0.0");
		return df.format(number); 
	}
	
	/**
	 * @desciption 只保留整数部分(四舍五入)
	 * @create 2014年11月16日
	 * @param number
	 * @return
	 */
	public static String keepIntegerNumber(double number){
		DecimalFormat df = new   DecimalFormat("#0");
		return df.format(number); 
	}
	
	/**
	 * @desciption 判断电话号码是否合法
	 * @create 2014年12月11日
	 * @param mobile
	 * @return
	 */
	public static boolean checkMobileNumber(String mobile) {  
        String regex = "(\\+\\d+)?1[3458]\\d{9}$";  
        return Pattern.matches(regex,mobile);  
    } 

}
