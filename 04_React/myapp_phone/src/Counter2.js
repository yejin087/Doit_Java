import { Component } from "react";

class Counter2 extends Component {
  state = {
    myAge: 0,
  };

  // 구조 분해 ?
  decreaseCount = () => {
    this.setState(({ myAge }) => ({ myAge: myAge - 1 }));
    // this.setState((st) => ({ myAge: st.myAge - 1 }));
  };

  increaseCount = () => {
    this.setState((st) => ({ myAge: st.myAge + 1 }));
  };

  //  component class life cycle

  componentDidMount() {
    console.log("in componentDidMount");
  }

  // 변화가 있을 떄
  componentDidUpdate() {
    console.log("in componentdidUpdate");
  }

  componentWillUnmount() {
    console.log("in componentWillUnmount");
  }

  render() {
    return (
      <div>
        <h3>Counter class Component arrow fucntion</h3>
        <div> age : {this.state.myAge} </div>
        <button onClick={this.increaseCount}>increase</button>
        <button onClick={this.decreaseCount}>decrease</button>
      </div>
    );
  }
}

export default Counter2;
