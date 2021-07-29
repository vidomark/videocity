import React from "react";
import { useEffect } from "react";
import { Link, withRouter } from "react-router-dom";
import token from "../util/token";
import { toast } from "react-toastify";

function Navbar(props) {
  toast.configure();
  const notify = () =>
    toast.success("You have been successfully logged out!", {
      position: toast.POSITION.TOP_CENTER,
      autoClose: 3000,
    });

  const loggedIn = token.available();
  const logout = () => {
    token.logout(() => props.history.push("/"))
    notify()
  }

  useEffect(() => {

  }, [loggedIn])

  return (
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container px-5">
        <Link class="navbar-brand" to="/">
          Videocity
        </Link>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <Link class="nav-link" to="/">
                Home
              </Link>
            </li>
            <li class="nav-item">
              {loggedIn ?  <Link class="nav-link" to="/" onClick={() => logout()}>Logout</Link> : <Link class="nav-link" to="/login">
                Login
              </Link>}
            </li>
            <li class="nav-item">
              {!loggedIn && <Link class="nav-link" to="/registration">
                Registration
              </Link>}
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default withRouter(Navbar)