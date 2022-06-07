import axios from "axios";
import { useEffect, useState } from "react";
import BoardForm from "./BoardForm";

function App1() {
  const [formContent, setFormContent] = useState({
    title: "",
    content: "",
  });

  const [listContent, setListContent] = useState([]);

  // 제목과 내용을 가지고 /api/insert => simpleboard table에 추가
  const submitBoard = () => {
    axios
      .post("/api/insert", {
        title: formContent.title,
        content: formContent.content,
      })
      .then(() => {
        alert("등록 완료");
        listBoard();
      });
  };

  const getValue = (e) => {
    setFormContent({ ...formContent, [e.target.name]: e.target.value });
    console.log(formContent);
  };

  const listBoard = () => {
    axios.get("/api/list").then((resp) => {
      setListContent(resp.data);
    });
  };

  useEffect(() => {
    listBoard();
  }, []);

  return (
    <div>
      <h1>Simple Board</h1>
      <div>
        <input
          type="text"
          name="title"
          placeholder="제목"
          onChange={getValue}
        />
        <br />
        <textarea
          name="content"
          row="5"
          col="50"
          onChange={getValue}
        ></textarea>
        <br />
        <button onClick={submitBoard}>입력</button>
        <button onClick={listBoard}>전체보기</button>
      </div>
      <hr />
      <div>
        {listContent.map((board, index) => {
          return (
            <div key={index}>
              번호 : {board.num} <br />
              제목 : {board.title} <br />
              내용 : {board.content} <br />
              <br />
            </div>
          );
        })}
      </div>
    </div>
  );
}

export default App1;
