package com.day10_calendar;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1; // 0~11
		int day = now.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + ":" + month + ":" + day);

		int ampm = now.get(Calendar.AM_PM);
		int h = now.get(Calendar.HOUR);
		int m = now.get(Calendar.MINUTE);
		int s = now.get(Calendar.SECOND);
		String str = "";
		if (ampm == Calendar.PM) {
			str = "PM";
		} else {
			str = "AM";
		}
		System.out.println(str + ":" + h + ":" + m + ":" + s);
		int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
		System.out.println(str + ":" + hourOfDay + ":" + m + ":" + s);

		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		String[] dow = { "sun", "mon", "tue", "wen", "thu", "fri", "sat" };
		String dow_s = null;

		switch (dayOfWeek) {
		case Calendar.MONDAY:
			dow_s = "mon";
		case Calendar.TUESDAY:
			dow_s = "tue";
			break;
		case Calendar.WEDNESDAY:
			dow_s = "tue";
			break;
		case Calendar.THURSDAY:
			dow_s = "thu";
			break;
		case Calendar.FRIDAY:
			dow_s = "fri";
			break;
		case Calendar.SATURDAY:
			dow_s = "sat";
			break;
		case Calendar.SUNDAY:
			dow_s = "sun";
			break;
		}
		System.out.println("switch >> " + dow_s);
		System.out.println("array >> " + dow[dayOfWeek - 1]);
		System.out.println("day of week : " + dayOfWeek);

		Calendar someday = Calendar.getInstance();
		someday.set(2022, 11, 25);
		int some_dow = someday.get(Calendar.DAY_OF_WEEK);
		System.out.println("xmas : " + dow[some_dow - 1]);
	}
}
