package org.eclipse.milo.examples.server.data;

public class Path {
    private String deviceId;
    private String logicalDeviceKey;
    private String datapointKey;

    public Path(String deviceId, String logicalDeviceKey, String datapointKey) {
        this.deviceId = deviceId;
        this.logicalDeviceKey = logicalDeviceKey;
        this.datapointKey = datapointKey;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getLogicalDeviceKey() {
        return logicalDeviceKey;
    }

    public String getDatapointKey() {
        return datapointKey;
    }
}
