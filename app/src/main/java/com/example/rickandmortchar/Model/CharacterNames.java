
package com.example.rickandmortchar.Model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

//import javax.annotation.Generated;

//@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CharacterNames {

    @SerializedName("info")
    private Info mInfo;

    @SerializedName("results")
    private List<Result> mResults;

    public Info getInfo() {
        return mInfo;
    }

    public void setInfo(Info info) {
        mInfo = info;
    }

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }

}
