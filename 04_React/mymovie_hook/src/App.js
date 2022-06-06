import { BrowserRouter, Route, Switch } from "react-router-dom";
import Movie from "./components/Movie";
import MovieView from "./components/MovieView";
import About from "./router/About";
import Home from "./router/Home";
import Navigation from "./router/Navigation";

function App() {
  return (
    <BrowserRouter>
      <Navigation />
      <Switch>
        <Route path={"/"} exact={true} component={Home}></Route>
        <Route path={"/list"} component={Home}></Route>
        <Route path={"/detail"} component={MovieView}></Route>
        <Route path={"/about"} component={About}></Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
