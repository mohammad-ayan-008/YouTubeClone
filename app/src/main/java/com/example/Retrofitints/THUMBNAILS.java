package com.example.Retrofitints;
import com.example.Retrofitints.Defs;
import com.google.gson.annotations.SerializedName;

public class THUMBNAILS {
                @SerializedName("high")
                public Defs efault;

                public THUMBNAILS(Defs efault) {
                     this.efault = efault;
                }

                public Defs getEfault() {
                    return this.efault;
                }

                public void setEfault(Defs efault) {
                    this.efault = efault;
                }
            }