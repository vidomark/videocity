import React from "react";
import { useState, useEffect } from "react";
import { fetchData } from "../util/api";
import Video from "./Video";

export default function Videos({ selectVideo }) {
  const [videos, setVideos] = useState(null);

  useEffect(() => {
    const videoUrl = "http://localhost:9090/video";
    fetchData(videoUrl).then((result) => setVideos(result.data));
  }, []);

  return (
    videos && (
      <section class="py-5">
        <div class="container px-5 my-5">
          <div class="row gx-5 justify-content-center">
            <div class="col-lg-8 col-xl-6">
              <div class="text-center">
                <h2 class="fw-bolder mb-5">Videos</h2>
                {/* <p class="lead fw-normal text-muted mb-5">
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque
              fugit ratione dicta mollitia. Officiis ad.
            </p> */}
              </div>
            </div>
          </div>
          <div class="row gx-5">
            {videos.map((video) => (
              <Video key={video.id} {...{ video }} {...{ selectVideo }} />
            ))}
          </div>
        </div>
      </section>
    )
  );
}
