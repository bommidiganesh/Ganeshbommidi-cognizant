import React from "react";
import CalculateScore from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        Name="Steeve"
        School="DNV Public School"
        Total={284}
      />
    </div>
  );
}

export default App;