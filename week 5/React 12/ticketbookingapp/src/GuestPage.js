import React from "react";

function GuestPage(props) {

    return (

        <div style={{ marginLeft: "180px", marginTop: "100px" }}>

            <h1>Please sign up.</h1>

            <button onClick={props.login}>
                Login
            </button>

        </div>

    );

}

export default GuestPage;