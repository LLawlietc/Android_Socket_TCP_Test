package com.example.sockettcptest;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText show;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (EditText)findViewById(R.id.text);
        new Thread()
        {
            @Override
            public void run()
            {
                try{
                    Log.d(TAG,"======2======");
                    Socket socket = new Socket("10.0.2.15" , 30000);
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(socket.getInputStream())
                    );
                    String line = br.readLine();
                    show.setText("来自服务器的数据 " + line);

                    br.close();
                    socket.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
