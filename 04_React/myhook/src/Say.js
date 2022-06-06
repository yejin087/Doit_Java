import { useState } from "react";

const Say = () => {
  const [message, setMessage] = useState("안녕"); // default value of message
  const [color, setColor] = useState("");

  const onClickEnter = () => {
    setMessage("반갑습니다");
    setColor("red");
  };
  const onClickLeave = () => {
    setMessage("안녕히가세요");
    setColor("blue");
  };

  const onChangeColor = (color) => {
    setColor(color);
  };

  const clickColor = () => {
    setColor("blue");
  };
  return (
    <div>
      <button value="enter" onClick={onClickEnter}>
        입장
      </button>
      <button value="exit" onClick={onClickLeave}>
        퇴장
      </button>
      <h1 style={{ color }}>{message}</h1>
      <button onClick={() => onChangeColor("red")}>red</button>
      {/* 클릭하기 전에  함수 불러서 무한 루프 , onChangeColor("red")가 이미 실행 함수*/}
      {/* <button onClick={onChangeColor("red")}>red</button> */}
      <button onClick={clickColor}>blue</button>
    </div>
  );
};

export default Say;
