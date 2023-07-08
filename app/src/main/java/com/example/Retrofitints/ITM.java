package com.example.Retrofitints;

public class ITM {

    public String etag;
    public ID id;
    public snpts snippet;

    public ITM(String etag, ID id, snpts snippet) {
        this.etag = etag;
        this.id = id;
        this.snippet = snippet;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public ID getId() {
        return this.id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public snpts getSnippet() {
        return this.snippet;
    }

    public void setSnippet(snpts snippet) {
        this.snippet = snippet;
    }
}
