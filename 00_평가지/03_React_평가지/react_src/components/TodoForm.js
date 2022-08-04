import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import TodoService from "../service/Todo-Service";

const TodoForm = () => {
  const navigate = useNavigate();
  const [todo, setTodo] = useState({
    title: "",
    content: "",
  });

  const handleChange = (e) => {
    setTodo({
      ...todo,
      [e.target.name]: e.target.value,
    });
  };

  const handleAdd = () => {
    TodoService.insertTodo(todo).then(() => {
      setTodo({ title: "", content: "" });
      navigate("/");
    });
  };

  return (
    <Form>
      <Form.Group className="mb-3" controlId="TodoForm.Title">
        <Form.Label>Title</Form.Label>
        <Form.Control
          name="title"
          type="text"
          value={todo.title}
          placeholder="제목"
          onChange={handleChange}
        />
      </Form.Group>
      <Form.Group className="mb-3" controlId="TodoForm.Content">
        <Form.Label>Content</Form.Label>
        <Form.Control
          name="content"
          type="text"
          value={todo.content}
          onChange={handleChange}
        />
      </Form.Group>
      <Button onClick={handleAdd}>추가</Button>
    </Form>
  );
};

export default TodoForm;
