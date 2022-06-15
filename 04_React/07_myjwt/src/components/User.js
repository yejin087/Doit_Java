import { useEffect, useState } from "react";
import UserService from "../services/User-Service";

const User = () => {
  const [content, setContent] = useState("");

  useEffect(() => {
    UserService.getUser().then(
      (response) => {
        setContent(response.data);
      },
      (error) => {
        setContent(error.code);
      }
    );
  }, []);

  return <div>{content}</div>;
};

export default User;
