import React from "react";

export default function Iframe({ videoId, width = "300", height = "300" }) {
  return (
    <div className="video" style={{ width: width, height: height }}>
      <iframe
        src={`https://www.youtube.com/embed/${videoId}`}
        frameBorder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
        allowFullScreen
        title="Embedded youtube"
      />
    </div>
  );
}
