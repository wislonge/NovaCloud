package com.se.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by lty on 2017-9-20.
 */
public class ServerThread implements Runnable {

    Socket socket = null;

    BufferedReader br = null;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }

    @Override
    public void run() {

        try {
            String content = null;
            while ((content = readFromClient()) != null) {

                for (Socket socket : MyServer.socketList) {
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    ps.print(content);
                }

            }
        } catch (Exception e) {

        }

    }

    private String readFromClient() {

        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            MyServer.socketList.remove(socket);
        }
        return null;

    }
}
