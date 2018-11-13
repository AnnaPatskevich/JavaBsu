package com.company;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class User implements Serializable  {
    //Fields
    private boolean isDeleted = false;
    private static String fieldName = "flightNumber";


    private int flightNumber;
    private int colPlace;
    private String nameDestination;
    private String nameUser;
    private String time;
    private Date startDate;


    //  Methods
    public User() {
    }

    public User(int flightNumber, int colPlace, String nameDestination, String nameUser, Date startDate, String time) {
        this.flightNumber = flightNumber;
        this.colPlace = colPlace;
        this.nameDestination = nameDestination;
        this.nameUser = nameUser;
        this.startDate = startDate;
        this.time = time;
    }
    public User(String s) throws ParseException
    {
        StringTokenizer str=new StringTokenizer(s," ,");
        if(str.hasMoreTokens())
        {
            this.flightNumber=Integer.parseInt(str.nextToken());//код секции
            this.colPlace=Integer.parseInt(str.nextToken());//кол-во минут
            this.nameDestination=str.nextToken();//вид занятия
            this.nameUser=str.nextToken();//ФИО
            SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
            this.startDate=sdf.parse(str.nextToken());//дата
            this.time=str.nextToken();//время
        }
    }
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    public Object getFieldName() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(this);
    }

    public static void setFieldName(String fieldName) {
        User.fieldName = fieldName;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getColPlace() {
        return colPlace;
    }

    public void setColPlace(int colPlace) {
        this.colPlace = colPlace;
    }

    public String getNameDestination() {
        return nameDestination;
    }

    public void setNameDestination(String nameDestination) {
        this.nameDestination = nameDestination;
    }

    public String getnameUser() {
        return nameUser;
    }

    public void setnameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Date getstartDate() {
        return startDate;
    }

    public void setstartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "User{" +
                "flightNumber=" + flightNumber +
                ", colPlace=" + colPlace +
                ", nameDestination='" + nameDestination + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", startDate=" + startDate +
                ", time=" + time +
                '}';
    }
}

