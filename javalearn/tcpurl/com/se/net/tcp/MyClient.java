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
public class MyClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 30000);
        new Thread(new ClientThread(socket)).start();
        PrintStream ps = new PrintStream(socket.getOutputStream());

        String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null) {
            ps.print(line);
        }

    }

}
