package edu.asu.ser515.sockets;

import java.net.*;
import java.io.*;

class Sender {

	public static void main(String[] args) throws Exception {

		String msg = args[0];
		InetAddress group = InetAddress.getByName("225.6.7.8");
		MulticastSocket socket = new MulticastSocket(2222);

		socket.joinGroup(new InetSocketAddress(group, 2222), NetworkInterface.getByName("eth0"));
		DatagramPacket packet =
			new DatagramPacket(msg.getBytes(), msg.length(), group, 2222);
 		socket.send(packet);
		socket.leaveGroup(new InetSocketAddress(group, 2222), NetworkInterface.getByName("eth0"));
	}
}
