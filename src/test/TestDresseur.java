package test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;

import libtest.*;

import application.Arene;
import application.Dresseur;
import application.Poquemont;

/**
 * classe de test de la classe Dresseur
 */
public class TestDresseur {
	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestDresseur(), args);
	}

	/**
	 * test appels methodes
	 */
	@Test
	public void test_appelMethodes() {
		Arene env = new Arene();
		Dresseur d = new Dresseur(env);
		Dresseur dresseur = new Dresseur("Dresseur1", 0, 0, env);
		Dresseur dresseur2 = new Dresseur("Dresseur2", 0, 0, env);
		Poquemont o = new Poquemont(1, 1, 2, 3, env);
		boolean res = false;

		// on appelle les methodes de dresseur
		res = dresseur.prendrePoquemont(o);
		res = dresseur.attaquer(dresseur2);
		res = dresseur.deposerPoquemont();
		res = dresseur.etreBlesse();
		dresseur.seDeplacer(2, 0);
		String n = dresseur.getNom();
		Poquemont o2 = dresseur.getPoquemontDresse();
		int pos = dresseur.getPosX();
		int posY = dresseur.getPosY();
		int pv = dresseur.getPv();
		assertEquals("devrait avoir 5pv", 5, pv);

		dresseur.subirDegats(1);
		Arene a=dresseur.getArene();
	}

	/**
	 * test constructeur vide
	 */
	@Test
	public void test_constructeurVide() {
		Arene arene = new Arene();
		Dresseur d = new Dresseur(arene);

		assertEquals("nom defaut", "Sacha", d.getNom());
		assertEquals("pv defaut", 5, d.getPv());
		assertEquals("posX defaut", 0, d.getPosX());
		assertEquals("posY defaut", 0, d.getPosY());
		assertEquals("pas de poquemont par defaut", null, d.getPoquemontDresse());
	}

	/**
	 * cas normal
	 */
	@Test
	public void test_constructeur_normal() {
		Arene arene = new Arene();
		Dresseur d = new Dresseur("toto", 1, 2, arene);

		assertEquals("nom defaut", "toto", d.getNom());
		assertEquals("pv defaut", 5, d.getPv());
		assertEquals("posX defaut", 1, d.getPosX());
		assertEquals("posY defaut", 2, d.getPosY());
		assertEquals("pas de poquemont par defaut", null, d.getPoquemontDresse());
	}

	// TODO a completer

}
