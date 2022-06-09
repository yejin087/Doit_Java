import { useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import axios from "axios";
function TodoForm({ loadContent }) {
  const [todoContent, setTodoContent] = useState({
    subject: "",
    name: "",
    summary: "",
  });

  const submitTodo = () => {
    // axios
    //   .post("/api/insert", {
    //     subject: todoContent.subject,
    //     name: todoContent.name,
    //     summary: todoContent.summary,
    //   })
    //   .then((resp) => {
    //     console.log(resp);
    //     alert("success");
    //     loadContent();
    //     setTodoContent({
    //       subject: "",
    //       name: "",
    //       summary: "",
    //     });
    //   });

    fetch("/api/insert", {
      method: "post",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        subject: todoContent.subject,
        name: todoContent.name,
        summary: todoContent.summary,
      }),
    }).then((resp) => {
      loadContent();
      setTodoContent({
        subject: "",
        name: "",
        summary: "",
      });
    });
  };

  const getTodo = (e) => {
    setTodoContent({ ...todoContent, [e.target.name]: e.target.value });
  };

  return (
    <Form>
      <Form.Group className="mb-3" controlId="TodoForm.Subject">
        <Form.Label>Subject</Form.Label>
        <Form.Control name="subject" type="text" onChange={getTodo} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="TodoForm.Name">
        <Form.Label>Name</Form.Label>
        <Form.Control name="name" type="text" onChange={getTodo} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="TodoForm.Summary">
        <Form.Label>Summary</Form.Label>
        <Form.Control
          name="summary"
          as="textarea"
          rows={3}
          onChange={getTodo}
        />
      </Form.Group>
      <Button variant="primary" onClick={submitTodo}>
        Submit
      </Button>
    </Form>
  );
}

export default TodoForm;
