import { useEffect, useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import "axios";
import axios from "axios";
import { Outlet, useNavigate, useParams } from "react-router-dom";
function TodoView() {
  const params = useParams();
  const navigate = useNavigate();

  const [todoView, setTodoView] = useState({
    num: "",
    title: "",
    content: "",
    checked: 0,
  });

  useEffect(() => {
    let num = params.num;
    console.log(num);
    findByNUm(num);
  }, []);

  const findByNUm = (num) => {
    axios.get("/todo/find/" + num).then((resp) => {
      console.log(resp.data);
      setTodoView(resp.data);
    });
  };

  const handleOnChange = (e) => {
    setTodoView({ ...todoView, [e.target.name]: e.target.value });
    console.log(todoView);
  };

  const handleonUpdate = () => {
    axios
      .put("/todo/update/", {
        num: todoView.num,
        title: todoView.title,
        content: todoView.content,
      })
      .then((resp) => {
        alert("update");
        navigate("/");
      });
  };
  return (
    <Container className="mt-5">
      <Form>
        <Form.Group className="mb-3" controlId="TodoForm.Title">
          <Form.Label>Title</Form.Label>
          <Form.Control
            name="title"
            type="text"
            value={todoView.title}
            onChange={handleOnChange}
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="TodoForm.Content">
          <Form.Label>Content</Form.Label>
          <Form.Control
            name="content"
            type="text"
            value={todoView.content}
            onChange={handleOnChange}
          />
        </Form.Group>
        <Button variant="warning" onClick={handleonUpdate}>
          수정
        </Button>
      </Form>
    </Container>
  );
}

export default TodoView;
