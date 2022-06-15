import { useEffect, useState } from "react";
import "react-bootstrap";
import { Nav } from "react-bootstrap";
import AuthService from "../services/Auth-Service";

const Navigation = () => {
  const [key, setKey] = useState();
  const [currentUser, setCurrentUser] = useState(undefined);

  useEffect(() => {
    const user = AuthService.getCurrentUser();
    if (user) {
      setCurrentUser(user);
    }
  }, []);

  const logout = () => {
    AuthService.logout();
  };

  return (
    <Nav
      fill
      variant="tabs"
      activeKey={key}
      onSelect={(k) => {
        setKey(k);
        console.log(key);
      }}
    >
      <Nav.Item>
        <Nav.Link eventKey="disabled" disabled>
          My_JWT
        </Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link eventKey="home" href="/">
          Home
        </Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link eventKey="manager" href="/manager">
          Manager
        </Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link eventKey="user" href="/user">
          User
        </Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link eventKey="admin" href="/admin">
          Admin
        </Nav.Link>
      </Nav.Item>

      {currentUser ? (
        <>
          <Nav.Item>
            <Nav.Link eventKey="profile" href="/profile">
              Profile
            </Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link eventKey="logout" onClick={logout}>
              Logout
            </Nav.Link>
          </Nav.Item>
        </>
      ) : (
        <>
          <Nav.Item>
            <Nav.Link eventKey="register" href="/register">
              Register
            </Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link eventKey="login" href="/login">
              Login
            </Nav.Link>
          </Nav.Item>
        </>
      )}
    </Nav>
  );
};

export default Navigation;
