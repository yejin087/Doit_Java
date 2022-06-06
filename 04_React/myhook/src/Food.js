const Food = ({ foodItem }) => {
  const { id, name, image, rating } = foodItem;

  return (
    <div>
      <div>
        <h3>{id}</h3>
        <p>
          {name} / {rating}
        </p>
        <img src={image} alt={name} width="150" />
      </div>
    </div>
  );
};

export default Food;
