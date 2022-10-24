package org.eclipse.milo.examples.server.data;

import org.json.JSONObject;

import java.util.ArrayList;

public class Device {
    private int id;
    private String eui;
    private String name;
    private String defaultName;
    private String metadata;
    private String templateHash;
    private Boolean discovered;
    private Boolean online;
    private ArrayList<LogicalDevice> logicalDeviceArrayList;

    public Device(int id,
                  String eui,
                  String name,
                  String defaultName,
                  String metadata,
                  String templateHash,
                  Boolean discovered,
                  Boolean online,
                  ArrayList<LogicalDevice> logicalDeviceArrayList) {
        this.id = id;
        this.eui = eui;
        this.name = name;
        this.defaultName = defaultName;
        this.metadata = metadata;
        this.templateHash = templateHash;
        this.discovered = discovered;
        this.online = online;
        this.logicalDeviceArrayList = logicalDeviceArrayList;
    }

    public Device(JSONObject jsonObject, ArrayList<LogicalDevice> logicalDeviceArrayList) {
        this(jsonObject.getInt("id"),
                jsonObject.getString("eui"),
                jsonObject.getString("name"),
                jsonObject.getString("defaultName"),
                jsonObject.has("metadata") ? jsonObject.getString("metadata") : "",
                jsonObject.has("templateHash") ? jsonObject.getString("templateHash") : "",
                jsonObject.getBoolean("discovered"),
                jsonObject.getBoolean("online"),
                logicalDeviceArrayList);
    }

    @Override
    public String toString() {
        return "id:  " + id + "\n" +
                "eui: " + eui + "\n" +
                "name: " + name + "\n" +
                "defaultname: " + defaultName + "\n" +
                "metadata: " + metadata + "\n" +
                "templateHash: " + templateHash + "\n" +
                "discovered: " + discovered + "\n" +
                "online: " + online;
    }

    public int getId() {
        return id;
    }

    public String getEui() {
        return eui;
    }

    public String getName() {
        return name;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public String getMetadata() {
        return metadata;
    }

    public String getTemplateHash() {
        return templateHash;
    }

    public Boolean getDiscovered() {
        return discovered;
    }

    public Boolean getOnline() {
        return online;
    }

    public ArrayList<LogicalDevice> getLogicalDeviceArrayList() {
        return logicalDeviceArrayList;
    }
}
