import { Button, Card } from "react-bootstrap";
import { Link } from "react-router-dom";

function Movie({ id, year, title, summary, poster, genres }) {
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
        <Card.Text>{summary.slice(0, 180)}...</Card.Text>
        <Link
          to={{
            pathname: "/detail",
            state: { id, year, title, summary, poster, genres },
          }}
        >
          <Button variant="primary">View</Button>
        </Link>
      </Card.Body>
    </Card>
  );
}

export default Movie;
