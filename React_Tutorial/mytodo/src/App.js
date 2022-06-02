import { Component } from "react";
import Form from "../../mytodo/src/components/Form";
import TodoItemList from "../../mytodo/src/components/TodoItemList";
import TodoListTemplate from "./components/TodoListTemplate";

class App extends Component {
  id = 3;
  state = {
    input: "",
    todos: [
      { id: 0, text: "치킨 먹기1", checked: false },
      { id: 1, text: "치킨 먹기2", checked: true },
      { id: 2, text: "치킨 먹기3", checked: false },
    ],
  };

  handleChange = (e) => {
    this.setState({
      input: e.target.value,
    });
  };

  handelToggle = (id) => {
    const { todos } = this.state;
    const index = todos.findIndex((todo) => todo.id === id);
    const selected = todos[index];
    const nextTodos = [...todos];
    nextTodos[index] = {
      ...selected,
      checked: !selected.checked,
    };

    this.setState({
      todos: nextTodos,
    });
  };

  handleCreate = () => {
    const { input, todos } = this.state;

    this.setState({
      input: "",
      todos: todos.concat({ id: this.id++, text: input, checked: false }),
    });
  };

  handleKeyPress = (e) => {
    if (e.key === "Enter") {
      this.handleCreate();
    }
  };

  handelRemove = (id) => {
    const { todos } = this.state;
    const nextTodos = todos.filter((todo) => todo.id !== id);

    this.setState({
      todos: nextTodos,
    });
  };

  render() {
    return (
      <div className="todo-list">
        <TodoListTemplate
          form={
            <Form
              value={this.state.input}
              onKeyPress={this.handleKeyPress}
              onChange={this.handleChange}
              onCreate={this.handleCreate}
            />
          }
        >
          <TodoItemList
            todos={this.state.todos}
            onRemove={this.handelRemove}
            onToggle={this.handelToggle}
          />
        </TodoListTemplate>
      </div>
    );
  }
}

export default App;
