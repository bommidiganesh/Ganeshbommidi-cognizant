import React from "react";
import "./App.css";

function App() {

    const officeList = [

        {
            id: 1,
            name: "Tech Park",
            rent: 55000,
            address: "Chennai"
        },

        {
            id: 2,
            name: "DLF Cyber City",
            rent: 80000,
            address: "Hyderabad"
        },

        {
            id: 3,
            name: "RMZ Eco World",
            rent: 45000,
            address: "Bangalore"
        },

        {
            id: 4,
            name: "Tidel Park",
            rent: 70000,
            address: "Chennai"
        }

    ];

    return (

        <div className="container">

            <h1>Office Space Rental App</h1>

            <img
                src="/office.jpg"
                alt="Office Space"
                width="500"
                height="300"
            />

            <br />
            <br />

            {
                officeList.map((office) => (

                    <div className="card" key={office.id}>

                        <h2>{office.name}</h2>

                        <p>
                            <b>Rent : </b>

                            <span
                                style={{
                                    color:
                                        office.rent < 60000
                                            ? "red"
                                            : "green"
                                }}
                            >
                                ₹{office.rent}
                            </span>

                        </p>

                        <p>

                            <b>Address : </b>

                            {office.address}

                        </p>

                    </div>

                ))
            }

        </div>

    );
}

export default App;