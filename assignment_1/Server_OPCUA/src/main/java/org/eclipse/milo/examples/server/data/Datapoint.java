package org.eclipse.milo.examples.server.data;

import org.json.JSONObject;

public class Datapoint {
    private String key;
    private String name;
    private String type;
    private String unit;
    private String access;
    private String lastUpdated;
    private Object value;

    public Datapoint(String key, String name, String type, String unit, String access, String lastUpdated, Object value) {
        this.key = key;
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.access = access;
        this.lastUpdated = lastUpdated;
        this.value = value;
    }

    public Datapoint(JSONObject jsonObject) {
        this(jsonObject.getString("key"),
                jsonObject.getString("name"),
                jsonObject.getString("type"),
                jsonObject.has("unit") ? jsonObject.getString("unit") : "",
                jsonObject.getString("access"),
                jsonObject.has("lastUpdated") ? jsonObject.getString("lastUpdated") : "",
                jsonObject.has("value") ? jsonObject.get("value") : null);
    }

    @Override
    public String toString() {
        return "key:  " + key + "\n" +
                "name: " + name + "\n" +
                "type: " + type + "\n" +
                "unit: " + unit + "\n" +
                "access: " + access + "\n" +
                "lastUpdated: " + lastUpdated + "\n" +
                "value: " + value;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public String getAccess() {
        return access;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
