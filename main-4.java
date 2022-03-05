
import java.io.*;

import java.lang.String;



public class main {

   
    public static String x = "";

    public static int i;

    
    public static void main(String[] args) {

        
        String inFile = "input.txt";

        String read;

        try {

            FileReader fr = new FileReader(inFile);

            BufferedReader br = new BufferedReader(fr);

            while ((read = br.readLine()) != null) {

                x = read;

                i = 0;


                if (GR_A()) {

                    System.out.println("The string \"" + read + "\" is in the language.");

                } else {

                    System.out.println("The string \"" + read + "\" is not in the language.");

                }

            }

            br.close();

        } catch (IOException ex) {

            System.out.println("BING BONG!!");

        }

    }

    private static boolean GR_A() {

        if (GR_I()) {

            if (i < x.length() && (x.charAt(i) == '=')) {

                ++i;

                if (GR_E()) {

                    return true;

                }

            }

        } else if (GR_E()) {

            return true;

        }

        return false;

    }

    private static boolean GR_E() {

        if (GR_P()) {

            if (GR_O()) {

                if (GR_P()) {

                    return true;

                }

            }

        } else if (GR_P()) {

            return true;

        }

        return false;

    }

    private static boolean GR_O() {

        if (i < x.length() && (x.charAt(i) == '+')) {

            ++i;

            return true;

        } else if (i < x.length() && (x.charAt(i) == '-')) {

            ++i;

            return true;

        } else if (i < x.length() && (x.charAt(i) == '/')) {

            ++i;

            return true;

        } else if (i < x.length() && (x.charAt(i) == '*')) {

            ++i;

            if (i < x.length() && (x.charAt(i) == '*')) {

                ++i;

                return true;

            }

            return true;

        }

        return false;

    }

    private static boolean GR_P() {

        if (GR_I()) {

            return true;

        } else if (GR_L()) {

            return true;

        } else if (GR_U() && GR_I()) {

            return true;

        } else if (GR_U() && GR_L()) {

            return true;

        } else if (i < x.length() && (x.charAt(i) == '(')) {

            ++i;

            if (GR_E()) {

                if (i < x.length() && (x.charAt(i) == ')')) {

                    ++i;

                    return true;

                }

            }

        }

        return false;

    }

    private static boolean GR_U() {

        if (i < x.length() && (x.charAt(i) == '+' || x.charAt(i) == '-' || x.charAt(i)

                ==
                '!')) {

            ++i;

            return true;

        }

        return false;

    }

    private static boolean GR_I() {

        if (GR_C()) {

            return true;

        } else if (GR_C() && GR_I()) {

            return true;

        }

        return false;

    }

    private static boolean GR_C() {

        if (i < x.length() && (x.charAt(i) >= 'a' && x.charAt(i) <= 'z')) {

            ++i;

            return true;

        }

        return false;

    }

    private static boolean GR_L() {

        if (GR_D()) {

            return true;

        } else if (GR_D() && GR_L()) {

            return true;

        }

        return false;

    }

    private static boolean GR_D() {

        if (i < x.length() && (x.charAt(i) >= '0' && x.charAt(i) <= '9')) {

            ++i;

            return true;

        }

        return false;

    }

}
