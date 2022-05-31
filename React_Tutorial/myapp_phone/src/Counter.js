import { Component } from "react";

//Class Component
class Counter extends Component {
  // props : parent Componet로 부터 받아오는 값
  constructor(props) {
    super(props);
    // Counter에서 사용하는 값
    this.state = {
      count: 0,
    };

    // 생성자에서 선언한 function을 bind 한다.
    // 만약 ->를 사용하면 bind 작업을 하지 않아도 된다
    this.increaseCount = this.increaseCount.bind(this);
    this.decreaseCount = this.decreaseCount.bind(this);
  }

  increaseCount() {
    this.setState(({ count }) => {
      return { count: count + 1 };
    });
  }

  decreaseCount() {
    this.setState(({ count }) => ({ count: count - 1 }));
  }

  // Class는 render function을 가지고 있어야한다
  render() {
    return (
      // root Component를 가지고 있어야한다?
      <div>
        <div>Count Component / Count {this.state.count}</div>
        <button onClick={this.increaseCount}>Count up</button>
        <button onClick={this.decreaseCount}>Count down</button>
      </div>
    );
  }
}

export default Counter;
