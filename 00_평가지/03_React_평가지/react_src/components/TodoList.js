import { useState } from "react";
import { Button, Col, Container, Form, Row } from "react-bootstrap";
import TodoItem from "./TodoItem";

const TodoList = ({ todos, onDelete }) => {
  return (
    <Container className="mt-5 p-5 border rounded">
      <Row>
        <Col>Title</Col>
        <Col>Content</Col>
        <Col>Update</Col>
        <Col>Delete </Col>
      </Row>
      {todos &&
        todos.map((todo, index) => {
          return <TodoItem key={index} todo={todo} onDelete={onDelete} />;
        })}
    </Container>
  );
};

export default TodoList;
