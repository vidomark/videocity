import React from "react";
import { Grid } from "@material-ui/core";
import profilePicture from "../assets/images/profile-picture.png";

export default function VideoDescription({ video }) {
  return (
    <div>
      <div className="video-title fw-bold">{video.title}</div>
      <div className="video-publishedAt">{video.publishedAt}</div>
      <div className="divider"></div>
      <Grid container direction="column" alignItems="flex-start">
        <Grid item>
          <img
            src={profilePicture}
            alt="profile"
            className="video-profile-picture"
          />
          <span className="fw-bold video-channel-title">
            {video.channelTitle}
          </span>
        </Grid>
        <Grid item>
          <div className="video-description">{video.description}</div>
        </Grid>
      </Grid>
      <div className="divider"></div>
    </div>
  );
}
