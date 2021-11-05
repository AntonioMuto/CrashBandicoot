package View;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {
	
 private Image icon;
 private Image menuLvl1;
 private Image menuLvl2;
 private Image menuLvl2Locked;
 private Image menu1;
 private Image menu2;
 private Image menu3;
 private Image TerraTyleSnow; 
 private Image TerraTyle; 
 private Image GroundTyleSnow;
 private Image GroundTyle;
 private Image cerbottana3;
 private Image cerbottana2;
 private Image cerbottana1;
 private Image arrow;
 private Image jumpS2;
 private Image jumpS1;
 private Image boxTNT;
 private Image jumpR5;
 private Image jumpR4;
 private Image jumpR3;
 private Image jumpR2;
 private Image jumpR1;
 private Image jumpup3sx;
 private Image jumpup2sx;
 private Image jumpup1sx;
 private Image jumpup3;
 private Image jumpup2;
 private Image jumpup1;
 private Image downsx;
 private Image down;
 private Image akudx;
 private Image akusx;
 private Image aku2dx;
 private Image aku2;
 private Image spin2;
 private Image spin1;
 private Image rundx3;
 private Image rundx2;
 private Image runsx3;
 private Image runsx2;
 private Image runsx1;
 private Image rundx1;
 private Image bg;
 private Image bgSnow;
 private Image crashdx;
 private Image crashsx;
 private Image boxBase;
 private Image hitEnemy; 
 private Image writeCheck;
 private Image maskBox;
 private Image checkpoint;
 private Image crystal;
 private Image explosion;
 private Image tnt3;
 private Image tnt2;
 private Image tnt1;
 private Image brokenBox;
 private Image wumpa;
 private Image down2sx;
 private Image down1sx;
 private Image down2dx;
 private Image down1dx;
 private Image jumpS5;
 private Image jumpS4;
 private Image jumpS3;
 private Image GameOverNo;
 private Image GameOverSi;
 private Image PauseR__;
 private Image PauseQ__;
 private Image PauseRGC;
 private Image PauseQGC;
 private Image PauseRG_;
 private Image PauseQG_;
 private Image PauseR_C;
 private Image PauseQ_C;
 private Image wumpaGUI;
 private Image boxGUI;
 private Image unlocrystalGUI;
 private Image crystalGUI;
 private Image gemGUI;
 private Image unlogemGUI;
 private Image gem;
 private Image portalEnd;
 private Image endLevel;
 private Image woodCommands;
 private Image dinoWalk1dx;
 private Image dinoWalk2dx;
 private Image dinoWalk3dx;
 private Image dinoWalk4dx;
 private Image dinoWalk5dx;
 private Image dinoWalk1sx;
 private Image dinoWalk2sx;
 private Image dinoWalk3sx;
 private Image dinoWalk4sx;
 private Image dinoWalk5sx;
 private Image loading;
 
 Images(){ 
	 try {				
		 menuLvl2Locked = ImageIO.read(getClass().getResourceAsStream("/resources/level_2_locked.png"));		 
		 loading = ImageIO.read(getClass().getResourceAsStream("/resources/loading.jpg"));		 
		 PauseQ_C = ImageIO.read(getClass().getResourceAsStream("/resources/PausaQ_C.png"));		 
		 PauseR_C = ImageIO.read(getClass().getResourceAsStream("/resources/PausaR_C.png"));		 
		 PauseQG_ = ImageIO.read(getClass().getResourceAsStream("/resources/PausaQG_.png"));		 
		 PauseRG_ = ImageIO.read(getClass().getResourceAsStream("/resources/PausaRG_.png"));		 
		 PauseQGC = ImageIO.read(getClass().getResourceAsStream("/resources/PausaQGC.png"));		 
		 PauseRGC = ImageIO.read(getClass().getResourceAsStream("/resources/PausaRGC.png"));		 
		 PauseQ__ = ImageIO.read(getClass().getResourceAsStream("/resources/PausaQ__.png"));		 
		 PauseR__ = ImageIO.read(getClass().getResourceAsStream("/resources/PausaR__.png"));		 
		 woodCommands = ImageIO.read(getClass().getResourceAsStream("/resources/woodCommands.png"));
		 endLevel = ImageIO.read(getClass().getResourceAsStream("/resources/end_level.png"));
		 portalEnd = ImageIO.read(getClass().getResourceAsStream("/resources/portal_end.png"));
		 gem = ImageIO.read(getClass().getResourceAsStream("/resources/gem_red.png"));
		 gemGUI = ImageIO.read(getClass().getResourceAsStream("/resources/GemredGUI.png"));
		 unlogemGUI = ImageIO.read(getClass().getResourceAsStream("/resources/unloGemredGUI.png"));
		 unlocrystalGUI = ImageIO.read(getClass().getResourceAsStream("/resources/PurpleCrystal_unlocked.png"));
		 crystalGUI = ImageIO.read(getClass().getResourceAsStream("/resources/PurpleCrystal.png"));
		 boxGUI = ImageIO.read(getClass().getResourceAsStream("/resources/boxcount.png"));
		 wumpaGUI = ImageIO.read(getClass().getResourceAsStream("/resources/wumpa_gui.png"));
		 GameOverSi = ImageIO.read(getClass().getResourceAsStream("/resources/gameoverPanelSi.png"));
		 GameOverNo = ImageIO.read(getClass().getResourceAsStream("/resources/gameoverPanelNo.png"));
		 aku2dx = ImageIO.read(getClass().getResourceAsStream("/resources/aku2dx.png"));
		 aku2 = ImageIO.read(getClass().getResourceAsStream("/resources/aku2.png"));
		 menuLvl1 = ImageIO.read(getClass().getResourceAsStream("/resources/level_1_tile.png"));
		 menuLvl2 = ImageIO.read(getClass().getResourceAsStream("/resources/level_2_tile.png"));
		 menu1 = ImageIO.read(getClass().getResourceAsStream("/resources/MenuImage_start.png"));
		 menu2 = ImageIO.read(getClass().getResourceAsStream("/resources/MenuImage_levels.png"));
		 menu3 = ImageIO.read(getClass().getResourceAsStream("/resources/MenuImage_exit.png"));
		 icon = ImageIO.read(getClass().getResourceAsStream("/resources/icona.png"));
		 TerraTyleSnow = ImageIO.read(getClass().getResourceAsStream("/resources/Snow_terra_tyle.png"));
		 TerraTyle = ImageIO.read(getClass().getResourceAsStream("/resources/terra.png"));
		 GroundTyleSnow = ImageIO.read(getClass().getResourceAsStream("/resources/Snow_ground_Tyle.png"));
		 GroundTyle = ImageIO.read(getClass().getResourceAsStream("/resources/GroundTyle.png"));
		 cerbottana3 = ImageIO.read(getClass().getResourceAsStream("/resources/cerbottana3.png"));
		 cerbottana2 = ImageIO.read(getClass().getResourceAsStream("/resources/cerbottana2.png"));
		 cerbottana1 = ImageIO.read(getClass().getResourceAsStream("/resources/cerbottana1.png"));
		 arrow = ImageIO.read(getClass().getResourceAsStream("/resources/stone.png"));
		 hitEnemy = ImageIO.read(getClass().getResourceAsStream("/resources/hitEnemy.png"));
	  	 maskBox = ImageIO.read(getClass().getResourceAsStream("/resources/maskbox.png"));
	  	 crystal = ImageIO.read(getClass().getResourceAsStream("/resources/Crystal.png"));
	  	 explosion = ImageIO.read(getClass().getResourceAsStream("/resources/explosion.png"));
	  	 tnt3 = ImageIO.read(getClass().getResourceAsStream("/resources/tnt3.png"));
	  	 tnt2 = ImageIO.read(getClass().getResourceAsStream("/resources/tnt2.png"));
	  	 tnt1 = ImageIO.read(getClass().getResourceAsStream("/resources/tnt1.png"));
	  	 brokenBox = ImageIO.read(getClass().getResourceAsStream("/resources/BrokenBox.png"));
	  	 wumpa = ImageIO.read(getClass().getResourceAsStream("/resources/wumpa.png"));
	  	 jumpS5 = ImageIO.read(getClass().getResourceAsStream("/resources/jumpS5.png"));
	  	 jumpS4 = ImageIO.read(getClass().getResourceAsStream("/resources/jumpS4.png"));
	  	 jumpS3 = ImageIO.read(getClass().getResourceAsStream("/resources/jumpS3.png"));
	  	 jumpS2 = ImageIO.read(getClass().getResourceAsStream("/resources/jumpS2.png"));
	  	 jumpS1 = ImageIO.read(getClass().getResourceAsStream("/resources/jumpS1.png"));
	  	 boxTNT = ImageIO.read(getClass().getResourceAsStream("/resources/tnt.png"));
	  	 jumpR5 = ImageIO.read(getClass().getResourceAsStream("/resources/jumpR5.png"));
	  	 jumpR4 = ImageIO.read(getClass().getResourceAsStream("/resources/jumpR4.png"));
	  	 jumpR3 = ImageIO.read(getClass().getResourceAsStream("/resources/jumpR3.png"));
	  	 jumpR2 = ImageIO.read(getClass().getResourceAsStream("/resources/jumpR2.png"));
	  	 jumpR1 = ImageIO.read(getClass().getResourceAsStream("/resources/jumpR1.png"));
	  	 jumpup3sx = ImageIO.read(getClass().getResourceAsStream("/resources/jump3sx.png"));
	  	 jumpup2sx = ImageIO.read(getClass().getResourceAsStream("/resources/jump2sx.png"));
	  	 jumpup1sx = ImageIO.read(getClass().getResourceAsStream("/resources/jump1sx.png"));
	     jumpup3 = ImageIO.read(getClass().getResourceAsStream("/resources/jump3dx.png"));
	     jumpup2 = ImageIO.read(getClass().getResourceAsStream("/resources/jump2dx.png"));
	     jumpup1 = ImageIO.read(getClass().getResourceAsStream("/resources/jump1dx.png"));
	     downsx = ImageIO.read(getClass().getResourceAsStream("/resources/downsx.png"));
	     down = ImageIO.read(getClass().getResourceAsStream("/resources/down.png"));
	     akudx = ImageIO.read(getClass().getResourceAsStream("/resources/akudx.png"));
	     akusx = ImageIO.read(getClass().getResourceAsStream("/resources/aku.png")); 
	     spin2 = ImageIO.read(getClass().getResourceAsStream("/resources/spin2.png"));
	     spin1 = ImageIO.read(getClass().getResourceAsStream("/resources/spin1.png"));
	     rundx3 = ImageIO.read(getClass().getResourceAsStream("/resources/rundx3.png"));
	     rundx2 = ImageIO.read(getClass().getResourceAsStream("/resources/rundx2.png"));
	     runsx3 = ImageIO.read(getClass().getResourceAsStream("/resources/runsx3.png"));  
	     runsx2 = ImageIO.read(getClass().getResourceAsStream("/resources/runsx2.png"));  
	     runsx1 = ImageIO.read(getClass().getResourceAsStream("/resources/runsx1.png"));  
	     rundx1 = ImageIO.read(getClass().getResourceAsStream("/resources/rundx1.png"));
	     bg = ImageIO.read(getClass().getResourceAsStream("/resources/BackGround.png"));
	     bgSnow = ImageIO.read(getClass().getResourceAsStream("/resources/BackGroundSnow.png"));
	     crashdx = ImageIO.read(getClass().getResourceAsStream("/resources/posa.png"));
	     crashsx = ImageIO.read(getClass().getResourceAsStream("/resources/posasx.png"));
	     boxBase = ImageIO.read(getClass().getResourceAsStream("/resources/box.png"));
	     dinoWalk1dx = ImageIO.read(getClass().getResourceAsStream("/resources/dinoWalk1dx.png"));
	     dinoWalk2dx = ImageIO.read(getClass().getResourceAsStream("/resources/dinoWalk2dx.png"));
	     dinoWalk3dx = ImageIO.read(getClass().getResourceAsStream("/resources/dinoWalk3dx.png"));
	     dinoWalk4dx = ImageIO.read(getClass().getResourceAsStream("/resources/dinoWalk4dx.png"));
	     dinoWalk5dx = ImageIO.read(getClass().getResourceAsStream("/resources/dinoWalk5dx.png"));
	     dinoWalk1sx = ImageIO.read(getClass().getResourceAsStream("/resources/dinoWalk1sx.png"));
	     dinoWalk2sx = ImageIO.read(getClass().getResourceAsStream("/resources/dinoWalk2sx.png"));
	     dinoWalk3sx = ImageIO.read(getClass().getResourceAsStream("/resources/dinoWalk3sx.png"));
	     dinoWalk4sx = ImageIO.read(getClass().getResourceAsStream("/resources/dinoWalk4sx.png"));
	     dinoWalk5sx = ImageIO.read(getClass().getResourceAsStream("/resources/dinoWalk5sx.png"));
	     
   }catch (IOException e) {
	 }
	 
 }
 
 public Image getEndLevel() {
	return endLevel;
 }
 
 public Image getPortalEnd() {
	return portalEnd;
 }
 
 public Image getBoxGUI() {
	return boxGUI;
 }
 
 public Image getWoodCommands() {
	return woodCommands;
 }
 public Image getunloCrystalGUI() {
	return unlocrystalGUI;
 }
 
 public Image getGem() {
	return gem;
 }	
 
 public Image getGemGUI() {
	return gemGUI;
 }
 
 public Image getUnlogemGUI() {
	return unlogemGUI;
}
 
 public Image getUnlocrystalGUI() {
	return unlocrystalGUI;
}
 
 public Image getCrystalGUI() {
		return crystalGUI;
 }
 
 public Image getGameOverNo() {
	return GameOverNo;
 }
 
 public Image getGameOverSi() {
	return GameOverSi;
 }
 
 public Image getMenu3() {
	return menu3;
 }
 
 public Image getMenu2() {
	return menu2;
 }
 
 public Image getMenu1() {
	return menu1;
 }
 
 public Image getMenuLvl1() {
	return menuLvl1;
 }
 
 public Image getMenuLvl2() {
	return menuLvl2;
 }
 
 public Image getIcon() {
	return icon;
 } 
  
public Image getCrashdx() {
	return crashdx;
}

public Image getBg() {
	return bg;
}

public Image getBgSnow() {
	return bgSnow;
}

public Image getLoading() {
	return loading;
}

public Image getBoxBase() {
	return boxBase;
}

public Image getCrashsx() {
	return crashsx;
}

public Image getRundx1() {
	return rundx1;
}

public Image getRunsx1() {
	return runsx1;
}

public Image getRunsx2() {
	return runsx2;
}

public Image getRunsx3() {
	return runsx3;
}

public Image getRundx2() {
	return rundx2;
}

public Image getRundx3() {
	return rundx3;
}

public Image getSpin1() {
	return spin1;
}

public Image getSpin2() {
	return spin2;
}

public Image getAkusx() {
	return akusx;
}

public Image getAkudx() {
	return akudx;
}

public Image getDowndx() {
	return down;
}

public Image getDownsx() {
	return downsx;
}

public Image getJumpup1() {
	return jumpup1;
}

public Image getJumpup2() {
	return jumpup2;
}

public Image getJumpup3() {
	return jumpup3;
}

public Image getJumpup1sx() {
	return jumpup1sx;
}

public Image getJumpup2sx() {
	return jumpup2sx;
}

public Image getJumpup3sx() {
	return jumpup3sx;
}
public Image getJumpR1() {
	return jumpR1;
}
public Image getJumpR2() {
	return jumpR2;
}
public Image getJumpR3() {
	return jumpR3;
}
public Image getJumpR4() {
	return jumpR4;
}
public Image getJumpR5() {
	return jumpR5;
}
public Image getBoxTNT() {
	return boxTNT;
}
public Image getJumpS1() {
	return jumpS1;
}
public Image getJumpS2() {
	return jumpS2;
}
public Image getJumpS3() {
	return jumpS3;
}
public Image getJumpS4() {
	return jumpS4;
}
public Image getJumpS5() {
	return jumpS5;
}

public Image getDown1dx() {
	return down1dx;
}

public Image getDown2dx() {
	return down2dx;
}

public Image getDown1sx() {
	return down1sx;
}

public Image getDown2sx() {
	return down2sx;
}

public Image getWumpa() {
	return wumpa;
}

public Image getBrokenBox() {
	return brokenBox;
}

public Image getTnt1() {
	return tnt1;
}

public Image getTnt2() {
	return tnt2;
}

public Image getTnt3() {
	return tnt3;
}

public Image getExplosion() {
	return explosion;
}

public Image getCrystal() {
	return crystal;
}

public Image getCheckpoint() {
	return checkpoint;
}

public Image getMaskBox() {
	return maskBox;
}

public Image getWriteCheck() {
	return writeCheck;
}

public Image getHitEnemy() {
	return hitEnemy;
}

public Image getDinoWalk1dx() {
	return dinoWalk1dx;
}

public Image getDinoWalk2dx() {
	return dinoWalk2dx;
}

public Image getDinoWalk3dx() {
	return dinoWalk3dx;
}

public Image getDinoWalk4dx() {
	return dinoWalk4dx;
}

public Image getDinoWalk5dx() {
	return dinoWalk5dx;
}

public Image getDinoWalk1sx() {
	return dinoWalk1sx;
}

public Image getDinoWalk2sx() {
	return dinoWalk2sx;
}

public Image getDinoWalk3sx() {
	return dinoWalk3sx;
}

public Image getDinoWalk4sx() {
	return dinoWalk4sx;
}

public Image getDinoWalk5sx() {
	return dinoWalk5sx;
}

public Image getCerbottana1() {
	return cerbottana1;
}

public Image getCerbottana2() {
	return cerbottana2;
}

public Image getCerbottana3() {
	return cerbottana3;
}

public Image getArrow() {
	return arrow;
}

public Image getGroundTyle() {
	return GroundTyle;
}

public Image getTerraTyle() {
	return TerraTyle;
}

public Image getGroundTyleSnow() {
	return GroundTyleSnow;
}

public Image getTerraTyleSnow() {
	return TerraTyleSnow;
}

public Image getAku2() {
	return aku2;
}

public Image getAku2dx() {
	return aku2dx;
}

public Image getWumpaGUI() {
	return wumpaGUI;
}

public Image getPauseQ__() {
	return PauseQ__;
}

public Image getPauseR__() {
	return PauseR__;
}

public Image getPauseQ_C() {
	return PauseQ_C;
}

public Image getPauseR_C() {
	return PauseR_C;
}

public Image getPauseQGC() {
	return PauseQGC;
}

public Image getPauseRGC() {
	return PauseRGC;
}

public Image getPauseQG_() {
	return PauseQG_;
}

public Image getPauseRG_() {
	return PauseRG_;
}

public Image getMenuLvl2Locked() {
	return menuLvl2Locked;
}

}

