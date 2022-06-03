import axios from "axios";
import { Component } from "react";
import Movie from "../components/Movie";
import About from "./About";
import "./Home.css";

class Home extends Component {
  state = {
    movies: [],
    isLoading: true,
  };

  getMovies = async () => {
    const {
      data: {
        data: { movies },
      },
    } = await axios.get(
      "https://yts-proxy.now.sh/list_movies.json?sort_by=rating"
    );

    this.setState({ movies, isLoading: false });
  };

  componentDidMount() {
    this.getMovies();
  }

  render() {
    const { movies, isLoading } = this.state;

    return (
      <div>
        {isLoading ? (
          <div className="loader">
            <span className="loader__text">"isLoading.."</span>
          </div>
        ) : (
          <div className="movies">
            <About></About>
            {movies.map((movie, index) => {
              return (
                <Movie
                  key={index}
                  id={movie.id}
                  year={movie.year}
                  title={movie.title}
                  summary={movie.summary}
                  poster={movie.medium_cover_image}
                  genres={movie.genres}
                />
              );
            })}
          </div>
        )}
      </div>
    );
  }
}

export default Home;
