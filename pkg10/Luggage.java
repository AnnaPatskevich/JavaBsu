package лось.лаба.pkg11.задание.pkg10;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Luggage implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int number_of_flight;
    private Date date_of_flight;
    private String destination;
    private String passenger_surname;
    private String passenger_name;
    private String passenger_patronomic;
    private int count_of_places;
    private double weight;

    Luggage() {}
    public Luggage(int number_of_flight, String date_of_flight, String destination, String passenger_surname, String passenger_name, String passenger_patronomic, int count_of_places, double weight) throws ParseException
    {
        if (number_of_flight<=0)
            throw new IllegalArgumentException("Неверное значение number_of_flight");
        if (count_of_places<0)
            throw new IllegalArgumentException("Неверное значение count_of_places");
        if (weight<0)
            throw new IllegalArgumentException("Неверное значение weight");
        this.number_of_flight = number_of_flight;
        SimpleDateFormat sp = new SimpleDateFormat("dd.mm.yyyy HH.mm");
        this.date_of_flight = sp.parse(date_of_flight);
        this.destination = destination;
        this.passenger_surname = passenger_surname;
        this.passenger_name = passenger_name;
        this.passenger_patronomic = passenger_patronomic;
        this.count_of_places = count_of_places;
        this.weight = weight;
    }

    public Luggage(Scanner sc) throws ParseException
    {
        this.number_of_flight = sc.nextInt();
        sc.nextLine();
        SimpleDateFormat sp = new SimpleDateFormat("dd.mm.yyyy HH:mm");
        this.date_of_flight = sp.parse(sc.nextLine());
        this.destination = sc.nextLine();
        this.passenger_surname = sc.nextLine();
        this.passenger_name = sc.nextLine();
        this.passenger_patronomic = sc.nextLine();
        this.count_of_places = sc.nextInt();
        this.weight = sc.nextDouble();
        if (number_of_flight<=0)
            throw new IllegalArgumentException("Неверное значение number_of_flight");
        if (number_of_flight<=0)
            throw new IllegalArgumentException("Неверное значение number_of_flight");
        if (count_of_places<0)
            throw new IllegalArgumentException("Неверное значение count_of_places");
        if (weight<0)
            throw new IllegalArgumentException("Неверное значение weight");
    }

    public Luggage(String [] mas) throws ParseException
    {
        this.number_of_flight = Integer.parseInt(mas[0]);
        SimpleDateFormat sp = new SimpleDateFormat("dd.mm.yyyy HH:mm");
        this.date_of_flight = sp.parse(mas[1]);
        this.destination = mas[2];
        this.passenger_surname = mas[3];
        this.passenger_name = mas[4];
        this.passenger_patronomic = mas[5];
        this.count_of_places = Integer.parseInt(mas[6]);
        this.weight = Double.parseDouble(mas[7]);
        if (number_of_flight<=0)
            throw new IllegalArgumentException("Неверное значение number_of_flight");
        if (number_of_flight<=0)
            throw new IllegalArgumentException("Неверное значение number_of_flight");
        if (count_of_places<0)
            throw new IllegalArgumentException("Неверное значение count_of_places");
        if (weight<0)
            throw new IllegalArgumentException("Неверное значение weight");
    }
    
    public int getNumber_of_flight()
    {
        return number_of_flight;
    }

    public void setNumber_of_flight(int number_of_flight)
    {
        if (number_of_flight<=0)
            throw new IllegalArgumentException("Неверное значение number_of_flight");
        this.number_of_flight = number_of_flight;
    }

    public void setNumber_of_flight(Scanner sc)
    {
        if (number_of_flight<=0)
            throw new IllegalArgumentException("Неверное значение number_of_flight");
        this.number_of_flight = sc.nextInt();
    }

    public Date getDate_of_flight()
    {
        return date_of_flight;
    }

    public void setDate_of_flight(Date date_of_flight)
    {
        this.date_of_flight = date_of_flight;
    }

    public void setDate_of_flight(Scanner sc) throws ParseException
    {
        SimpleDateFormat sp = new SimpleDateFormat("dd.mm.yyyy HH.mm");
        date_of_flight = sp.parse(sc.nextLine());
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public void setDestination(Scanner sc)
    {
        this.destination = sc.nextLine();
    }

    public String getPassenger_surname()
    {
        return passenger_surname;
    }

    public void setPassenger_surname(String passenger_surname)
    {
        this.passenger_surname = passenger_surname;
    }

    public void setPassenger_surname(Scanner sc)
    {
        this.passenger_surname = sc.nextLine();
    }

    public String getPassenger_name()
    {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name)
    {
        this.passenger_name = passenger_name;
    }

    public void setPassenger_name(Scanner sc)
    {
        this.passenger_name = sc.nextLine();
    }

    public String getPassenger_patronomic()
    {
        return passenger_patronomic;
    }

    public void setPassenger_patronomic(String passenger_patronomic)
    {
        this.passenger_patronomic = passenger_patronomic;
    }

    public void setPassenger_patronomic(Scanner sc)
    {
        this.passenger_patronomic = sc.nextLine();
    }

    public int getCount_of_places()
    {
        return count_of_places;
    }

    public void setCount_of_places(int count_of_places)
    {
        if (count_of_places<0)
            throw new IllegalArgumentException("Неверное значение count_of_places");
        this.count_of_places = count_of_places;
    }

    public void setCount_of_places(Scanner sc)
    {
        if (count_of_places<0)
            throw new IllegalArgumentException("Неверное значение count_of_places");
        this.count_of_places = sc.nextInt();
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        if (weight<0)
            throw new IllegalArgumentException("Неверное значение weight");
        this.weight = weight;
    }

    public void setWeight(Scanner sc)
    {
        if (weight<0)
            throw new IllegalArgumentException("Неверное значение weight");
        this.weight = sc.nextDouble();
    }

    @Override
    public String toString()
    {
        return "Luggage{" +
                "number_of_flight=" + number_of_flight +
                ", date_of_flight=" + DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT).format(date_of_flight) +
                ", destination='" + destination + '\'' +
                ", passenger_surname='" + passenger_surname + '\'' +
                ", passenger_name='" + passenger_name + '\'' +
                ", passenger_patronomic='" + passenger_patronomic + '\'' +
                ", count_of_places=" + count_of_places +
                ", weight=" + weight +
                '}';
    }
}
