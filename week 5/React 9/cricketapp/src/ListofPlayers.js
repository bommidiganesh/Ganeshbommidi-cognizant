import React from "react";

export function ListofPlayers({ players }) {
  return (
    <ul>
      {players.map((player, index) => (
        <li key={index}>
          Mr. {player.name} {player.score}
        </li>
      ))}
    </ul>
  );
}