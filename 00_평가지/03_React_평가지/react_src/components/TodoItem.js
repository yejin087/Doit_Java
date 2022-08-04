import { Button, Col, Row } from "react-bootstrap";
import { Link } from "react-router-dom";

const TodoItem = ({ todo, onDelete }) => {
  return (
    <Row className="p-2 ">
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
            onDelete(todo.num);
          }}
        >
          &times;
        </Button>
      </Col>
    </Row>
  );
};

export default TodoItem;
