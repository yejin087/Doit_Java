import { Component } from "react";

class PhoneInfo extends Component {
  render() {
    const { id, name, phone } = this.props.info;
    const style = {
      border: "1px solid black",
      padding: "8px",
      margin: "8px",
    };
    return (
      <div style={style}>
        <h4>PhoneInfo Component</h4>
        <div>Id : {id}</div>
        <div>Name : {name}</div>
        <div>Tel : {phone}</div>
        <button>del</button>
      </div>
    );
  }
}

export default PhoneInfo;
