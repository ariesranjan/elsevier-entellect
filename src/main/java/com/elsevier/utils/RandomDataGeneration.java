package com.elsevier.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.github.javafaker.Faker;


public class RandomDataGeneration {
	
	Faker faker = new Faker();
	
	public String randomFirstName(){
		String firstName = faker.name().firstName();
		return firstName;
	}

	public String randomLastName(){
		String lastName = faker.name().lastName();
		return lastName;
	}
	

	public long randomRoomID(){
		long roomID = faker.number().randomNumber();
		return roomID;
	}
	
	public String randomCheckInDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date currentDate = new Date();

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        c.add(Calendar.YEAR, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, 1); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.HOUR, 3);
        c.add(Calendar.MINUTE, 1);
        c.add(Calendar.SECOND, 1);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();
        String convertedDate = dateFormat.format(currentDatePlusOne);
        return convertedDate;
	}
	
	public String randomCheckOutDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date currentDate = new Date();

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        c.add(Calendar.YEAR, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, 3); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.HOUR, 2);
        c.add(Calendar.MINUTE, 30);
        c.add(Calendar.SECOND, 30);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();
        String convertedDate = dateFormat.format(currentDatePlusOne);
        return convertedDate;
	}
	
	public String randomPhoneNumber(){
		String phoneNumber = faker.phoneNumber().cellPhone();
		return phoneNumber;
	}

}
