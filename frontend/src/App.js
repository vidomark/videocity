import "./App.css";
import "./assets/css/style.css";
import { BrowserRouter as Router } from "react-router-dom";
import Navbar from "./components/Navbar";
import Header from "./components/Header";
import Features from "./components/Features";
import Introduction from "./components/Introduction";
import Videos from "./components/Videos";
import Footer from "./components/Footer";

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />

        <Header />

        <Features />

        <Introduction />

        <Videos />

        <Footer />
      </Router>
    </div>
  );
}

export default App;
