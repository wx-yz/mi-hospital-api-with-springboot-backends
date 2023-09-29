package com.pinevalley.PineValleyServices;

public class Doctor {
    private String name;
    private String time;

    Doctor(String name, String time, String hospital) {
        this.name = name;
        this.time = time;
        this.hospital = hospital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    private String hospital;

    @Override
    public String toString()  {
        return this.name + " (" + this.hospital + ") : " + "Available at - " + this.time;
    }
}
