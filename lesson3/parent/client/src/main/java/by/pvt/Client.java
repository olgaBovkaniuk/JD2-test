package by.pvt;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client {

    private static Logger log = Logger.getLogger("by.pvt.Client");

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 3036)) {
            Scanner scanner = new Scanner(System.in);
            DataOutputStream dataOutputStream =
                    new DataOutputStream(socket.getOutputStream());
            String command = "";
            while (!"END".equals(command)) {
                command = scanner.nextLine();
                dataOutputStream.writeUTF(command);
                dataOutputStream.flush();
            }
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
