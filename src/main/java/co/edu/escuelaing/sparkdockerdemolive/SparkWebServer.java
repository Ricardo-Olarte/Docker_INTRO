package co.edu.escuelaing.sparkdockerdemolive;

import spark.Request;
import static spark.Spark.*;

/**
 * Use spark
 * @author RiCHi
 */
public class SparkWebServer {

    /**
     * main, run web server in PORT 4567
     * @param args
     */
    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("/sin", (req,res) -> {
            String string = req.queryParams("value");
            return buildGET(req, string);
        });
        get("/cos", (req,res) -> {
            String string = req.queryParams("value");
            return buildGET(req, string);
        });
        get("/pal", (req,res) -> {
            String string = req.queryParams("value");
            return buildGET(req, string);
        });
        get("/mag", (req,res) -> {
            String string = req.queryParams("value");
            return buildGET(req, string);
        });

    }

    /**
     * Identify  the var in the URL
     * @param req
     * @param string
     * @return String, it's the result about other fuctions
     */
    private static String buildGET(Request req, String string){

        if(string.isEmpty()){return "Not Valid Command";}

        String fuction = req.pathInfo();
        string.replace(" ","");

        switch (fuction){
            case "/sin":
                return sin(string);
            case "/cos":
                return cos(string);
            case "/pal":
                return pal(string);
            case "/mag":
                String[] temp = string.split(",");
                return mag(temp[0], temp[1]);
        }

        return "Not Valid Command";
    }

    /**
     * @return int, it's a port
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    /**
     * Sin fuction
     * @param s
     * @return int cast to String
     */
    private static String sin(String s){
        try {
            return String.valueOf(Math.sin(Double.parseDouble(s)));
        }catch (NumberFormatException e){
            return "Invalid Number";
        }
    }

    /**
     * Cos fuction
     * @param s
     * @return int cast to String
     */
    private static String cos(String s){
        try{
            return String.valueOf(Math.cos(Double.parseDouble(s)));
        }catch (NumberFormatException e){
            return "Invalid Number";
        }
    }

    /**
     * Identify if the string it's palindrome
     * @param string
     * @return boolean cast to String
     */
    private static String pal(String string){
        String c = "";
        for(int i=(string.length()-1);i>=0;--i){
            c += string.charAt(i);
        }
        return String.valueOf(string.equals(c));
    }

    /**
     * Fuction the distance between two points
     * @param s1
     * @param s2
     * @return int cast to String
     */
    private static String mag(String s1, String s2){
        try {
            Double a = Double.parseDouble(s1);
            Double b = Double.parseDouble(s2);
            return String.valueOf(Math.sqrt(Math.pow(b, 2) + Math.pow(a, 2)));
        }catch (NumberFormatException e){
            return "Invalid Number(s)";
        }
    }

}
