package com.example.myapplication2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2019/5/14.
 */

public class Database {
    private String fileName = "";
    static Map<String, String> core = new HashMap<String, String>();
    public Database(String name){
        fileName = name;
        assert name != null;
        init();
    }

    public void init(){

    }

    public boolean checkUser(String name, String pwd){
        if(Data.databaseLocked) throw new Error("Database in lock");
        String result = core.get(name);
        if(result == null) throw new Error("Username Doesn't ...");
        return result.equals(pwd);
    }



}
