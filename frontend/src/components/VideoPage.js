import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { fetchData, postData } from "../util/api";
import { Alert, Col, Form, Row, Button } from "react-bootstrap";
import profilePicture from "../assets/images/profile-picture.png";
import Iframe from "./Iframe";
import VideoDescription from "./VideoDescription";
import Recommendation from "./Recommendation";

export default function VideoPage({ video, localStorageVideo }) {
  const [recommendations, setRecommendations] = useState();
  const [error, setError] = useState(null);
  const [comment, setComment] = useState(null);

  // In case of page refresh
  video = video ? video : localStorageVideo;
  const fetchRecommendations = () => {
    const url = `http://localhost:9090/video?id=${video.id}`;
    fetchData(url).then((result) => {
      if (result.status === 200) {
        setRecommendations([]);
      } else if (result.status === 202) {
        setError({
          message: result.data,
          type: "danger",
        });
      }
    });
  };

  const commentVideo = () => {
    const url = `http://localhost:9090/recommendation?videoId=${video.id}`;
    const recommendation = {
      videoId: video.id,
      message: comment,
      postedAt: "",
    };
    postData(url, recommendation).then((result) => {
      if (result.status === 200) {
        const newRecommendation = result.data;
        setRecommendations([...recommendations, newRecommendation]);
      }
    });
  };

  useEffect(() => {
    fetchRecommendations();
    /* eslint-disable */
  }, []);

  if (error) {
    return (
      <div className="error">
        <Alert variant={error.type}>{error.message}</Alert>
      </div>
    );
  } else if (video) {
    return (
      <div className="recommendation-container">
        <Iframe videoId={video.id} videoPage={true} />
        <VideoDescription {...{ video }} />
        <div className="comments fw-bold">
          {recommendations ? `${recommendations.length} Comment` : "0 Comment"}
        </div>
        <div className="comment-container">
          <Form.Group as={Row} style={{ marginLeft: "0px" }}>
            <Form.Label column style={{ marginLeft: "0px" }}>
              <img
                src={profilePicture}
                alt="profile"
                style={{
                  marginLeft: "0px",
                  borderRadius: "50%",
                  maxWidth: "30px",
                }}
              />
            </Form.Label>
            <Col sm="11" style={{ marginLeft: "0px" }}>
              <Form.Control
                onChange={(event) => setComment(event.target.value)}
                type="text"
                placeholder="Share your comment..."
                className="comment-input"
                style={{
                  width: "94%",
                  marginBottom: "10px",
                }}
              />
            </Col>
            <Button
              onClick={() => commentVideo()}
              className="float-left"
              style={{
                maxWidth: "150px",
                marginBottom: "70px",
                marginLeft: "148px",
              }}
            >
              Comment
            </Button>
          </Form.Group>
        </div>
        {recommendations &&
          recommendations.map((recommendation) => (
            <Recommendation
              {...{ recommendation }}
              {...{ setRecommendations }}
            />
          ))}
      </div>
    );
  }
}
