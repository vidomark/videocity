import React from "react";
import profilePicture from "../assets/images/profile-picture.png";
import { Grid } from "@material-ui/core";

export default function Recommendation({ recommendation }) {
  return (
    <div>
      <Grid container direction="row">
        <Grid item>
          <img
            src={profilePicture}
            alt="profile"
            className="recommendation-profile-picture"
          />
        </Grid>
        <Grid item>
          <div className="recommendation-message">{recommendation.message}</div>
          <div className="recommendation-postedAt">
            {recommendation.postedAt}
          </div>
        </Grid>
      </Grid>
    </div>
  );
}
