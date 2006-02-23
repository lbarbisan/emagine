package fr.umlv.ir3.emagine.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class DateOperations {

	public static Date stringToDate(String stringDate) {
		Date date = null;
		System.err.println(stringDate);
		if (stringDate != "") {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:ss:SSS");
			date = Calendar.getInstance().getTime();
			try {
				date = simpleDateFormat.parse(stringDate);
				System.err.println(date);
			} catch (ParseException e) {
			}
		}
		return date;
	}

	public static String dateToShow(Date date) {
		System.out.println("date de date to show avant :"+date);
		String stringDate = "";
		if (date != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
			stringDate = simpleDateFormat.format(date);
		}
		System.err.println("date de date to show apres :"+date);
		return stringDate;
	}
	public static boolean checkStringDate(String date){
		boolean ok = false;
		if(date.length() == 8){
			Pattern modele = Pattern.compile("/");
	        String[] valeurs = modele.split(date, date.length());
	        if(valeurs.length == 3) ok=true ;
		}
		return ok;
	}

}
