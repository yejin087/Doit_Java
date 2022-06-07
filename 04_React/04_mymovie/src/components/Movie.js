import { Component } from "react";
import "./Movie.css";
import { Link } from "react-router-dom";

class Movie extends Component {
  render() {
    const { year, title, summary, poster, genres } = this.props;
    return (
      <div className="movie">
        <Link
          to={{
            pathname: "/movie-view",
            state: { year, title, summary, poster, genres },
          }}
        >
          <img src={poster} alt={title} titlie={title} />
          <div className="movie__data">
            <h3 className="movie__title">{title}</h3>
            <h3 className="movie__year">{year}</h3>
            <ul className="movie__genres">
              {genres.map((genre, index) => {
                return (
                  <li key={index} className="movie__genre">
                    {genre}
                  </li>
                );
              })}
            </ul>
            <p className="movie__summary">{summary.slice(0, 180)}...</p>
          </div>
        </Link>
      </div>
    );
  }
}

export default Movie;
