package com.example.sockettcpservicetest;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    new Thread(){
    @Override
    public void run(){
        try {
            ServerSocket ss = new ServerSocket(30000);
            while(true){
                Log.d(TAG,"======1======");
                Socket s = ss.accept();
                OutputStream os = s.getOutputStream();
                os.write("啊哈哈，成功了".getBytes("utf-8"));
                os.close();
                s.close();
            }
        }catch(Exception e){
            e.printStackTrace();
            }
        }
    }.start();

    }

}
