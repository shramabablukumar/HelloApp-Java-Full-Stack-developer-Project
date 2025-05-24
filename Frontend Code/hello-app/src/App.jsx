import React, { useEffect, useState } from "react";
import GreetingForm from "./Components/GreetingForm";
import GreetingList from "./Components/GreetingList";
import {
  getAllGreetings,
  createGreeting,
  updateGreeting,
  deleteGreeting,
} from "./Services/greetingServices";
import "./App.css";

const App = () => {
  const [greetings, setGreetings] = useState([]);
  const [message, setMessage] = useState("");
  const [editingId, setEditingId] = useState(null);

  useEffect(() => {
    loadGreetings();
  }, []);

  const loadGreetings = () => {
    getAllGreetings().then(setGreetings).catch(console.error);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!message.trim()) return;

    const greeting = { message };

    if (editingId) {
      updateGreeting(editingId, greeting).then(() => {
        resetForm();
        loadGreetings();
      });
    } else {
      createGreeting(greeting).then(() => {
        resetForm();
        loadGreetings();
      });
    }
  };

  const handleDelete = (id) => {
    if (window.confirm("Are you sure?")) {
      deleteGreeting(id).then(loadGreetings);
    }
  };

  const handleEdit = (greeting) => {
    setMessage(greeting.message);
    setEditingId(greeting.id);
  };

  const resetForm = () => {
    setMessage("");
    setEditingId(null);
  };

  return (
    <div className="app">
      <h1>Hello App</h1>
      <GreetingForm
        message={message}
        setMessage={setMessage}
        onSubmit={handleSubmit}
        editingId={editingId}
        cancelEdit={resetForm}
      />
      <GreetingList
        greetings={greetings}
        onEdit={handleEdit}
        onDelete={handleDelete}
      />
    </div>
  );
};

export default App;
