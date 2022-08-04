import { useEffect, useState } from "react";
import { Button, Container, Form, FormControl } from "react-bootstrap";
import TodoService from "../service/Todo-Service";
import Navigation from "./Navigation";
import TodoList from "./TodoList";
const TodoHome = () => {
  const [todos, setTodos] = useState([]);
  const [search, setSearch] = useState("");
  //검색
  const handleSearch = (search) => {
    TodoService.searchTodo(search).then((resp) => {
      setTodos(resp.data);
    });
  };

  const handleChange = (e) => [setSearch(e.target.value)];
  useEffect(() => {
    loadTodos();
  }, []);

  const loadTodos = () => {
    TodoService.listTodo().then((resp) => setTodos(resp.data));
  };

  const handleDelete = (num) => {
    TodoService.deleteTodo(num).then(
      setTodos(todos.filter((todo) => todo.num !== num))
    );
  };

  return (
    <Container className="mt-5">
      <Form className="d-flex">
        <FormControl
          type="search"
          placeholder="Search"
          className="me-2 ml-3"
          aria-label="Search"
          value={search}
          onChange={handleChange}
        />
        <Button
          variant="btn btn-outline-primary"
          onClick={(e) => {
            e.stopPropagation();
            handleSearch(search);
          }}
        >
          Search
        </Button>
      </Form>
      <TodoList todos={todos} onDelete={handleDelete}></TodoList>;
    </Container>
  );
};

export default TodoHome;
