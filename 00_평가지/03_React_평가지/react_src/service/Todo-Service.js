import axios from "axios";
const insertTodo = (todo) => {
  return axios.put("/add", { title: todo.title, content: todo.content });
};

const listTodo = () => {
  return axios.get("/list");
};

const viewTodo = (num) => {
  return axios.get("/view/" + num);
};
const updateTodo = (todoView) => {
  return axios.put("/update", {
    num: todoView.num,
    title: todoView.title,
    content: todoView.content,
  });
};

const deleteTodo = (num) => {
  return axios.delete("/delete/" + num);
};

const searchTodo = (search) => {
  return axios.get("/search", {
    params: {
      searchword: search,
    },
  });
};

export default {
  insertTodo,
  listTodo,
  viewTodo,
  updateTodo,
  deleteTodo,
  searchTodo,
};
