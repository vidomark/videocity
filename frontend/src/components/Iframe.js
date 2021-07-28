import React from "react";

export default function Iframe({ videoId, videoPage = false }) {
  const className = videoPage ? "iframe-page" : "iframe";
  return (
    <div className="video">
      <iframe
        src={`https://www.youtube.com/embed/${videoId}`}
        frameBorder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
        allowFullScreen
        title="Embedded youtube"
        className={className}
      />
    </div>
  );
}
