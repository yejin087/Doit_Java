import { useState } from "react";

const Counter = () => {
  const [count, setCount] = useState(0);

  const onChangeCount = (num) => {
    setCount(count + num);
  };

  return (
    <div>
      <button onClick={() => onChangeCount(+1)}>+1</button>
      <button onClick={() => onChangeCount(-1)}>-1</button>
      {count}
    </div>
  );
};

export default Counter;
