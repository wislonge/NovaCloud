package com.se.net.tcp;

import com.se.util.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by lty on 2017-9-20.
 */
public class ClientThread implements Runnable {

    Socket socket = null;

    BufferedReader br = null;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    @Override
    public void run() {

        try {
            String content = null;
            while ((content = br.readLine()) != null) {
                Utils.out(content);
            }
        } catch (Exception e) {

        }

    }


}
