package com.example.Retrofitints;
import com.example.Retrofitints.ITM;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class PageInfo {
       
        public int totalResults;
    
        

        public PageInfo(int totalResults) {
            this.totalResults = totalResults;
            
        }

        public int getTotalResults() {
            return this.totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        
}