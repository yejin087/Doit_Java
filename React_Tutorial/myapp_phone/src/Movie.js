import { Component } from "react";

class Movie extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div>
        <h3>Movie Component </h3>
        <div>{this.props.title}</div>
      </div>
    );
  }
}

export default Movie;
