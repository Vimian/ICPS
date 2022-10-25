package org.eclipse.milo.examples.server.data;

import java.util.ArrayList;

public class LogicalDevice {
    private String name;
    private String key;
    private ArrayList<Datapoint> datapointArrayList;

    public LogicalDevice(String name, String key, ArrayList<Datapoint> datapointArrayList) {
        this.name = name;
        this.key = key;
        this.datapointArrayList = datapointArrayList;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "key: " + key;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public ArrayList<Datapoint> getDatapointArrayList() {
        return datapointArrayList;
    }
}
