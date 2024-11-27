package com.ferra13671.DiscordWebhookSystem;

import com.ferra13671.DiscordWebhookSystem.EmbdedObject.*;
import com.ferra13671.DiscordWebhookSystem.EmbdedObject.Image;
import com.ferra13671.DiscordWebhookSystem.Utils.JsonObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WebHookInfo {
    protected String content;
    protected String username;
    protected String avatarUrl;
    protected boolean tts;
    protected final List<EmbedObject> embeds = new ArrayList<>();

    public JsonObject prepare() {
        JsonObject json = new JsonObject();

        json.put("content", content);
        json.put("username", username);
        json.put("avatar_url", avatarUrl);
        json.put("tts", tts);

        if (!embeds.isEmpty()) {
            List<JsonObject> embedObjects = new ArrayList<>();

            for (EmbedObject embed : this.embeds) {
                JsonObject jsonEmbed = new JsonObject();

                jsonEmbed.put("title", embed.getTitle());
                jsonEmbed.put("description", embed.getDescription());
                jsonEmbed.put("url", embed.getUrl());

                if (embed.getColor() != null) {
                    Color color = embed.getColor();
                    int rgb = color.getRed();
                    rgb = (rgb << 8) + color.getGreen();
                    rgb = (rgb << 8) + color.getBlue();

                    jsonEmbed.put("color", rgb);
                }

                Footer footer = embed.getFooter();
                Image image = embed.getImage();
                Thumbnail thumbnail = embed.getThumbnail();
                Author author = embed.getAuthor();
                List<Field> fields = embed.getFields();

                if (footer != null) {
                    JsonObject jsonFooter = new JsonObject();

                    jsonFooter.put("text", footer.getText());
                    jsonFooter.put("icon_url", footer.getIconUrl());
                    jsonEmbed.put("footer", jsonFooter);
                }

                if (image != null) {
                    JsonObject jsonImage = new JsonObject();

                    jsonImage.put("url", image.getUrl());
                    jsonEmbed.put("image", jsonImage);
                }

                if (thumbnail != null) {
                    JsonObject jsonThumbnail = new JsonObject();

                    jsonThumbnail.put("url", thumbnail.getUrl());
                    jsonEmbed.put("thumbnail", jsonThumbnail);
                }

                if (author != null) {
                    JsonObject jsonAuthor = new JsonObject();

                    jsonAuthor.put("name", author.getName());
                    jsonAuthor.put("url", author.getUrl());
                    jsonAuthor.put("icon_url", author.getIconUrl());
                    jsonEmbed.put("author", jsonAuthor);
                }

                List<JsonObject> jsonFields = new ArrayList<>();
                for (Field field : fields) {
                    JsonObject jsonField = new JsonObject();

                    jsonField.put("name", field.getName());
                    jsonField.put("value", field.getValue());
                    jsonField.put("inline", field.isInline());

                    jsonFields.add(jsonField);
                }

                jsonEmbed.put("fields", jsonFields.toArray());
                embedObjects.add(jsonEmbed);
            }

            json.put("embeds", embedObjects.toArray());
        }

        return json;
    }
}
