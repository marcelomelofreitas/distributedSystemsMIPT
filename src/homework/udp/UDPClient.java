package homework.udp;

import java.io.IOException;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        int maxLength = 1000;
        byte[] buffer = new byte[maxLength];
        int length = System.in.read(buffer);

        InetAddress address = InetAddress.getLocalHost();
        ReliablePacket packet = new ReliablePacket(buffer, length, address, UDPServer.PORT);
        ReliableSocket socket = new ReliableSocket();

        if (socket.send(packet)) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }
    }
}
