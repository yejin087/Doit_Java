import "bootstrap/dist/css/bootstrap.min.css";
import { Container } from "react-bootstrap";
import Navigation from "./components/Navigation";
import "react-router-dom";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Home from "./components/Home";
import Register from "./components/Register";
import Login from "./components/Login";
import Profile from "./components/Profile";
import User from "./components/User";
import Manager from "./components/Manager";
import Admin from "./components/Admin";

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
          <Route path="/user" component={User} />
          <Route path="/manager" component={Manager} />
          <Route path="/admin" component={Admin} />
        </Switch>
      </Container>
    </BrowserRouter>
  );
}

export default App;
