package co.edu.escuelaing.sparkdockerdemolive;

import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("/sin", (req,res) -> {
            String string = req.queryString();
            return buildGET(req, string);
        });
        get("/cos", (req,res) -> {
            String string = req.queryString();
            return buildGET(req, string);
        });
        get("/pal", (req,res) -> {
            String string = req.queryString();
            return buildGET(req, string);
        });
        get("/mag", (req,res) -> {
            String string = req.queryString();
            return buildGET(req, string);
        });

    }

    private static String buildGET(Request req, String string){

        String fuction = req.pathInfo();
        string.replace("=","");

        if(string.isEmpty()){return "Not Valid Command";}


        //System.out.println("EL REQ ES: " + req);
        //System.out.println("EL FUCTION ES: " + fuction);
        //System.out.println("EL VAR: " + string);

        switch (fuction){
            case "/sin":
                return (string);
            case "/cos":
                return cos(string);
            case "/pal":
                return pal(string);
            case "/mag":
                String[] temp = string.split(" ");
                return mag(temp[0], temp[1]);
        }

        return "Not Valid Command";
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String sin(String s){
        try {
            return String.valueOf(Math.sin(Double.parseDouble(s)));
        }catch (NumberFormatException e){
            return "Invalid Number";
        }
    }

    private static String cos(String s){
        try{
            return String.valueOf(Math.cos(Double.parseDouble(s)));
        }catch (NumberFormatException e){
            return "Invalid Number";
        }
    }

    private static String pal(String string){
        String c = "";
        for(int i=(string.length()-1);i>=0;--i){
            c += string.charAt(i);
        }
        return String.valueOf(string.equals(c));
    }

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