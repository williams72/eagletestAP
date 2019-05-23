package com.dilatoit.eagletest.handler;

import javax.websocket.Session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Salt on 2017/9/12.
 */
public class TailLogThread extends Thread {
    private BufferedReader reader;
    private Session session;

    TailLogThread(InputStream in, Session session){
        this.reader = new BufferedReader(new InputStreamReader(in));
        this.session = session;
    }

    @Override
    public void run(){
        String line;
        try{
            while((line = reader.readLine()) != null){
                session.getBasicRemote().sendText(line + "<br/>");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
