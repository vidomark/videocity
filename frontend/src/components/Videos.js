import React from "react";
import { Alert } from "react-bootstrap";
import { useState, useEffect } from "react";
import { fetchData } from "../util/api";
import Video from "./Video";
import token from "../util/token";

export default function Videos({ selectVideo }) {
  const [videos, setVideos] = useState(null);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const videoUrl = "http://localhost:9090/video";
    //const header = { Authorization: `${token.getToken()}` };
    fetchData(videoUrl)
      .then((result) => {
        if (result) {
          setVideos(result.data);
        } else {
          setIsLoading(true);
        }
      })
      .then(setIsLoading(false));
  }, []);

  if (isLoading) {
    return <Alert style={{margin: "20px"}} variant="info">Loading videos...</Alert>;
  } else {
    return (
      videos && (
        <section class="py-5">
          <div class="container px-5 my-5">
            <div class="row gx-5 justify-content-center">
              <div class="col-lg-8 col-xl-6">
                <div class="text-center">
                  <h2 class="fw-bolder mb-5">Videos</h2>
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
}
