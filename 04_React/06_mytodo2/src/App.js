import TodoForm from "./TodoForm";
import TodoList from "./TodoList";
import "bootstrap/dist/css/bootstrap.min.css";
import { Container } from "react-bootstrap";
import { useEffect, useState } from "react";
import axios from "axios";
function App() {
  // db에 추가되면 todos에도 추가되어야함.
  const [todos, setTodos] = useState([]);
  useEffect(() => {
    loadContent();
  }, []);

  const loadContent = () => {
    axios.get("/api/listAll").then((resp) => {
      setTodos(resp.data);
      console.log(resp.data);
    });
  };

  const deleteContent = (num) => {
    axios.delete("/api/delete", { params: { num: num } }).then((resp) => {
      alert(resp);
      const newTods = todos.filter((todo) => todo.num !== num);
      setTodos(newTods);
    });
  };

  return (
    <Container className="mt-5">
      <h1>Todo 김예진</h1>
      <TodoForm loadContent={loadContent} />
      <TodoList todos={todos} onRemove={deleteContent} />
    </Container>
  );
}

export default App;
