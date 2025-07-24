public class ComportamientoDefensivo implements EstrategiaBatalla{
    @Override
    public void actuar(Pokemon pokemon, Pokemon enemigo){
        int escudo = 5 + (int)(Math.random()*5);
        pokemon.aumentarDefensa(escudo);
        System.out.println(pokemon.getNombre() + " refuerza su defensa aumentando su " +
        "escudo en " + escudo + " puntos");
    }
}
