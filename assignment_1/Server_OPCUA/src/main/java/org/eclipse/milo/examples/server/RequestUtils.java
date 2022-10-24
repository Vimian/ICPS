package org.eclipse.milo.examples.server;

import org.eclipse.milo.examples.server.data.Datapoint;
import org.eclipse.milo.examples.server.data.Device;
import org.eclipse.milo.examples.server.data.LogicalDevice;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class RequestUtils {
    private static String base_url = "http://gw-2500.sandbox.tek.sdu.dk/ssapi";

    public static void main(String[] args) {
        try {
            ArrayList<Device> deviceArrayList = getDevices();
            System.out.println(deviceArrayList.size());
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public static String getRequest(URL url) throws Exception {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        con.setUseCaches(false);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();

        //printing result from response
        //System.out.println(response.toString());
        return response.toString();
    }

    public static ArrayList<Device> getDevices() throws Exception {
        System.out.println("Requesting devices! base_url: " + base_url);
        URL url = new URL(base_url + "/zb/dev");
        String response = getRequest(url);

        JSONArray jsonArray = new JSONArray(response);
        ArrayList<Device> deviceArrayList = new ArrayList<Device>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            ArrayList<LogicalDevice> logicalDeviceArrayList = getLogicalDevices(jsonObject.getInt("id"));

            Device device = new Device(jsonObject, logicalDeviceArrayList);
            deviceArrayList.add(device);
        }

        return deviceArrayList;
    }

    public static ArrayList<Datapoint> getAllDatapoint(int deviceId, String logicalDeviceKey) throws Exception {
        System.out.println("Requesting datapoints! deviceId: " + deviceId + " | logicalDeviceKey: " + logicalDeviceKey);
        URL url = new URL(base_url +
                "/zb/dev/" +
                deviceId +
                "/ldev/" +
                logicalDeviceKey +
                "/data");
        String response = getRequest(url);
        JSONArray jsonArray = new JSONArray(response);

        ArrayList<Datapoint> datapointArrayList = new ArrayList<Datapoint>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            datapointArrayList.add(new Datapoint(jsonObject));
        }

        return datapointArrayList;
    }

    public static LogicalDevice getLogicalDevice(int deviceId, JSONObject jsonObject) throws Exception {
        System.out.println("Creating logical device! deviceId: " + deviceId + " | key: "+ jsonObject.getString("key"));
        ArrayList<Datapoint> datapointArrayList = getAllDatapoint(deviceId, jsonObject.getString("key"));

        LogicalDevice logicalDevice = new LogicalDevice(jsonObject.getString("name"),
                jsonObject.getString("key"),
                datapointArrayList);

        return logicalDevice;
    }

    public static ArrayList<LogicalDevice> getLogicalDevices(int id) throws Exception {
        System.out.println("Requesting logical devices! deviceId: " + id);
        URL url = new URL(base_url + "/zb/dev/" + id + "/ldev");

        String response = "[]";
        try {
             response = getRequest(url);
        } catch (Exception err) {

        }

        JSONArray jsonArray = new JSONArray(response);
        ArrayList<LogicalDevice> logicalDeviceArrayList = new ArrayList<LogicalDevice>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            LogicalDevice logicalDevice = getLogicalDevice(id, jsonObject);

            logicalDeviceArrayList.add(logicalDevice);
        }

        return logicalDeviceArrayList;
    }
}
