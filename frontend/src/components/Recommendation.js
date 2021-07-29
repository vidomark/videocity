import React, { useState } from "react";
import { Grid } from "@material-ui/core";
import { ReactComponent as Bin } from "../assets/images/trash.svg";
import { ReactComponent as Edit } from "../assets/images/edit.svg";
import { deleteData, putData } from "../util/api";
import { Col, Form, Row, Button } from "react-bootstrap";
import profilePicture from "../assets/images/profile-picture.png";
import token from "../util/token";

export default function Recommendation({ recommendation, setRecommendations }) {
  const [edit, setEdit] = useState(false);
  const [message, setMessage] = useState(null);
  const [authenticated, setAuthenticated] = useState(token.available())

  const deleteComment = () => {
    const url = `http://localhost:9090/recommendation?id=${recommendation.id}`;
    const header = { Authorization: `${token.getToken()}` };
    const message = recommendation.message;
    deleteData(url, header).then((result) => {
      if (result.status === 200) {
        setRecommendations((previous) =>
          previous.filter(
            (recommendation) => recommendation.message !== message
          )
        );
      }
    });
  };

  const editComment = () => {
    const url = `http://localhost:9090/recommendation?id=${recommendation.id}&message=${message}`;
    const header = { Authorization: `${token.getToken()}` };
    putData(url, null, header).then((result) => {
      if (result) {
        if (result.status === 200) {
          const newComment = result.data;
          console.log(newComment);
          setRecommendations((previous) =>
            previous.map((recommendation) => {
              if (recommendation.id === newComment.id) {
                return (recommendation = newComment);
              }
              return recommendation;
            })
          );
          setEdit(false);
        }
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
            <div>
              {edit ? (
                <Form.Group as={Row}>
                  <Col sm="10">
                    <Form.Control
                      type="text"
                      placeholder="Edit your comment..."
                      onChange={(event) => setMessage(event.target.value)}
                    />
                  </Col>
                  <Form.Label column>
                    <Button column onClick={() => editComment()}>
                      Edit
                    </Button>
                  </Form.Label>
                </Form.Group>
              ) : (
                recommendation.message
              )}
            </div>
            <div className="delete-icon-container">
              {authenticated && <Bin className="delete-icon" onClick={() => deleteComment()} />}
              {authenticated && <Edit className="edit-icon" onClick={() => setEdit(true)} />}
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
