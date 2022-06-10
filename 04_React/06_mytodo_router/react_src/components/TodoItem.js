import { Button, Col, Row } from "react-bootstrap";
import { Link } from "react-router-dom";

function TodoItem({ todo, onRemove, onToggle }) {
  return (
    <Row className="p-2 ">
      <Col onClick={() => onToggle(todo.num)}>
        {todo.checked && <Button variant="info border round">&#x2713;</Button>}
      </Col>
      <Col>{todo.title} </Col>
      <Col>{todo.content}</Col>
      <Col>
        <Link to={"/view/" + todo.num}>
          <Button variant="warning">수정</Button>
        </Link>
      </Col>
      <Col>
        <Button
          className="rounded-circle"
          variant="danger"
          onClick={(e) => {
            e.stopPropagation();
            onRemove(todo.num);
          }}
        >
          &times;
        </Button>
      </Col>
    </Row>
  );
}

export default TodoItem;
