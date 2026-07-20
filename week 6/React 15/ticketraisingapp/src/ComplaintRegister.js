import React, { useState } from "react";

function ComplaintRegister() {

    const [name, setName] = useState("");
    const [complaint, setComplaint] = useState("");

    const handleSubmit = (e) => {

        e.preventDefault();

        const transactionId = Math.floor(Math.random() * 100);

        alert(
            "Thanks " +
            name +
            "\nYour Complaint was Submitted.\nTransaction ID is: " +
            transactionId
        );

        setName("");
        setComplaint("");
    };

    return (

        <div className="container">

            <h1>Register your complaints here!!!</h1>

            <form onSubmit={handleSubmit}>

                <table>

                    <tbody>

                        <tr>

                            <td>Name:</td>

                            <td>

                                <input
                                    type="text"
                                    value={name}
                                    onChange={(e) => setName(e.target.value)}
                                    required
                                />

                            </td>

                        </tr>

                        <tr>

                            <td>Complaint:</td>

                            <td>

                                <textarea
                                    rows="3"
                                    value={complaint}
                                    onChange={(e) => setComplaint(e.target.value)}
                                    required
                                ></textarea>

                            </td>

                        </tr>

                        <tr>

                            <td></td>

                            <td>

                                <button type="submit">
                                    Submit
                                </button>

                            </td>

                        </tr>

                    </tbody>

                </table>

            </form>

        </div>

    );
}

export default ComplaintRegister;