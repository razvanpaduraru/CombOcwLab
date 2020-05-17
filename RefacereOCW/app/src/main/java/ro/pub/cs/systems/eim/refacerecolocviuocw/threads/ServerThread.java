package ro.pub.cs.systems.eim.refacerecolocviuocw.threads;

import android.util.Log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import cz.msebera.android.httpclient.client.ClientProtocolException;
import ro.pub.cs.systems.eim.refacerecolocviuocw.Information;

public class ServerThread extends Thread {
    private int port = 0;
    private ServerSocket serverSocket = null;

    HashMap<String, Information> data = null;

    public ServerThread(int port) {
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException ioException) {
            Log.e("[PracticalTest02]", "An exception has occurred: " + ioException.getMessage());
            if (true) {
                ioException.printStackTrace();
            }
        }
        this.data = new HashMap<>();
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Log.i("[PracticalTest02]", "[SERVER THREAD] Waiting for a client invocation...");
                Socket socket = serverSocket.accept();
                Log.i("[PracticalTest02]", "[SERVER THREAD] A connection request was received from " + socket.getInetAddress() + ":" + socket.getLocalPort());
                CommunicationThread communicationThread = new CommunicationThread(this, socket);
                communicationThread.start();
            }
        } catch (ClientProtocolException clientProtocolException) {
            Log.e("[PracticalTest02]", "[SERVER THREAD] An exception has occurred: " + clientProtocolException.getMessage());
            if (true) {
                clientProtocolException.printStackTrace();
            }
        } catch (IOException ioException) {
            Log.e("[PracticalTest02]", "[SERVER THREAD] An exception has occurred: " + ioException.getMessage());
            if (true) {
                ioException.printStackTrace();
            }
        }
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public synchronized void setData(String city, Information information) {
        this.data.put(city, information);
    }

    public synchronized HashMap<String, Information> getData() {
        return this.data;
    }

    public void stopThread() {
        interrupt();
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException ioException) {
                Log.e("[PracticalTest02]", "[SERVER THREAD] An exception has occurred: " + ioException.getMessage());
                if (true) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
