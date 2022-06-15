import axios from "axios";
import authHeader from "./Auth-Header";

const API_URL = "http://localhost:7711/api/test/";

const getPublicContent = () => {
  return axios.get(API_URL + "all");
};

const getUser = () => {
  return axios.get(API_URL + "user", { headers: authHeader() });
};

const getManager = () => {
  return axios.get(API_URL + "manager", { headers: authHeader() });
};

const getAdmin = () => {
  return axios.get(API_URL + "admin", { headers: authHeader() });
};

export default {
  getPublicContent,
  getUser,
  getManager,
  getAdmin,
};
