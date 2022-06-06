import { Component } from "react";
import PhoneForm from "./PhoneForm";
import PhoneList from "./PhoneInfoList";

class App extends Component {
  //Class 형에서 사용할 수 있는 변수 id, state

  id = 2;
  state = {
    information: [
      {
        id: 0,
        name: "hong",
        phone: "010-2222-2222",
      },
      {
        id: 1,
        name: "lee",
        phone: "010-3333-3333",
      },
    ],
  };

  // 기존 값에 추가
  handleCreate = (data) => {
    console.log(data);
    const { information } = this.state; // 기존의 값
    this.setState({
      information: information.concat({ id: this.id++, ...data }),
    });
  };

  render() {
    return (
      <div>
        <PhoneForm onCreate={this.handleCreate} />
        <PhoneList data={this.state.information} />
      </div>
    );
  }
}

export default App;
