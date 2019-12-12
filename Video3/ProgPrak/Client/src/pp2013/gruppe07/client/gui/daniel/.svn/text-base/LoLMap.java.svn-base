package pp2013.gruppe07.client.gui.daniel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import pp2013.gruppe07.client.gui.AttackImages;
import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.client.gui.Images;
import pp2013.gruppe07.client.gui.World;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.entity.Building;
import pp2013.gruppe07.shared.entity.CaptainObvious;
import pp2013.gruppe07.shared.entity.ClitComander;
import pp2013.gruppe07.shared.entity.DangerDan;
import pp2013.gruppe07.shared.entity.Entity;
import pp2013.gruppe07.shared.entity.FamousFlorian;
import pp2013.gruppe07.shared.entity.FederalFelix;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.GeneralHate;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Inhibitor;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.Joschifant;
import pp2013.gruppe07.shared.entity.Monster;
import pp2013.gruppe07.shared.entity.Nature;
import pp2013.gruppe07.shared.entity.Nexus;
import pp2013.gruppe07.shared.entity.Pinguin;
import pp2013.gruppe07.shared.entity.SafetySteven;
import pp2013.gruppe07.shared.entity.Sebamster;
import pp2013.gruppe07.shared.entity.SeriousSven;
import pp2013.gruppe07.shared.entity.Shop;
import pp2013.gruppe07.shared.entity.SpaceHolder;
import pp2013.gruppe07.shared.entity.Squirrel;
import pp2013.gruppe07.shared.entity.SuperVasall;
import pp2013.gruppe07.shared.entity.Superboss;
import pp2013.gruppe07.shared.entity.Tower;
import pp2013.gruppe07.shared.entity.Tree;
import pp2013.gruppe07.shared.entity.Tree2;
import pp2013.gruppe07.shared.entity.Vasall;
import pp2013.gruppe07.shared.entity.Wall;
import pp2013.gruppe07.shared.ground.Ground;
import pp2013.gruppe07.shared.ground.Sand;

/**
 * 
 * @author Daniel Diese Klasse erstellt die Ansicht auf der der Spieler spielt.
 * 
 */
public class LoLMap extends JPanel {
	private static int MouseKlickmovex = 0;
	private static int MouseKlickmovey = 0;
	ArrayList<String> chat;
	World world;
	private boolean Fog = true;
	private Timer timer;
	private Timer timerFE;
	
	private int time;
	private int timeFE;
	private Timer timertowerhit;
	private int time2;
	private int attackTime;
	int deathtime = Integer.MAX_VALUE;
	private Tile[][] MAP = new Tile[23][11];
	private final Image IMAGE;
	Frame frame;
	private String Chat = "";

	private int attackTimeactivated = Integer.MAX_VALUE;
	// Captainobvious-----------------------
	protected Image FirstSkill1linksCO;
	protected Image SecondSkill1linksCO;
	protected Image FourthSkill1linksCO;
	protected Image ThirdSkill1linksCO;
	protected Image FirstSkill2linksCO;
	protected Image SecondSkill2linksCO;
	protected Image FourthSkill2linksCO;
	protected Image ThirdSkill2linksCO;
	protected Image FirstSkill1rechtsCO;
	protected Image SecondSkill1rechtsCO;
	protected Image FourthSkill1rechtsCO;
	protected Image ThirdSkill1rechtsCO;
	protected Image FirstSkill2rechtsCO;
	protected Image SecondSkill2rechtsCO;
	protected Image FourthSkill2rechtsCO;
	protected Image ThirdSkill2rechtsCO;
	protected Image FirstSkill1obenCo;
	protected Image SecondSkill1obenCO;
	protected Image FourthSkill1obenCO;
	protected Image ThirdSkill1obenCO;
	protected Image FirstSkill2obenCO;
	protected Image SecondSkill2obenCO;
	protected Image FourthSkill2obenCO;
	protected Image ThirdSkill2obenCO;
	protected Image FirstSkill1untenCO;
	protected Image SecondSkill1untenCO;
	protected Image FourthSkill1untenCO;
	protected Image ThirdSkill1untenCO;
	protected Image FirstSkill2untenCO;
	protected Image SecondSkill2untenCO;
	protected Image FourthSkill2untenCO;
	protected Image ThirdSkill2untenCO;
	protected Image EisPfeillinks;
	protected Image EisPfeilrechts;
	protected Image EisPfeilunten;
	protected Image EisPfeiloben;
	protected Image FrostPfeillinks;
	protected Image FrostPfeilrechts;
	protected Image FrostPfeilunten;
	protected Image FrostPfeiloben;

	// ClitCommander-------------------------------------
	protected Image FirstSkill1linksCL;
	protected Image SecondSkill1linksCL;
	protected Image FourthSkill1linksCL;
	protected Image ThirdSkill1linksCL;
	protected Image FirstSkill2linksCL;
	protected Image SecondSkill2linksCL;
	protected Image FourthSkill2linksCL;
	protected Image ThirdSkill2linksCL;
	protected Image FirstSkill1rechtsCL;
	protected Image SecondSkill1rechtsCL;
	protected Image FourthSkill1rechtsCL;
	protected Image ThirdSkill1rechtsCL;
	protected Image FirstSkill2rechtsCL;
	protected Image SecondSkill2rechtsCL;
	protected Image FourthSkill2rechtsCL;
	protected Image ThirdSkill2rechtsCL;
	protected Image FirstSkill1obenCL;
	protected Image SecondSkill1obenCL;
	protected Image FourthSkill1obenCL;
	protected Image ThirdSkill1obenCL;
	protected Image FirstSkill2obenCL;
	protected Image SecondSkill2obenCL;
	protected Image FourthSkill2obenCL;
	protected Image ThirdSkill2obenCL;
	protected Image FirstSkill1untenCL;
	protected Image SecondSkill1untenCL;
	protected Image FourthSkill1untenCL;
	protected Image ThirdSkill1untenCL;
	protected Image FirstSkill2untenCL;
	protected Image SecondSkill2untenCL;
	protected Image FourthSkill2untenCL;
	protected Image ThirdSkill2untenCL;
	// Dangerdan-------------------------------------------------
	protected Image FirstSkill1linksDD;
	protected Image SecondSkill1linksDD;
	protected Image FourthSkill1linksDD;
	protected Image ThirdSkill1linksDD;
	protected Image FirstSkill2linksDD;
	protected Image SecondSkill2linksDD;
	protected Image FourthSkill2linksDD;
	protected Image ThirdSkill2linksDD;
	protected Image FirstSkill1rechtsDD;
	protected Image SecondSkill1rechtsDD;
	protected Image FourthSkill1rechtsDD;
	protected Image ThirdSkill1rechtsDD;
	protected Image FirstSkill2rechtsDD;
	protected Image SecondSkill2rechtsDD;
	protected Image FourthSkill2rechtsDD;
	protected Image ThirdSkill2rechtsDD;
	protected Image FirstSkill1obenDD;
	protected Image SecondSkill1obenDD;
	protected Image FourthSkill1obenDD;
	protected Image ThirdSkill1obenDD;
	protected Image FirstSkill2obenDD;
	protected Image SecondSkill2obenDD;
	protected Image FourthSkill2obenDD;
	protected Image ThirdSkill2obenDD;
	protected Image FirstSkill1untenDD;
	protected Image SecondSkill1untenDD;
	protected Image FourthSkill1untenDD;
	protected Image ThirdSkill1untenDD;
	protected Image FirstSkill2untenDD;
	protected Image SecondSkill2untenDD;
	protected Image FourthSkill2untenRR;
	protected Image ThirdSkill2untenDD;
	// Famousflorin--------------------------------
	protected Image FirstSkill1linksFL;
	protected Image SecondSkill1linksFL;
	protected Image FourthSkill1linksFL;
	protected Image ThirdSkill1linksFL;
	protected Image FirstSkill2linksFL;
	protected Image SecondSkill2linksFL;
	protected Image FourthSkill2linksFL;
	protected Image ThirdSkill2linksFL;
	protected Image FirstSkill1rechtsFL;
	protected Image SecondSkill1rechtsFL;
	protected Image FourthSkill1rechtsFL;
	protected Image ThirdSkill1rechtsFL;
	protected Image FirstSkill2rechtsFL;
	protected Image SecondSkill2rechtsFL;
	protected Image FourthSkill2rechtsFL;
	protected Image ThirdSkill2rechtsFL;
	// Federalfelix---------------------------------------------------------GeneralHate
	protected Image FirstSkill1linksFE;
	protected Image SecondSkill1linksFE;
	protected Image FourthSkill1linksFE;
	protected Image ThirdSkill1linksFE;
	protected Image FirstSkill2linksFE;
	protected Image SecondSkill2linksFE;
	protected Image FourthSkill2linksFE;
	protected Image ThirdSkill2linksFE;
	protected Image FirstSkill1rechtsFE;
	protected Image SecondSkill1rechtsFE;
	protected Image FourthSkill1rechtsFE;
	protected Image ThirdSkill1rechtsFE;
	protected Image FirstSkill2rechtsFE;
	protected Image SecondSkill2rechtsFE;
	protected Image FourthSkill2rechtsFE;
	protected Image ThirdSkill2rechtsFE;
	protected Image FirstSkill1obenFE;
	protected Image SecondSkill1obenFE;
	protected Image FourthSkill1obenFE;
	protected Image ThirdSkill1obenFE;
	protected Image FirstSkill2obenFE;
	protected Image SecondSkill2obenFE;
	protected Image FourthSkill2obenFE;
	protected Image ThirdSkill2obenFE;
	protected Image FirstSkill1untenFE;
	protected Image SecondSkill1untenFE;
	protected Image FourthSkill1untenFE;
	protected Image ThirdSkill1untenFE;
	protected Image FirstSkill2untenFE;
	protected Image SecondSkill2untenFE;
	protected Image FourthSkill2untenFE;
	protected Image ThirdSkill2untenFE;

