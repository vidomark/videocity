import "./App.css";
import "./assets/css/style.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Header from "./components/Header";
import Features from "./components/Features";
import Introduction from "./components/Introduction";
import Videos from "./components/Videos";
import VideoPage from "./components/VideoPage";
import Footer from "./components/Footer";
import { useState } from "react";
import { Fragment } from "react";

function App() {
  const [video, setVideo] = useState(null); // Selected video

  const selectVideo = (video) => {
    setVideo(video);
    localStorage.setItem("video", JSON.stringify(video));
  };

  const watchVideo = () => {
    try {
      return JSON.parse(localStorage.getItem("video"));
    } catch (exception) {
      return null;
    }
  };

  const localStorageVideo = watchVideo();

  return (
    <div className="App">
      <Router>
        <Navbar />

        <Route
          exact
          path="/"
          render={() => (
            <Fragment>
              <Header />
              <Features />
              <Introduction />
              <Videos {...{ selectVideo }} />
            </Fragment>
          )}
        />

        {/* For watching youtube video */}
        {localStorageVideo && (
          <Route
            exact
            path={`/video/${localStorageVideo.id}`}
            render={() => (
              <VideoPage {...{ video }} {...{ localStorageVideo }} />
            )}
          />
        )}

        <Footer />
      </Router>
    </div>
  );
}

export default App;
