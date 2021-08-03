import java.io.*;

/**

 * 

 * Klasse <code>Tastatur</code> enthaelt 

 * statische Methoden zum Einlesen von

 * der Standardeingabe (Kommandozeile)

 */

public class Tastatur {


    /**

     * Wartet auf Eingabe von der Kommandozeile, 

     * liefert eine Instanz von <code>String</code>

     */

    public static String readString() {

        BufferedReader reader = new 

            BufferedReader(new InputStreamReader(System.in));

        System.out.flush();

        try {

            return reader.readLine();

        }

        catch (Exception e) { System.out.println(e); }

        return new String("");

    }


    /**

     * Warter auf Eingabe von der Kommandozeile, 

     * liefert einen Wert vom Grundtyp <code>char</code>

     */

    public static char readchar() {

        BufferedReader reader = new 

            BufferedReader(new InputStreamReader(System.in));

        String line="";

        System.out.flush();

        try {

            line=reader.readLine();

            if (line.length()>0) return line.charAt(0);

        }

        catch (Exception e) { System.out.println(e); }

        return ' ';

    }

    /**

     * Warter auf Eingabe von der Kommandozeile, 

     * liefert einen Wert vom Grundtyp <code>int</code>

     */

    public static int readint() {

        BufferedReader reader = new 

            BufferedReader(new InputStreamReader(System.in));

        String line="";

        System.out.flush();

        try { line=reader.readLine();  }

        catch (Exception e) { System.out.println(e); }

        try  {

            return (new Integer(line)).intValue();

        }

        catch (Exception e) { return 0; }

    }

    /**

     * Warter auf Eingabe von der Kommandozeile, 

     * liefert einen Wert vom Grundtyp <code>float</code>

     */

    public static float readfloat()  {

        BufferedReader reader = new 

            BufferedReader(new InputStreamReader(System.in));

        String line="";

        System.out.flush();

        try { line=reader.readLine(); }

        catch (Exception e) { System.out.println(e); }

        try {

            return (new Float(line)).floatValue();

        }

        catch (Exception e) { return 0; }

    }

    /**

     * Warter auf Eingabe von der Kommandozeile, 

     * liefert einen Wert vom Grundtyp <code>double</code>

     */

    public static double readdouble() {

        BufferedReader reader = new 

            BufferedReader(new InputStreamReader(System.in));

        String line="";

        System.out.flush();

        try { line=reader.readLine(); }

        catch (Exception e) { System.out.println(e); }

        try { return (new Double(line)).doubleValue(); }

        catch (Exception e) { return 0; }

    }

}
