package com.zzxtit.java822;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * data 
 * 
 * date 
 * 
 * 
 * 
 * 
 * @author zzxt
 *
 */
public class DateTest {

	
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		
		System.out.println("date:" + date);
		System.out.println("date:" + date.getTime());
		
		Date thatTime = new Date(1534898372544l);
		System.out.println("thatTime:" + thatTime);
		System.out.println("thatTime:" + thatTime.getTime());
		
		//2018-8-22 08:43:54 
		//2018/8/22 8:44:34
		
		//日期格式化工具
		//pattern  M/d/yy 
		//yyyy-MM-dd HH:mm:ss SSS
		/**
		 * y 表示年
		 * M 表示月
		 * d 表示日
		 * H 表示小时
		 * m 表示分
		 * s 表示秒
		 * S 表示毫秒
		 */
		DateFormat normalDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm:ss SSS EEEE");
		String dateStr = normalDf.format(date);
		System.out.println("=======================>" + dateStr);
		System.out.println("=======================>" + df.format(date));
		
		//将日期格式的字符串转化为 Date类型的数据
		String dStr = "2018-08-22 09:03:54";
		//如果模板不对应，则会出现异常
//		Date tDate = normalDf.parse(dStr);
		Date tDate = df.parse(dStr);
		
		System.out.println("**************>" + tDate);
		
		
		
	}
}
