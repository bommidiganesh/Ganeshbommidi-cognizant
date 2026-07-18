import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

import Home from "./components/Home";
import TrainersList from "./components/TrainersList";
import TrainerDetails from "./components/TrainerDetails";

function App() {
  return (
    <BrowserRouter>

      <h1>My Academy Trainers App</h1>

      <Link to="/">Home</Link>
      {" | "}
      <Link to="/trainers">Show Trainers</Link>

      <hr />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<TrainersList />} />
        <Route path="/trainers/:id" element={<TrainerDetails />} />
      </Routes>

    </BrowserRouter>
  );
}

export default App;