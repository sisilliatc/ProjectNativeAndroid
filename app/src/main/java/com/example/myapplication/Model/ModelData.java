package com.example.myapplication.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelData {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("value")
    @Expose
    private List<ModelData> value;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("joke")
    @Expose
    private String joke;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ModelData> getValue() {
        return value;
    }

    public void setValue(List<ModelData> value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
