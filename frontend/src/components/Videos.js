import React from "react";
import profilePicture from "../assets/images/profile-picture.png";

export default function Videos() {
  return (
    <section class="py-5">
      <div class="container px-5 my-5">
        <div class="row gx-5 justify-content-center">
          <div class="col-lg-8 col-xl-6">
            <div class="text-center">
              <h2 class="fw-bolder mb-5">Videos</h2>
              {/* <p class="lead fw-normal text-muted mb-5">
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque
                fugit ratione dicta mollitia. Officiis ad.
              </p> */}
            </div>
          </div>
        </div>
        <div class="row gx-5">
          <div class="col-lg-4 mb-5">
            <div class="card h-100 shadow border-0">
              <img
                class="card-img-top"
                src="https://dummyimage.com/600x350/ced4da/6c757d"
                alt="..."
              />
              <div class="card-body p-4">
                <div class="badge bg-primary bg-gradient rounded-pill mb-2">
                  News
                </div>
                <a
                  class="text-decoration-none link-dark stretched-link"
                  href="#!"
                >
                  <h5 class="card-title mb-3">Blog post title</h5>
                </a>
                <p class="card-text mb-0">
                  Some quick example text to build on the card title and make up
                  the bulk of the card's content.
                </p>
              </div>
              <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                <div class="d-flex align-items-end justify-content-between">
                  <div class="d-flex align-items-center">
                    <img
                      class="rounded-circle me-3"
                      src={profilePicture}
                      alt="..."
                    />
                    <div class="small">
                      <div class="fw-bold">Kelly Rowan</div>
                      <div class="text-muted">
                        March 12, 2021 &middot; 6 min read
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}
