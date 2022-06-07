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

  handelToggle = (id) => {
    // state에서 todos를 받아온다
    const { todos } = this.state;

    // 선택된 todo의 idx와 내용
    const index = todos.findIndex((todo) => todo.id === id);
    const selected = todos[index];

    // 다음에 변경될 내용으로 표시될 todos
    const nextTodos = [...todos];
    // 선택된 idx번 nextTodos의 selectd= false
    nextTodos[index] = {
      ...selected,
      checked: !selected.checked,
    };

    // 변경된 내용으로 할당
    this.setState({
      todos: nextTodos,
    });
  };

  handelRemove = (id) => {
    const { todos } = this.state;

    //filter
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
