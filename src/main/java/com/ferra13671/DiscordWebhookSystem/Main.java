package com.ferra13671.DiscordWebhookSystem;

public class Main {

    public static void main(String[] args) {
        WebHook webhook = new WebHook("https://discord.com/api/webhooks/1311056104548995154/d2vuuKdOvQUgCpG5w4LX3wEsYY_51HdlFKJZa02MnJTzG23DT0-s45qAchJKenny9cLe");
        webhook.setContent("Test test test test test");
        webhook.setUsername("Webhook test");
        webhook.send();
    }
}
