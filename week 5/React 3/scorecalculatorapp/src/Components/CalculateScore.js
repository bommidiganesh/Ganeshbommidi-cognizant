import React from "react";
import "../Stylesheets/mystyle.css";

function CalculateScore(props) {

    const score = ((props.Total / 300) * 100).toFixed(2);

    return (
        <div className="App">
            <h1>Student Details:</h1>

            <h3 className="blue">
                Name: <span>{props.Name}</span>
            </h3>

            <h3 className="red">
                School: <span>{props.School}</span>
            </h3>

            <h3 className="brown">
                Total: <span>{props.Total}Marks</span>
            </h3>

            <h3 className="green">
                Score:{score}%
            </h3>
        </div>
    );
}

export default CalculateScore;