import React from "react";
import profilePicture from "../assets/images/profile-picture.png";
import { Grid } from "@material-ui/core";
import { ReactComponent as Bin } from "../assets/images/trash.svg";
import axios from "axios";
import { deleteData } from "../util/api";

export default function Recommendation({ recommendation, setRecommendations }) {
  const deleteComment = () => {
    const url = `http://localhost:9090/recommendation?id=${recommendation.id}`;
    const message = recommendation.message;
    deleteData(url).then((result) => {
      if (result.status === 200) {
        setRecommendations((previous) =>
          previous.filter(
            (recommendation) => recommendation.message !== message
          )
        );
      }
    });
  };

  return (
    <div className="recommendation">
      <Grid container direction="row">
        <Grid item>
          <img
            src={profilePicture}
            alt="profile"
            className="recommendation-profile-picture"
          />
        </Grid>
        <Grid item>
          <div className="recommendation-message">
            <div>{recommendation.message}</div>
            <div
              className="delete-icon-container"
              onClick={() => deleteComment()}
            >
              <Bin className="delete-icon" />
            </div>
          </div>

          <div className="recommendation-postedAt">
            {recommendation.postedAt}
          </div>
        </Grid>
      </Grid>
    </div>
  );
}
