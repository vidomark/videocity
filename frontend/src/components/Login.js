import React, {useState, useEffect} from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import { Alert } from "react-bootstrap";
import { postData } from "../util/api";
import token from "../util/token";
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

export default function Login(props) {
  toast.configure();
  const notify = () =>
    toast.success("You have been successfully logged in!", {
      position: toast.POSITION.TOP_CENTER,
      autoClose: 3000,
    });

  const [invalidLogin, setInvalidLogin] = useState(false);
  const [formData, setFormData] = useState({
    username: null,
    password: null,
  });

  const handleChange = (event) => {
    setFormData({ ...formData, [event.target.name]: event.target.value });
  };

  const sendLogin = () => {
    const url = "http://localhost:9090/auth/login";

    postData(url, formData).then((result) => {
      // Successfull authentication
      if (result) {
        const jwt = result.data.jwt;
        token.login(() => props.history.push("/"), jwt);
        notify();
      } else {
        setInvalidLogin(true);
      }
    });
  };

  useEffect(() => {}, [invalidLogin]);

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
              <div>
              {invalidLogin && (
            <Alert style={{marginTop: "20px", marginBottom: "20px"}} variant="danger">Invalid username or password!</Alert>
          )}
              </div>
                <div className="grey-text">
                  <MDBInput
                    label="Username"
                    name="username"
                    onChange={(event) => handleChange(event)}
                    group
                    icon="user"
                    type="text"
                    validate
                    className="input"
                  />
                  <MDBInput
                    label="Password"
                    name="password"
                    onChange={(event) => handleChange(event)}
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
                    onClick={() => sendLogin()}
                  >
                    Sign In
                  </MDBBtn>
                </div>
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
