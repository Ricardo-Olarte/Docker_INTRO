package co.edu.escuelaing.sparkdockerdemolive;

import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("sin", (req,res) -> sin("45"));
        get("cos", (req,res) -> cos("45"));
        get("palindromo", (req,res) -> palindromo("amolapaloma"));
        get("magnitud", (req,res) -> magnitud("2", "3"));

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String sin(String s){
        return String.valueOf(Math.sin(Double.parseDouble(s)));
    }

    private static String cos(String s){
        return String.valueOf(Math.cos(Double.parseDouble(s)));
    }

    private static String palindromo(String string){
        String c = "";
        for(int i=(string.length()-1);i>=0;--i){
            c += string.charAt(i);
        }
        return String.valueOf(string.equals(c));
    }

    private static String magnitud(String s1, String s2){
        Double a = Double.parseDouble(s1);
        Double b = Double.parseDouble(s2);
        return String.valueOf(Math.sqrt(Math.pow(b,2) + Math.pow(a,2)));
    }

}