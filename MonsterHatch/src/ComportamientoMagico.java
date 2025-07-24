public class ComportamientoMagico implements EstrategiaBatalla{
    private final int costeMana; //Valor para la cantida de mana necesaria por hechizo.
    private final int poderMagico; //Daño que causa el hechizo lanzado.

    public ComportamientoMagico(int costeMana, int poderMagico) {
        this.costeMana = costeMana;
        this.poderMagico = poderMagico;
    }

 @Override
    public void actuar(Pokemon pokemon, Pokemon enemigo) {
        if (pokemon instanceof CategoriaMagica) {  //Ayuda a verifica si el pokemon es de CategoriaMagica.
            CategoriaMagica categoriaMagica = (CategoriaMagica) pokemon;
            if (categoriaMagica.usarMana(costeMana)) {  //Accion de consumir el valor del mana para realizar hechizo y causar daño.
                int daño = categoriaMagica.getAtaque() + poderMagico + (int)(Math.random()*8);
                System.out.println(categoriaMagica.getNombre() + " procede a lanzar un hechizo poderoso causando " + daño + " puntos de daño a " + enemigo.getNombre());
                enemigo.reducirVida(daño);
            } else { //Llegado el caso si la criatura ya no tiene suficiente mana, entonces le da un puñetazo.
                System.out.println(pokemon.getNombre() + " no tiene suficiente mana para lanzar hechizos, pero no se ha quedo sin opciones, entonces a realizado un ataque basico.");
                new ComportamientoAgresivo().actuar(pokemon, enemigo);
            }
        } else {  //Si por casualidad se da el comportamiento a una criatura que no es mágica, entonces esta realiza un ataque muy débil.
            System.out.println(pokemon.getNombre() + " no es de Categoria Magica, no tiene el conocimiento para usar esta estrategia.");
            int daño = pokemon.getAtaque() / 2;
            enemigo.reducirVida(daño);
            System.out.println(pokemon.getNombre() + " intenta imitar un hechizo, pero sin el conocimiento suficiente solo causa " + daño + " puntos de daño");
        }
    }
}
