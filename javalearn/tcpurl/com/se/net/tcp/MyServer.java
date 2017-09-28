package com.se.net.tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lty on 2017-9-20.
 */
public class MyServer {

    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(30000);
        while (true) {
            Socket socket = ss.accept();
            socketList.add(socket);
            new Thread(new ServerThread(socket)).start();
        }

    }

}
