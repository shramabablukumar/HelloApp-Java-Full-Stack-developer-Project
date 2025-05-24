const API_URL = "http://localhost:8080/api/greetings";

export const getAllGreetings = () => fetch(API_URL).then((res) => res.json());

export const createGreeting = (greeting) =>
  fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(greeting),
  }).then((res) => res.json());

export const updateGreeting = (id, greeting) =>
  fetch(`${API_URL}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(greeting),
  }).then((res) => res.json());

export const deleteGreeting = (id) =>
  fetch(`${API_URL}/${id}`, {
    method: "DELETE",
  });
