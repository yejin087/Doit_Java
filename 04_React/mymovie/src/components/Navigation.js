import { Link } from "react-router-dom";
import "./Navigation.css";

function Navigation() {
  return (
    <div className="nav">
      <Link
        to={{
          pathname: "/",
        }}
      >
        Home
      </Link>
      <Link
        to={{
          pathname: "/about",
        }}
      >
        About
      </Link>
    </div>
  );
}

export default Navigation;
