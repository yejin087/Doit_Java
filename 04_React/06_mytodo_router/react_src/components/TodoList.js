import axios from "axios";
import { useEffect, useState } from "react";
import { Button, Col, Container, Form, Row } from "react-bootstrap";
import TodoItem from "./TodoItem";

function TodoList({ todos, onRemove, onUpdate, onToggle }) {
  const [searchTitle, setSearchTitle] = useState("");

  // 검색어 (searchTitle)이 변할 때 마다 검색함수 호출
  useEffect(() => {
    handleSearch(searchTitle);
  }, [searchTitle]);

  const handleChange = (e) => {
    setSearchTitle(e.target.value);
    console.log(searchTitle);
  };

  //검색한 title을 가진 todo axios로 가지고 온다.
  const handleSearch = (title) => {
    axios.get("/todo/list/" + title).then((resp) => {
      onUpdate(resp.data);
    });
  };

  return (
    <Container className="mt-5 p-5 border rounded">
      <Row>
        <Col>Checked</Col>
        <Col>Title</Col>
        <Col>Content</Col>
        <Col>Update</Col>
        <Col>Delete </Col>
      </Row>
      {todos &&
        todos.map((todo) => {
          return (
            <TodoItem
              key={todo.num}
              todo={todo}
              onRemove={onRemove}
              onToggle={onToggle}
            />
          );
        })}

      <Container className="mt-5">
        <Form>
          <Row>
            <Col>
              <Form.Group className="mb-3" controlId="TodoForm.Search">
                <Form.Control
                  name="search"
                  type="text"
                  onChange={handleChange}
                />
              </Form.Group>
            </Col>
            <Col>
              <Button
                onClick={(e) => {
                  e.stopPropagation();
                  handleSearch(searchTitle);
                }}
              >
                검색
              </Button>
            </Col>
          </Row>
        </Form>
      </Container>
    </Container>
  );
}

export default TodoList;
