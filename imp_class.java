
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author psg
 */
interface RainfallCalculator {

    /**
     * Captures rain occured in the given region
     *
     * @param measure amount of rainfall in centi meters
     * @param rainDate date on which rainfall measure is recorded
     * @param pincode identifies the location of rainfall where this was
     * recorded
     */
    void captureRain(Float measure, Date rainDate, String pincode);

    /**
     * Region which has gt maximum rainfall in the given . If more than 1 region
     * got the same maximum, then return whichever has got the rain recently. If
     * both have got the rain on the same date, return whichever was captured
     * first
     */
    String getRegionWithMaxRainfall(Date fromDate, Date toDate);

    /**
     * Similar to above, but which region has got minimum rainfall
     */
    String getRegionWithMinRainfall(Date fromDate, Date toDate);

    /**
     * Compute the average rainfall in the given date range and return the
     * average
     */
    float getAverageRainfall(Date fromDate, Date toDate);
}

public class imp_class implements RainfallCalculator {

    /* considering a linked list containing 3 data parts date,measure and region*/
    public void captureRain(Float measure, Date rainDate, String pincode) {
        list.head = new Node(measure, rainDate, pincode);
    }

    /**
     * Region which has gt maximum rainfall in the given . If more than 1 region
     * got the same maximum, then return whichever has got the rain recently. If
     * both have got the rain on the same date, return whichever was captured
     * first
     */
    public String getRegionWithMaxRainfall(Date fromDate, Date toDate) {
        int max = 0;
        String res = new String();
        Node temp = head;
        while (head.next != null) {
            if (head.date >= fromDate && head.date <= toDate) {
                if (head.measure > max) {
                    max = head.measure;
                    res = head.region;
                }
            }
            head = head.next;
        }
        head = temp;//resuming head value
        return res;
    }

    /**
     * Similar to above, but which region has got minimum rainfall
     */
    public String getRegionWithMinRainfall(Date fromDate, Date toDate) {
        int min = 9999;
        String res = new String();
        Node temp = head;
        while (head.next != null) {
            if (head.date >= fromDate && head.date <= toDate) {
                if (head.measure < min) {
                    min = head.measure;
                    res = head.region;
                }
            }
            head = head.next;
        }
        head = temp;//resuming head value
        return res;
    }

    /**
     * Compute the average rainfall in the given date range and return the
     * average
     */
    public float getAverageRainfall(Date fromDate, Date toDate) {
        int sum = 0, count = 0;
        Node temp = head;
        while (head.next != null) {
            if (head.date >= fromDate && head.date <= toDate) {
                sum = sum + head.measure;
                count++;
            }
        }

        float avg = sum / count;
        return avg;
    }

    public static void main(String args[]) {

    }
}
