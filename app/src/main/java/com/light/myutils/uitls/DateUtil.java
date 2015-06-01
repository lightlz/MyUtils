package com.light.myutils.uitls;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @desciption 时期时间工具
 * @create 2014年10月10日
 */
public class DateUtil {
	
	public static final int SECONDS_IN_DAY = 1000*60 * 60 * 24;
	/**
	 * @desciption 得到约定时间的格林威治时间
	 * @create 2014年10月10日
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @return
	 */
	public static String getAgreeTime(int year,int month,int day,int hour,int minute){
		String time = "";
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day, hour, minute);
		time = String.valueOf(cal.getTimeInMillis()/1000);
		return time;
	}
	
	/**
	 * @desciption 格林威治时间转换为年月日时分
	 
	 
	 * @create 2014年10月11日
	 * @param longtime
	 * @return
	 */
	public static String formateDateTime(String longtime){
		String datetime = "";
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy年MM月dd日  HH:mm");
		Date date = new Date(Long.valueOf(longtime)*1000);
		datetime = simpleFormat.format(date);
		return datetime;
	}
	
	/**
	 * @desciption 显示聊天信息时间
	 
	 
	 * @create 2014年10月25日
	 * @param longtime
	 * @return
	 */
	public static String formateIMDateTime(long longtime){
		String datetime = "";

		long now = System.currentTimeMillis();

		long compare = now - longtime;
		if(compare<SECONDS_IN_DAY  && isSameDate(longtime,now)){
			SimpleDateFormat simpleFormat = new SimpleDateFormat("HH:mm");
			Date date = new Date(longtime);
			datetime = simpleFormat.format(date);
		}else{
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(longtime);
			datetime = simpleFormat.format(date);
		}
		
		return datetime;
	}
	
	
	/**
	 * @desciption 判断消息的时间间隔超过10分钟
	 
	 
	 * @create 2014年10月24日
	 * @param lastTime
	 * @param nowTime
	 * @return
	 */
	public static boolean isOverIMMessageTime(long lastTime,long nowTime){
		
		int limitedTime = 10;
		
		boolean isOver = false;
		
		long  temp = (nowTime - lastTime)/1000/60;
		if(temp>limitedTime){
			isOver = true;
		}
		return isOver;
	}
	
	/**
	 * @desciption 圈子时间
	 
	 
	 * @create 2014年10月29日
	 * @param time
	 * @return
	 */
	public static String formateCommuityDateTime(String time){
		String datetime = "";
		
		long longtime = Long.valueOf(time)*1000;
		long now = System.currentTimeMillis();
		long compare = now - longtime;
		
		SimpleDateFormat simpleFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date(longtime);
		datetime = simpleFormat.format(date);
		
		if(compare<60*1000){
			datetime = "刚刚";
		}else if(compare<60*60*1000){
			datetime = compare/(60*1000)+"分钟之前";
		}else if(compare<SECONDS_IN_DAY && isSameDate(longtime,now)){
			datetime = datetime;
		}else if(compare>SECONDS_IN_DAY && compare<SECONDS_IN_DAY*2){
			datetime = "昨天 "+datetime;
		}else if(compare>SECONDS_IN_DAY && compare<SECONDS_IN_DAY*3){
				datetime = "前天 "+datetime;
		}else{
			simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
			datetime = simpleFormat.format(date);
		}
		return datetime;
	}
	
	/**
	 * @desciption 判断是否为同一天(日期)
	 
	 
	 * @create 2014年10月29日
	 * @param cal1
	 * @param ca2
	 * @return
	 */
	public static boolean isSameDate(long ms1,long ms2){
		boolean isSame = true;
		 
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		String tadeDate = sf.format(ms1);
		String uiTradeDate = sf.format(ms2);
		if(tadeDate != null && !tadeDate.equals(uiTradeDate)){
			isSame = false;
		}
		return isSame;
	}
	
	
	/**
	 * @desciption 获取当前的年份
	 
	 
	 * @create 2014年11月3日
	 * @return
	 */
	public static int getThisYear(){
		Calendar cal = Calendar.getInstance();  
		return cal.get(Calendar.YEAR);
	}
	
	/**
	 * @desciption 获取当前的月份
	 
	 
	 * @create 2014年11月3日
	 * @return
	 */
	public static int getThisMonth(){
		Calendar cal = Calendar.getInstance();  
		return cal.get(Calendar.MONTH)+1;
	}
	
	/**
	 * @desciption 获取当前的日期
	 
	 
	 * @create 2014年11月3日
	 * @return
	 */
	public static int getThisDay(){
		Calendar cal = Calendar.getInstance();  
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * @desciption 获取当前小时
	 
	 
	 * @create 2014年11月14日
	 * @return
	 */
	public static int getThisHour(){
		Calendar cal = Calendar.getInstance();  
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * @desciption 获取当前分钟
	 
	 
	 * @create 2014年11月14日
	 * @return
	 */
	public static int getThisMinute(){
		Calendar cal = Calendar.getInstance();  
		return cal.get(Calendar.MINUTE);
	}
	
	/**
	 * @desciption 美食日记的日
	 
	 
	 * @create 2014年11月9日
	 * @param time
	 * @return
	 */
	public static String getDiaryDay(String time){
		String result = "01";
		
		Calendar cal = Calendar.getInstance(); 
		cal.setTimeInMillis(Long.valueOf(time)*1000);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		if(day<10){
			result = "0"+day;
		}else{
			result = ""+day;
		}
		return result;
	}
	
	/**
	 * @desciption 获取美食日日记月份
	 
	 
	 * @create 2014年11月9日
	 * @param time
	 * @return
	 */
	public static String getDiaryMonth(String time){
		String result = "1月";
		
		Calendar cal = Calendar.getInstance(); 
		cal.setTimeInMillis(Long.valueOf(time)*1000);
		int month = cal.get(Calendar.MONTH)+1;
		result = month+"月";
		return result;
	}
	
	/**
	 * @desciption 获取美食日记大图的时间
	 
	 
	 * @create 2014年11月11日
	 * @param longtime
	 * @return
	 */
	public static String getDiaryFullPhotoDate(String longtime){
		String datetime = "";
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy年MM月dd日\tHH:dd");
		Date date = new Date(Long.valueOf(longtime)*1000);
		datetime = simpleFormat.format(date);
		return datetime;
	}
	
	/**
	 * @desciption 是否为合法的年份
	 
	 
	 * @create 2014年11月15日
	 * @param year
	 * @return
	 */
	public static boolean isYear(String year){
		boolean isYear = false;
		if(!StringUtil.isEmpty(year)){
			int tempYear = Integer.valueOf(year);
			if(tempYear>=getThisYear() && tempYear<2100){
				isYear = true;
			}
		}
		
		return isYear;
	}
	
	/**
	 * @desciption 判断是否为合法的月份
	 
	 
	 * @create 2014年11月15日
	 * @param month
	 * @return
	 */
	public static boolean isMonth(String month){
		boolean isMonth = false;
		if(!StringUtil.isEmpty(month)){
			int tempMonth = Integer.valueOf(month);
			if(tempMonth>0 && tempMonth<13){
				isMonth = true;
			}
		}
		return isMonth;
	}
	
	/**
	 * @desciption 判断是否为合法的日期
	 
	 
	 * @create 2014年11月15日
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static boolean isDay(String year,String month,String day){
		boolean isDay = false;
		if(!StringUtil.isEmpty(year) && !StringUtil.isEmpty(month) 
				&& !StringUtil.isEmpty(day)){
			int tempYear = Integer.valueOf(year);
			int tempMonth = Integer.valueOf(month);
			int tempDay = Integer.valueOf(day);
			Calendar cal = Calendar.getInstance();
			cal.set(tempYear, tempMonth, 1);
			cal.set(Calendar.DAY_OF_MONTH,0);
			if(tempDay<=cal.get(Calendar.DAY_OF_MONTH) && tempDay>=1){
				isDay = true;
			}
		}
		return isDay;
	}
	
	/**
	 * @desciption 判断是否为合法的小时
	 
	 
	 * @create 2014年11月15日
	 * @param hour
	 * @return
	 */
	public static boolean isHour(String hour){
		boolean isHour = false;
		if(!StringUtil.isEmpty(hour)){
			int tempHour = Integer.valueOf(hour);
			if(tempHour>=0 && tempHour<24){
				isHour = true;
			}
		}
		return isHour;
	}
	
	/**
	 * @desciption 判断是否为合法的分钟
	 
	 
	 * @create 2014年11月15日
	 * @param minute
	 * @return
	 */
	public static boolean isMinute(String minute){
		boolean isMinute = false;
		if(!StringUtil.isEmpty(minute)){
			int tempMinute = Integer.valueOf(minute);
			if(tempMinute>=0 && tempMinute<60){
				isMinute = true;
			}
		}
		return isMinute;
	}
	
	/**
	 * @desciption 判断输入的时间是否过期
	 
	 
	 * @create 2014年12月10日
	 * @return
	 */
	public static boolean isExpired(String year,String month,String day
			,String hour,String minute){
		boolean isExpired = true;
		if(!StringUtil.isEmpty(year) && !StringUtil.isEmpty(month) 
				&& !StringUtil.isEmpty(day) && !StringUtil.isEmpty(hour)
				&& !StringUtil.isEmpty(minute)){
			int tempYear = Integer.valueOf(year);
			int tempMonth = Integer.valueOf(month);
			int tempDay = Integer.valueOf(day);
			int tempHour = Integer.valueOf(hour);
			int tempMinute = Integer.valueOf(minute);
			Calendar cal = Calendar.getInstance();
			cal.set(tempYear, tempMonth, 1);
			cal.set(Calendar.DAY_OF_MONTH,0);
			if(tempDay<=cal.get(Calendar.DAY_OF_MONTH) && tempDay>=1){
				cal.set(tempYear, tempMonth, tempDay, tempHour, tempMinute, 0);
				if(cal.getTimeInMillis()>System.currentTimeMillis()){
					isExpired = false;
				}
			}
		}
		return isExpired;
	}
	
	/**
	 * @desciption 判断输入的时间是否过期
	 
	 
	 * @create 2014年12月22日
	 * @param time
	 * @return
	 */
	public static boolean isExpired(long time){
		boolean isExpired = true;
		if(time>System.currentTimeMillis()){
			isExpired = false;
		}
		return isExpired;
	}
	
	/**
	 * @desciption 转换为发布任务时选中的时间的格式
	 * x月x日 周x x：x
	 
	 
	 * @create 2014年12月22日
	 * @param time
	 * @return
	 */
	public static String getTaskSelectTime(long time){
		DateFormat format = new SimpleDateFormat("MM月dd日 EEE HH:mm");
		return format.format(time);
	}
	
	/**
	 * @desciption 获取发布任务的默认时间
	 
	 
	 * @create 2014年12月22日
	 * @param time
	 * @return
	 */
	public static long getTaskDefaultTime(){
		Calendar now = Calendar.getInstance();
		now.add(Calendar.HOUR_OF_DAY, 1);
		return now.getTimeInMillis();
	}
	
	/**
	 * @desciption 获取当前时间去掉秒
	 
	 
	 * @2015年1月14日
	 *  @return
	 */
	public static String getCurrentMillisWithoutSec(){
		return String.valueOf(System.currentTimeMillis()/1000);
	}
	
	/**
	 * @desciption 减去1秒钟
	 
	 
	 * @2015年1月14日
	 *  @param time
	 *  @return
	 */
	public static String getPreMillisWithoutSec(String time){
		return String.valueOf(Long.valueOf(time)-1);
	}
}
