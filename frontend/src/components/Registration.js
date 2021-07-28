import React from "react";
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

export default function Registration() {
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
              <form>
                <div className="grey-text">
                  <MDBInput
                    label="Email"
                    icon="envelope"
                    group
                    type="email"
                    validate
                    error="wrong"
                    success="right"
                    className="input"
                  />
                  <MDBInput
                    label="Username"
                    icon="lock"
                    group
                    type="text"
                    validate
                    className="input"
                  />
                  <MDBInput
                    label="Password"
                    icon="lock"
                    group
                    type="password"
                    validate
                    className="input"
                  />
                  <MDBInput
                    label="Confirm password"
                    icon="lock"
                    group
                    type="password"
                    validate
                    className="input"
                  />
                </div>

                <div className="text-center mt-4">
                  <MDBBtn
                    color="blue"
                    className="mb-3 form-button"
                    type="submit"
                  >
                    Sign Up
                  </MDBBtn>
                </div>
              </form>
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
