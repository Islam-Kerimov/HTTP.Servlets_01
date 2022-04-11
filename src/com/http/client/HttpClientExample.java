package com.http.client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

        System.out.println(response.body());
        System.out.println(response.headers());

        HttpRequest request2 = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .POST(BodyPublishers.ofFile(Path.of("C:\\Users\\islam\\OneDrive\\Рабочий стол\\http_servlets_starter\\src\\com\\http\\socket\\DatagramRunner.java")))
                .build();

        HttpResponse<String> response2 = httpClient.send(request2, BodyHandlers.ofString());

        System.out.println(response2.body());
    }
}
