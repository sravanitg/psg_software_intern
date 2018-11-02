
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author psg
 */
public class sravpsg {

    /**
     * @param args the command line arguments
     */
    public static boolean check_if_num(String s) {
        boolean res = true;
        try {
            int num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            res = false;
        }
        return res;
    }

    public static String obfuscate(String input, Integer charOffset, Map<String, String> map) {
        String out = new String();
        boolean num = check_if_num(input);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == input) {
                out = entry.getValue();
            } else if (num == true) {
                int in = Integer.parseInt(input);
                int res = in * charOffset;
                out = String.valueOf(res);
            } else {
                String res = new String();
                for (int i = 0; i < input.length(); i++) {
                    out += (char) (input.charAt(i) + charOffset);
                }

            }
        }
        return out;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Map<String, String> map = new TreeMap<String, String>();
        map.put("10", "srav");
        map.put("prav", "ngg");
        map.put("sks", "ngs");
        for (String name : map.keySet()) {
            System.out.println("key: " + name);
        }
        String in = "prav";
        int charoffset = 2;
        /* for (Map.Entry<String,String> entry : map.entrySet())  
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue());*/
        String output = obfuscate(in, charoffset, map);
        System.out.println("The output : " + output);
    }

}
