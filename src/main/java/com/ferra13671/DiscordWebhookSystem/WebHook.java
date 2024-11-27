package com.ferra13671.DiscordWebhookSystem;

import com.ferra13671.DiscordWebhookSystem.Connection.WebhookConnection;
import com.ferra13671.DiscordWebhookSystem.EmbdedObject.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebHook {
    private final WebhookConnection connection;
    private final WebHookInfo webHookInfo = new WebHookInfo();


    public WebHook(String url) {
        connection = new WebhookConnection(url);
    }

    public void send() {
        if (webHookInfo.content == null && webHookInfo.embeds.isEmpty()) {
            System.out.println("[DiscordWebhookSystem / WARN] Nothing to send. Set content or add at least one EmbedObject.");
            return;
        }

        try {
            connection.trySend(webHookInfo.prepare());
        } catch (IOException e) {
            System.out.println("[DiscordWebhookSystem / WARN] Failed to send data.");
        }
    }


    public void setContent(String content) {
        webHookInfo.content = content;
    }

    public String getContent() {
        return webHookInfo.content;
    }

    public void setUsername(String username) {
        webHookInfo.username = username;
    }

    public String getUsername() {
        return webHookInfo.username;
    }

    public void setAvatarUrl(String avatarUrl) {
        webHookInfo.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return webHookInfo.avatarUrl;
    }

    public void setTts(boolean tts) {
        webHookInfo.tts = tts;
    }

    public boolean isTts() {
        return webHookInfo.tts;
    }

    public void addEmbed(EmbedObject embed) {
        webHookInfo.embeds.add(embed);
    }

    public List<EmbedObject> getEmbeds() {
        return new ArrayList<>(webHookInfo.embeds);
    }
}
