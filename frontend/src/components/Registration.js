import React, {useState} from "react";
import {postData} from "../util/api"
import {
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBModalFooter,
  MDBIcon,
  MDBCardHeader,
  MDBBtn,
  MDBInput,
} from "mdb-react-ui-kit";
import { Link } from "react-router-dom";
import { Alert } from "react-bootstrap";

export default function Registration() {
  const [registrationState, setRegistrationState] = useState(null)
  const [message, setMessage] = useState(null)
  const [formData, setFormData] = useState({
    email: null,
    username: null,
    password: null,
    confirmPassword: null,
  });

  const handleChange = (event) => {
    setFormData({ ...formData, [event.target.name]: event.target.value });
  };

  const sendRegistration = () => {
    const url = "http://localhost:9090/auth/registration";
    console.log(formData);
    postData(url, formData)
      .then((result) => {
        if (result) {
          setRegistrationState("success");
          setMessage("Successful registration!");
        } else {
          console.log("ELSE: " + result);
          setRegistrationState("danger");
          setMessage("Please check your ceredentials!");
        }
      })
      .catch((error) => {
        setRegistrationState("danger");
        setMessage("Please check your ceredentials!");
      });
  };

  return (
    <MDBContainer className="mt-5 mb-5 form-container">
      <MDBRow>
        <MDBCol md="">
          <MDBCard>
            <MDBCardBody>
              <MDBCardHeader className="form-header deep-blue-gradient rounded">
                <h3 className="my-3">
                  <MDBIcon icon="lock" /> Registration:
                </h3>
              </MDBCardHeader>
              {registrationState && <Alert style={{marginTop: "20px", marginBottom: "20px"}} variant={registrationState}>{message}</Alert>}
                <div className="grey-text">
                  <MDBInput
                    label="Email"
                    name="email"
                    icon="envelope"
                    group
                    type="email"
                    validate
                    error="wrong"
                    success="right"
                    className="input"
                    onChange={(event) => handleChange(event)}
                  />
                  <MDBInput
                    label="Username"
                    name="username"
                    icon="lock"
                    group
                    type="text"
                    validate
                    className="input"
                    onChange={(event) => handleChange(event)}
                  />
                  <MDBInput
                    label="Password"
                    name="password"
                    icon="lock"
                    group
                    type="password"
                    validate
                    className="input"
                    onChange={(event) => handleChange(event)}
                  />
                  <MDBInput
                    label="Confirm password"
                    name="confirmPassword"
                    icon="lock"
                    group
                    type="password"
                    validate
                    className="input"
                    onChange={(event) => handleChange(event)}
                  />
                </div>

                <div className="text-center mt-4">
                  <MDBBtn
                    color="blue"
                    className="mb-3 form-button"
                    type="submit"
                    onClick={() => sendRegistration()}
                  >
                    Sign Up
                  </MDBBtn>
                </div>
              <MDBModalFooter>
                <div className="font-weight-light">
                  <p>
                    Already a member? <Link to="/login">Sign In</Link>
                  </p>
                </div>
              </MDBModalFooter>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
      <div style={{ height: "50px" }}></div>
    </MDBContainer>
  );
}
