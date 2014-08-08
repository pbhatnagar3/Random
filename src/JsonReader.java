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
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {

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
//            JSONObject json = new JSONObject(jsonText);
            return jsonText;
        } finally {
            is.close();
        }
    }
    

    public static void main(String[] args) throws IOException, JSONException {
    	//jusst change the path of the file that you are reading and you will be good to go
    	Scanner scan = new Scanner(new File("information.txt"));
    	PrintWriter writer = new PrintWriter("one-off script.txt", "UTF-8");
//    	writer.println("The first line");
//    	writer.println("The second line");
    	int count = 0;
    	int flag = 0;
    	ArrayList<String> keepingTrack = new ArrayList<String>(){
    		@Override
    		public String toString(){
    			String output = "";
    			for(String s : this){
    				output = output + s + "\t;\t";
    			}
    			return output;
    		}
    		
    	};
    	while(scan.hasNextLine()){
    	
    	String input_line = scan.nextLine();
//    	String[] temp = input_line.split(";");
    	String dmaDiscription = (input_line.split(";"))[1];
    	String dmaCode = (input_line.split(";"))[0];
    	 
    	dmaDiscription = dmaDiscription.replace(' ', '+');
    	if(dmaDiscription.contains("(")){
    		int sindx = dmaDiscription.indexOf('(');
    		int eindx = dmaDiscription.indexOf(')');
    		dmaDiscription = dmaDiscription.substring(0, sindx) + dmaDiscription.substring(eindx+1, dmaDiscription.length());
    	}
//    	String temp1 = temp.replace("(", )
    	
    	String input = "http://nominatim.openstreetmap.org/search?q=" + dmaDiscription+"&format=json&addressdetails=1";
        String jsonString = readStringFromUrl(input);
        if (jsonString.length()==2){
        	System.out.println("line " + ++count + "skipped");
        	flag++;
        	keepingTrack.add(input_line);
        	continue;
        }

        jsonString = jsonString.substring(1, jsonString.length()-1);
        JSONObject json = new JSONObject(jsonString);
        String latitude = json.getString("lat");
        String longitude = json.getString("lon");
        String region = "";
        if(Float.parseFloat(latitude) > 39.81 )
        	region = region + "NORTH";
        else
        	region = region + "SOUTH";
        if(Float.parseFloat(longitude)> 98.55)
        	region += "WEST";
        else
        	region += "EAST";
//        String lat_long = latitude + " " + longitude; 
//       String toWrite = "table.put(" + "\"" + input_line + "\"" + "," +  "\""+ latitude + "; " + longitude +  "\"" +");"; 
        StringBuffer toWrite = new StringBuffer("DmaLocationModel.createInstance(");
        toWrite.append( dmaCode);
        toWrite.append("," + region);
        toWrite.append("," + latitude);
        toWrite.append("," + longitude + ");");
//        , region, latitude, longitude)
        writer.println(toWrite);
        System.out.println(++count);
//        break;
//        jsonString = "{" + jsonString + "}";
//        JSONArray json = new JSONArray(jsonString);
//        Object j = json.get(0);
//        System.out.println(json.toString());
//        System.out.println(json.get("id"));
    	}
    	writer.close();
 
		System.out.println("the number skipped : " + flag);
    	System.out.println("here is a list of all the skipped places");
    	System.out.println(keepingTrack.toString());
    }
}