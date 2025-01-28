package inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class InetAddressDemo {
    public static void main(String[] args) {
        String[] hosts = {
            "facebook.com",
            "youtube.com",
            "google.com",
            "instagram.com",
            "twitter.com",
            "linkedin.com",
            "github.com",
            "amazon.com",
            "wikipedia.org",
            "reddit.com"
        };

        Random random = new Random();
        String randomHost = hosts[random.nextInt(hosts.length)];

        try {
            InetAddress host = InetAddress.getByName(randomHost);

            String hostName = host.getHostName();
            System.out.println("Host Name: " + hostName);

            String hostAddress = host.getHostAddress();
            System.out.println("Host IP Address: " + hostAddress);

            String canonicalHostName = host.getCanonicalHostName();
            System.out.println("Canonical Host Name: " + canonicalHostName);

            InetAddress localHost = InetAddress.getLocalHost();
            String localHostAddress = localHost.getHostAddress();
            System.out.println("Local Host Address: " + localHostAddress);

            byte[] hostAddressBytes = host.getAddress();
            if (hostAddressBytes.length == 4) {
                System.out.println("This is an IPv4 address");
            } else if (hostAddressBytes.length == 16) {
                System.out.println("This is an IPv6 address");
            }

        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve the host: " + e.getMessage());
        }
    }
}