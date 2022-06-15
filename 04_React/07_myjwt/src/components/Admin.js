import { useEffect, useState } from "react";
import UserService from "../services/User-Service";

const Admin = () => {
  const [content, setContent] = useState("");

  useEffect(() => {
    UserService.getAdmin().then(
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

export default Admin;
