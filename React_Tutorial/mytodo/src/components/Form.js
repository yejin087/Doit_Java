import "./Form.css";
const Form = ({ value, onKeyPress, onChange, onCreate }) => {
  return (
    <div className="form">
      <input value={value} onChange={onChange} onKeyPress={onKeyPress} />
      <div className="create-button" onCreate={onCreate}>
        추가
      </div>
    </div>
  );
};

export default Form;
