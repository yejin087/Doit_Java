import { useState } from "react";
import axios from "axios";
function BoardForm({ listBoard }) {
  const [formContent, setFormContent] = useState({
    title: "",
    content: "",
  });

  // 제목과 내용을 가지고 /api/insert => simpleboard table에 추가
  const submitBoard = () => {
    axios
      .post("/api/insert", {
        title: formContent.title,
        content: formContent.content,
      })
      .then(() => {
        alert("등록 완료");
        setFormContent({ title: "", content: "" });
        listBoard();
      });
  };
  const getValue = (e) => {
    setFormContent({ ...formContent, [e.target.name]: e.target.value });
    console.log(formContent);
  };

  return (
    <div>
      <input
        type="text"
        name="title"
        value={formContent.title}
        placeholder="제목"
        onChange={getValue}
      />
      <br />
      <textarea
        name="content"
        value={formContent.content}
        row="5"
        col="50"
        onChange={getValue}
      ></textarea>
      <br />
      <button onClick={submitBoard}>입력</button>
    </div>
  );
}

export default BoardForm;
