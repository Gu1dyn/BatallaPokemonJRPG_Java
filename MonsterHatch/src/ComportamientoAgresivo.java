public class ComportamientoAgresivo implements EstrategiaBatalla{
    @Override
    public void actuar(Pokemon pokemon, Pokemon enemigo){
        int daño = pokemon.getAtaque() + (int)(Math.random()*5);
        enemigo.reducirVida(daño);
        System.out.println(pokemon.getNombre() + "ataca violentamente causando " + daño +
        " puntos de daño a " + enemigo.getNombre());
    }
}
