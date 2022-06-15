import { useEffect, useState } from "react";
import UserService from "../services/User-Service";

const Manager = () => {
  const [content, setContent] = useState("");

  useEffect(() => {
    UserService.getManager().then(
      (response) => {
        console.log("@@", response.data);
        setContent(response.data);
      },
      (error) => {
        setContent(error.code);
      }
    );
  }, []);

  return <div>{content}</div>;
};

export default Manager;
