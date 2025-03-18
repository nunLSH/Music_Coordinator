package com.grepp.mc.infra.llm;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class Run {

    public static void main(String[] args) {

        try (
            HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        ) {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                    "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=AIzaSyBbhzFA1WJ2m-ebtlY7Bq3yQo3873IzAM4"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString("{\n"
                    + "  \"contents\": [{\n"
                    + "    \"parts\":[{\"text\": \"오늘 저녁 메뉴 추천해줘\"}]\n"
                    + "  }]\n"
                    + "}"))
                .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
