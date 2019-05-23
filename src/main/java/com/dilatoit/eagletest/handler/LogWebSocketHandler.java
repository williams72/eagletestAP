package com.dilatoit.eagletest.handler;

import com.dilatoit.eagletest.util.SysConvert;
import org.springframework.context.annotation.Scope;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Salt on 2017/9/12.
 */
@ServerEndpoint(value = "/websocket/log/{logfile}")
@Scope("prototype")
public class LogWebSocketHandler {

    private Process process;
    private InputStream inputStream;

    @OnOpen
    public void onOpen(@PathParam(value = "logfile") String logfile, Session session){
        logfile = SysConvert.hexToString(logfile);
        try{
            process = Runtime.getRuntime().exec("tail -f -n +1 " + logfile);
            inputStream = process.getInputStream();

            TailLogThread thread = new TailLogThread(inputStream, session);
            thread.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(){
        System.out.println("ws closing...");
        try{
            if(process != null){
                process.destroy();
                System.out.println("pro closed");
            }
            if(inputStream != null){
                inputStream.close();
                System.out.println("ws closed");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @OnError
    public void onError(Throwable thr){
        thr.printStackTrace();
    }

}
