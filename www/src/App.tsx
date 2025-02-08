import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import PokemonInTeam from "./components/PokemonInTeam";

function App() {
  const [count, setCount] = useState(0);

  const [team, setTeam] = useState([
    { name: "Pikachu" },
    { name: "Chandelure" },
    { name: "Charizard" },
    { name: "Blastoiser" },
    { name: "Entei" },
    { name: "Eevee" },
  ]);

  return (
    <div className="container">
      <div className="left-part">
        {team.map((pokemon) => (
          <PokemonInTeam key={pokemon.name} name={pokemon.name} />
        ))}
      </div>
      <div className="middle-part">
        <div>
          <h1>Choose your starter</h1>
        </div>
        <div></div>
        <div>
          <button>Open all</button>
        </div>
      </div>
      <div className="right-part">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>
    </div>
  );
}

export default App;
