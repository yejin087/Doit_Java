import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import { useEffect, useState } from "react";
import { Container } from "react-bootstrap";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navigation from "./components/Navigation";
import TodoHome from "./components/TodoHome";
import TodoList from "./components/TodoList";
import TodoView from "./components/TodoView";

function App() {
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    loadTodos();
  }, [todos]);

  // 모든 todo 가지고 온다
  const loadTodos = () => {
    axios.get("/todo/list").then((resp) => {
      setTodos(resp.data);
    });
  };

  const handleDelete = (num) => {
    axios.delete("/todo/delete/" + num).then(() => {
      alert("delete");
      setTodos(todos.filter((todo) => todo.num !== num));
    });
  };

  const handleUpdate = (searchTodos) => {
    setTodos(searchTodos);
  };

  const handleToggle = (num) => {
    axios.put("/todo/checked/" + num).then(() => {
      const index = todos.findIndex((todo) => todo.num === num);
      const selectd = todos[index];

      const nextTodos = [...todos];
      nextTodos[index] = {
        ...selectd,
        checked: !selectd.checked,
      };

      // console.log("Cjekce", nextTodos);

      setTodos(nextTodos);
    });
  };

  return (
    <BrowserRouter>
      <Container className="mt-5">
        <Navigation />
      </Container>
      <Routes>
        <Route
          path="/"
          element={
            <TodoHome
              loadTodos={loadTodos}
              todos={todos}
              handleDelete={handleDelete}
              handleUpdate={handleUpdate}
              handleToggle={handleToggle}
            />
          }
        />
        <Route
          path="/list"
          element={
            <TodoList
              todos={todos}
              onRemove={handleDelete}
              onUpdate={handleUpdate}
              onToggle={handleToggle}
            />
          }
        />
        <Route path="/view">
          <Route path=":num" element={<TodoView />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
