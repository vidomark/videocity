package com.codecool.video_service.util;

import com.codecool.video_service.configuration.YoutubeApiConfiguration;
import com.codecool.video_service.model.Recommendation;
import com.codecool.video_service.model.Video;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Data
public class VideoConverter {

    private String apiKey;
    private String youtubeApi;
    private final YoutubeApiConfiguration youtubeApiConfiguration;
    private final Set<Video> videos = new HashSet<>();

    @Autowired
    public VideoConverter(YoutubeApiConfiguration youtubeApiConfiguration) {
        this.youtubeApiConfiguration = youtubeApiConfiguration;
        this.apiKey = youtubeApiConfiguration.getApiKey();
        this.youtubeApi = String.format("https://www.googleapis.com/youtube/v3/search?key=%s&playlistId=PLxeobsc2iscCHBzruJVasVmz7z1EEk7Tf&part=snippet", apiKey);;
    }

    public void createVideos(ResponseEntity<String> response) {
        JSONObject jsonObject = new JSONObject(response);
        String body = jsonObject.getString("body");
        JSONObject jsonBody = new JSONObject(body);
        JSONArray items = jsonBody.getJSONArray("items");

        for (int i = 0; i < items.length(); i++) {
            JSONObject item = (JSONObject) items.get(i);
            JSONObject id = item.getJSONObject("id");
            String videoId = id.getString("videoId");
            JSONObject snippet = item.getJSONObject("snippet");

            Video video = Video.builder()
                    .id(videoId)
                    .publishedAt(snippet.getString("publishedAt"))
                    .channelId(snippet.getString("channelId"))
                    .channelTitle(snippet.getString("channelTitle"))
                    .title(snippet.getString("title"))
                    .publishTime(snippet.getString("publishTime"))
                    .description(snippet.getString("description"))
                    .liveBroadcastContent(snippet.getString("liveBroadcastContent"))
                    .build();

            videos.add(video);
        }
    }
}
