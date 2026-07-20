import React, { useState } from "react";

function Register() {

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (event) => {

    event.preventDefault();

    if (name.length < 5) {
      alert("Name should have at least 5 characters.");
      return;
    }

    if (!email.includes("@") || !email.includes(".")) {
      alert("Enter a valid Email.");
      return;
    }

    if (password.length < 8) {
      alert("Password should have at least 8 characters.");
      return;
    }

    alert("Registration Successful");

    setName("");
    setEmail("");
    setPassword("");
  };

  return (

    <div className="container">

      <h1>Mail Registration</h1>

      <form onSubmit={handleSubmit}>

        <table>

          <tbody>

            <tr>
              <td>Name</td>
              <td>
                <input
                  type="text"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <td>Email</td>
              <td>
                <input
                  type="text"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <td>Password</td>
              <td>
                <input
                  type="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
              </td>
            </tr>

            <tr>
              <td></td>
              <td>
                <button type="submit">
                  Register
                </button>
              </td>
            </tr>

          </tbody>

        </table>

      </form>

    </div>

  );
}

export default Register;