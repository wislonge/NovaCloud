package com.se.net.tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lty on 2017-9-20.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);
        System.out.println("wait client");
	while (true) {
            Socket socket = ss.accept();
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("收到消息");
            ps.close();
            ss.close();
        }

    }

}
