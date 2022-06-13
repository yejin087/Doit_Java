import { useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import AuthService from "../services/Auth-Service";

const Register = () => {
  const [registerUser, setRegisterUser] = useState({
    username: "",
    email: "",
    password: "",
  });

  const history = useHistory();

  const [message, setMessage] = useState("");

  const OnChangeUser = (e) => {
    setRegisterUser({
      ...registerUser,
      [e.target.name]: e.target.value,
    });
    console.log(registerUser);
  };

  const handleRegister = (e) => {
    e.preventDefault();
    AuthService.register(
      registerUser.username,
      registerUser.email,
      registerUser.password
    )
      .then((resp) => {
        setMessage(resp.data.message);
        history.push("/login");
      })
      .catch(function (error) {
        setMessage(error.response.data.message);
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
            value={registerUser.username}
            onChange={OnChangeUser}
          />
        </Col>
      </Form.Group>

      <Form.Group as={Row} className="mb-3">
        <Form.Label column sm="2">
          Email
        </Form.Label>
        <Col>
          <Form.Control
            type="text"
            id="email"
            name="email"
            value={registerUser.email}
            onChange={OnChangeUser}
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
            value={registerUser.password}
            onChange={OnChangeUser}
          />
        </Col>
      </Form.Group>

      <Button
        className="float-end"
        variant="outline-success"
        onClick={handleRegister}
      >
        Register
      </Button>

      <p className="float-end m-2" style={{ color: "red" }}>
        {message}
      </p>
    </Form>
  );
};

export default Register;
