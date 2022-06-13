import axios from "axios";

const API_URL = "http://localhost:7711/api/auth/";

const register = (username, email, password) => {
  return axios.post(API_URL + "signup", { username, email, password });
};

const login = (username, password) => {
  return axios.post(API_URL + "signin", { username, password }).then((resp) => {
    console.log(resp);
    if (resp.data.token) {
      localStorage.setItem("user", JSON.stringify(resp.data));
    }

    return resp.data;
  });
};

const getCurrentUser = () => {
  console.log(">>", JSON.parse(localStorage.getItem("user")));
  return JSON.parse(localStorage.getItem("user"));
};
const logout = () => {
  localStorage.removeItem("user");
};

export default {
  register,
  login,
  logout,
  getCurrentUser,
};
