import React, { useState } from "react";

const InputTest = () => {
  const [text, setText] = useState("");
  const textChange = (e) => {
    setText(e.target.value);
  };
  const onReset = () => {
    setText("");
  };

  return (
    <div>
      <input value={text} onChange={textChange} />
      <button onClick={onReset}>초기화</button>
      <div>
        <b>text : {text}</b>
      </div>
    </div>
  );
};

export default InputTest;
