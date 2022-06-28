package com.piersonapps.test;

public class TestList {



    private String name;

    private String column;

    private String myKey;

    TestList(String name, String column){
        this.name = name;
        this.column = column;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getMyKey() {
        return myKey;
    }

    public void setMyKey(String myKey) {
        this.myKey = myKey;
    }
}