	// Safety steven-------------------------------
	protected Image FirstSkill1linksSA;
	protected Image FirstSkill2linksSA;
	protected Image FirstSkill1rechtsSA;
	protected Image ThirdSkill1rechtsSA;
	protected Image FirstSkill2rechtsSA;
	protected Image ThirdSkill2rechtsSA;
	protected Image FirstSkill1obenSA;
	protected Image FirstSkill2obenSA;
	protected Image FirstSkill1untenSA;
	protected Image FirstSkill2untenSA;
	// SeriousSven-----------------------------
	protected Image FirstSkill1linksSS;
	// fliegenderPfeil
	protected Image Pfeiloben;
	protected Image Pfeilunten;
	protected Image Pfeilrechts;
	protected Image Pfeillinks;

	protected final Image IMAGEDIE;
	private boolean gamerunning = true;

	public LoLMap(Tile[][] Map, World world, Frame frame) {
		super.setSize(LoLFrame.MAPAREA.getSize());
		this.setVisible(true);
		this.frame = frame;
		chat = new ArrayList<String>();

		IMAGE = Toolkit.getDefaultToolkit().getImage("Images/semifog.png");

		IMAGEDIE = Toolkit.getDefaultToolkit().getImage("Images/KaBoom.png");

		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// Captain obvious---------------------

		FirstSkill1linksCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CaptainSchild1.png");
		SecondSkill1linksCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CE1L.png");
		ThirdSkill1linksCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CF1L.png");
		FourthSkill1linksCO = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2linksCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CaptainSchild1.png");
		SecondSkill2linksCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CE2L.png");
		ThirdSkill2linksCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CF2L.png");
		FourthSkill2linksCO = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1rechtsCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CaptainSchild1.png");
		SecondSkill1rechtsCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CE1R.png");
		ThirdSkill1rechtsCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CF1R.png");
		FourthSkill1rechtsCO = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2rechtsCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CaptainSchild1.png");
		SecondSkill2rechtsCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CE2R.png");
		ThirdSkill2rechtsCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CF2R.png");
		FourthSkill2rechtsCO = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1obenCo = Toolkit.getDefaultToolkit().getImage(
				"Images/CaptainSchild1.png");
		SecondSkill1obenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CE1O.png");
		ThirdSkill1obenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CF1O.png");
		FourthSkill1obenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2obenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CaptainSchild1.png");
		SecondSkill2obenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CE2O.png");
		ThirdSkill2obenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CF2O.png");
		FourthSkill2obenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1untenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CaptainSchild1.png");
		SecondSkill1untenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CE1U.png");
		ThirdSkill1untenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CF1U.png");
		FourthSkill1untenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2untenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CaptainSchild1.png");
		SecondSkill2untenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CE2U.png");
		ThirdSkill2untenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/CF2U.png");
		FourthSkill2untenCO = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		EisPfeilrechts = Toolkit.getDefaultToolkit().getImage(
				"Images/EisPfeilrechts.png");
		EisPfeillinks = Toolkit.getDefaultToolkit().getImage(
				"Images/EisPfeillinks.png");
		EisPfeiloben = Toolkit.getDefaultToolkit().getImage(
				"Images/EisPfeiloben.png");
		EisPfeilunten = Toolkit.getDefaultToolkit().getImage(
				"Images/EisPfeilunten.png");

		FrostPfeilrechts = Toolkit.getDefaultToolkit().getImage(
				"Images/FrostPfeilrechts.png");
		FrostPfeillinks = Toolkit.getDefaultToolkit().getImage(
				"Images/FrostPfeillinks.png");
		FrostPfeiloben = Toolkit.getDefaultToolkit().getImage(
				"Images/FrostPfeiloben.png");
		FrostPfeilunten = Toolkit.getDefaultToolkit().getImage(
				"Images/FrostPfeilunten.png");
		// Clitcomander-----------------------------------

		FirstSkill1linksCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CL1L.png");
		SecondSkill1linksCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLH2L.png");
		ThirdSkill1linksCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLS1L.png");
		FourthSkill1linksCL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2linksCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CL2L.png");
		SecondSkill2linksCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLH2L.png");
		ThirdSkill2linksCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLS1L.png");
		FourthSkill2linksCL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1rechtsCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CL1R.png");
		SecondSkill1rechtsCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLH2.png");
		ThirdSkill1rechtsCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLS1R.png");
		FourthSkill1rechtsCL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2rechtsCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CL2R.png");
		SecondSkill2rechtsCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLH2.png");
		ThirdSkill2rechtsCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLS1R.png");
		FourthSkill2rechtsCL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1obenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CL1O.png");
		SecondSkill1obenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLH2O.png");
		ThirdSkill1obenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLS1O.png");
		FourthSkill1obenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2obenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CL2O.png");
		SecondSkill2obenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLH2O.png");
		ThirdSkill2obenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLS1O.png");
		FourthSkill2obenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1untenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CL1U.png");
		SecondSkill1untenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLH2O.png");
		ThirdSkill1untenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLS1U.png");
		FourthSkill1untenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2untenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CL2U.png");
		SecondSkill2untenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLH2O.png");
		ThirdSkill2untenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/CLS1U.png");
		FourthSkill2untenCL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		// DAngerdan-------------------------
		FirstSkill1linksDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DS1L.png");
		SecondSkill1linksDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DSS.png");
		ThirdSkill1linksDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DE1.png");
		FourthSkill1linksDD = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2linksDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DS2L.png");
		SecondSkill2linksDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DSS2.png");
		ThirdSkill2linksDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DE2.png");
		FourthSkill2linksDD = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1rechtsDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DS1R.png");
		SecondSkill1rechtsDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DSS.png");
		ThirdSkill1rechtsDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DE1.png");
		FourthSkill1rechtsDD = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2rechtsDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DS2R.png");
		SecondSkill2rechtsDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DSS2.png");
		ThirdSkill2rechtsDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DE2.png");
		FourthSkill2rechtsDD = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1obenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DS1L.png");
		SecondSkill1obenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DSS.png");
		ThirdSkill1obenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DE1.png");
		FourthSkill1obenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2obenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DS1R.png");
		SecondSkill2obenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DSS2.png");
		ThirdSkill2obenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DE2.png");
		FourthSkill2obenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1untenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DS2L.png");
		SecondSkill1untenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DSS.png");
		ThirdSkill1untenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DE1.png");
		FourthSkill1untenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2untenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DS2R.png");
		SecondSkill2untenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DSS2.png");
		ThirdSkill2untenDD = Toolkit.getDefaultToolkit().getImage(
				"Images/DE2.png");
		FourthSkill2untenRR = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		// Famousflo---------------------------
		FirstSkill1linksFL = Toolkit.getDefaultToolkit().getImage(
				"Images/FG1L.png");
		SecondSkill1linksFL = Toolkit.getDefaultToolkit().getImage(
				"Images/Aura.png");
		ThirdSkill1linksFL = Toolkit.getDefaultToolkit().getImage(
				"Images/FH1L.png");
		FourthSkill1linksFL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2linksFL = Toolkit.getDefaultToolkit().getImage(
				"Images/FG2R.png");
		SecondSkill2linksFL = Toolkit.getDefaultToolkit().getImage(
				"Images/Aura2.png");
		ThirdSkill2linksFL = Toolkit.getDefaultToolkit().getImage(
				"Images/FH2L.png");
		FourthSkill2linksFL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1rechtsFL = Toolkit.getDefaultToolkit().getImage(
				"Images/FG1R.png");
		SecondSkill1rechtsFL = Toolkit.getDefaultToolkit().getImage(
				"Images/Aura.png");
		ThirdSkill1rechtsFL = Toolkit.getDefaultToolkit().getImage(
				"Images/FH1R.png");
		FourthSkill1rechtsFL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2rechtsFL = Toolkit.getDefaultToolkit().getImage(
				"Images/FG2L.png");
		SecondSkill2rechtsFL = Toolkit.getDefaultToolkit().getImage(
				"Images/Aura2.png");
		ThirdSkill2rechtsFL = Toolkit.getDefaultToolkit().getImage(
				"Images/FH2R.png");
		FourthSkill2rechtsFL = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		// Fedrals felix------------------------------------GeneralHate
		FirstSkill1linksFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Kugelhagel1L.png");
		SecondSkill1linksFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Haddle1.png");
		ThirdSkill1linksFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Bombe1R.png");
		FourthSkill1linksFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2linksFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Kugelhagel2L.png");
		SecondSkill2linksFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Haddle2.png");
		ThirdSkill2linksFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Bombe1R.png");
		FourthSkill2linksFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1rechtsFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Kugelhagel1R.png");
		SecondSkill1rechtsFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Haddle1.png");
		ThirdSkill1rechtsFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Bombe1L.png");
		FourthSkill1rechtsFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2rechtsFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Kugelhagel2R.png");
		SecondSkill2rechtsFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Haddle2.png");
		ThirdSkill2rechtsFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Bombe1L.png");
		FourthSkill2rechtsFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1obenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Kugelhagel1O.png");
		SecondSkill1obenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Haddle1.png");
		ThirdSkill1obenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Bombe1O.png");
		FourthSkill1obenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2obenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Kugelhagel2O.png");
		SecondSkill2obenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Haddle2.png");
		ThirdSkill2obenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Bombe1O.png");
		FourthSkill2obenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");

		FirstSkill1untenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Kugelhagel1U.png");
		SecondSkill1untenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Haddle1.png");
		ThirdSkill1untenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Bombe1U.png");
		FourthSkill1untenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		FirstSkill2untenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Kugelhagel2U.png");
		SecondSkill2untenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Haddle2.png");
		ThirdSkill2untenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Bombe1U.png");
		FourthSkill2untenFE = Toolkit.getDefaultToolkit().getImage(
				"Images/Captainkleinlinks.png");
		// Safety Seven------------------------------------------------------
		FirstSkill1linksSA = Toolkit.getDefaultToolkit().getImage(
				"Images/herz.png");
		FirstSkill2linksSA = Toolkit.getDefaultToolkit().getImage(
				"Images/herz.png");

		FirstSkill1rechtsSA = Toolkit.getDefaultToolkit().getImage(
				"Images/herz.png");
		ThirdSkill1rechtsSA = Toolkit.getDefaultToolkit().getImage(
				"Images/Blitz1.png");
		FirstSkill2rechtsSA = Toolkit.getDefaultToolkit().getImage(
				"Images/herz.png");
		ThirdSkill2rechtsSA = Toolkit.getDefaultToolkit().getImage(
				"Images/Blitz2.png");

		FirstSkill1obenSA = Toolkit.getDefaultToolkit().getImage(
				"Images/herz.png");
		FirstSkill2obenSA = Toolkit.getDefaultToolkit().getImage(
				"Images/herz.png");

		FirstSkill1untenSA = Toolkit.getDefaultToolkit().getImage(
				"Images/herz.png");
		FirstSkill2untenSA = Toolkit.getDefaultToolkit().getImage(
				"Images/herz.png");
		// serioussven---------------------------------------------
		FirstSkill1linksSS = Toolkit.getDefaultToolkit().getImage(
				"Images/Panzer.png");
		// fliegendePfeile
		Pfeiloben = Toolkit.getDefaultToolkit()
				.getImage("Images/Pfeiloben.png");
		Pfeilunten = Toolkit.getDefaultToolkit().getImage(
				"Images/Pfeilunten.png");

		Pfeillinks = Toolkit.getDefaultToolkit().getImage(
				"Images/Pfeillinks.png");
		Pfeilrechts = Toolkit.getDefaultToolkit().getImage(
				"Images/Pfeilrechts.png");

		for (int i = 0; i < MAP.length; i++) {
			for (int j = 0; j < MAP[0].length; j++) {
				MAP[i][j] = new Tile(new SpaceHolder(1, 1), new Sand(1, 1), i,
						j);
			}
		}
		this.MAP = Map;
		this.world = world;
		time = 0;
		/**
		 * 
		 * @author Daniel Hier werden die Timer fuer die Schlag und
		 *         Spezialattacken gesetzt.
		 * 
		 */
		timer = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				time++;
				attackTime = (time % 2);

			}
		});
		timertowerhit = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				time2++;

			}
		});
		timerFE = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timeFE++;

			}
		});
		timer.start();

	}

	public void setChat(String chat) {

		this.chat = world.getChat();

		Chat = "You: " + chat;
	}

	public String getChat() {

		return Chat;
	}

	public void clearChat() {

		Chat = "";
	}

	
	
	public void paint(Graphics g) {

		int FieldSize = 80;
		Tile[][] map = new Tile[140][140];
		map = world.getMap();

		for (int i = 0; i < MAP.length; i++) {
			for (int j = 0; j < MAP[0].length; j++) {
				MAP[i][j] = map[i
						+ frame.getGlobalBackground().lolFrame.moveviewxvalue()][j
						+ frame.getGlobalBackground().lolFrame.moveviewyvalue()];
			}
		}

		// ground------------------------------------------------------------
		/**
		 * 
		 * @author Daniel Zeichnen des Grounds
		 * 
		 */
		for (int i = 0; i < MAP.length; i++) {
			for (int j = 0; j < MAP[0].length; j++) {
				int[] position = { i * FieldSize, j * FieldSize };
				Ground ground = MAP[i][j].getground();

				g.drawImage(Images.grounds.get(ground.getTYPE())[0],
						position[0], position[1], this);

			}
		}

		// objekte---------------------------------------------------------------
		/**
		 * 
		 * @author Daniel Zeichnen der Objekte
		 * 
		 */
		for (int i = 0; i < MAP.length; i++) {
			for (int j = 0; j < MAP[0].length; j++) {
				int[] position = { i * FieldSize, j * FieldSize };

				Entity entity = MAP[i][j].getobject();

				// nature----------------------------
				if (entity instanceof Nature) {
					Nature nature = (Nature) entity;
					if (entity instanceof Tree) {
						g.drawImage(Images.nature.get(nature.getType())[0],
								position[0], position[1], this);

					}
					if (entity instanceof Tree2) {
						g.drawImage(Images.nature.get(nature.getType())[0],
								position[0], position[1], this);

					}
					if (entity instanceof Wall) {
						g.drawImage(Images.nature.get(nature.getType())[0],
								position[0], position[1], this);

					}
				}
				// building -------------------------------------------------
				if (entity instanceof Building) {
					Building building = (Building) entity;
					if (entity instanceof Inhibitor) {
						g.setColor(Color.black);
						g.fillRect(position[0], position[1], 103, 6);
						g.setColor(Color.green);
						if (building.getvalue()[6] >= 0)
							g.fillRect(position[0] + 1, position[1] + 1,
									(building.get_Akt_Life() * 101 / building
											.getvalue()[6]), 4);

						if (((Building) entity).getTeam().equals(Team.BLUE))
							g.drawImage(
									Images.buildings.get(building.getTYPE())[0],
									position[0], position[1], this);
						if (((Building) entity).getTeam().equals(Team.RED))
							g.drawImage(
									Images.buildings.get(building.getTYPE())[1],
									position[0], position[1], this);
					}
					if (entity instanceof Nexus) {
						g.setColor(Color.black);
						g.fillRect(position[0], position[1], 203, 6);
						g.setColor(Color.green);
						if (building.getvalue()[6] >= 0)
							g.fillRect(position[0] + 1, position[1] + 1,
									(building.get_Akt_Life() * 201 / building
											.getvalue()[6]), 4);

						if (((Building) entity).getTeam().equals(Team.BLUE))
							g.drawImage(
									Images.buildings.get(building.getTYPE())[0],
									position[0], position[1], this);
						if (((Building) entity).getTeam().equals(Team.RED))
							g.drawImage(
									Images.buildings.get(building.getTYPE())[1],
									position[0], position[1], this);
					}
					if (entity instanceof Tower) {
						g.setColor(Color.black);
						g.fillRect(position[0], position[1], 103, 6);
						g.setColor(Color.green);
						g.fillRect(position[0] + 1, position[1] + 1,
								(building.get_Akt_Life() * 101 / building
										.getvalue()[6]), 4);

						if (((Building) entity).getTeam().equals(Team.BLUE))
							g.drawImage(
									Images.buildings.get(building.getTYPE())[0],
									position[0], position[1], this);
						if (((Building) entity).getTeam().equals(Team.RED))
							g.drawImage(
									Images.buildings.get(building.getTYPE())[1],
									position[0], position[1], this);
						if (building.getattack()) {
							// towerhit-.-.-.-.-.-.-.-.-.-.-.-..-
							timertowerhit.start();
							double increase;

							if ((((Tower) building).gettarget()[0] - building
									.getPosition()[0]) != 0) {

								if ((((Tower) building).gettarget()[1] - building
										.getPosition()[1]) == 0
										&& (((Tower) building).gettarget()[0] - building
												.getPosition()[0]) < 0)// links
									g.drawImage(Images.buildings.get(building
											.getTYPE())[2], position[0] - time2
											* 25, position[1], this);
								if ((((Tower) building).gettarget()[1] - building
										.getPosition()[1]) == 0
										&& (((Tower) building).gettarget()[0] - building
												.getPosition()[0]) > 0)// rechts
									g.drawImage(Images.buildings.get(building
											.getTYPE())[2], position[0] + time2
											* 25, position[1], this);

								if ((((Tower) building).gettarget()[1] - building
										.getPosition()[1]) > 0
										&& (((Tower) building).gettarget()[0] - building
												.getPosition()[0]) > 0)// obenrechts
									g.drawImage(Images.buildings.get(building
											.getTYPE())[2], position[0] + time2
											* 25, position[1] + time2 * 25,
											this);
								if ((((Tower) building).gettarget()[1] - building
										.getPosition()[1]) < 0
										&& (((Tower) building).gettarget()[0] - building
												.getPosition()[0]) > 0)// untenrechts
									g.drawImage(Images.buildings.get(building
											.getTYPE())[2], position[0] + time2
											* 25, position[1] - time2 * 25,
											this);

								if ((((Tower) building).gettarget()[1] - building
										.getPosition()[1]) > 0
										&& (((Tower) building).gettarget()[0] - building
												.getPosition()[0]) < 0)// obenlinks
									g.drawImage(Images.buildings.get(building
											.getTYPE())[2], position[0] - time2
											* 25, position[1] + time2 * 25,
											this);
								if ((((Tower) building).gettarget()[1] - building
										.getPosition()[1]) < 0
										&& (((Tower) building).gettarget()[0] - building
												.getPosition()[0]) < 0)// untenlinks
									g.drawImage(Images.buildings.get(building
											.getTYPE())[2], position[0] - time2
											* 25, position[1] - time2 * 25,
											this);

							} else if (((Tower) building).gettarget()[1]
									- building.getPosition()[1] <= 0)
								g.drawImage(Images.buildings.get(building
										.getTYPE())[2], position[0],
										position[1] - time2 * 25, this);
							else
								g.drawImage(Images.buildings.get(building
										.getTYPE())[2], position[0],
										position[1] + time2 * 25, this);

							if (time2 >= 5) {
								time2 = 0;
								((Tower) building).setattack(false);
								timertowerhit.stop();
							}
						}

					}
					if (entity instanceof Shop) {
						if (((Building) entity).getTeam().equals(Team.BLUE))
							g.drawImage(
									Images.buildings.get(building.getTYPE())[0],
									position[0], position[1], this);
						if (((Building) entity).getTeam().equals(Team.RED))
							g.drawImage(
									Images.buildings.get(building.getTYPE())[1],
									position[0], position[1], this);

					}
					if (building.get_Akt_Life() <= 0) {
						if (deathtime > time)
							deathtime = time;
						if (time < deathtime + 2)
							g.drawImage(IMAGEDIE, position[0], position[1],
									this);
					}

				} // Figure---------------------------------
				if (entity instanceof Figure) {
					// heros---------------------------------------------

					if (entity instanceof Hero) {
						if (frame.getGlobalBackground().getLoLFrame().getfog()[i
								+ frame.getGlobalBackground().getLoLFrame()
										.moveviewxvalue()][j
								+ frame.getGlobalBackground().getLoLFrame()
										.moveviewyvalue()] == 2
								|| !Fog) {
							Hero hero = (Hero) entity;

							if (entity instanceof CaptainObvious) {
								// CaptainObvious------------------------------
								paintlifefigure(hero, g, position);
								paintCO(hero, g, position);
							}
							if (entity instanceof ClitComander) {
								// ClitComander------------------------------
								paintlifefigure(hero, g, position);
								paintCC(hero, g, position);
							}
							if (entity instanceof DangerDan) {
								// DangerDan------------------------------
								paintlifefigure(hero, g, position);
								paintDD(hero, g, position);
							}
							if (entity instanceof FamousFlorian) {
								// FamousFlorian------------------------------
								paintlifefigure(hero, g, position);
								paintFlo(hero, g, position);
							}
							if (entity instanceof FederalFelix) {
								// FederalFelix------------------------------
								paintlifefigure(hero, g, position);
								paintFe(hero, g, position);
							}
							if (entity instanceof GeneralHate) {
								// GeneralHate------------------------------
								paintlifefigure(hero, g, position);
								paintG(hero, g, position);
							}
							if (entity instanceof SafetySteven) {
								// SafetySteven------------------------------

								paintSa(hero, g, position);
							}
							if (entity instanceof SeriousSven) {
								// SeriousSven------------------------------
								paintlifefigure(hero, g, position);
								paintSS(hero, g, position);
							}
							figureAttack(g, hero, position);
							if (hero.get_Akt_Life() <= 0) {
								if (deathtime > time)
									deathtime = time;
								if (time < deathtime + 2)
									g.drawImage(IMAGEDIE, position[0],
											position[1], this);
							}
						}

					} // vasallen--------------------------------------------
					if (entity instanceof Vasall) {
						if (frame.getGlobalBackground().getLoLFrame().getfog()[i
								+ frame.getGlobalBackground().getLoLFrame()
										.moveviewxvalue()][j
								+ frame.getGlobalBackground().getLoLFrame()
										.moveviewyvalue()] == 2
								|| !Fog) {
							Vasall vasall = (Vasall) entity;
							paintlifefigure(vasall, g, position);
							if (entity instanceof Pinguin) {

								if (((Vasall) entity).getTeam().equals(
										Team.BLUE)) {

									if (vasall.getdirection() == 1) {
										g.drawImage(Images.vasalls.get(vasall
												.getType())[2], position[0],
												position[1], this);
									}

									// rechts
									if (vasall.getdirection() == 2) {
										g.drawImage(Images.vasalls.get(vasall
												.getType())[0], position[0],
												position[1], this);
									}
								}
								if (((Vasall) entity).getTeam()
										.equals(Team.RED)) {
									if (vasall.getdirection() == 1) {
										g.drawImage(Images.vasalls.get(vasall
												.getType())[3], position[0],
												position[1], this);
									}

									// rechts
									if (vasall.getdirection() == 2) {
										g.drawImage(Images.vasalls.get(vasall
												.getType())[1], position[0],
												position[1], this);
									}
								}
								figureAttack(g, vasall, position);
							}
							if (entity instanceof Squirrel) {
								if (((Vasall) entity).getTeam().equals(
										Team.BLUE)) {
									if (vasall.getdirection() == 1) {
										g.drawImage(Images.vasalls.get(vasall
												.getType())[2], position[0],
												position[1], this);
									}

									// rechts
									if (vasall.getdirection() == 2) {
										g.drawImage(Images.vasalls.get(vasall
												.getType())[0], position[0],
												position[1], this);
									}
								}
								if (((Vasall) entity).getTeam()
										.equals(Team.RED)) {
									if (vasall.getdirection() == 1) {
										g.drawImage(Images.vasalls.get(vasall
												.getType())[3], position[0],
												position[1], this);
									}

									// rechts
									if (vasall.getdirection() == 2) {
										g.drawImage(Images.vasalls.get(vasall
												.getType())[1], position[0],
												position[1], this);
									}
								}
								figureAttack(g, vasall, position);

							}
							if (entity instanceof SuperVasall) {
								if (((Vasall) entity).getTeam().equals(
										Team.BLUE))
									if (vasall.getdirection() == 1) {
										g.drawImage(Images.vasalls.get(vasall
												.getType())[2], position[0],
												position[1], this);
									}

								// rechts
								if (vasall.getdirection() == 2) {
									g.drawImage(Images.vasalls.get(vasall
											.getType())[0], position[0],
											position[1], this);
								}
								if (((Vasall) entity).getTeam()
										.equals(Team.RED))
									if (vasall.getdirection() == 1) {
										g.drawImage(Images.vasalls.get(vasall
												.getType())[3], position[0],
												position[1], this);
									}

								// rechts
								if (vasall.getdirection() == 2) {
									g.drawImage(Images.vasalls.get(vasall
											.getType())[1], position[0],
											position[1], this);
								}

							}
							figureAttack(g, vasall, position);

						}
					} // Monster-------------------------------------------
					if (entity instanceof Monster) {

						if (frame.getGlobalBackground().getLoLFrame().getfog()[i
								+ frame.getGlobalBackground().getLoLFrame()
										.moveviewxvalue()][j
								+ frame.getGlobalBackground().getLoLFrame()
										.moveviewyvalue()] == 2
								|| !Fog) {
							Monster monster = (Monster) entity;
							paintlifefigure(monster, g, position);
							if (entity instanceof Sebamster) {
								if (monster.getdirection() == 1) {
									g.drawImage(Images.monsters.get(monster
											.getType())[1], position[0],
											position[1], this);
								}

								// rechts
								if (monster.getdirection() == 2) {
									g.drawImage(Images.monsters.get(monster
											.getType())[0], position[0],
											position[1], this);
								}
								figureAttack(g, (Figure) MAP[i][j].getobject(),
										position);

							}
							if (entity instanceof Joschifant) {
								if (monster.getdirection() == 1) {
									g.drawImage(Images.monsters.get(monster
											.getType())[1], position[0],
											position[1], this);
								}

								// rechts
								if (monster.getdirection() == 2) {
									g.drawImage(Images.monsters.get(monster
											.getType())[0], position[0],
											position[1], this);
								}
								figureAttack(g, (Figure) MAP[i][j].getobject(),
										position);

							}
							if (entity instanceof Superboss) {
								if (monster.getdirection() == 1) {
									g.drawImage(Images.monsters.get(monster
											.getType())[1], position[0],
											position[1], this);
								}

								// rechts
								if (monster.getdirection() == 2) {
									g.drawImage(Images.monsters.get(monster
											.getType())[0], position[0],
											position[1], this);
								}
								figureAttack(g, (Figure) MAP[i][j].getobject(),
										position);

							}
						}

					}

				}

			}
		}

		// ------------------------------------------------------------------------------------

		// nebel----------------------------------------------------
		if (Fog) {// zum cheaten
			int m = 0, l = 0;
			for (int i = frame.getGlobalBackground().getLoLFrame()
					.moveviewxvalue(); i < frame.getGlobalBackground()
					.getLoLFrame().moveviewxvalue()
					+ MAP.length; i++) {
				for (int j = frame.getGlobalBackground().getLoLFrame()
						.moveviewyvalue(); j < frame.getGlobalBackground()
						.getLoLFrame().moveviewyvalue()
						+ MAP[0].length + 1; j++) {

					int[] position1 = { m * FieldSize, l * FieldSize };

					if (frame.getGlobalBackground().getLoLFrame().getfog()[i][j] != 2
							&& frame.getGlobalBackground().getLoLFrame()
									.getsemifog()[i][j] != 3) {

						g.drawImage(IMAGE, position1[0], position1[1], this);
					}
					l++;
				}
				m++;
				l = 0;
			}
		}
		if (Fog) {
			int m = 0, l = 0;
			for (int i = frame.getGlobalBackground().getLoLFrame()
					.moveviewxvalue(); i < frame.getGlobalBackground()
					.getLoLFrame().moveviewxvalue()
					+ MAP.length; i++) {
				for (int j = frame.getGlobalBackground().getLoLFrame()
						.moveviewyvalue(); j < frame.getGlobalBackground()
						.getLoLFrame().moveviewyvalue()
						+ MAP[0].length + 1; j++) {

					int[] position1 = { m * FieldSize, l * FieldSize };

					if (frame.getGlobalBackground().getLoLFrame().getfog()[i][j] != 2
							&& frame.getGlobalBackground().getLoLFrame()
									.getsemifog()[i][j] == 3) {
						g.drawImage(IMAGE, position1[0], position1[1], this);
					}
					l++;
				}
				m++;
				l = 0;
			}
		}
		// chat-----------------------------------------------
		g.setColor(Color.white);

		Font Chat = new Font("Arial", Font.BOLD, 16);

		g.setFont(Chat);

		int chatSize = world.getChat().size();

		if (world.getChat().size() < 10) {
			for (int k = 0; k < chatSize; k++) {
				
				g.drawString(world.getChat().get(k), 10, 16 + 25 * k);
			}
		} else {
			for (int k = 0; k < 10; k++) {
				g.drawString(world.getChat().get(chatSize - 10 + k), 10,
						16 + 25 * (k));
			}
		}

		g.setColor(Color.PINK);
		g.drawRect(getMove()[0] * FieldSize, getMove()[1] * FieldSize,
				FieldSize, FieldSize);
		// Information ob Spiel gewonnen
		if (!world.getgamerunning()) {
			Font Win = new Font("Arial", Font.BOLD, 300);

			g.setFont(Win);
			if(!world.getwinning())
			g.drawString("Lose", 300, 500);
			else
				if(world.getwinning())
				g.drawString("Sieg", 300, 500);
		}

	}
	
	
	public void setMove(int[] position) {
		MouseKlickmovex = position[0];
		MouseKlickmovey = position[1];

	}

	public int[] getMove() {
		int[] position = { MouseKlickmovex, MouseKlickmovey };
		return position;
	}

	

	/**
	 * @param g
	 * @param figure
	 * @param position
	 * regelt die animation der attacken
	 */
	public void figureAttack(Graphics g, Figure figure, int[] position) {

		if (figure.get_Akt_Life() != figure.getvalue()[6]) {

		}

		if (figure.getfightart().equals("sword")) {
			if (figure.getattack()) {

				if (attackTimeactivated > time)
					attackTimeactivated = time;
				if (time > attackTimeactivated + 1) {
					figure.setattack(false);
					attackTimeactivated = Integer.MAX_VALUE;
				}
				if (figure.getAttackdirection() == 2) {

					// rechts

					g.drawImage(
							AttackImages.attacks.get(Figure.direction.right)[attackTime],
							position[0] + figure.getPosition_values()[0],
							position[1] + figure.getPosition_values()[1], this);
				}
				if (figure.getAttackdirection() == 1) {
					// left

					g.drawImage(
							AttackImages.attacks.get(Figure.direction.left)[attackTime],
							position[0] + figure.getPosition_values()[2],
							position[1] + figure.getPosition_values()[3], this);

				}

				if (figure.getAttackdirection() == 3) { // oben

					g.drawImage(
							AttackImages.attacks.get(Figure.direction.up)[attackTime],
							position[0] + figure.getPosition_values()[4],
							position[1] + figure.getPosition_values()[5], this);
				}
				if (figure.getAttackdirection() == 4) { // unten

					g.drawImage(
							AttackImages.attacks.get(Figure.direction.down)[attackTime],
							position[0] + figure.getPosition_values()[6],
							position[1] + figure.getPosition_values()[7], this);

				}
			}
		}
		// fernkampf
		if (figure.getfightart().equals("arrow")) {

			if (figure.getattack()) {
				if (figure.gettimeaktivated() > figure.gettime())
					figure.settimeaktivated(figure.gettime());
				if (figure.gettimeaktivated() + 4 < figure.gettime()) {
					figure.setattack(false);
					figure.settimeaktivated(100);
					figure.resettime();
					System.out.println("timerstoppt");

				} else {

					figure.settime(figure.gettime() - figure.gettimeaktivated()
							+ 1);
					if (figure instanceof Hero)
						System.out
								.println("Pfeilschuss true setzen wird gemacht"
										+ figure.gettime() + "attacktime"
										+ figure.gettimeaktivated());

					if (((figure.gettarget()[0] - figure.getPosition()[0]) != 0)) {

						if (((figure.gettarget()[1] - figure.getPosition()[1]) == 0 && (figure
								.gettarget()[0] - figure.getPosition()[0]) < 0)) {// links
							if (figure.gettime() == 1)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.left)[2],
										position[0] - 15, position[1], this);
							if (figure.gettime() == 2)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.left)[3],
										position[0], position[1], this);
							if (figure.gettime() > 2)
								g.drawImage(Pfeillinks,
										position[0] - (figure.gettime() - 2)
												* 50, position[1], this);
						}
						if ((figure.gettarget()[1] - figure.getPosition()[1]) == 0
								&& (figure.gettarget()[0] - figure
										.getPosition()[0]) > 0) {// rechts
							if (figure.gettime() == 1)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.right)[2],
										position[0] - 15, position[1], this);
							if (figure.gettime() == 2)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.right)[3],
										position[0], position[1], this);
							if (figure.gettime() > 2)
								g.drawImage(Pfeilrechts,
										position[0] + (figure.gettime() - 2)
												* 50, position[1], this);
						}
						if ((figure.gettarget()[1] - figure.getPosition()[1]) > 0
								&& (figure.gettarget()[0] - figure
										.getPosition()[0]) > 0) {// obenrechts
							if (figure.gettime() == 1)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.right)[2],
										position[0] - 15, position[1], this);
							if (figure.gettime() == 2)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.right)[3],
										position[0], position[1], this);
							if (figure.gettime() > 2)
								g.drawImage(Pfeilrechts,
										position[0] + (figure.gettime() - 2)
												* 50,
										position[1] + (figure.gettime() - 2)
												* 50, this);
						}
						if ((figure.gettarget()[1] - figure.getPosition()[1]) < 0
								&& (figure.gettarget()[0] - figure
										.getPosition()[0]) > 0) {// untenrechts
							if (figure.gettime() == 1)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.right)[2],
										position[0] - 15, position[1], this);
							if (figure.gettime() == 2)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.right)[3],
										position[0], position[1], this);
							if (figure.gettime() > 2)
								g.drawImage(Pfeilrechts,
										position[0] + (figure.gettime() - 2)
												* 50,
										position[1] - (figure.gettime() - 2)
												* 50, this);
						}
						if ((figure.gettarget()[1] - figure.getPosition()[1]) > 0
								&& (figure.gettarget()[0] - figure
										.getPosition()[0]) < 0) {// obenlinks

							if (figure.gettime() == 1)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.left)[2],
										position[0] - 15, position[1], this);
							if (figure.gettime() == 2)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.left)[3],
										position[0], position[1], this);
							if (figure.gettime() > 2)
								g.drawImage(Pfeillinks,
										position[0] - (figure.gettime() - 2)
												* 50,
										position[1] + (figure.gettime() - 2)
												* 50, this);
						}

						if ((figure.gettarget()[1] - figure.getPosition()[1]) < 0
								&& (figure.gettarget()[0] - figure
										.getPosition()[0]) < 0) {// untenlinks
							if (figure.gettime() == 1)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.left)[2],
										position[0] - 15, position[1], this);
							if (figure.gettime() == 2)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.left)[3],
										position[0], position[1], this);
							if (figure.gettime() > 2)
								g.drawImage(Pfeillinks,
										position[0] - (figure.gettime() - 2)
												* 50,
										position[1] - (figure.gettime() - 2)
												* 50, this);

						}

					} else {
						if (figure.gettarget()[1] - figure.getPosition()[1] <= 0) {
							// oben
							if (figure.gettime() == 1)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.up)[2],
										position[0], position[1] + 15, this);
							if (figure.gettime() == 2)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.up)[3],
										position[0], position[1], this);
							if (figure.gettime() > 2)
								g.drawImage(Pfeiloben, position[0], position[1]
										- (figure.gettime() - 2) * 50, this);
						} else {// unten
							if (figure.gettime() == 1)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.down)[2],
										position[0], position[1] - 15, this);
							if (figure.gettime() == 2)
								g.drawImage(AttackImages.attacks
										.get(Figure.direction.down)[3],
										position[0], position[1], this);
							if (figure.gettime() > 2)

								g.drawImage(Pfeilunten, position[0],
										position[1] + (figure.gettime() - 2)
												* 50, this);
						}
					}
				}
			}
		}

	}

	
	/**
	 * @param figure
	 * @param g
	 * @param position
	 * regelt die lebensanzeige
	 */
	public void paintlifefigure(Figure figure, Graphics g, int[] position) {

		g.setColor(Color.black);

		g.fillRect(position[0], position[1], 53, 6);
		g.setColor(Color.green);
		if (figure.get_Akt_Life() >= 0) {

			g.fillRect(position[0] + 1, position[1] + 1,
					(figure.get_Akt_Life() * 51 / figure.getvalue()[6]), 4);

		}

	}

	// 
	/**
	 * @param hero
	 * @param g
	 * @param position
	 * zeichnet Captainobvious und Spezialattacken.
	 */
	public void paintCO(Hero hero, Graphics g, int[] position) {
		if (hero.getdirection() == 1) {// links
			g.drawImage(Images.heroes.get(hero.getType())[2], position[0],
					position[1], this);
		}

		// rechts
		if (hero.getdirection() == 2) {
			g.drawImage(Images.heroes.get(hero.getType())[0], position[0],
					position[1], this);
		}
		// spezialattacken
		if (hero.getAbilitiesaktivated()[0]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 0);
				hero.settimeaktivated(100);
			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (hero.getAttackdirection() == 2) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1rechtsCO, position[0] - 20,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2rechtsCO, position[0] - 20,
							position[1] - 20, this);
			}
			if (hero.getAttackdirection() == 1) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1linksCO, position[0] - 20,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2linksCO, position[0] - 20,
							position[1] - 20, this);
			}

			if (hero.getAttackdirection() == 3) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1obenCo, position[0] - 20,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2obenCO, position[0] - 20,
							position[1] - 20, this);
			}
			if (hero.getAttackdirection() == 4) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1untenCO, position[0] - 20,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2untenCO, position[0] - 20,
							position[1] - 20, this);
			}

		}
		if (hero.getAbilitiesaktivated()[1]) {

			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 1);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

				if (((hero.gettarget()[0] - hero.getPosition()[0]) != 0)) {

					if (((hero.gettarget()[1] - hero.getPosition()[1]) == 0 && (hero
							.gettarget()[0] - hero.getPosition()[0]) < 0)) {// links
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1], this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) == 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// rechts
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1], this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) > 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// obenrechts
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1] + (hero.gettime() - 2) * 50,
									this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) < 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// untenrechts
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1] - (hero.gettime() - 2) * 50,
									this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) > 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) < 0) {// obenlinks

						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1] + (hero.gettime() - 2) * 50,
									this);
					}

					if ((hero.gettarget()[1] - hero.getPosition()[1]) < 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) < 0) {// untenlinks
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1] - (hero.gettime() - 2) * 50,
									this);

					}

				} else {
					if (hero.gettarget()[1] - hero.getPosition()[1] <= 0) {
						// oben
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1obenCO, position[0],
									position[1] + 15, this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2obenCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeiloben, position[0], position[1]
									- (hero.gettime() - 2) * 50, this);
					} else {// unten
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1untenCO, position[0],
									position[1] - 15, this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2untenCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)

							g.drawImage(EisPfeilunten, position[0], position[1]
									+ (hero.gettime() - 2) * 50, this);
					}
				}
			}
		}

		if (hero.getAbilitiesaktivated()[2]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 2);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

				if (((hero.gettarget()[0] - hero.getPosition()[0]) != 0)) {

					if (((hero.gettarget()[1] - hero.getPosition()[1]) == 0 && (hero
							.gettarget()[0] - hero.getPosition()[0]) < 0)) {// links
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1], this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) == 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// rechts
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1], this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) > 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// obenrechts
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1] + (hero.gettime() - 2) * 50,
									this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) < 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// untenrechts
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1] - (hero.gettime() - 2) * 50,
									this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) > 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) < 0) {// obenlinks

						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1] + (hero.gettime() - 2) * 50,
									this);
					}

					if ((hero.gettarget()[1] - hero.getPosition()[1]) < 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) < 0) {// untenlinks
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1] - (hero.gettime() - 2) * 50,
									this);

					}

				} else {
					if (hero.gettarget()[1] - hero.getPosition()[1] <= 0) {
						// oben
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1obenCO, position[0],
									position[1] + 15, this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2obenCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeiloben, position[0],
									position[1] - (hero.gettime() - 2) * 50,
									this);
					} else {// unten
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1untenCO, position[0],
									position[1] - 15, this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2untenCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)

							g.drawImage(FrostPfeilunten, position[0],
									position[1] + (hero.gettime() - 2) * 50,
									this);
					}
				}
			}
		}

		//
	}


	/**
	 * @param hero
	 * @param g
	 * @param position
	 *  zeichnet ClitCommander und Spezialattacken.
	 */
	private void paintCC(Hero hero, Graphics g, int[] position) {
		if (hero.getdirection() == 1) {// links
			g.drawImage(Images.heroes.get(hero.getType())[2], position[0],
					position[1], this);
		}

		// rechts
		if (hero.getdirection() == 2) {
			g.drawImage(Images.heroes.get(hero.getType())[0], position[0],
					position[1], this);
		}
		// spezialattacken
		if (hero.getAbilitiesaktivated()[0]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 0);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (hero.getAttackdirection() == 2) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1rechtsCL, position[0] + 50,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2rechtsCL, position[0] + 50,
							position[1] - 20, this);
			}
			if (hero.getAttackdirection() == 1) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1linksCL, position[0] - 90,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2linksCL, position[0] - 90,
							position[1] - 20, this);
			}

			if (hero.getAttackdirection() == 3) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1obenCL, position[0] - 20,
							position[1] - 90, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2obenCL, position[0] - 20,
							position[1] - 90, this);
			}
			if (hero.getAttackdirection() == 4) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1untenCL, position[0] - 20,
							position[1] + 50, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2untenCL, position[0] - 20,
							position[1] + 50, this);
			}

		}
		if (hero.getAbilitiesaktivated()[1]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 1);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (hero.getAttackdirection() == 2) {
				if (attackTime == 0)
					g.drawImage(SecondSkill1rechtsCL, position[0] + 20,
							position[1] - 15, this);
				if (attackTime == 1)
					g.drawImage(SecondSkill2rechtsCL, position[0] + 45,
							position[1] - 20, this);
			}
			if (hero.getAttackdirection() == 1) {
				if (attackTime == 0)
					g.drawImage(SecondSkill1linksCL, position[0] - 40,
							position[1] - 15, this);
				if (attackTime == 1)
					g.drawImage(SecondSkill2linksCL, position[0] - 65,
							position[1] - 20, this);
			}

			if (hero.getAttackdirection() == 3) {
				if (attackTime == 0)
					g.drawImage(SecondSkill1obenCL, position[0] - 10,
							position[1] - 60, this);
				if (attackTime == 1)
					g.drawImage(SecondSkill2obenCL, position[0] - 5,
							position[1] - 85, this);
			}
			if (hero.getAttackdirection() == 4) {
				if (attackTime == 0)
					g.drawImage(SecondSkill1untenCL, position[0] - 10,
							position[1] + 65, this);
				if (attackTime == 1)
					g.drawImage(SecondSkill2untenCL, position[0] - 5,
							position[1] + 85, this);
			}
		}

		if (hero.getAbilitiesaktivated()[2]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 2);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (hero.getAttackdirection() == 2) {
				if (attackTime == 0)
					g.drawImage(ThirdSkill1rechtsCL, position[0] + 20,
							position[1] + 15, this);
				if (attackTime == 1)
					g.drawImage(ThirdSkill2rechtsCL, position[0] + 30,
							position[1] + 25, this);
			}
			if (hero.getAttackdirection() == 1) {
				if (attackTime == 0)
					g.drawImage(ThirdSkill1linksCL, position[0] - 30,
							position[1] - 15, this);
				if (attackTime == 1)
					g.drawImage(ThirdSkill2linksCL, position[0] - 40,
							position[1] - 5, this);
			}

			if (hero.getAttackdirection() == 3) {
				if (attackTime == 0)
					g.drawImage(ThirdSkill1obenCL, position[0] - 10,
							position[1] - 40, this);
				if (attackTime == 1)
					g.drawImage(ThirdSkill2obenCL, position[0] - 5,
							position[1] - 35, this);
			}
			if (hero.getAttackdirection() == 4) {
				if (attackTime == 0)
					g.drawImage(ThirdSkill1untenCL, position[0] + 20,
							position[1] + 25, this);
				if (attackTime == 1)
					g.drawImage(ThirdSkill2untenCL, position[0] + 10,
							position[1] + 35, this);
			}
		}

	}

	// 
	/**
	 * @param hero
	 * @param g
	 * @param position
	 * zeichnet Dangerdan und Spezialattacken.
	 */
	private void paintDD(Hero hero, Graphics g, int[] position) {

		if (hero.getAbilitiesaktivated()[1]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 1);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			g.drawImage(SecondSkill2untenDD, position[0] - 8, position[1] - 8,
					this);
			if (attackTime == 0)
				g.drawImage(SecondSkill1untenDD, position[0] - 8,
						position[1] - 8, this);
			if (attackTime == 1)
				g.drawImage(SecondSkill2untenDD, position[0] - 8,
						position[1] - 8, this);
		}
		if (hero.getAbilitiesaktivated()[2]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 2);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (attackTime == 1)
				g.drawImage(ThirdSkill1rechtsDD, position[0] - 20,
						position[1] + 30, this);
			if (attackTime == 0)
				g.drawImage(ThirdSkill2rechtsDD, position[0] - 25,
						position[1] + 30, this);
		}

		if (hero.getdirection() == 1) {// links
			g.drawImage(Images.heroes.get(hero.getType())[2], position[0],
					position[1], this);
		}

		// rechts
		if (hero.getdirection() == 2) {
			g.drawImage(Images.heroes.get(hero.getType())[0], position[0],
					position[1], this);
		}

		// spezialattacken
		if (hero.getAbilitiesaktivated()[0]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 0);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (hero.getAttackdirection() == 2) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1rechtsDD, position[0] - 15,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2rechtsDD, position[0] - 15,
							position[1] - 20, this);
			}
			if (hero.getAttackdirection() == 1) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1linksDD, position[0] - 35,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2linksDD, position[0] - 35,
							position[1] - 20, this);
			}

			if (hero.getAttackdirection() == 3) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1obenDD, position[0] - 20,
							position[1] - 40, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2obenDD, position[0] - 20,
							position[1] - 40, this);
			}
			if (hero.getAttackdirection() == 4) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1untenDD, position[0] - 10,
							position[1] + 10, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill2untenDD, position[0] - 10,
							position[1] + 10, this);
			}

		}
	}

	//
	/**
	 * @param hero
	 * @param g
	 * @param position
	 *  zeichnet FamousFlorian und Spezialattacken.
	 */
	private void paintFlo(Hero hero, Graphics g, int[] position) {
		if (hero.getAbilitiesaktivated()[1]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 1);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (attackTime == 1)
				g.drawImage(SecondSkill1rechtsFL, position[0] - 20,
						position[1] - 15, this);
			if (attackTime == 0)
				g.drawImage(SecondSkill2rechtsFL, position[0] - 20,
						position[1] - 20, this);
		}

		if (hero.getdirection() == 1) {// links
			g.drawImage(Images.heroes.get(hero.getType())[0], position[0],
					position[1], this);
		}

		// rechts
		if (hero.getdirection() == 2) {
			g.drawImage(Images.heroes.get(hero.getType())[2], position[0],
					position[1], this);
		}
		if (hero.getAbilitiesaktivated()[0]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 0);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (attackTime == 1)
				g.drawImage(FirstSkill1rechtsFL, position[0] - 20,
						position[1] + 30, this);
			if (attackTime == 0)
				g.drawImage(FirstSkill2rechtsFL, position[0] - 20,
						position[1] + 30, this);
		}

		if (hero.getAbilitiesaktivated()[2]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 2);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (attackTime == 1)
				g.drawImage(ThirdSkill1rechtsFL, position[0] - 20,
						position[1] + 20, this);
			if (attackTime == 0)
				g.drawImage(ThirdSkill2rechtsFL, position[0] - 20,
						position[1] + 20, this);
		}

	}

	
	/**
	 * @param hero
	 * @param g
	 * @param position
	 * zeichnet FederalFelix und Spezialattacken.
	 */
	private void paintFe(Hero hero, Graphics g, int[] position) {
		if (hero.getAbilitiesaktivated()[1]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 1);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (attackTime == 1)
				g.drawImage(SecondSkill1rechtsFE, position[0] - 20,
						position[1] - 15, this);
			if (attackTime == 0)
				g.drawImage(SecondSkill2rechtsFE, position[0] - 25,
						position[1] - 20, this);
		}

		if (hero.getdirection() == 1) {// links
			g.drawImage(Images.heroes.get(hero.getType())[2], position[0],
					position[1], this);
		}

		// rechts
		if (hero.getdirection() == 2) {
			g.drawImage(Images.heroes.get(hero.getType())[0], position[0],
					position[1], this);
		}
		if (hero.getAbilitiesaktivated()[0]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 0);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (hero.getAttackdirection() == 2) {
				if (attackTime == 1)
					g.drawImage(FirstSkill1rechtsFE, position[0] + 30,
							position[1] + 10, this);
				if (attackTime == 0)
					g.drawImage(FirstSkill2rechtsFE, position[0] + 60,
							position[1] + 10, this);
			}
			if (hero.getAttackdirection() == 1) {
				if (attackTime == 1)
					g.drawImage(FirstSkill1linksFE, position[0] - 50,
							position[1] + 10, this);
				if (attackTime == 0)
					g.drawImage(FirstSkill2linksFE, position[0] - 80,
							position[1] + 10, this);
			}

			if (hero.getAttackdirection() == 3) {
				if (attackTime == 1)
					g.drawImage(FirstSkill1obenFE, position[0] - 20,
							position[1] - 50, this);
				if (attackTime == 0)
					g.drawImage(FirstSkill2obenFE, position[0] - 20,
							position[1] - 90, this);
			}
			if (hero.getAttackdirection() == 4) {
				if (attackTime == 1)
					g.drawImage(FirstSkill1untenFE, position[0] - 20,
							position[1] + 40, this);
				if (attackTime == 0)
					g.drawImage(FirstSkill2untenFE, position[0] - 20,
							position[1] + 80, this);
			}

		}

		if (hero.getAbilitiesaktivated()[2]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 2);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

				if (((hero.gettarget()[0] - hero.getPosition()[0]) != 0)) {

					if (((hero.gettarget()[1] - hero.getPosition()[1]) == 0 && (hero
							.gettarget()[0] - hero.getPosition()[0]) < 0))// links
						g.drawImage(ThirdSkill1linksFE, position[0] - timeFE
								* 25, position[1], this);
					if ((hero.gettarget()[1] - hero.getPosition()[1]) == 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0)// rechts
						g.drawImage(ThirdSkill1rechtsFE, position[0] + timeFE
								* 25, position[1], this);

					if ((hero.gettarget()[1] - hero.getPosition()[1]) > 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0)// obenrechts
						g.drawImage(ThirdSkill1rechtsFE, position[0] + timeFE
								* 25, position[1] + timeFE * 25, this);
					if ((hero.gettarget()[1] - hero.getPosition()[1]) < 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0)// untenrechts
						g.drawImage(ThirdSkill1rechtsFE, position[0] + timeFE
								* 25, position[1] - timeFE * 25, this);

					if ((hero.gettarget()[1] - hero.getPosition()[1]) > 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) < 0)// obenlinks
						g.drawImage(ThirdSkill1linksFE, position[0] - timeFE
								* 25, position[1] + timeFE * 25, this);
					if ((hero.gettarget()[1] - hero.getPosition()[1]) < 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) < 0)// untenlinks
						g.drawImage(ThirdSkill1linksFE, position[0] - timeFE
								* 25, position[1] - timeFE * 25, this);

				} else {
					if (hero.gettarget()[1] - hero.getPosition()[1] <= 0)
						g.drawImage(ThirdSkill1obenFE, position[0], position[1]
								- timeFE * 25, this);
					else
						g.drawImage(ThirdSkill1untenFE, position[0],
								position[1] + timeFE * 25, this);
				}
			}

		}

	}

	//
	/**
	 * @param hero
	 * @param g
	 * @param position
	 *  zeichnet GenerealHate und Spezialattacken.
	 */
	private void paintG(Hero hero, Graphics g, int[] position) {
		if (hero.getAbilitiesaktivated()[1]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 1);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}

			if (attackTime == 1)
				g.drawImage(SecondSkill1rechtsFE, position[0] - 50,
						position[1] - 15, this);
			if (attackTime == 0)
				g.drawImage(SecondSkill2rechtsFE, position[0] - 50,
						position[1] - 20, this);
		}

		if (hero.getdirection() == 1) {// links
			g.drawImage(Images.heroes.get(hero.getType())[0], position[0],
					position[1], this);
		}

		// rechts
		if (hero.getdirection() == 2) {
			g.drawImage(Images.heroes.get(hero.getType())[2], position[0],
					position[1], this);
		}
		if (hero.getAbilitiesaktivated()[0]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 0);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (hero.getAttackdirection() == 2) {
				if (attackTime == 1)
					g.drawImage(FirstSkill1rechtsFE, position[0] - 10,
							position[1] - 15, this);
				if (attackTime == 0)
					g.drawImage(FirstSkill2rechtsFE, position[0] - 5,
							position[1] - 20, this);
			}
			if (hero.getAttackdirection() == 1) {
				if (attackTime == 1)
					g.drawImage(FirstSkill1linksFE, position[0] - 30,
							position[1] - 15, this);
				if (attackTime == 0)
					g.drawImage(FirstSkill2linksFE, position[0] - 35,
							position[1] - 15, this);
			}

			if (hero.getAttackdirection() == 3) {
				if (attackTime == 1)
					g.drawImage(FirstSkill1obenFE, position[0] - 20,
							position[1] - 50, this);
				if (attackTime == 0)
					g.drawImage(FirstSkill2obenFE, position[0] - 20,
							position[1] - 90, this);
			}
			if (hero.getAttackdirection() == 4) {
				if (attackTime == 1)
					g.drawImage(FirstSkill1untenFE, position[0] - 20,
							position[1] + 40, this);
				if (attackTime == 0)
					g.drawImage(FirstSkill2untenFE, position[0] - 20,
							position[1] + 80, this);
			}

		}

		if (hero.getAbilitiesaktivated()[2]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 2);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (hero.getAttackdirection() == 2) {
				if (attackTime == 1)
					g.drawImage(ThirdSkill1rechtsFE, position[0] + 80,
							position[1] - 15, this);
				if (attackTime == 0)
					g.drawImage(ThirdSkill2rechtsFE, position[0] + 120,
							position[1] - 20, this);
			}
			if (hero.getAttackdirection() == 1) {
				if (attackTime == 1)
					g.drawImage(ThirdSkill1linksFE, position[0] - 100,
							position[1] - 15, this);
				if (attackTime == 0)
					g.drawImage(ThirdSkill2linksFE, position[0] - 140,
							position[1] - 20, this);
			}

			if (hero.getAttackdirection() == 3) {
				if (attackTime == 1)
					g.drawImage(ThirdSkill1obenFE, position[0] - 10,
							position[1] - 120, this);
				if (attackTime == 0)
					g.drawImage(ThirdSkill2obenFE, position[0] - 5,
							position[1] - 160, this);
			}
			if (hero.getAttackdirection() == 4) {
				if (attackTime == 1)
					g.drawImage(ThirdSkill1untenFE, position[0] - 10,
							position[1] + 50, this);
				if (attackTime == 0)
					g.drawImage(ThirdSkill2untenFE, position[0] - 5,
							position[1] + 90, this);
			}
		}

	}

	// 
	/**
	 * @param hero
	 * @param g
	 * @param position
	 * zeichnet SafetySteven und Spezialattacken.
	 */
	private void paintSa(Hero hero, Graphics g, int[] position) {
		if (hero.getAbilitiesaktivated()[1]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 9) {
				hero.setAbilitiesaktivated(false, 1);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
		}
		if (!hero.getAbilitiesaktivated()[1]) {
			g.setColor(Color.black);
			g.fillRect(position[0], position[1], 53, 6);
			g.setColor(Color.green);
			if (hero.get_Akt_Life() >= 0)
				g.fillRect(position[0] + 1, position[1] + 1,
						(hero.get_Akt_Life() * 51 / hero.getvalue()[6]), 4);
			if (hero.getAbilitiesaktivated()[2]) {
				if (hero.gettimeaktivated() > hero.gettime())
					hero.settimeaktivated(hero.gettime());
				if (hero.gettime() > hero.gettimeaktivated() + 8) {
					hero.setAbilitiesaktivated(false, 2);
					hero.settimeaktivated(100);
					hero.resettime();

				} else {
					hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

				}

				if (attackTime == 1)
					g.drawImage(ThirdSkill1rechtsSA, position[0] - 200,
							position[1] - 200, this);
				if (attackTime == 0)
					g.drawImage(ThirdSkill2rechtsSA, position[0] - 200,
							position[1] - 200, this);
			} else {
				if (hero.getdirection() == 1) {// links
					g.drawImage(Images.heroes.get(hero.getType())[0],
							position[0], position[1], this);
				}

				// rechts
				if (hero.getdirection() == 2) {
					g.drawImage(Images.heroes.get(hero.getType())[2],
							position[0], position[1], this);
				}
			}

			// spezialattacken
			if (hero.getAbilitiesaktivated()[0]) {
				if (hero.gettimeaktivated() > hero.gettime())
					hero.settimeaktivated(hero.gettime());
				if (hero.gettime() > hero.gettimeaktivated() + 8) {
					hero.setAbilitiesaktivated(false, 0);
					hero.settimeaktivated(100);
					hero.resettime();

				} else {
					hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

				}
				if (hero.getAttackdirection() == 2) {
					if (attackTime == 1)
						g.drawImage(FirstSkill1rechtsSA, position[0] - 20,
								position[1] - 20, this);
					if (attackTime == 0)
						g.drawImage(FirstSkill2rechtsSA, position[0] - 25,
								position[1] - 15, this);
				}
				if (hero.getAttackdirection() == 1) {
					if (attackTime == 1)
						g.drawImage(FirstSkill1linksSA, position[0] - 120,
								position[1] - 20, this);
					if (attackTime == 0)
						g.drawImage(FirstSkill2linksSA, position[0] - 115,
								position[1] - 15, this);
				}

				if (hero.getAttackdirection() == 3) {
					if (attackTime == 1)
						g.drawImage(FirstSkill1obenSA, position[0] - 80,
								position[1] - 100, this);
					if (attackTime == 0)
						g.drawImage(FirstSkill2obenSA, position[0] - 85,
								position[1] - 95, this);
				}
				if (hero.getAttackdirection() == 4) {
					if (attackTime == 1)
						g.drawImage(FirstSkill1untenSA, position[0] - 80,
								position[1] + 50, this);
					if (attackTime == 0)
						g.drawImage(FirstSkill2untenSA, position[0] - 85,
								position[1] + 45, this);
				}

			}

		}
	}

	// 
	/**
	 * @param hero
	 * @param g
	 * @param position
	 * paintme serious sven
	 */
	private void paintSS(Hero hero, Graphics g, int[] position) {

		if (hero.getdirection() == 1) {// links
			g.drawImage(Images.heroes.get(hero.getType())[2], position[0],
					position[1], this);
		}

		// rechts
		if (hero.getdirection() == 2) {
			g.drawImage(Images.heroes.get(hero.getType())[0], position[0],
					position[1], this);
		}
		// spezialattacken
		if (hero.getAbilitiesaktivated()[0]) {
			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 0);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

			}
			if (hero.getAttackdirection() == 2) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1linksSS, position[0] - 20,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill1linksSS, position[0] - 20,
							position[1] - 20, this);
			}
			if (hero.getAttackdirection() == 1) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1linksSS, position[0] - 20,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill1linksSS, position[0] - 20,
							position[1] - 20, this);
			}

			if (hero.getAttackdirection() == 3) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1linksSS, position[0] - 20,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill1linksSS, position[0] - 20,
							position[1] - 20, this);
			}
			if (hero.getAttackdirection() == 4) {
				if (attackTime == 0)
					g.drawImage(FirstSkill1linksSS, position[0] - 20,
							position[1] - 20, this);
				if (attackTime == 1)
					g.drawImage(FirstSkill1linksSS, position[0] - 20,
							position[1] - 20, this);
			}

		}
		if (hero.getAbilitiesaktivated()[1]) {

			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 1);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

				if (((hero.gettarget()[0] - hero.getPosition()[0]) != 0)) {

					if (((hero.gettarget()[1] - hero.getPosition()[1]) == 0 && (hero
							.gettarget()[0] - hero.getPosition()[0]) < 0)) {// links
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1], this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) == 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// rechts
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1], this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) > 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// obenrechts
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1] + (hero.gettime() - 2) * 50,
									this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) < 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// untenrechts
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1] - (hero.gettime() - 2) * 50,
									this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) > 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) < 0) {// obenlinks

						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1] + (hero.gettime() - 2) * 50,
									this);
					}

					if ((hero.gettarget()[1] - hero.getPosition()[1]) < 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) < 0) {// untenlinks
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1] - (hero.gettime() - 2) * 50,
									this);

					}

				} else {
					if (hero.gettarget()[1] - hero.getPosition()[1] <= 0) {
						// oben
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1obenCO, position[0],
									position[1] + 15, this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2obenCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(EisPfeiloben, position[0], position[1]
									- (hero.gettime() - 2) * 50, this);
					} else {// unten
						if (hero.gettime() == 1)
							g.drawImage(SecondSkill1untenCO, position[0],
									position[1] - 15, this);
						if (hero.gettime() == 2)
							g.drawImage(SecondSkill2untenCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)

							g.drawImage(EisPfeilunten, position[0], position[1]
									+ (hero.gettime() - 2) * 50, this);
					}
				}
			}
		}

		if (hero.getAbilitiesaktivated()[2]) {

			if (hero.gettimeaktivated() > hero.gettime())
				hero.settimeaktivated(hero.gettime());
			if (hero.gettime() > hero.gettimeaktivated() + 8) {
				hero.setAbilitiesaktivated(false, 2);
				hero.settimeaktivated(100);
				hero.resettime();

			} else {
				hero.settime(hero.gettime() - hero.gettimeaktivated() + 1);

				if (((hero.gettarget()[0] - hero.getPosition()[0]) != 0)) {

					if (((hero.gettarget()[1] - hero.getPosition()[1]) == 0 && (hero
							.gettarget()[0] - hero.getPosition()[0]) < 0)) {// links
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1], this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) == 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// rechts
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1], this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) > 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// obenrechts
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1] + (hero.gettime() - 2) * 50,
									this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) < 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) > 0) {// untenrechts
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1rechtsCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2rechtsCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeilrechts,
									position[0] + (hero.gettime() - 2) * 50,
									position[1] - (hero.gettime() - 2) * 50,
									this);
					}
					if ((hero.gettarget()[1] - hero.getPosition()[1]) > 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) < 0) {// obenlinks

						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1] + (hero.gettime() - 2) * 50,
									this);
					}

					if ((hero.gettarget()[1] - hero.getPosition()[1]) < 0
							&& (hero.gettarget()[0] - hero.getPosition()[0]) < 0) {// untenlinks
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1linksCO, position[0] - 15,
									position[1], this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2linksCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeillinks,
									position[0] - (hero.gettime() - 2) * 50,
									position[1] - (hero.gettime() - 2) * 50,
									this);

					}

				} else {
					if (hero.gettarget()[1] - hero.getPosition()[1] <= 0) {
						// oben
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1obenCO, position[0],
									position[1] + 15, this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2obenCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)
							g.drawImage(FrostPfeiloben, position[0],
									position[1] - (hero.gettime() - 2) * 50,
									this);
					} else {// unten
						if (hero.gettime() == 1)
							g.drawImage(ThirdSkill1untenCO, position[0],
									position[1] - 15, this);
						if (hero.gettime() == 2)
							g.drawImage(ThirdSkill2untenCO, position[0],
									position[1], this);
						if (hero.gettime() > 2)

							g.drawImage(FrostPfeilunten, position[0],
									position[1] + (hero.gettime() - 2) * 50,
									this);
					}
				}
			}
		}

		//
	}

	public void setfog(boolean fog) {
		this.Fog = fog;
	}

}
