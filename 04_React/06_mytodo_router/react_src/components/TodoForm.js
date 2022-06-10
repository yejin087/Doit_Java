import axios from "axios";
import { useState } from "react";
import { Button, Container, Form } from "react-bootstrap";

function TodoForm({ loadTodos }) {
  const [todo, setTodo] = useState({ title: "", content: "" });
  const onChangeTodoForm = (e) => {
    setTodo({ ...todo, [e.target.name]: e.target.value });
  };
  const insertTodo = () => {
    axios
      .put("/todo/insert", { title: todo.title, content: todo.content })
      .then((resp) => {
        alert(resp);
        loadTodos();
      });
  };
  return (
    <Container className="mt-5">
      <Form>
        <Form.Group className="mb-3" controlId="TodoForm.Title">
          <Form.Label>Title</Form.Label>
          <Form.Control name="title" type="text" onChange={onChangeTodoForm} />
        </Form.Group>
        <Form.Group className="mb-3" controlId="TodoForm.Content">
          <Form.Label>Content</Form.Label>
          <Form.Control
            name="content"
            type="text"
            onChange={onChangeTodoForm}
          />
        </Form.Group>
        <Button onClick={insertTodo}>추가</Button>
      </Form>
    </Container>
  );
}

export default TodoForm;
