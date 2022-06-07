function BoardItem({ board, onRemove }) {
  return (
    <div>
      번호 : {board.num} <br />
      제목: {board.title} <br />
      내용 : {board.content} <br />
      <button
        onClick={(e) => {
          e.stopPropagation();
          onRemove(board.num);
        }}
      >
        삭제
      </button>
      <br />
    </div>
  );
}
export default BoardItem;
