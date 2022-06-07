import BoardItem from "./BoardItem";

function BoardList({ listContent, onRemove }) {
  return (
    <div>
      {listContent &&
        listContent.map((board, index) => {
          return (
            <BoardItem key={board.num} board={board} onRemove={onRemove} />
          );
        })}
    </div>
  );
}

export default BoardList;
