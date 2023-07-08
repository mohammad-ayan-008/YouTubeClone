package com.example.Retrofitints;

import com.example.Retrofitints.ITM;
import com.example.Retrofitints.PageInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Model {

    public PageInfo pageInfo;
    public List<ITM> items;

    public Model(PageInfo pageInfo, List<ITM> items) {
        this.pageInfo = pageInfo;
        this.items = items;
    }

    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<ITM> getItems() {
        return this.items;
    }

    public void setItems(List<ITM> items) {
        this.items = items;
    }
}
