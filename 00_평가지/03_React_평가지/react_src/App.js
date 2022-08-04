import "bootstrap/dist/css/bootstrap.min.css";
import { Container } from "react-bootstrap";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navigation from "./components/Navigation";
import TodoForm from "./components/TodoForm";
import TodoHome from "./components/TodoHome";
import TodoView from "./components/TodoView";
function App() {
  return (
    <BrowserRouter>
      <Container className="mt-5 p-5">
        <Navigation />
        <Routes>
          <Route path="/" element={<TodoHome />} />
          <Route path="/list" element={<TodoHome />} />
          <Route path="/add" element={<TodoForm />} />
          <Route path="/view/:num" element={<TodoView />} />
        </Routes>
      </Container>
    </BrowserRouter>
  );
}

export default App;
