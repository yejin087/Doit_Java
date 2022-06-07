import { BrowserRouter, Route, Switch } from "react-router-dom";
import MovieView from "./routers/MovieView";
import Home from "./routers/Home";
import "./App.css";
import About from "./routers/About";

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact={true} component={Home}></Route>
        <Route path="/about" component={About}></Route>
        <Route path="/movie-view" component={MovieView}></Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
