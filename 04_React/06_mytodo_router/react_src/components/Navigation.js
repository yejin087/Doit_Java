import { Nav } from "react-bootstrap";
function Navigation() {
  return (
    <Nav>
      <Nav.Item>
        <Nav.Link href="/">Home</Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link href="/list">TodoList</Nav.Link>
      </Nav.Item>
    </Nav>
  );
}

export default Navigation;
