import { Card } from "react-bootstrap";

const MovieView = ({ location }) => {
  // const { year, title, summary, poster, genres } = props.location.state;
  const { year, title, summary, poster, genres } = location.state;

  if (location.state) {
    return (
      <Card style={{ width: "18rem" }}>
        <Card.Img src={poster} alt={title} titlie={title} />
        <Card.Body>
          <Card.Title>{title}</Card.Title>
          <Card.Text>{year}</Card.Text>
          <ul style={{ width: "18rem" }}>
            {genres.map((genre, index) => (
              <li key={index}>{genre}</li>
            ))}
          </ul>
          <Card.Text>{summary}...</Card.Text>
        </Card.Body>
      </Card>
    );
  } else {
    return null;
  }
};

export default MovieView;
