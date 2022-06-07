import { useEffect, useState } from "react";
import axios from "axios";
import "react-bootstrap";
import Movie from "../components/Movie";
import "bootstrap/dist/css/bootstrap.min.css";
import { Col, Container, Row, Spinner } from "react-bootstrap";

function Home() {
  const [movies, setMovies] = useState([]);
  const [isLoading, setLoading] = useState(true);

  const getMovies = () => {
    axios
      .get("https://yts-proxy.now.sh/list_movies.json?sort_by=rating")
      .then((res) => {
        setMovies(res.data.data.movies);
        setLoading(false);
      });
  };

  // componentDidMount, didUpdate의 기능을 가진
  useEffect(() => {
    getMovies();
  }, []);

  return (
    <Container>
      {isLoading ? (
        <Spinner animation="border" role="status">
          <span className="visually-hidden"> Loading ..</span>
        </Spinner>
      ) : (
        <Row>
          {movies.map((movie, index) => {
            return (
              <Col key={index} md={4}>
                <Movie
                  key={index}
                  id={movie.id}
                  year={movie.year}
                  title={movie.title}
                  summary={movie.summary}
                  poster={movie.medium_cover_image}
                  genres={movie.genres}
                />
              </Col>
            );
          })}
        </Row>
      )}
    </Container>
  );
}

export default Home;
