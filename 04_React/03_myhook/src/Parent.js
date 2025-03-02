import Child from "./Child";
import Food from "./Food";

const Parent = () => {
  let comment = ["comment1", "comment2", "comment3"];

  const foodILike = [
    {
      id: 1,
      name: "Kimchi",
      image:
        "http://aeriskitchen.com/wp-content/uploads/2008/09/kimchi_bokkeumbap_02-.jpg",
      rating: 5,
    },
    {
      id: 2,
      name: "Samgyeopsal",
      image:
        "https://3.bp.blogspot.com/-hKwIBxIVcQw/WfsewX3fhJI/AAAAAAAAALk/yHxnxFXcfx4ZKSfHS_RQNKjw3bAC03AnACLcBGAs/s400/DSC07624.jpg",
      rating: 4.9,
    },
    {
      id: 3,
      name: "Bibimbap",
      image:
        "http://cdn-image.myrecipes.com/sites/default/files/styles/4_3_horizontal_-_1200x900/public/image/recipes/ck/12/03/bibimbop-ck-x.jpg?itok=RoXlp6Xb",
      rating: 5,
    },
    {
      id: 4,
      name: "Doncasu",
      image:
        "https://s3-media3.fl.yelpcdn.com/bphoto/7F9eTTQ_yxaWIRytAu5feA/ls.jpg",
      rating: 5,
    },
    {
      id: 5,
      name: "Kimbap",
      image:
        "http://cdn2.koreanbapsang.com/wp-content/uploads/2012/05/DSC_1238r-e1454170512295.jpg",
      rating: 5,
    },
  ];

  return (
    <div>
      <h3>child</h3>
      {comment.map((com, index) => {
        return <Child comment={com} key={index} />;
      })}
      <h3>Food Likes</h3>
      {foodILike.map((foodItem, index) => (
        <Food foodItem={foodItem} key={index} />
      ))}
    </div>
  );
};

export default Parent;
