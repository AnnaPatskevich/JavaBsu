import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Angle implements Comparable<Angle>, Iterator<Integer> {
    private int index = 0;
    private int degree = 0;
    private int minute = 0;
    private int sortBy = 0;

    private static int sgn(int num) {
        if(num == 0) return 0;
        return num / Math.abs(num);
    }

    private int toMinute() {
        return degree * 60 + sgn(degree) * minute;
    }

    private int getDegree(int minutes) {
        return minutes / 60;
    }

    private int getMinute(int minutes) {
        return Math.abs(minutes - getDegree(minutes) * 60);
    }

    public Angle() {
    }

    public Angle(int degree, int minute) {
        assert(minute >= 0 && minute < 60);
        this.degree = degree;
        this.minute = minute;
    }

    public Angle(String str) {
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher m = pattern.matcher(str);
        if(m.find()) {
            degree = Integer.parseInt(m.group());
        }
        if(m.find()) {
            assert(Integer.parseInt(m.group()) >= 0 && Integer.parseInt(m.group()) < 60);
            minute = Integer.parseInt(m.group());
        }
    }

    public int getSortBy() {
        return sortBy;
    }

    public void setSortBy(int sortBy) throws IllegalArgumentException {
        if(sortBy > 1) throw new IllegalArgumentException("Wrong index");
        this.sortBy = sortBy;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        assert(minute >= 0 && minute < 60);
        this.minute = minute;
    }

    public void toDefaultRange() {

        if(degree < 0) {
            degree = 360 + (degree - 360 * (degree / 360));
        }
        if(this.degree >= 0) {
            degree = degree - 360 * (degree / 360);
        }
    }

    public void add(Angle a) {
        int res = toMinute() + a.toMinute();
        degree = getDegree(res);
        minute = getMinute(res);
    }

    public void sub(Angle a) {
        int res = toMinute() - a.toMinute();
        degree = getDegree(res);
        minute = getMinute(res);
    }

    public void mul(Angle a) {
        int res = toMinute() * a.toMinute();
        degree = getDegree(res);
        minute = getMinute(res);
    }

    public void div(Angle a) {
        int res = toMinute() / a.toMinute();
        degree = getDegree(res);
        minute = getMinute(res);
    }

    public double toRad() {
        return (toMinute() * Math.PI) / 10800;
    }

    public boolean hasNext() {
        if(index > 1) return false;
        return true;
    }

    public String toString() {
        return degree + "�" + minute + "'";
    }

    public Integer next() throws NoSuchElementException {
        if(index == 0) {
            ++index;
            return degree;
        }

        if(index == 1) {
            ++index;
            return minute;
        }
        throw new NoSuchElementException("No such element");
    }

    public int compareTo(Angle arg) throws IllegalArgumentException {
        if(sortBy == 0) {
            return Integer.compare(degree, arg.degree);
        }
        if(sortBy == 1) {
            return Integer.compare(minute, arg.minute);
        }
        throw new IllegalArgumentException("Wrong index");
    }

}