import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
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
              <Link class="nav-link" href="about.html">
                About
              </Link>
            </li>
            <li class="nav-item">
              <Link class="nav-link" to="/">
                Login
              </Link>
            </li>
            <li class="nav-item">
              <Link class="nav-link" to="/">
                Registration
              </Link>
            </li>

            {/* <li class="nav-item dropdown">
              <Link
                class="nav-link dropdown-toggle"
                id="navbarDropdownBlog"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Blog
              </Link>
              <ul
                class="dropdown-menu dropdown-menu-end"
                aria-labelledby="navbarDropdownBlog"
              >
                <li>
                  <Link class="dropdown-item" href="blog-home.html">
                    Blog Home
                  </Link>
                </li>
                <li>
                  <Link class="dropdown-item" href="blog-post.html">
                    Blog Post
                  </Link>
                </li>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <Link
                class="nav-link dropdown-toggle"
                id="navbarDropdownPortfolio"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Portfolio
              </Link>
              <ul
                class="dropdown-menu dropdown-menu-end"
                aria-labelledby="navbarDropdownPortfolio"
              >
                <li>
                  <Link class="dropdown-item" href="portfolio-overview.html">
                    Portfolio Overview
                  </Link>
                </li>
                <li>
                  <Link class="dropdown-item" href="portfolio-item.html">
                    Portfolio Item
                  </Link>
                </li>
              </ul>
            </li> */}
          </ul>
        </div>
      </div>
    </nav>
  );
}
