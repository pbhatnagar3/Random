
/**
 * Created by pbhatnagar on 6/23/14.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import net.sf.json.JSONString;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SongKick {

    private static String url = "http://api.songkick.com/api/3.0/";
    private static String APIkey = "apikey=PwBAEZKTxnU9Yi96";
    public enum SendCommand{
        VENUE_SEARCH("search/venues.json?query="),
        VENUE_INFO("venues/"),
        JSON(".json");


        private String command;
        SendCommand(String command){
            this.command = command;
        }

        public String getValue(){
            return command;
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static String readStringFromUrl(String url) throws IOException, JSONException{
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return jsonText;
        } finally {
            is.close();
        }
    }

    public static String url_VenueInfo(String vid){
        String output = url + SendCommand.VENUE_INFO.getValue() + vid + SendCommand.JSON.getValue() + "?" + APIkey;
        return output;
    }

    public static String url_getVenues(String place){
        String output = url + SendCommand.VENUE_SEARCH.getValue() + place + "&" + APIkey ;
        return output;
    }

    public static JSONObject getVenueInfoViaID(String vid){
        String input = "";
        input = url_VenueInfo(vid);
        String jsonString = "";
        try {
            jsonString = readStringFromUrl(input);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject json = null;
        try {
            json = new JSONObject(jsonString);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;
    }

    public static JSONObject getVenuesViaCity(String place) throws JSONException{
        String input = url_getVenues(place);

        String jsonString = null;
        try {
            jsonString = readStringFromUrl(input);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject json = null;
        json = new JSONObject(jsonString);
        return json;
    }

    public static JSONObject getVenuesViaLatLng(String latLng){

        String[] data = latLng.split(";");
        String lat = data[0].replace(" ", "");
        String lng =  data[1].replace(" ", "");
        String input = url_getVenuesViaLatLng(lat, lng);
        String jsonString = null;
        try {
            jsonString = readStringFromUrl(input);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject json_result = null;
        try {
            json_result = new JSONObject(jsonString);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json_result;
    }

    private static String url_getVenuesViaLatLng(String lat, String lng) {
        // TODO Auto-generated method stub

        return url + "search/locations.json?location=geo:" + lat + "," + lng + "&" + APIkey;
    }

//    public static void main(String[] args) throws IOException, JSONException {
////tests for all the methods
//        JSONObject o1 = getVenuesViaCity("Oakland");
//
//    JSONObject o2 = getVenueInfoViaID("17522");
//        JSONObject o3 = getVenuesViaLatLng("31.158522; -85.426966299239");
////		System.out.println(o1.getString("resultsPage").toString());
////		System.out.println(o2.getString("resultsPage").toString());
//        JSONObject o4 = o1.getJSONObject("resultsPage");
//        System.out.println();
//    }

}
