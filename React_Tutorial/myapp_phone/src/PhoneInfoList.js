import { Component } from "react";
import PhoneInfo from "./PhoneInfo";

class PhoneList extends Component {
  render() {
    const { data } = this.props;

    return (
      <div>
        <h3>PhoenList Component</h3>
        {data.map((info) => {
          return <PhoneInfo key={info.id} info={info} />;
        })}
      </div>
    );
  }
}

export default PhoneList;
