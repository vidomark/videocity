import React from "react";
import { Link } from "react-router-dom";
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

export default function Login() {
  return (
    <MDBContainer className="mt-5 mb-5 form-container">
      <MDBRow>
        <MDBCol md="">
          <MDBCard>
            <MDBCardBody>
              <MDBCardHeader className="form-header deep-blue-gradient rounded">
                <h3 className="my-3">
                  <MDBIcon icon="lock" /> Login:
                </h3>
              </MDBCardHeader>
              <form>
                <div className="grey-text">
                  <MDBInput
                    label="Username"
                    group
                    icon="user"
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
                    Not a member yet? <Link to="/registration">Sign Up</Link>
                  </p>
                </div>
              </MDBModalFooter>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
      <div style={{ height: "178px" }}></div>
    </MDBContainer>
  );
}
