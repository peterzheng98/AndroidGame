package com.example.myapplication2;

/**
 * Created by dell on 2019/5/14.
 */


import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class DatabaseCore {
    private Map<String, String> core = new HashMap<>();
    private String filename = "";

    public DatabaseCore() {

    }

    public DatabaseCore(String name) {
        this.filename = name;
        Log.i("DatabaseCore", "Database File Name:" + name);
        init();
        Log.i("DatabaseCore", "Load ended");
    }

    private void init() {
        // load file as csv file
        File csv = new File(filename); // CSV文件路径
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            Log.i("DatabaseCore", e.getMessage());
        }
        String line = "";
        String everyLine = "";
        List<String> allString = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                everyLine = line;
                Log.i("DatabaseCore[Init]", everyLine);
                allString.add(everyLine);
            }
            Log.i("DatabaseCore[Init]", "csv表格中所有行数：" + allString.size());
        } catch (IOException e) {
            Log.i("DatabaseCore", e.getMessage());
        }
        try {
            br.close();
        } catch (IOException e) {
            Log.i("DatabaseCore", e.getMessage());
        }
        // Set data in K,V map
        int cnt = 0;
        for (String i : allString) {
            int idx = i.indexOf(",");
            String key = i.substring(0, idx);
            String value = i.substring(idx + 1, i.length());
            core.put(key, value);
            cnt = cnt + 1;
            Log.i("DatabaseCore", "Total Record:" + cnt);
        }
    }

    public boolean insert(String Key, String Value) {
        // Check whether there is duplicated data!
        String result = core.get(Key);
        if (result != null) {
            Log.i("Database:insert", "Duplicated Data for Key:" + Key);
            return false;
        }
        core.put(Key, Value);
        return true;
    }

    public boolean modify(String key, String value) {
        // Check whether there exists the data
        String result = core.get(key);
        if (result == null) {
            Log.i("Database:Modify", "No Data for Key:" + key);
            return false;
        }
        core.remove(key);
        core.put(key, value);
        return true;
    }

    public boolean erase(String key) {
        String result = core.get(key);
        if (result == null) {
            Log.i("Database:Erase", "No Data for Key:" + key);
            return false;
        }
        core.remove(key);
        return true;
    }

    public String query(String Key) {
        // Check whether there is duplicated data!
        String result = core.get(Key);
        if (result == null) {
            Log.i("Database:query", "No Data for Key:" + Key);
            return "";
        }
        return result;
    }

    public void leave(String filename) {
        try{
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "GBK"));
            for (String key : core.keySet()) {
                String result = core.get(key);
                String line = key + "," + result + "\n";
                out.write(line);
            }
            out.close();
            Log.i("DatabaseCore", "Dump End");
        } catch (FileNotFoundException e){
            Log.i("DatabaseCore", e.getMessage());
        } catch (IOException e){
            Log.i("DatabaseCore", e.getMessage());
        }

    }
}
