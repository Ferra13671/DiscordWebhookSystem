package com.ferra13671.DiscordWebhookSystem.Connection;

import com.ferra13671.DiscordWebhookSystem.Utils.JsonObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WebhookConnection {
    private final String url;


    public WebhookConnection(String url) {
        this.url = url;
    }

    public void trySend(JsonObject webhookInfo) throws IOException {
        URL _url = new URL(url);
        HttpsURLConnection connection = (HttpsURLConnection) _url.openConnection();
        connection.addRequestProperty("Content-Type", "application/json");
        connection.addRequestProperty("User-Agent", "YourLocalLinuxUser");
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");

        OutputStream stream = connection.getOutputStream();
        stream.write(webhookInfo.toString().getBytes(StandardCharsets.UTF_8));
        stream.flush();
        stream.close();

        connection.getInputStream().close();
        connection.disconnect();
    }
}
