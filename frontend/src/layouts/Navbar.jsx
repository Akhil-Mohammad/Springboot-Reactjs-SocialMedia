import React from "react";

export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container">
          <div className="d-flex justify-content-left w-100">
            <div className="navbar-brand">Vapp </div>
            <div class="container">
              <form class="form-inline d-flex my-2 my-lg-0">
                <input
                  class="form-control mr-4 search-input"
                  type="search"
                  placeholder="Search"
                  aria-label="Search"
                  style={{width : "250px", marginRight: "20px"}}
                />
                <button
                  class="btn btn-outline-success my-2 my-sm-0"
                  type="submit"
                >
                  Search
                </button>
              </form>
            </div>
<ul>
            <li class="nav-item dropdown">
                <a data-mdb-dropdown-init class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button"
                data-mdb-toggle="dropdown" aria-expanded="false"> <i class="fas fa-user mx-1"></i> Profile </a>

                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    <li>
                        <a class="dropdown-item" href="#">My account</a>
                    </li>

                    <li>
                        <a class="dropdown-item" href="#">Log out</a>
                    </li>
                </ul>
            </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
}
