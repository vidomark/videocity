import React from "react";

export default function Introduction() {
  return (
    <div class="py-5 bg-light">
      <div class="container px-5 my-5">
        <div class="row gx-5 justify-content-center">
          <div class="col-lg-10 col-xl-7">
            <div class="text-center">
              <div class="fs-4 mb-4 fst-italic">
                This is my first microservice application using Spring Boot.
              </div>
              <div class="d-flex align-items-center justify-content-center">
                <img
                  class="rounded-circle me-3"
                  src="https://dummyimage.com/40x40/ced4da/6c757d"
                  alt="..."
                />
                <div class="fw-bold">
                  Vidó Márk
                  <span class="fw-bold text-primary mx-1">/</span>
                  Codecooler
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
