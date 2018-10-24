package com.company;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class User implements Serializable  {
    //Fields
    private int flightNumber;
    private int colPlace;
    private String nameDestination;
    private String nameUser;
    private Date startDate;
    private String time;


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
            this.flightNumber=Integer.parseInt(str.nextToken());//номер р.
            this.colPlace=Integer.parseInt(str.nextToken());//кол-во мест.
            this.nameDestination=str.nextToken();//пункт назначения.
            this.nameUser=str.nextToken();//ФИО пассажира.
            SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
            this.startDate=sdf.parse(str.nextToken());//дата.
            this.time=str.nextToken();//время.

        }
    }
    public int getflightNumber() {
        return flightNumber;
    }

    public void setflightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getcolPlace() {
        return colPlace;
    }

    public void setcolPlace(int colPlace) {
        this.colPlace = colPlace;
    }

    public String getnameDestination() {
        return nameDestination;
    }

    public void setnameDestination(String nameDestination) {
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



    // "User{sectionNumber=%s, \n DENIS_COOL=%s|}", 1, 2
    // String.format("User, %s ,
    // "SomeString",
    // "SomeString",
    // "SomeString",);

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

