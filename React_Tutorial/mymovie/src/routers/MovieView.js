import { Component } from "react";
import "./MovieView.css";

class MovieView extends Component {
  componentDidMount() {
    const { location, history } = this.props;
    if (location.state === undefined) {
      //   history.push("/");
    }
  }
  render() {
    const { location } = this.props;
    if (location.state) {
      return (
        <div className="movie__container">
          <img
            src={location.state.poster}
            alt={location.state.title}
            title={location.state.poster}
          ></img>
          <div>
            <h3 className="movie__title">{location.state.title}</h3>
            <h3 className="movie__year">{location.state.year}</h3>
            <h3 className="movie__genres">{location.state.genres}</h3>
            <p className="movie__summary">{location.state.summary}</p>
          </div>
        </div>
      );
    } else {
      return null;
    }
  }
}

export default MovieView;
