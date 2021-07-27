import React from "react";

export default function Features() {
  return (
    <section class="py-5" id="features">
      <div class="container px-5 my-5">
        <div class="row gx-5">
          <div class="col-lg-4 mb-5 mb-lg-0">
            <h2 class="fw-bolder mb-0">Supported features.</h2>
          </div>
          <div class="col-lg-8">
            <div class="row gx-5 row-cols-1 row-cols-md-2">
              <div class="col mb-5 h-100">
                <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
                  <i class="bi bi-collection"></i>
                </div>
                <h2 class="h5">Video streaming</h2>
                <p class="mb-0">The videos are embedded using Youtube Api.</p>
              </div>
              <div class="col mb-5 h-100">
                <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
                  <i class="bi bi-toggles2"></i>
                </div>
                <h2 class="h5">Recommendation</h2>
                <p class="mb-0">
                  Able to recommend, update, delete end edit videos based on
                  user experience.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}
