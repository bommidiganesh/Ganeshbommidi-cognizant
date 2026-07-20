import React from "react";

function UserPage(props) {

    return (

        <div style={{ marginLeft: "180px", marginTop: "100px" }}>

            <h1>Welcome User</h1>

            <h3>You can now book your tickets.</h3>

            <button onClick={props.logout}>
                Logout
            </button>

        </div>

    );

}

export default UserPage;