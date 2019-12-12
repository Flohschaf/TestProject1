package pp2013.gruppe07.client.gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import pp2013.gruppe07.shared.entity.Building;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Monster;
import pp2013.gruppe07.shared.entity.Nature;
import pp2013.gruppe07.shared.entity.Vasall;
import pp2013.gruppe07.shared.ground.Ground;

/**
 * In dieser Klasse werden zu Beginn des Spiels alle Bilder geladen und gespeichert. Uber eine HashmMap sind diese immer sehr einfach zugaenglich.
 * @author Felix
 * 
 */
public class Images {

	public static HashMap<Ground.Groundtype, Image[]> grounds;
	public static HashMap<Hero.Heronames, Image[]> heroes;
	public static HashMap<Building.Type, Image[]> buildings;
	public static HashMap<Nature.Type, Image[]> nature;
	public static HashMap<Monster.Type, Image[]> monsters;
	public static HashMap<Vasall.Type, Image[]> vasalls;

	public static void init() {

		grounds = new HashMap<Ground.Groundtype, Image[]>();
		heroes = new HashMap<Hero.Heronames, Image[]>();
		buildings = new HashMap<Building.Type, Image[]>();
		monsters = new HashMap<Monster.Type, Image[]>();
		nature = new HashMap<Nature.Type, Image[]>();
		vasalls = new HashMap<Vasall.Type, Image[]>();

		Image[] grass = {
				Toolkit.getDefaultToolkit().getImage("Images/graswege.gif"),
				Toolkit.getDefaultToolkit().getImage("Images/waldnebel.png") };

		Image[] sand = {
				Toolkit.getDefaultToolkit().getImage("Images/Sand.gif"),
				Toolkit.getDefaultToolkit().getImage("Images/sandnebel.png") };

		Image[] stone = {
				Toolkit.getDefaultToolkit().getImage("Images/stonenew.gif"),
				Toolkit.getDefaultToolkit().getImage("Images/steinnebel.png") };

		Image[] junglePath = {
				Toolkit.getDefaultToolkit().getImage("Images/gras.gif"),
				Toolkit.getDefaultToolkit().getImage("Images/grasnebel.png") };

		Image[] wallGround = {
				Toolkit.getDefaultToolkit().getImage("Images/stonenew.gif"),
				Toolkit.getDefaultToolkit().getImage("Images/steinnebel.png") };

		Image[] water = {
				Toolkit.getDefaultToolkit().getImage("Images/water.gif"),
				Toolkit.getDefaultToolkit().getImage("Images/wassernebel.png") };

		grounds.put(Ground.Groundtype.GRASS, grass);
		grounds.put(Ground.Groundtype.SAND, sand);
		grounds.put(Ground.Groundtype.STONE, stone);
		grounds.put(Ground.Groundtype.JUNGLEPATH, junglePath);
		grounds.put(Ground.Groundtype.WALLGROUND, wallGround);
		grounds.put(Ground.Groundtype.WATER, water);

		Image[] captainObvious = {
				Toolkit.getDefaultToolkit().getImage("Images/Captainklein.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Captaingross.png"),
				Toolkit.getDefaultToolkit().getImage(
						"Images/Captainkleinlinks.png") };

		Image[] clitComander = {
				Toolkit.getDefaultToolkit().getImage("Images/Jayklein.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Jaygross.png"),
				Toolkit.getDefaultToolkit()
						.getImage("Images/Jaykleinlinks.png") };

		Image[] dangerDan = {
				Toolkit.getDefaultToolkit().getImage(
						"Images/DangerDanklein.png"),
				Toolkit.getDefaultToolkit().getImage(
						"Images/Dangerdangross.png"),
				Toolkit.getDefaultToolkit().getImage(
						"Images/DangerDankleinlinks.png") };

		Image[] famousFlorian = {
				Toolkit.getDefaultToolkit().getImage("Images/Floklein.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Flogross.png"),
				Toolkit.getDefaultToolkit()
						.getImage("Images/Flokleinlinks.png") };

		Image[] federalFelix = {
				Toolkit.getDefaultToolkit().getImage(
						"Images/Felixkleinlinks.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Felixgross.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Felixklein.png") };

		Image[] generalHate = {
				Toolkit.getDefaultToolkit().getImage(
						"Images/Generalkleinlinks.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Genrealgross.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Generalklein.png") };

		Image[] safetySteven = {
				Toolkit.getDefaultToolkit().getImage("Images/Stevenklein.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Stevengross.png"),
				Toolkit.getDefaultToolkit().getImage(
						"Images/Stevenkleinlinks.png") };

		Image[] seriousSven = {
				Toolkit.getDefaultToolkit().getImage("Images/svenlinks.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Svengross.png"),
				Toolkit.getDefaultToolkit().getImage("Images/sven.png") };

		Image[] empty = {
				Toolkit.getDefaultToolkit().getImage("Images/Captainklein.png"),
				Toolkit.getDefaultToolkit().getImage("Images/emty.png") };

		heroes.put(Hero.Heronames.CAPTAIN_OBVIOUS, captainObvious);
		heroes.put(Hero.Heronames.CLIT_COMANDER, clitComander);
		heroes.put(Hero.Heronames.DANGER_DAN, dangerDan);
		heroes.put(Hero.Heronames.FAMOUS_FLORIAN, famousFlorian);
		heroes.put(Hero.Heronames.FEDERAL_FELIX, federalFelix);
		heroes.put(Hero.Heronames.GENERAL_HATE, generalHate);
		heroes.put(Hero.Heronames.SAFETY_STEVEN, safetySteven);
		heroes.put(Hero.Heronames.SERIOUS_SVEN, seriousSven);
		heroes.put(Hero.Heronames.EMPTY, empty);

		Image[] inhibitor = {
				Toolkit.getDefaultToolkit().getImage("Images/Inhibblue.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Inhibred.png") };

		Image[] nexus = {
				Toolkit.getDefaultToolkit().getImage("Images/Schlossblue.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Schlossred.png") };

		Image[] shop = {
				Toolkit.getDefaultToolkit().getImage("Images/Shopblue.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Shopred.png") };

		Image[] tower = {
				Toolkit.getDefaultToolkit().getImage("Images/Turmblue.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Turmred.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Towerhit.png") };

		buildings.put(Building.Type.INHIBITOR, inhibitor);
		buildings.put(Building.Type.NEXUS, nexus);
		buildings.put(Building.Type.SHOP, shop);
		buildings.put(Building.Type.TOWER, tower);

		Image[] tree = { Toolkit.getDefaultToolkit().getImage(
				"Images/Baumlaub.gif") };

		Image[] tree2 = { Toolkit.getDefaultToolkit().getImage(
				"Images/Baumnadel.gif") };

		Image[] wall = { Toolkit.getDefaultToolkit()
				.getImage("Images/wall.gif") };

		nature.put(Nature.Type.TREE, tree);
		nature.put(Nature.Type.TREE2, tree2);
		nature.put(Nature.Type.WALL, wall);

		Image[] boss = {
				Toolkit.getDefaultToolkit().getImage(
						"Images/Sebamsterrechts.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Sebamster.png") };

		Image[] boss1 = {
				Toolkit.getDefaultToolkit().getImage(
						"Images/Joschifantrechts.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Joschifant.png") };

		Image[] superBoss = {
				Toolkit.getDefaultToolkit().getImage("Images/drachenR.png"),
				Toolkit.getDefaultToolkit().getImage("Images/drachenL.png") };

		monsters.put(Monster.Type.SEBAMSTER, boss);
		monsters.put(Monster.Type.JOSCHIFANT, boss1);
		monsters.put(Monster.Type.SUPER_BOSS, superBoss);

		Image[] vasall = {
				Toolkit.getDefaultToolkit().getImage("Images/pinguinblue.png"),
				Toolkit.getDefaultToolkit().getImage("Images/pinguinred.png"),
				Toolkit.getDefaultToolkit().getImage(
						"Images/pinguinbluelinks.png"),
				Toolkit.getDefaultToolkit().getImage(
						"Images/pinguinredlinks.png") };

		Image[] vasall1 = {
				Toolkit.getDefaultToolkit().getImage("Images/Eichhornblue.png"),
				Toolkit.getDefaultToolkit().getImage("Images/Eichhornred.png"),
				Toolkit.getDefaultToolkit().getImage(
						"Images/Eichhornbluelinks.png"),
				Toolkit.getDefaultToolkit().getImage(
						"Images/Eichhornredlinks.png") };

		Image[] superVasall = {
				Toolkit.getDefaultToolkit().getImage("Images/BaerblueR.png"),
				Toolkit.getDefaultToolkit().getImage("Images/BaerredR.png"),
				Toolkit.getDefaultToolkit().getImage("Images/BaerblueL.png"),
				Toolkit.getDefaultToolkit().getImage("Images/BaerredL.png") };

		vasalls.put(Vasall.Type.PINGUIN, vasall);
		vasalls.put(Vasall.Type.SQUIRREL, vasall1);
		vasalls.put(Vasall.Type.SUPER_VASALL, superVasall);

	}
}
