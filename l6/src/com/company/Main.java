package com.company;

public class Main {

    public static void main(String[] args) {
        try
        {
            Connector con = new Connector("1.dat");
            Test ts = new Test();
            Worker [] mass = ts.createCompany();
            con.write(mass);
            Worker [] company2 = con.read();
            System.out.println("Фирма:\n");
            for(int i=0;i<5;i++) {
                System.out.println(company2[i].toStr());
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }

    }
}