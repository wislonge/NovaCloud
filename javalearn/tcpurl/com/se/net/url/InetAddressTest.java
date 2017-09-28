package com.se.net.url;

import com.se.util.Utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2017-9-20.
 */
public class InetAddressTest {

    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        Utils.out("是否通：" + ip.isReachable(2000));
        Utils.out("ip：" + ip.getHostAddress());
        InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        Utils.out("Locak是否通：" + ip.isReachable(2000));
    }

}
