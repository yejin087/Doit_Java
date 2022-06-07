import { Component } from "react";

class InputTest2 extends Component {
  state = {
    text: "",
  };

  textChange = (e) => {
    this.setState({ text: e.target.value });
  };

  onReset = () => {
    this.setState({
      text: "",
    });
  };

  render() {
    return (
      <div>
        <input value={this.state.text} onChange={this.textChange} />
        <button onClick={this.onReset}>초기화</button>
        <div>
          <b>text : {this.state.text} </b>
        </div>
      </div>
    );
  }
}

export default InputTest2;
