package com.company;
import java.io.*;
import java.io.Serializable;

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

}

class Manager extends Worker implements Serializable
{
    public Manager (String name)
    {
        super(name, Type.manager);
    }
    @Override
    public String toStr() {
        return new String ("Работник:"+" "+super.getName()+"\n"+"Должность:"+" "+super.getType().toString()+"\n"+"Дополнительные сведения:"+" "+super.getInfo()+"\n");
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
        return new String ("Работник:"+" "+super.getName()+"\n"+"Должность:"+" "+super.getType().toString()+"\n"+"Дополнительные сведения:"+" "+super.getInfo()+"\n");
    }
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
        return new String ("Работник:"+" "+super.getName()+"\n"+"Должность:"+" "+super.getType().toString()+"\n"+"Дополнительные сведения:"+" "+super.getInfo()+"\n");
    }
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
        return new String ("Работник:"+" "+super.getName()+"\n"+"Должность:"+" "+super.getType().toString()+"\n"+"Дополнительные сведения:"+" "+super.getInfo()+"\n");
    }
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
        return new String ("Работник:"+" "+super.getName()+"\n"+"Должность:"+" "+super.getType().toString()+"\n"+"Дополнительные сведения:"+" "+super.getInfo()+"\n");
    }
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
        company[0] = new Programmer("Андрей");
        company[0].setInfo("самая большая з/п");
        company[1] = new Designer("Артём");
        company[1].setInfo("самый сильный парень");
        company[2] = new Tester("Денис");
        company[2].setInfo("всегда на фирме");
        company[3] = new Manager("Анна");
        company[3].setInfo("прилежная ученица");
        company[4] = new Analyst("Евгений");
        company[4].setInfo("ни одного прогула");
        return company;
    }

}
