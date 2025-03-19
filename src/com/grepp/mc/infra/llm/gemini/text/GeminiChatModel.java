package com.grepp.mc.infra.llm.gemini.text;

import com.google.gson.Gson;
import com.grepp.mc.infra.llm.ChatModel;
import com.grepp.mc.infra.llm.Request;
import com.grepp.mc.infra.llm.Response;
import com.grepp.mc.infra.llm.gemini.text.vo.RequestDocument;
import com.grepp.mc.infra.llm.gemini.text.vo.ResponseDocument;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class GeminiChatModel implements ChatModel {

    private static final String API_URL = "https://generativelanguage.googleapis.com"
        + "/v1beta"
        + "/models"
        + "/gemini-1.5-flash:generateContent";
    private static final String API_KEY = "AIzaSyBbhzFA1WJ2m-ebtlY7Bq3yQo3873IzAM4";

    @Override
    public Response invoke(Request request) {

        String body = request.toJson();

        try (
            HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        ) {
            HttpRequest requestClient = HttpRequest.newBuilder()
                .uri(URI.create(
                    API_URL + "?key=" + API_KEY))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(body))
                .build();

            HttpResponse<String> response = client.send(requestClient, BodyHandlers.ofString());
            return new TextResponse(response.body());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
