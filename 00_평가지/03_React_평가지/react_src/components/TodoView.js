import { useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import TodoService from "../service/Todo-Service";

const TodoView = () => {
  const params = useParams();
  const navigate = useNavigate();

  const [todoView, setTodoView] = useState({
    num: "",
    title: "",
    content: "",
  });

  useEffect(() => {
    let num = params.num;
    // console.log(num);
    findByNum(num);
  }, []);

  const handleChange = (e) => {
    setTodoView({
      ...todoView,
      [e.target.name]: e.target.value,
    });
  };

  const findByNum = (num) => {
    TodoService.viewTodo(num).then((resp) => {
      setTodoView(resp.data);
    });
  };

  const handleonUpdate = () => {
    TodoService.updateTodo(todoView).then(() => {
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
          value={todoView.title}
          placeholder="제목"
          onChange={handleChange}
        />
      </Form.Group>
      <Form.Group className="mb-3" controlId="TodoForm.Content">
        <Form.Label>Content</Form.Label>
        <Form.Control
          name="content"
          type="text"
          value={todoView.content}
          onChange={handleChange}
        />
      </Form.Group>
      <Button onClick={handleonUpdate}>추가</Button>
    </Form>
  );
};

export default TodoView;
