import React from "react";
const GreetingList = ({ greetings, onEdit, onDelete }) => (
  <ul style={{ listStyle: "none", padding: 0, marginTop: 20 }}>
    {greetings.length === 0 && <li>No greetings yet</li>}
    {greetings.map((greeting) => (
      <li
        key={greeting.id}
        style={{
          marginBottom: 10,
          padding: 10,
          border: "1px solid #ccc",
          borderRadius: 4,
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
        }}
      >
        <span>{greeting.message}</span>
        <div>
          <button onClick={() => onEdit(greeting)} style={{ marginRight: 8 }}>
            Edit
          </button>
          <button onClick={() => onDelete(greeting.id)}>Delete</button>
        </div>
      </li>
    ))}
  </ul>
);

export default GreetingList;
