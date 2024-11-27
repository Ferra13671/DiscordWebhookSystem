package com.ferra13671.DiscordWebhookSystem.EmbdedObject;

public class Footer {
    private final String text;
    private final String iconUrl;

    public Footer(String text, String iconUrl) {
        this.text = text;
        this.iconUrl = iconUrl;
    }

    public String getText() {
        return text;
    }
    public String getIconUrl() {
        return iconUrl;
    }
}