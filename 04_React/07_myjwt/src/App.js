import "bootstrap/dist/css/bootstrap.min.css";
import { Container } from "react-bootstrap";
import Navigation from "./components/Navigation";
import "react-router-dom";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Home from "./components/Home";
import Register from "./components/Register";
import Login from "./components/Login";
import Profile from "./components/Profile";

function App() {
  return (
    <BrowserRouter>
      <Container className="mt-5">
        <Navigation />
      </Container>
      <Container className="mt-5 p-5 border rounded">
        <Switch>
          <Route path="/" exact={true} component={Home} />
          <Route path="/register" component={Register} />
          <Route path="/login" component={Login} />
          <Route path="/profile" component={Profile} />
        </Switch>
      </Container>
    </BrowserRouter>
  );
}

export default App;
