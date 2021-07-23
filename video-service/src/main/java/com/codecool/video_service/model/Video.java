package com.codecool.video_service.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Video {

	@Id
	private String id;

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