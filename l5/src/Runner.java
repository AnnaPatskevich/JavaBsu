import java.util.ArrayList;

public class Runner {

    private static void sortAndPrint(ArrayList<Angle> list, int sortBy) {
        for(Angle i : list)
            i.setSortBy(sortBy);
        list.sort(null);
        for(Angle i : list)
            System.out.println(i.toString());
    }

    private static void printRad(ArrayList<Angle> list) {
        for(Angle i : list)
            System.out.println(i.toRad());
    }

    public static void main(String[] args) {
        ArrayList<Angle> angles = new ArrayList<Angle>();
        angles.add(new Angle(90, 40));
        angles.add(new Angle(180, 0));
        angles.add(new Angle("10,30"));
        angles.add(new Angle(-5, 5));
        angles.add(new Angle(-145, 35));

        angles.get(0).add(angles.get(1));
        angles.get(1).sub(angles.get(2));
        angles.get(2).mul(angles.get(3));
        angles.get(3).div(angles.get(4));

        for(Angle i : angles)
            i.toDefaultRange();

        System.out.println("Sort by degrees:");
        sortAndPrint(angles, 0);
        System.out.println("Sort by minutes:");
        sortAndPrint(angles, 1);
        System.out.println("Print in radians:");
        printRad(angles);

        System.out.println("Iterator print:");
        while(angles.get(1).hasNext())
            System.out.println(angles.get(1).next());

    }
}


