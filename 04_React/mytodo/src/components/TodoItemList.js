import { Component } from "react";
import TodoItem from "./TodoItem";

class TodoItemList extends Component {
  render() {
    const { todos, onRemove, onToggle } = this.props;
    const todoList = todos.map(({ id, text, checked }) => (
      <TodoItem
        key={id}
        id={id}
        text={text}
        checked={checked}
        onRemove={onRemove}
        onToggle={onToggle}
      />
    ));

    return <div>{todoList}</div>;
  }
}

export default TodoItemList;
