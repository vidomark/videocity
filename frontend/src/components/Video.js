import React from "react";
import profilePicture from "../assets/images/profile-picture.png";
import Iframe from "./Iframe";
import { Link } from "react-router-dom";

export default function Video({ video, selectVideo }) {
  return (
    <div class="col-lg-4 mb-5">
      <Link
        to={`/video/${video.id}`}
        style={{ color: "inherit", textDecoration: "inherit" }}
      >
        <div
          class="card h-100 shadow border-0"
          onClick={() => selectVideo(video)}
        >
          <Iframe videoId={video.id} />
          <div class="card-body p-4">
            <a class="text-decoration-none link-dark stretched-link" href="#!">
              <h5 class="card-title mb-3">{video.title}</h5>
            </a>
            <p class="card-text mb-0">{video.description}</p>
          </div>
          <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
            <div class="d-flex align-items-end justify-content-between">
              <div class="d-flex align-items-center">
                <img
                  class="rounded-circle me-3"
                  src={profilePicture}
                  alt="..."
                />
                <div class="small">
                  <div class="fw-bold">{video.channelTitle}</div>
                  <div class="text-muted">{video.publishedAt}</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </Link>
    </div>
  );
}
