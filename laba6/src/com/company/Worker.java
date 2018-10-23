package com.company;

import java.io.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

abstract class Worker implements Serializable
{
    private String name;
    public String getName() {
        return name;
    }

    public enum Type { manager,analyst,programmer,tester,designer }
    private Type type;
    public Type getType() {
        return type;
    }

    private String info = "";
    public String getInfo() {
        return info;
    }
    public void setInfo( String info ) {
        this.info = info;
    }

    //public abstract void ShowInform ();
    public abstract String toStr ();
    public Worker (){}
    protected Worker (String name,Type tp)
    {
        this.name=name;
        this.type=tp;
    }

    public final Date creationDate = new Date ();
    public String getCreationDate (){
        DateFormat dateFormatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT,DateFormat.DEFAULT,AppLocale.get());
        String dateOut = dateFormatter.format(creationDate);
        return dateOut;
    }

}

class Manager extends Worker implements Serializable
{
    public Manager (String name)
    {
        super(name, Type.manager);
    }
    @Override
    public String toStr() {
        return new String ("Работник:"+" "+super.getName()+"\n"+"Должность:"+" "+super.getType().toString()+"\n"+"Дополнительные сведения:"+" "
                +super.getInfo()+"\n"+"Время создание:"+" "+super.getCreationDate());
    }
    public Manager(){}

}
class Analyst extends Worker implements Serializable
{
    public Analyst (String name)
    {
        super(name,Type.analyst);
    }

    @Override
    public String toStr() {
        return new String ("Работник:"+" "+super.getName()+"\n"+"Должность:"+" "+super.getType().toString()+"\n"+"Дополнительные сведения:"+" "
                +super.getInfo()+"\n"+"Время создание:"+" "+super.getCreationDate()); }
    public Analyst(){}
}

class Programmer extends Worker implements Serializable
{
    public Programmer (String name)
    {
        super(name,Type.programmer);
    }

    @Override
    public String toStr() {
        return new String ("Работник:"+" "+super.getName()+"\n"+"Должность:"+" "+super.getType().toString()+"\n"+"Дополнительные сведения:"+" "
                +super.getInfo()+"\n"+"Время создание:"+" "+super.getCreationDate()); }
    public Programmer(){}
}

class Tester extends Worker implements Serializable
{
    public Tester (String name)
    {
        super(name,Type.tester);
    }

    @Override
    public String toStr() {
        return new String ("Работник:"+" "+super.getName()+"\n"+"Должность:"+" "+super.getType().toString()+"\n"+"Дополнительные сведения:"+" "
                +super.getInfo()+"\n"+"Время создание:"+" "+super.getCreationDate()); }
    public Tester() {}
}
class Designer extends Worker implements Serializable
{
    public Designer (String name)
    {
        super(name,Type.designer);
    }

    @Override
    public String toStr() {
        return new String ("Работник:"+" "+super.getName()+"\n"+"Должность:"+" "+super.getType().toString()+"\n"+"Дополнительные сведения:"+" "
                +super.getInfo()+"\n"+"Время создание:"+" "+super.getCreationDate()); }
    public Designer(){}
}
class Connector
{
    private String filename;
    public Connector (String filename){this.filename=filename;}
    public void write (Worker []company) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(filename);
        try(ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeInt(company.length);
            for(int i=0;i<company.length;i++)
            {
                oos.writeObject(company[i]);
            }
            oos.flush();
        }

    }
    public Worker [] read () throws IOException,ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream(filename);
        try(ObjectInputStream oin = new ObjectInputStream(fis))
        {
            int length = oin.readInt();
            Worker [] result = new Worker[length];
            for(int i=0;i<length;i++)
                result[i] = (Worker) oin.readObject();
            return result;
        }
    }
}

class Test
{
    public static Worker [] createCompany ()
    {
        Worker [] company = new Worker [5];
        company[0] = new Programmer (AppLocale.getString(AppLocale.Andrey));
        company[0].setInfo(AppLocale.getString(AppLocale.high_salary));
        company[1] = new Designer (AppLocale.getString(AppLocale.Artjom));
        company[1].setInfo(AppLocale.getString(AppLocale.the_strongest_guy));
        company[2] = new Tester(AppLocale.getString(AppLocale.Denis));
        company[2].setInfo(AppLocale.getString(AppLocale.always_at_the_company));
        company[3] = new Manager (AppLocale.getString(AppLocale.Anna));
        company[3].setInfo(AppLocale.getString(AppLocale.carefree_laughter));
        company[4] = new Analyst(AppLocale.getString(AppLocale.Evgenij));
        company[4].setInfo(AppLocale.getString(AppLocale.never_missed));
        return company;
    }
}

class AppLocale
{
    private static final String strMsg = "Msg";
    private static Locale loc = Locale.getDefault();
    private static ResourceBundle res = ResourceBundle.getBundle(AppLocale.strMsg,AppLocale.loc);
    static Locale get(){return AppLocale.loc;}
    static void set (Locale loc ){
        AppLocale.loc = loc;
        res = ResourceBundle.getBundle(AppLocale.strMsg,AppLocale.loc);
    }
    static ResourceBundle getBundle (){return AppLocale.res;}
    static String getString (String key) {
        return AppLocale.res.getString(key);
    }
    public static final String Andrey = "Andrey";
    public static final String Evgenij = "Evgenij";
    public static final String Anna = "Anna";
    public static final String Artjom = "Artjom";
    public static final String Denis = "Denis";
    //public static final String company = "company";
    public static final String high_salary = "the_highest_salary";
    public static final String carefree_laughter = "carefree_laughter";
    public static final String the_strongest_guy = "the_strongest_guy";
    public static final String always_at_the_company = "the_strongest_guy";
    public static final String never_missed = "never_missed";



}
