import { Component } from "react";
import "./TodoItem.css";

class TodoItem extends Component {
  render() {
    const { id, text, checked, onRemove, onToggle } = this.props;

    return (
      <div className="todo-item" onClick={() => onToggle(id)}>
        <div
          className="remove"
          onClick={(e) => {
            e.stopPropagation();
            onRemove(id);
          }}
        >
          &times;
        </div>
        <div className="{`todo-text ${checked && `checked`}`}">
          {id} {text}
        </div>
        {checked && <div className="check-mark">&#x2713;</div>}
      </div>
    );
  }
}

export default TodoItem;
