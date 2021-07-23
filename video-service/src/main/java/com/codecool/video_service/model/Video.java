package com.codecool.video_service.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Video {

	@Id
	private String id;

	@ElementCollection
	@Singular
	private Set<Recommendation> recommendations = new HashSet<>();

	@SerializedName("publishTime")
	private String publishTime;

	@SerializedName("publishedAt")
	private String publishedAt;

	@SerializedName("description")
	private String description;

	@SerializedName("title")
	private String title;

	@SerializedName("channelId")
	private String channelId;

	@SerializedName("channelTitle")
	private String channelTitle;

	@SerializedName("liveBroadcastContent")
	private String liveBroadcastContent;
}