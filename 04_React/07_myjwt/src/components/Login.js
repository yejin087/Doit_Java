import { useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import AuthService from "../services/Auth-Service";

const Login = () => {
  const [user, setUser] = useState({
    username: "",
    password: "",
  });

  const history = useHistory();

  const onChangeUser = (e) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value,
    });
  };

  const handleLogin = (e) => {
    e.preventDefault();
    AuthService.login(user.username, user.password).then((resp) => {
      //   console.log(resp);
      history.push("/profile");
    });
  };

  return (
    <Form>
      <Form.Group as={Row} className="mb-3">
        <Form.Label column sm="2">
          Username
        </Form.Label>
        <Col>
          <Form.Control
            type="text"
            id="username"
            name="username"
            value={user.username}
            onChange={onChangeUser}
          />
        </Col>
      </Form.Group>

      <Form.Group as={Row} className="mb-3">
        <Form.Label column sm="2">
          Password
        </Form.Label>
        <Col>
          <Form.Control
            type="password"
            id="password"
            name="password"
            value={user.password}
            onChange={onChangeUser}
          />
        </Col>
      </Form.Group>

      <Button
        className="float-end"
        variant="outline-success"
        onClick={handleLogin}
      >
        Login
      </Button>
    </Form>
  );
};

export default Login;
