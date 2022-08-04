import axios from "axios";
import { useState } from "react";
import { Button, Form, FormControl, Nav } from "react-bootstrap";
import TodoService from "../service/Todo-Service";

const Navigation = ({ setTodos }) => {
  const [key, setKey] = useState("");

  return (
    <Nav
      fill
      variant="tabs"
      activeKey={key}
      onSelect={(k) => {
        setKey(k);
      }}
    >
      <Nav.Item>
        <Nav.Link eventKey="disabled" disabled>
          MyToodo
        </Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link eventKey="home" href="/">
          Home
        </Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link eventKey="list" href="/list">
          TodoList
        </Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link eventKey="add" href="/add">
          Add
        </Nav.Link>
      </Nav.Item>
    </Nav>
  );
};

export default Navigation;
