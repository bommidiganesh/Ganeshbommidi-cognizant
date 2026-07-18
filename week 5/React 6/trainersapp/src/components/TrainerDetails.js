import { useParams } from "react-router-dom";
import trainers from "../data/TrainersMock";

function TrainerDetails() {
  const { id } = useParams();

  const trainer = trainers.find(
    (t) => t.id === Number(id)
  );

  return (
    <div>
      <h2>Trainers Details</h2>

      <h4>
        {trainer.name} ({trainer.technology})
      </h4>

      <p>{trainer.email}</p>

      <p>{trainer.phone}</p>

      <ul>
        {trainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
}

export default TrainerDetails;