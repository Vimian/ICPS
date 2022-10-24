package org.eclipse.milo.examples.server.data;

import org.json.JSONObject;

public class DatapointBoolean extends Datapoint{
    private boolean value;

    public DatapointBoolean(JSONObject jsonObject) {
        super(jsonObject);

        this.value = jsonObject.getBoolean("value");
    }

    public boolean isValue() {
        return value;
    }
}
