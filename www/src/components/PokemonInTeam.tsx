interface PokemonInfo {
  name: string;
}

const PokemonInTeam = ({ name }: PokemonInfo) => {
  return (
    <div className="pokemon-in-team">
      <button> {name}</button>
    </div>
  );
};

export default PokemonInTeam;
