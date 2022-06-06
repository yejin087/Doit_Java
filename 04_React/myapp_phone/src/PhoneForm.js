import { Component } from "react";

class PhoneForm extends Component {
  state = {
    name: "",
    phone: "",
  };

  handleSubmit = (e) => {
    e.preventDefault();
    this.props.onCreate(this.state);
    this.setState({
      name: "",
      phone: "",
    });
  };

  //name, phone 입력시 호출
  handleChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    });
  };

  render() {
    return (
      <div>
        <h3>PhoneForm Component</h3>
        <form onSubmit={this.handleSubmit}>
          <input
            type="text"
            name="name"
            placeholder="name"
            onChange={this.handleChange}
            value={this.state.name}
          />
          <input
            type="text"
            name="phone"
            placeholder="phone"
            onChange={this.handleChange}
            value={this.state.phone}
          />
          <button type="submit">submit</button>
        </form>
      </div>
    );
  }
}

export default PhoneForm;
