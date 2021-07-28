import axios from "axios";

export const fetchData = (url, headers = null) => {
  return axios
    .get(url, { headers: headers })
    .then((result) => result)
    .catch((error) => console.log(error));
};

export const postData = (url, data, headers = null) => {
  return axios
    .post(url, data, { headers: headers })
    .then((result) => result)
    .catch((error) => console.log(error));
};

export const deleteData = (url, headers = null) => {
  return axios
    .delete(url, { headers: headers })
    .then((result) => result)
    .catch((error) => console.log(error));
};
