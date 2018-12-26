package лось.лаба.pkg11.задание.pkg10;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

public class FileBuffer
{
    private static final long serialVersionUID = 1L;
    public static byte[] toByteArray(Luggage lug) throws IOException
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JarOutputStream jarOutputStream = new JarOutputStream(byteArrayOutputStream);
        jarOutputStream.putNextEntry(new JarEntry("next_entry"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(jarOutputStream);
        objectOutputStream.writeObject(lug);
        objectOutputStream.flush();
        jarOutputStream.closeEntry();
        jarOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }
    public static Luggage fromByteArray(byte[] mas) throws IOException, ClassNotFoundException
    {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mas);
        JarInputStream jarInputStream = new JarInputStream(byteArrayInputStream);
        jarInputStream.getNextEntry();
        ObjectInputStream objectInputStream = new ObjectInputStream(jarInputStream);
        return (Luggage) objectInputStream.readObject();
    }
    public static void AppendFile(String filename, Luggage lug, String filename_ind) throws IOException, Exception
    {
        RandomAccessFile file = new RandomAccessFile(filename, "rw");
        file.seek(file.length());
        Index.add_fields_of_Luggage(lug,file.getFilePointer(),filename_ind);
        byte [] mas = toByteArray(lug);
        file.writeInt(mas.length);
        file.write(mas);
        file.setLength(file.getFilePointer());
        file.close();
    }
    public static Luggage[] ReadMas(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        RandomAccessFile file = new RandomAccessFile(filename, "r");
        ArrayList<Luggage> list = new ArrayList<>();
        while (file.getFilePointer()!=file.length())
        {
            int length = file.readInt();
            byte[] mas = new byte[length];
            file.read(mas);
            list.add(fromByteArray(mas));
        }
        Luggage[] rez = new Luggage[list.size()];
        for (int i=0; i<rez.length; i++)
            rez[i]=list.get(i);
        file.close();
        return rez;
    }
    public static Luggage ReadObjectFromPosition(String filename, long position) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        RandomAccessFile file = new RandomAccessFile(filename, "r");
        file.seek(position);
        int length = file.readInt();
        byte[] mas = new byte[length];
        file.read(mas);
        file.close();
        return fromByteArray(mas);
    }
    public static String ReadStringMas(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Luggage[] mas = ReadMas(filename);
        String str = new String();
        for (Luggage lug:mas)
            str+=lug+"\n";
        return str;
    }
    public static class Index
    {
        private static final long serialVersionUID = 1L;
        private static TreeMap<Integer, Long> Map_number_of_flight;
        private static TreeMap<Date,ArrayList<Long>> Map_date_of_flight;
        private static TreeMap<String,ArrayList<Long>> Map_destination;
        private static TreeMap<Double,ArrayList<Long>> Map_weight;
        public static void test_files(String filename, String filename_ind) throws ClassNotFoundException, Exception
        {
            load_maps_from_file(filename_ind);
            Map.Entry<Integer, Long> entry = Map_number_of_flight.firstEntry();
            ReadObjectFromPosition(filename, entry.getValue());
            entry=Map_number_of_flight.higherEntry(entry.getKey());
            while (entry!=null)
            {
                ReadObjectFromPosition(filename, entry.getValue());
                entry=Map_number_of_flight.higherEntry(entry.getKey());
            }
        }
        public static void change_record(String filename, String filename_ind, int current_number_of_flight, Luggage lug) throws Exception
        {
            if (current_number_of_flight==lug.getNumber_of_flight())
            {
                delete_by_index(filename, "number_of_flight", Integer.toString(current_number_of_flight), filename_ind);
                AppendFile(filename, lug, filename_ind);
            }
            else
            {
                if (str_by_index(filename, "number_of_flight", Integer.toString(current_number_of_flight), filename_ind).compareTo("Такого объекта в файле нет")==0)
                {
                     delete_by_index(filename, "number_of_flight", Integer.toString(current_number_of_flight), filename_ind);
                     AppendFile(filename, lug, filename_ind);
                }
                else
                    throw new Exception("Запись с таким номером рейса уже есть");
            }
            write_maps_to_file(filename_ind);
        }
        public static String get_str_numbers_of_flight(String filename_ind) throws IOException, FileNotFoundException, ClassNotFoundException, Exception
        {
            load_maps_from_file(filename_ind);
            SortedSet<Integer> key_set = (SortedSet<Integer>) Map_number_of_flight.keySet();
            String rez="";
            for(Integer value:key_set)
                rez+=Integer.toString(value)+"\n";
            return rez;
        }
        public  static Luggage get_object_by_number_of_flight(String filename, String filename_ind, int number) throws IOException, FileNotFoundException, ClassNotFoundException, Exception
        {
            load_maps_from_file(filename_ind);
            return ReadObjectFromPosition(filename, Map_number_of_flight.get(number));
        }
        private static void write_maps_to_file(String filename) throws FileNotFoundException, IOException
        {
            JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(filename));
            jarOutputStream.putNextEntry(new JarEntry("Entry"));
            ObjectOutputStream index_file = new ObjectOutputStream(jarOutputStream);
            index_file.writeObject(Map_number_of_flight);
            index_file.writeObject(Map_date_of_flight);
            index_file.writeObject(Map_destination);
            index_file.writeObject(Map_weight);
            jarOutputStream.closeEntry();
            jarOutputStream.close();
            index_file.close();
        }
        private static void load_maps_from_file(String filename) throws FileNotFoundException, IOException, ClassNotFoundException, Exception
        {
            try (BufferedReader bf = new BufferedReader(new BufferedReader(new InputStreamReader(new FileInputStream(filename)))))
            {
              String tmp=bf.readLine();
              if (tmp==null)
              {
                Map_number_of_flight = new TreeMap<Integer, Long>();
                Map_date_of_flight = new TreeMap<Date, ArrayList<Long>>();
                Map_destination = new TreeMap<String, ArrayList<Long>>();
                Map_weight = new TreeMap<Double, ArrayList<Long>>();
                write_maps_to_file(filename);
                return;
              }
                JarInputStream jarInputStream = new JarInputStream(new FileInputStream(filename));
                jarInputStream.getNextJarEntry();
                ObjectInputStream index_file = new ObjectInputStream(jarInputStream);
                Map_number_of_flight = (TreeMap<Integer, Long>) index_file.readObject();
                Map_date_of_flight = (TreeMap<Date,ArrayList<Long>>) index_file.readObject();
                Map_destination = (TreeMap<String, ArrayList<Long>>) index_file.readObject();
                Map_weight = (TreeMap<Double, ArrayList<Long>>) index_file.readObject();
                jarInputStream.closeEntry();
                jarInputStream.close();
                index_file.close();
            }
            catch (Exception e)
            {
                throw new Exception("Файл с контейнерами некорректен");
            }
        }
        private static void reset_maps(String filename) throws IOException
        {
            Map_number_of_flight = new TreeMap<Integer, Long>();
            Map_date_of_flight = new TreeMap<Date, ArrayList<Long>>();
            Map_destination = new TreeMap<String, ArrayList<Long>>();
            Map_weight = new TreeMap<Double, ArrayList<Long>>();
            write_maps_to_file(filename);
        }
        private static void add_fields_of_Luggage(Luggage lug, long position, String filename) throws Exception
        {
            load_maps_from_file(filename);
            if(Map_number_of_flight.containsKey(lug.getNumber_of_flight()))
                throw new Exception("Невозможно добавить записи из файла: повторяются значения Номера полёта");
            Map_number_of_flight.put(lug.getNumber_of_flight(),position);
            if (Map_date_of_flight.containsKey(lug.getDate_of_flight()))
            {
                ArrayList<Long> mas = Map_date_of_flight.get(lug.getDate_of_flight());
                mas.add(position);
                Map_date_of_flight.put(lug.getDate_of_flight(),mas);
            }
            else
            {
                ArrayList<Long> mas = new ArrayList<>();
                mas.add(position);
                Map_date_of_flight.put(lug.getDate_of_flight(),mas);
            }
            if (Map_destination.containsKey(lug.getDestination()))
            {
                ArrayList<Long> mas = Map_destination.get(lug.getDestination());
                mas.add(position);
                Map_destination.put(lug.getDestination(),mas);
            }
            else
            {
                ArrayList<Long> mas = new ArrayList<>();
                mas.add(position);
                Map_destination.put(lug.getDestination(),mas);
            }
            if (Map_weight.containsKey(lug.getWeight()))
            {
                ArrayList<Long> mas = Map_weight.get(lug.getWeight());
                mas.add(position);
                Map_weight.put(lug.getWeight(),mas);
            }
            else
            {
                ArrayList<Long> mas = new ArrayList<>();
                mas.add(position);
                Map_weight.put(lug.getWeight(),mas);
            }
            write_maps_to_file(filename);
        }
        public static String str_by_encreasing_index(String filename, String field_to_compare, String filename_ind) throws Exception
        {
            load_maps_from_file(filename_ind);
            switch (field_to_compare)
            {
                case "number_of_flight":
                    Map.Entry entry = Map_number_of_flight.firstEntry();
                    if (entry==null)
                        throw new Exception("Неккоректный файл");
                    String str="";
                    while (entry !=null)
                    {
                        str+=ReadObjectFromPosition(filename,(long)entry.getValue())+"\n";
                        entry=Map_number_of_flight.higherEntry((Integer) entry.getKey());
                    }
                    return str;
                case "date_of_flight":
                    entry = Map_date_of_flight.firstEntry();
                    if (entry==null)
                        throw new Exception("Неккоректный файл");
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_date_of_flight.higherEntry((Date) entry.getKey());
                    }
                    return str;
                case "destination":
                    entry = Map_destination.firstEntry();
                    if (entry==null)
                        throw new Exception("Неккоректный файл");
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_destination.higherEntry((String) entry.getKey());
                    }
                    return str;
                case "weight":
                    entry = Map_weight.firstEntry();
                    if (entry==null)
                        throw new Exception("Неккоректный файл");
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_weight.higherEntry((Double) entry.getKey());
                    }
                    return str;
                    default:
                        throw new Exception("Неверная команда");
            }
        }
        public static String str_by_decreasing_index(String filename, String field_to_compare, String filename_ind) throws Exception
        {
            load_maps_from_file(filename_ind);
            switch (field_to_compare)
            {
                case "number_of_flight":
                    Map.Entry entry = Map_number_of_flight.lastEntry();
                    if (entry==null)
                        throw new Exception("Неккоректный файл");
                    String str="";
                    while (entry !=null)
                    {
                        str+=ReadObjectFromPosition(filename,(long)entry.getValue())+"\n";
                        entry=Map_number_of_flight.lowerEntry((Integer) entry.getKey());
                    }
                    return str;
                case "date_of_flight":
                    entry = Map_date_of_flight.lastEntry();
                    if (entry==null)
                        throw new Exception("Неккоректный файл");
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_date_of_flight.lowerEntry((Date) entry.getKey());
                    }
                    return str;
                case "destination":
                    entry = Map_destination.lastEntry();
                    if (entry==null)
                        throw new Exception("Неккоректный файл");
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_destination.lowerEntry((String) entry.getKey());
                    }
                    return str;
                case "weight":
                    entry = Map_weight.lastEntry();
                    if (entry==null)
                        throw new Exception("Неккоректный файл");
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_weight.lowerEntry((Double) entry.getKey());
                    }
                    return str;
                default:
                    throw new Exception("Неверная команда");
            }
        }
        public static String str_by_index(String filename, String field, String index, String filename_ind) throws Exception
        {
            load_maps_from_file(filename_ind);
            switch (field)
            {
                case "number_of_flight":
                    int ind = Integer.parseInt(index);
                    if (!Map_number_of_flight.containsKey(ind))
                        return "Такого объекта в файле нет";
                    return new String(ReadObjectFromPosition(filename,Map_number_of_flight.get(ind)).toString());
                case "date_of_flight":
                    SimpleDateFormat sp = new SimpleDateFormat("dd.mm.yyyy HH:mm");
                    Date date = sp.parse(index);
                    if (!Map_date_of_flight.containsKey(date))
                        return "Такого объекта в файле нет";
                    String str="";
                    ArrayList<Long> mas = Map_date_of_flight.get(date);
                    for (long l:mas)
                        str+=ReadObjectFromPosition(filename,l)+"\n";
                    return str;
                case "destination":
                    if (!Map_destination.containsKey(index))
                        return "Такого объекта в файле нет";
                    str="";
                    mas = Map_destination.get(index);
                    for (long l:mas)
                        str+=ReadObjectFromPosition(filename,l)+"\n";
                    return str;
                case "weight":
                    Double we = Double.parseDouble(index);
                    if (!Map_weight.containsKey(we))
                        return "Такого объекта в файле нет";
                    str="";
                    mas = Map_weight.get(we);
                    for (long l:mas)
                        str+=ReadObjectFromPosition(filename,l)+"\n";
                    return str;
                default:
                    throw new Exception("Неверная команда");
            }
        }
        public static String str_larger_index(String filename, String field, String index, String filename_ind) throws Exception
        {
            load_maps_from_file(filename_ind);
            switch (field)
            {
                case "number_of_flight":
                    Map.Entry entry = Map_number_of_flight.higherEntry(Integer.parseInt(index));
                    if (entry==null)
                        return "Таких объектов в файле нет";
                    String str="";
                    while (entry !=null)
                    {
                        str+=ReadObjectFromPosition(filename,(long)entry.getValue())+"\n";
                        entry=Map_number_of_flight.higherEntry((Integer) entry.getKey());
                    }
                    return str;
                case "date_of_flight":
                    SimpleDateFormat sp = new SimpleDateFormat("dd.mm.yyyy HH:mm");
                    entry = Map_date_of_flight.higherEntry(sp.parse(index));
                    if (entry==null)
                        return "Таких объектов в файле нет";
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_date_of_flight.higherEntry((Date) entry.getKey());
                    }
                    return str;
                case "destination":
                    entry = Map_destination.higherEntry(index);
                    if (entry==null)
                        return "Таких объектов в файле нет";
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_destination.higherEntry((String) entry.getKey());
                    }
                    return str;
                case "weight":
                    entry = Map_weight.higherEntry(Double.parseDouble(index));
                    if (entry==null)
                        return "Таких объектов в файле нет";
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_weight.higherEntry((Double) entry.getKey());
                    }
                    return str;
                default:
                    throw new Exception("Неверная команда");
            }
        }
        public static String str_lower_index(String filename, String field, String index, String filename_ind) throws Exception
        {
            load_maps_from_file(filename_ind);
            switch (field)
            {
                case "number_of_flight":
                    Map.Entry entry = Map_number_of_flight.lowerEntry(Integer.parseInt(index));
                    if (entry==null)
                        return "Таких объектов в файле нет";
                    String str="";
                    while (entry !=null)
                    {
                        str+=ReadObjectFromPosition(filename,(long)entry.getValue())+"\n";
                        entry=Map_number_of_flight.lowerEntry((Integer) entry.getKey());
                    }
                    return str;
                case "date_of_flight":
                    SimpleDateFormat sp = new SimpleDateFormat("dd.mm.yyyy HH:mm");
                    entry = Map_date_of_flight.lowerEntry(sp.parse(index));
                    if (entry==null)
                        return "Таких объектов в файле нет";
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_date_of_flight.lowerEntry((Date) entry.getKey());
                    }
                    return str;
                case "destination":
                    entry = Map_destination.lowerEntry(index);
                    if (entry==null)
                        return "Таких объектов в файле нет";
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_destination.lowerEntry((String) entry.getKey());
                    }
                    return str;
                case "weight":
                    entry = Map_weight.lowerEntry(Double.parseDouble(index));
                    if (entry==null)
                        return "Таких объектов в файле нет";
                    str="";
                    while (entry !=null)
                    {
                        ArrayList<Long> mas = (ArrayList<Long>) entry.getValue();
                        for (Long l:mas)
                            str+=ReadObjectFromPosition(filename,l)+"\n";
                        entry=Map_weight.lowerEntry((Double) entry.getKey());
                    }
                    return str;
                default:
                    throw new Exception("Неверная команда");
            }
        }
        public static String delete_by_index(String filename, String field, String index, String filename_ind) throws Exception
        {
            load_maps_from_file(filename_ind);
            switch (field)
            {
                case "number_of_flight":
                    int ind = Integer.parseInt(index);
                    if (!Map_number_of_flight.containsKey(ind))
                        return "Такого объекта в файле нет, файл не изменён";
                    long position = Map_number_of_flight.get(ind);
                    reset_maps(filename_ind);
                    RandomAccessFile file = new RandomAccessFile(filename,"r");
                    while (file.getFilePointer()!=file.length())
                    {
                        if (file.getFilePointer()!=position)
                        {
                            int length = file.readInt();
                            byte [] mast = new byte[length];
                            file.read(mast);
                            AppendFile("tmp",fromByteArray(mast),filename_ind);
                        }
                        else
                            file.skipBytes(file.readInt());
                    }
                    file.close();
                    System.gc();
                    File f = new File(filename);
                    File ft = new File("tmp");
                    f.delete();
                    ft.renameTo(new File(filename));
                    return "Файл изменён";
                case "date_of_flight":
                    SimpleDateFormat sp = new SimpleDateFormat("dd.mm.yyyy HH:mm");
                    Date date = sp.parse(index);
                    if (!Map_date_of_flight.containsKey(date))
                        return "Такого объекта в файле нет, файл не изменён";
                    ArrayList<Long> mas = Map_date_of_flight.get(date);
                    reset_maps(filename_ind);
                    file = new RandomAccessFile(filename,"r");
                    while (file.getFilePointer()!=file.length())
                    {
                        if (!mas.contains(file.getFilePointer()))
                        {
                            int length = file.readInt();
                            byte [] mast = new byte[length];
                            file.read(mast);
                            AppendFile("tmp",fromByteArray(mast),filename_ind);
                        }
                        else
                            file.skipBytes(file.readInt());
                    }
                    file.close();
                    System.gc();
                    f = new File(filename);
                    ft = new File("tmp");
                    f.delete();
                    ft.renameTo(new File(filename));
                    return "Файл изменён";
                case "destination":
                    if (!Map_destination.containsKey(index))
                        return "Такого объекта в файле нет";
                    mas = Map_destination.get(index);
                    reset_maps(filename_ind);
                    file = new RandomAccessFile(filename,"r");
                    while (file.getFilePointer()!=file.length())
                    {
                        if (!mas.contains(file.getFilePointer()))
                        {
                            int length = file.readInt();
                            byte [] mast = new byte[length];
                            file.read(mast);
                            AppendFile("tmp",fromByteArray(mast),filename_ind);
                        }
                        else
                            file.skipBytes(file.readInt());
                    }
                    file.close();
                    System.gc();
                    f = new File(filename);
                    ft = new File("tmp");
                    f.delete();
                    ft.renameTo(new File(filename));
                    return "Файл изменён";
                case "weight":
                    Double we = Double.parseDouble(index);
                    if (!Map_weight.containsKey(we))
                        return "Такого объекта в файле нет";
                    mas = Map_weight.get(we);
                    reset_maps(filename_ind);
                    file = new RandomAccessFile(filename,"r");
                    while (file.getFilePointer()!=file.length())
                    {
                        if (!mas.contains(file.getFilePointer()))
                        {
                            int length = file.readInt();
                            byte [] mast = new byte[length];
                            file.read(mast);
                            AppendFile("tmp",fromByteArray(mast),filename_ind);
                        }
                        else
                            file.skipBytes(file.readInt());
                    }
                    file.close();
                    System.gc();
                    f = new File(filename);
                    ft = new File("tmp");
                    f.delete();
                    ft.renameTo(new File(filename));
                    return "Файл изменён";
                default:
                    throw new Exception("Неверная команда");
            }
        }
    }
}
