import axios from "axios";
import { useEffect, useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
import TodoItem from "./TodoItem";

function TodoList({ todos, onRemove }) {
  return (
    <Container className="mt-5">
      <Row>
        {todos.map((todo, index) => {
          return (
            <Col className="p-1" md={4} key={index}>
              <TodoItem
                key={todo.num}
                todo={todo}
                onRemove={onRemove}
              ></TodoItem>
            </Col>
          );
        })}
      </Row>
    </Container>
  );
}

export default TodoList;
