import axios from "axios";
import { useEffect, useState } from "react";
import BoardForm from "./BoardForm";
import BoardList from "./BoardList";

function App() {
  const [listContent, setListContent] = useState([]);

  useEffect(() => {
    listBoard();
  }, []);

  const listBoard = () => {
    axios.get("/api/list").then((resp) => {
      setListContent(resp.data);
    });
  };

  const deleteBoard = (selectednum) => {
    // // const { newList }로 하면 안된다 ??

    const newList = listContent.filter((item) => item.num !== selectednum);
    setListContent(newList);

    console.log(selectednum);
    // axios.delete("/api/delete/" + selectednum).then(() => {
    //   console.log(selectednum);
    //   listBoard();
    //   alert("삭제 성공");
    // });
    axios.delete("/api/delete", { data: { num: selectednum } }).then(() => {
      console.log(selectednum);
      listBoard();
      alert("삭제 성공");
    });
  };

  return (
    <div>
      <h1>Simple Board</h1>
      <BoardForm listBoard={listBoard} />
      <BoardList listContent={listContent} onRemove={deleteBoard} />
    </div>
  );
}

export default App;
