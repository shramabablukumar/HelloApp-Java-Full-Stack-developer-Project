import React from "react";

const GreetingForm = ({ message, setMessage, onSubmit, editingId, cancelEdit }) => (
  <form onSubmit={onSubmit}>
    <input
      type="text"
      value={message}
      placeholder="Enter greeting"
      onChange={(e) => setMessage(e.target.value)}
      style={{ width: "70%", padding: 8 }}
    />
    <button type="submit" style={{ marginLeft: 8 }}>
      {editingId ? "Update" : "Add"}
    </button>
    {editingId && (
      <button type="button" onClick={cancelEdit} style={{ marginLeft: 8 }}>
        Cancel
      </button>
    )}
  </form>
);

export default GreetingForm;
