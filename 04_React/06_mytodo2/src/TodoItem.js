import { Button, Card } from "react-bootstrap";
function TodoItem({ todo, onRemove }) {
  // const [todo, setTodo]= useState({
  //     { num, name, subject, regdate, summary} = todo
  // })
  return (
    <Card>
      <Card.Header as="h5">{todo.num}</Card.Header>
      <Card.Body>
        <Card.Title>{todo.subject}</Card.Title>
        <Card.Text>{todo.name}</Card.Text>
        <Card.Text>{todo.summary}</Card.Text>
        <Card.Text>{todo.regdate}</Card.Text>
        <Button
          variant="danger"
          onClick={(e) => {
            e.stopPropagation(0);
            onRemove(todo.num);
          }}
        >
          삭제
        </Button>
      </Card.Body>
    </Card>
  );
}

// 요청된 리소스 [/api/listAll]은(는) 가용하지 않습니다.
//Origin 서버가 대상 리소스를 위한 현재의 representation을 찾지 못했거나,
//그것이 존재하는지를 밝히려 하지 않습니다.
export default TodoItem;
