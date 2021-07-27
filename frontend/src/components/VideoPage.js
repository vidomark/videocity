import React from "react";
import Iframe from "./Iframe";

export default function VideoPage({ video, localStorageVideo }) {
  // In case of page refresh
  video = video ? video : localStorageVideo;
  return (
    <div>
      <Iframe videoId={video.id} width="1400" height="800" />
    </div>
  );
}
