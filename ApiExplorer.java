package apiTest;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
    	String serviceURL = "http://openapi.q-net.or.kr/api/service/rest/InquiryListNationalQualifcationSVC/getList";
    	String serviceKey = "ldY0vGslgEruKo%2FDYPpevsI8akCSFXkXlIRlGWyasEPBxKmb%2BijZu%2BPnB%2BnQGbNb4uymFpExVcf%2BP8zYb90LlQ%3D%3D";
        StringBuilder urlBuilder = new StringBuilder();
        // Service URL
        urlBuilder.append("http://openapi.q-net.or.kr/api/service/rest/InquiryListNationalQualifcationSVC/getList");
        urlBuilder.append("?ServiceKey=");
        // License code
        urlBuilder.append("&jmfldnm=0752");
        // AcceceKey
        urlBuilder.append("&serviceKey=ldY0vGslgEruKo%2FDYPpevsI8akCSFXkXlIRlGWyasEPBxKmb%2BijZu%2BPnB%2BnQGbNb4uymFpExVcf%2BP8zYb90LlQ%3D%3D");
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        System.out.println("")
    }
}